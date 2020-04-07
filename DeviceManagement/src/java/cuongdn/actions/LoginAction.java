/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuongdn.actions;

import com.opensymphony.xwork2.ActionContext;
import cuongdn.dbs.UserInfoBLO;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author Ngoc Cuong
 */
public class LoginAction {
    private String username;
    private String password;
    
    private static final String USER = "user";
    private static final String ADMIN = "admin";
    private static final String STAFF = "staff";
    private static final String FAIL = "fail";

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
    
    public LoginAction() {
    }
    
    public String execute() throws Exception {
        String url = FAIL;
        HttpServletRequest request = ServletActionContext.getRequest();
        username = request.getParameter("username");
        password = request.getParameter("password");
        UserInfoBLO blo = new UserInfoBLO();
        int role = blo.checkLogin(username, password);
        
        if(role == 0) {
            url = FAIL;
            request.setAttribute("ERROR", "Invalid username or password");
        } else {
            Map session = ActionContext.getContext().getSession();
            session.put("USER", username);
            if(role == 1) {
                url = USER;
            } else if(role == 2) {
                url =STAFF;
            } else if(role == 3) {
                url = ADMIN;
            } else {
                request.setAttribute("ERROR", "Your role is invalid");
            }
        }
        return url;
    }
    
}
