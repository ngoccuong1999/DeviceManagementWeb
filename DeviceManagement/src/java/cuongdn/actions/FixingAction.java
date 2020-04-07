/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuongdn.actions;

import com.opensymphony.xwork2.ActionContext;
import cuongdn.dbs.Annoucement;
import cuongdn.dbs.AnnoucementBLO;
import cuongdn.dbs.Device;
import cuongdn.dbs.DeviceBLO;
import cuongdn.dbs.DeviceFix;
import cuongdn.dbs.DeviceFixBLO;
import cuongdn.dbs.UserInfo;
import cuongdn.dbs.UserInfoBLO;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author Ngoc Cuong
 */
public class FixingAction {

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    private String fixStatus, userIdRequest, annoucementContent;
    private Date timeFixBegin, timeFixFinish;
    private List<Annoucement> listAnnoucement;

    public String getFixStatus() {
        return fixStatus;
    }

    public Date getTimeFixBegin() {
        return timeFixBegin;
    }

    public void setTimeFixBegin(Date timeFixBegin) {
        this.timeFixBegin = timeFixBegin;
    }

    public Date getTimeFixFinish() {
        return timeFixFinish;
    }

    public void setTimeFixFinish(Date timeFixFinish) {
        this.timeFixFinish = timeFixFinish;
    }

    public void setFixStatus(String fixStatus) {
        this.fixStatus = fixStatus;
    }

    public String getUserIdRequest() {
        return userIdRequest;
    }

    public void setUserIdRequest(String userIdRequest) {
        this.userIdRequest = userIdRequest;
    }

    public String getAnnoucementContent() {
        return annoucementContent;
    }

    public void setAnnoucementContent(String annoucementContent) {
        this.annoucementContent = annoucementContent;
    }

    public int getDeviceIdRequest() {
        return deviceIdRequest;
    }

    public void setDeviceIdRequest(int deviceIdRequest) {
        this.deviceIdRequest = deviceIdRequest;
    }
    private Date time;
    private int deviceIdRequest;

    public List<Annoucement> getListAnnoucement() {
        return listAnnoucement;
    }

    public void setListAnnoucement(List<Annoucement> listAnnoucement) {
        this.listAnnoucement = listAnnoucement;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public FixingAction() {
    }

    public String execute() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        fixStatus = request.getParameter("fixStatus");
        AnnoucementBLO annoucementBLO = new AnnoucementBLO();
        Map session = ActionContext.getContext().getSession();
        if (fixStatus.equals("fixing")) {
            Date time1 = new Date();
            session.put("TIMEFIXBEGIN", time1);
            String id1 = (String) session.get("USER");
            UserInfoBLO blo = new UserInfoBLO();
            UserInfo usi = blo.findById(id1);
            listAnnoucement = (List) usi.getAnnoucementCollection();
            DeviceBLO devBLO = new DeviceBLO();
            devBLO.updateStatus(deviceIdRequest, 1);
            annoucementBLO.updateStatus(id, 1);

        } else {
            DeviceBLO devBLO = new DeviceBLO();
            Device dev = devBLO.searchById(deviceIdRequest);
            UserInfoBLO usiBLO = new UserInfoBLO();
            UserInfo usiRequest = usiBLO.findById(userIdRequest);
            String currentUser = (String) session.get("USER");
            UserInfo usiFixing = usiBLO.findById(currentUser);
            timeFixBegin = (Date)session.get("TIMEFIXBEGIN");
            timeFixFinish = new Date();
            boolean result = true;
            if (fixStatus.equals("done")) {
                annoucementBLO.updateStatus(id, 0);
                devBLO.updateStatus(deviceIdRequest, 0);
                result = true;
            } else {
                annoucementBLO.updateStatus(id, 2);
                devBLO.updateStatus(deviceIdRequest, 2);
                result = false;
            }
            int i = 1;
            DeviceFixBLO devFixBLO = new DeviceFixBLO(); // tim id cho devfix
            while (devFixBLO.checkDuplicatedId(i)) {
                i++;
            }

            DeviceFix devFix = new DeviceFix(i, time, annoucementContent, timeFixBegin, timeFixFinish, result, dev, usiRequest, usiFixing);
            devFixBLO.insertDeviceFix(devFix);
        }
        return "success";
    }

}
