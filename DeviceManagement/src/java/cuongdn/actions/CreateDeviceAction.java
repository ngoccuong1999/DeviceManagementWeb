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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author Ngoc Cuong
 */
public class CreateDeviceAction {

    private int id;
    private String deviceName, deviceDescription, deviceType;
    private Date timeBuy, warrantyPeriod;
    private List<Device> listDevice;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceDescription() {
        return deviceDescription;
    }

    public void setDeviceDescription(String deviceDescription) {
        this.deviceDescription = deviceDescription;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public Date getTimeBuy() {
        return timeBuy;
    }

    public void setTimeBuy(Date timeBuy) {
        this.timeBuy = timeBuy;
    }

    public Date getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public void setWarrantyPeriod(Date warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }

    public List<Device> getListDevice() {
        return listDevice;
    }

    public void setListDevice(List<Device> listDevice) {
        this.listDevice = listDevice;
    }

    public CreateDeviceAction() {

    }

    public String execute() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        if (request.getParameter("id") == null) {
            return "success";
        } else {
            id = Integer.parseInt(request.getParameter("id"));
            deviceType = request.getParameter("deviceType");
            deviceDescription = request.getParameter("deviceDescription");
            deviceName = request.getParameter("deviceName");
            String date = request.getParameter("timeBuy");
            timeBuy = new SimpleDateFormat("MM/dd/yyyy").parse(date);
            String date1 = request.getParameter("warrantyPeriod");
            warrantyPeriod = new SimpleDateFormat("MM/dd/yyyy").parse(date1);
        
        boolean valid = true;
        ErrorDeviceDTO dto = new ErrorDeviceDTO();
        DeviceBLO blo = new DeviceBLO();
        boolean check = true;
        if (id != 0) {
            check = blo.checkDuplicatedId(id);
        }
        if (check) {
            valid = false;
            dto.setIdError("Id đã tồn tại");
        }

        if (valid) {
            DeviceRoomBLO devBLO = new DeviceRoomBLO();
            int i = 1;
            while (devBLO.checkDuplicatedId(i)) {
                i++;
            }
            DeviceRoom dev = new DeviceRoom(i, "Phòng cho user mới");
            devBLO.insertDeviceRoom(dev);
            Device devic = new Device(id, deviceName, deviceDescription, deviceType, timeBuy, warrantyPeriod, 0, dev);
            blo.insertUser(devic);
            listDevice = blo.findAll();
            return "success";
        }
        request.setAttribute("INVALID", dto);
        return "fail";
        }

    }

}
