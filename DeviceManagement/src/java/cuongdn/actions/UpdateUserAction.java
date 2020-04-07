/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuongdn.actions;

import com.opensymphony.xwork2.ActionContext;
import cuongdn.dbs.DeviceRoom;
import cuongdn.dbs.DeviceRoomBLO;
import cuongdn.dbs.UserInfo;
import cuongdn.dbs.UserInfoBLO;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author Ngoc Cuong
 */
public class UpdateUserAction {

    private String username1, password, fullName, phoneNumber;
    private int role, deviceRoomId;

    public List<UserInfo> getListUser() {
        return listUser;
    }

    public void setListUser(List<UserInfo> listUser) {
        this.listUser = listUser;
    }
    private List<UserInfo> listUser;

    public String getUsername() {
        return username1;
    }

    public void setUsername(String username1) {
        this.username1 = username1;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getDeviceRoomId() {
        return deviceRoomId;
    }

    public void setDeviceRoomId(int deviceRoomId) {
        this.deviceRoomId = deviceRoomId;
    }

    public UpdateUserAction() {
    }

    public String execute() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        username1 = request.getParameter("username1");
        password = request.getParameter("password");
        fullName = request.getParameter("fullName");
        phoneNumber = request.getParameter("phoneNumber");
        role = Integer.parseInt(request.getParameter("role"));
        deviceRoomId = Integer.parseInt(request.getParameter("deviceRoomId"));
        DeviceRoomBLO devBLO = new DeviceRoomBLO();
        DeviceRoom newRoom;
        if (devBLO.checkDuplicatedId(deviceRoomId)) {
            newRoom = devBLO.findById(deviceRoomId);
        } else {
            newRoom = new DeviceRoom(deviceRoomId, "Phòng mới tạo");
        }
        UserInfo usi = new UserInfo(username1, password, fullName, phoneNumber, false, role, newRoom);
        UserInfoBLO usiBLO = new UserInfoBLO();
        listUser = usiBLO.findAll();
        if (usiBLO.updateUser(usi, username1)) {
            return "success";
        }
        Map session = ActionContext.getContext().getSession();
        session.put("ERROR", "Update Failed");
        return "fail";

    }

}
