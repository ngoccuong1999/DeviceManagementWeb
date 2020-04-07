/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuongdn.actions;

import com.opensymphony.xwork2.ActionContext;
import cuongdn.dbs.Device;
import cuongdn.dbs.DeviceBLO;
import java.util.Map;

/**
 *
 * @author Ngoc Cuong
 */
public class DetailDeviceAction {
    private int id;
    private Device dev;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Device getDev() {
        return dev;
    }

    public void setDev(Device dev) {
        this.dev = dev;
    }
    public DetailDeviceAction() {
    }
    
    public String execute() throws Exception {
        DeviceBLO blo = new DeviceBLO();
        dev = blo.searchById(id);
        Map session = ActionContext.getContext().getSession();
        session.put("ROOM", dev.getDeviceRoomId().getId());
        return "success";
    }
    
}
