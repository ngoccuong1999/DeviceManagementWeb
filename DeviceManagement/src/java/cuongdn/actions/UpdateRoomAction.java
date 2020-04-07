/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuongdn.actions;

import com.opensymphony.xwork2.ActionContext;
import cuongdn.dbs.DeviceRoom;
import cuongdn.dbs.DeviceRoomBLO;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author Ngoc Cuong
 */
public class UpdateRoomAction {

    private int id1;
    private String deviceRoomName;
    private List<DeviceRoom> listDeviceRoom;

    public int getId1() {
        return id1;
    }

    public void setId1(int id1) {
        this.id1 = id1;
    }

    public String getDeviceRoomName() {
        return deviceRoomName;
    }

    public void setDeviceRoomName(String deviceRoomName) {
        this.deviceRoomName = deviceRoomName;
    }

    public List<DeviceRoom> getListDeviceRoom() {
        return listDeviceRoom;
    }

    public void setListDeviceRoom(List<DeviceRoom> listDeviceRoom) {
        this.listDeviceRoom = listDeviceRoom;
    }

    public UpdateRoomAction() {
    }

    public String execute() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        id1 = Integer.parseInt(request.getParameter("id1"));
        deviceRoomName = request.getParameter("deviceRoomName");
        DeviceRoomBLO devBLO = new DeviceRoomBLO();
        DeviceRoom newRoom = new DeviceRoom(id1, deviceRoomName);
        listDeviceRoom = devBLO.findAll();

        if (devBLO.updateRoom(newRoom)) {
            return "success";
        }
        Map session = ActionContext.getContext().getSession();
        session.put("ERROR", "Update Room Failed");
        return "fail";

    }

}
