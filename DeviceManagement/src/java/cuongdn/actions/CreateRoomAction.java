/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuongdn.actions;

import cuongdn.dbs.Device;
import cuongdn.dbs.DeviceBLO;
import cuongdn.dbs.DeviceRoom;
import cuongdn.dbs.DeviceRoomBLO;
import cuongdn.dtos.ErrorDeviceDTO;
import cuongdn.dtos.ErrorRoomDTO;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author Ngoc Cuong
 */
public class CreateRoomAction {

    public List<DeviceRoom> listDeviceRoom;
    private int id;
    private String roomName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public List<DeviceRoom> getListDeviceRoom() {
        return listDeviceRoom;
    }

    public void setListDeviceRoom(List<DeviceRoom> listDeviceRoom) {
        this.listDeviceRoom = listDeviceRoom;
    }

    public CreateRoomAction() {
    }

    public String execute() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        if (request.getParameter("id") == null) {
            return "success";
        } else {
            id = Integer.parseInt(request.getParameter("id"));
            roomName = request.getParameter("roomName");

            boolean valid = true;
            ErrorRoomDTO roomDTO = new ErrorRoomDTO();
            DeviceRoomBLO blo = new DeviceRoomBLO();
            boolean check = true;
            if (id != 0) {
                check = blo.checkDuplicatedId(id);
            }
            if (check) {
                valid = false;
                roomDTO.setRoomIdError("Room id đã tồn tại!!!");
            }

            if (valid) {
                DeviceRoom dev = new DeviceRoom(id, roomName);
                blo.insertDeviceRoom(dev);
                listDeviceRoom = blo.findAll();
                return "success";
            }
            request.setAttribute("INVALID", roomDTO);
            return "fail";
        }
    }

}
