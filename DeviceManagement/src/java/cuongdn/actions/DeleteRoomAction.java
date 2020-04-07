/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuongdn.actions;

import com.opensymphony.xwork2.ActionContext;
import cuongdn.dbs.Device;
import cuongdn.dbs.DevicePosition;
import cuongdn.dbs.DeviceRoom;
import cuongdn.dbs.DeviceRoomBLO;
import cuongdn.dbs.UserInfo;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Ngoc Cuong
 */
public class DeleteRoomAction {
    private int id;
    private List<DeviceRoom> listDeviceRoom;
    private List<UserInfo> listUserInfo;
    private List<DevicePosition> listDevicePosition;
    private List<Device> listDeviceN;

    public List<UserInfo> getListUserInfo() {
        return listUserInfo;
    }

    public void setListUserInfo(List<UserInfo> listUserInfo) {
        this.listUserInfo = listUserInfo;
    }

    public List<DevicePosition> getListDevicePosition() {
        return listDevicePosition;
    }

    public void setListDevicePosition(List<DevicePosition> listDevicePosition) {
        this.listDevicePosition = listDevicePosition;
    }

    public List<Device> getListDeviceN() {
        return listDeviceN;
    }

    public void setListDeviceN(List<Device> listDeviceN) {
        this.listDeviceN = listDeviceN;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<DeviceRoom> getListDeviceRoom() {
        return listDeviceRoom;
    }

    public void setListDeviceRoom(List<DeviceRoom> listDeviceRoom) {
        this.listDeviceRoom = listDeviceRoom;
    }
    public DeleteRoomAction() {
    }
    
    public String execute() throws Exception {
        DeviceRoomBLO blo = new DeviceRoomBLO();
        DeviceRoom devRoom = blo.findById(id);
        listUserInfo = (List)devRoom.getUserInfoCollection();
        listDeviceN = (List)devRoom.getDeviceCollection();
        listDevicePosition = (List<DevicePosition>) devRoom.getDevicePositionCollection();
        if(!listUserInfo.isEmpty() || !listDeviceN.isEmpty() || !listDevicePosition.isEmpty()) {
            return "constrain";
        }
        if(blo.deleteRoom(id)) {
            listDeviceRoom = blo.findAll();
            return "success";
        }
        Map session = ActionContext.getContext().getSession();
        session.put("ERROR", "Delete Device Room Failed !!!");
        return "fail";
    }
    
}
