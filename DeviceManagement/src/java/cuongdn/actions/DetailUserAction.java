/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuongdn.actions;

import cuongdn.dbs.UserInfo;
import cuongdn.dbs.UserInfoBLO;

/**
 *
 * @author Ngoc Cuong
 */
public class DetailUserAction {
    private String username;
    private UserInfo usi;
    public DetailUserAction(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public DetailUserAction() {
    }
    
    public String execute() throws Exception {
        UserInfoBLO usiBLO = new UserInfoBLO();
        usi = usiBLO.findByUserName(username);
        
        return "success";
    }

    public UserInfo getUsi() {
        return usi;
    }

    public void setUsi(UserInfo usi) {
        this.usi = usi;
    }
    
}
