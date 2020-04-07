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
import cuongdn.dbs.DeviceRoom;
import cuongdn.dbs.UserInfo;
import cuongdn.dbs.UserInfoBLO;
import java.text.DateFormat;
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
public class FixAction {

    private int deviceId;
    private String usernameLogin;
    private String content;
    private List<Device> listDevice;

    public List<Device> getListDevice() {
        return listDevice;
    }

    public void setListDevice(List<Device> listDevice) {
        this.listDevice = listDevice;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public FixAction() {
    }

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public String getUsernameLogin() {
        return usernameLogin;
    }

    public void setUsernameLogin(String usernameLogin) {
        this.usernameLogin = usernameLogin;
    }

    public String execute() throws Exception {
        DeviceBLO blo = new DeviceBLO();
        Device dev = blo.searchById(deviceId);
        blo.updateStatus(deviceId, 2);
        AnnoucementBLO annouBLO = new AnnoucementBLO();
        HttpServletRequest request = ServletActionContext.getRequest();
        Map session = ActionContext.getContext().getSession();
        usernameLogin = (String) session.get("USER");
        content = request.getParameter("content");
        int i = 1;
        while (annouBLO.checkDuplicatedId(i)) {
            i++;
        }
        String content12 = "User: " + usernameLogin + " yêu cầu sửa  thiết bị có id: " + dev.getId() + " " + dev.getDeviceName() + " " + this.content;
        Date dat = new Date();
        //Lay ra list user la staff fixing va admin 
        UserInfoBLO usiBLO = new UserInfoBLO();
        List<UserInfo> staffAdmin = usiBLO.findExceptUser();
        Annoucement annou = new Annoucement(i, content12, dat, usernameLogin, deviceId, 2, staffAdmin);
        annouBLO.insert(annou);
        String id = (String) session.get("USER");
//        
        DeviceRoom devRoom = usiBLO.findDeviceRoomId(id);
////        DeviceBLO deBLO = new DeviceBLO();
        listDevice = (List) devRoom.getDeviceCollection();
        return "success";
    }

}
