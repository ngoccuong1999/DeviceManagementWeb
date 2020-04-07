/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuongdn.actions;

import cuongdn.dbs.Device;
import cuongdn.dbs.DeviceBLO;
import cuongdn.dbs.DevicePosition;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author Ngoc Cuong
 */
public class PositionAction {
    private int deviceId;
    private List<DevicePosition> listPosition;
    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public List<DevicePosition> getListPosition() {
        return listPosition;
    }

    public void setListPosition(List<DevicePosition> listPosition) {
        this.listPosition = listPosition;
    }
    
    public PositionAction() {
    }
    
    public String execute() throws Exception {
        DeviceBLO blo = new DeviceBLO();
        Device dev = blo.searchById(deviceId);
        HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute("DEVICE", dev.getDeviceName());
        listPosition = (List)(dev.getDevicePositionCollection());
        return "success";
    }
    
}
