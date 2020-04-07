/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuongdn.actions;

import cuongdn.dbs.DeviceRoom;
import cuongdn.dbs.DeviceRoomBLO;
import java.util.List;

/**
 *
 * @author Ngoc Cuong
 */
public class CrudRoomAction {
    private List<DeviceRoom> listDeviceRoom;
    public CrudRoomAction() {
    }
    
    public String execute() throws Exception {
        DeviceRoomBLO blo = new DeviceRoomBLO();
        listDeviceRoom = blo.findAll();
        return "success";
    }

    public List<DeviceRoom> getListDeviceRoom() {
        return listDeviceRoom;
    }

    public void setListDeviceRoom(List<DeviceRoom> listDeviceRoom) {
        this.listDeviceRoom = listDeviceRoom;
    }
    
}
