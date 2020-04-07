/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuongdn.actions;

import com.opensymphony.xwork2.ActionContext;
import cuongdn.dbs.Device;
import cuongdn.dbs.DeviceBLO;
import cuongdn.dbs.DevicePosition;
import cuongdn.dbs.DevicePositionBLO;
import cuongdn.dbs.DeviceRoom;
import cuongdn.dbs.DeviceRoomBLO;
import cuongdn.dbs.UserInfo;
import cuongdn.dbs.UserInfoBLO;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author Ngoc Cuong
 */
public class UpdateDeviceAction {

    private String deviceName, deviceDescription, deviceType;
    private int id1, deviceRoomId, deviceStatus;
    private List<Device> listDevice;
    private String changeReason;

    public String getChangeReason() {
        return changeReason;
    }

    public void setChangeReason(String changeReason) {
        this.changeReason = changeReason;
    }
    public int getId1() {
        return id1;
    }

    public void setId1(int id1) {
        this.id1 = id1;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceDescription() {
        return deviceDescription;
    }

    public void setDeviceDescription(String deviceDescription) {
        this.deviceDescription = deviceDescription;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public int getDeviceRoomId() {
        return deviceRoomId;
    }

    public void setDeviceRoomId(int deviceRoomId) {
        this.deviceRoomId = deviceRoomId;
    }

    public int getDeviceStatus() {
        return deviceStatus;
    }

    public void setDeviceStatus(int deviceStatus) {
        this.deviceStatus = deviceStatus;
    }

    public List<Device> getListDevice() {
        return listDevice;
    }

    public void setListDevice(List<Device> listDevice) {
        this.listDevice = listDevice;
    }

    public UpdateDeviceAction() {
    }

    public String execute() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        id1 = Integer.parseInt(request.getParameter("id1"));
        deviceType = request.getParameter("deviceType");
        deviceDescription = request.getParameter("deviceDescription");

        deviceName = request.getParameter("deviceName");
        deviceStatus = Integer.parseInt(request.getParameter("deviceStatus"));
        deviceRoomId = Integer.parseInt(request.getParameter("deviceRoomId"));
        changeReason = request.getParameter("changeReason");
        DeviceRoomBLO devBLO = new DeviceRoomBLO();
        DeviceRoom newRoom;
        if (devBLO.checkDuplicatedId(deviceRoomId)) {
            newRoom = devBLO.findById(deviceRoomId);
        } else {
            newRoom = new DeviceRoom(deviceRoomId, "Phòng mới tạo");
        }
        DeviceBLO deblo = new DeviceBLO();
        listDevice = deblo.findAll();
        Map session = ActionContext.getContext().getSession();
        if (deblo.updateDevice(id1, deviceName, deviceDescription, deviceType, newRoom, deviceStatus)) {
            int deviceRoomBefore = (int)session.get("ROOM");
            if(deviceRoomBefore != deviceRoomId) {
                 Device dev = deblo.searchById(id1);
                 UserInfoBLO  usiBLO = new UserInfoBLO();
                 String username = (String)session.get("USER");
                 UserInfo usi = usiBLO.findById(username);
                 int i = 1;
                 // chen them so cho no
                 DevicePositionBLO devPositionBLO = new DevicePositionBLO();
                 
                 while(devPositionBLO.checkByIdAndNo(dev, i)) {
                     i++;
                 }
                 int j = 1;
                 while(devPositionBLO.checkDuplicatedId(j)) {
                     j++;
                 }
                 Date changeTime = new Date();
                 DevicePosition devPosition = new DevicePosition(j, i, changeTime, changeReason, dev, newRoom, usi);
                 devPositionBLO.insert(devPosition);
            }
            return "success";
        }
        
        session.put("ERROR", "Update Device Failed");
        return "fail";
    }

}
