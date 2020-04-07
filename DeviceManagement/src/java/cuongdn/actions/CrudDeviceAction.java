/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuongdn.actions;

import cuongdn.dbs.Device;
import cuongdn.dbs.DeviceBLO;
import java.util.List;

/**
 *
 * @author Ngoc Cuong
 */
public class CrudDeviceAction {
    private List<Device> listDevice;
    public CrudDeviceAction() {
    }
    
    public String execute() throws Exception {
        DeviceBLO blo = new DeviceBLO();
        listDevice = blo.findAll();
        return "success";
    }

    public List<Device> getListDevice() {
        return listDevice;
    }

    public void setListDevice(List<Device> listDevice) {
        this.listDevice = listDevice;
    }

    
    
}
