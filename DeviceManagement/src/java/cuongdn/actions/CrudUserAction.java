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
public class CrudUserAction {
    private List<UserInfo> listUser;
    private String userLogin;

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }
    public List<UserInfo> getListUser() {
        return listUser;
    }

    public void setListUser(List<UserInfo> listUser) {
        this.listUser = listUser;
    }
    public CrudUserAction() {
    }
    
    public String execute() throws Exception {
        UserInfoBLO usiBLO = new UserInfoBLO();
        listUser = usiBLO.findAll();
        Map session = ActionContext.getContext().getSession();
        userLogin = (String)session.get("USER");
        return "success";
    }
    
}
