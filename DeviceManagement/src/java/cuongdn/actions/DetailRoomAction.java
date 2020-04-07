/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuongdn.actions;

import cuongdn.dbs.DeviceRoom;
import cuongdn.dbs.DeviceRoomBLO;

/**
 *
 * @author Ngoc Cuong
 */
public class DetailRoomAction {
    private int id;
    private DeviceRoom devRoom;
    public DetailRoomAction() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DeviceRoom getDevRoom() {
        return devRoom;
    }

    public void setDevRoom(DeviceRoom devRoom) {
        this.devRoom = devRoom;
    }
    
    public String execute() throws Exception {
        DeviceRoomBLO blo = new DeviceRoomBLO();
        devRoom = blo.findById(id);
        return "success";
    }
    
}
