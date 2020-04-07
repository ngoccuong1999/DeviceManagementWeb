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
import cuongdn.dtos.ErrorObjDTO;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author Ngoc Cuong
 */
public class SignUpAction {

    private String username;
    private String password;
    private String repeatPassword;
    private String phoneNumber;
    private String fullName;
    private static final String VALID = "user";
    private static final String INVALID = "login";

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public SignUpAction() {
    }

    public String execute() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        username = request.getParameter("username");
        password = request.getParameter("password");
        repeatPassword = request.getParameter("repeatPassword");
        fullName = request.getParameter("fullName");
        phoneNumber = request.getParameter("phoneNumber");

        boolean valid = true;
        ErrorObjDTO dto = new ErrorObjDTO();
        UserInfoBLO blo = new UserInfoBLO();
        boolean check = true;
        if (username != null) {
            check = blo.checkDuplicatedId(username);
        }
        if (check) {
            valid = false;
            dto.setUsernameError("Username đã tồn tại");
        }
        if (valid) {
            DeviceRoomBLO devBLO = new DeviceRoomBLO();
            int i = 1;
            while (devBLO.checkDuplicatedId(i)) {
                i++;
            }
            DeviceRoom dev = new DeviceRoom(i, "Phòng cho user mới");
            devBLO.insertDeviceRoom(dev);
            UserInfo usi = new UserInfo(username, password, fullName, phoneNumber, true, 1, dev);
            blo.insertUser(usi);
            Map session = ActionContext.getContext().getSession();
            session.put("USER", username);
            return VALID;
        }
        request.setAttribute("INVALID", dto);
        return INVALID;

    }

}
