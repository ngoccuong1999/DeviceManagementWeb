/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuongdn.actions;

import com.opensymphony.xwork2.ActionContext;
import cuongdn.dbs.Device;
import cuongdn.dbs.DeviceBLO;
import cuongdn.dbs.DeviceFix;
import cuongdn.dbs.DeviceFixBLO;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author Ngoc Cuong
 */
public class FixHistoryAction {
    private int deviceId;
    private String username;
    private List<DeviceFix> listDeviceFix;

    public List<DeviceFix> getListDeviceFix() {
        return listDeviceFix;
    }

    public void setListDeviceFix(List<DeviceFix> listDeviceFix) {
        this.listDeviceFix = listDeviceFix;
    }
    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public FixHistoryAction() {
    }
    
    public String execute() throws Exception {
        Map session = ActionContext.getContext().getSession();
        HttpServletRequest request = ServletActionContext.getRequest();
        username = (String)session.get("USER");
        DeviceBLO deviceBLO = new DeviceBLO();
        Device dev = deviceBLO.searchById(deviceId);
        request.setAttribute("DEVICEX", dev);
        DeviceFixBLO fixBLO = new DeviceFixBLO();
        listDeviceFix = fixBLO.findByDeviceAndUser(username, deviceId);
        return "success";
    }
    
}
