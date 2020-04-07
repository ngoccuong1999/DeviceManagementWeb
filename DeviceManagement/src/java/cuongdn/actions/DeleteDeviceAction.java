/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuongdn.actions;

import com.opensymphony.xwork2.ActionContext;
import cuongdn.dbs.Device;
import cuongdn.dbs.DeviceBLO;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Ngoc Cuong
 */
public class DeleteDeviceAction {
    private int id;
    private List<Device> listDevice;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Device> getListDevice() {
        return listDevice;
    }

    public void setListDevice(List<Device> listDevice) {
        this.listDevice = listDevice;
        
    }
    public DeleteDeviceAction() {
    }
    
    public String execute() throws Exception {
        DeviceBLO blo = new DeviceBLO();
        if(blo.deleteDevice(id)) {
            listDevice= blo.findAll();
            return "success";
        } 
        Map session = ActionContext.getContext().getSession();
        session.put("ERROR", "Delete Device failed!!!");
        return "fail";
    }
    
}
