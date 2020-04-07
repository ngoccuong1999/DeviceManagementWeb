/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuongdn.actions;

import com.opensymphony.xwork2.ActionContext;
import cuongdn.dbs.Device;
import cuongdn.dbs.DeviceRoom;
import cuongdn.dbs.UserInfoBLO;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Ngoc Cuong
 */
public class LoadDeviceUserAction {
    private List<Device> listDevice;

    public List<Device> getListDevice() {
        return listDevice;
    }

    public void setListDevice(List<Device> listDevice) {
        this.listDevice = listDevice;
    }

    
    public LoadDeviceUserAction() {
    }
    
    public String execute() throws Exception {
        UserInfoBLO usiBLO = new UserInfoBLO();
        Map session = ActionContext.getContext().getSession();
        String id = (String)session.get("USER");
        
        DeviceRoom dev = usiBLO.findDeviceRoomId(id);
//        DeviceBLO deBLO = new DeviceBLO();
        listDevice = (List)dev.getDeviceCollection();
        
//        HttpServletRequest request = ServletActionContext.getRequest();
//        request.setAttribute("LISTUSER", result);
        return "success";
    }
    
}
