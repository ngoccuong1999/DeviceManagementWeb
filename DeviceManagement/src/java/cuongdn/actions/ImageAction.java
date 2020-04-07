/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuongdn.actions;

import cuongdn.dbs.Device;
import cuongdn.dbs.DeviceBLO;
import cuongdn.dbs.DeviceImage;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author Ngoc Cuong
 */
public class ImageAction {

    private int deviceId;
    private List<DeviceImage> listImage;

    public ImageAction() {
    }

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public List<DeviceImage> getListImage() {
        return listImage;
    }

    public void setListImage(List<DeviceImage> listImage) {
        this.listImage = listImage;
    }

    public String execute() throws Exception {
        DeviceBLO blo = new DeviceBLO();
        Device dev = blo.searchById(deviceId);
        HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute("DEVICE", dev.getDeviceName());
        listImage = (List) (dev.getDeviceImageCollection());
        return "success";
    }

}
