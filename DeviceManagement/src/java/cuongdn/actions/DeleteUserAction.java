/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuongdn.actions;

import com.opensymphony.xwork2.ActionContext;
import cuongdn.dbs.UserInfo;
import cuongdn.dbs.UserInfoBLO;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Ngoc Cuong
 */
public class DeleteUserAction {
    private String username; 
    private List<UserInfo> listUser;
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public DeleteUserAction() {
    }
    
    public String execute() throws Exception {
        UserInfoBLO usiBLO = new UserInfoBLO();
        if(usiBLO.delete(username)) {
            
            listUser = usiBLO.findAll();
            return "success";
        }
         Map session = ActionContext.getContext().getSession();
        session.put("ERROR", "Delete User failed!!!");
        return "fail";
    }

    public List<UserInfo> getListUser() {
        return listUser;
    }

    public void setListUser(List<UserInfo> listUser) {
        this.listUser = listUser;
    }
    
}
