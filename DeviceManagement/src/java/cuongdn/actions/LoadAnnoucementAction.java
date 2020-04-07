/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuongdn.actions;

import com.opensymphony.xwork2.ActionContext;
import cuongdn.dbs.Annoucement;
import cuongdn.dbs.UserInfo;
import cuongdn.dbs.UserInfoBLO;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Ngoc Cuong
 */
public class LoadAnnoucementAction {

    private List<Annoucement> listAnnoucement;

    public LoadAnnoucementAction() {
    }

    public String execute() throws Exception {
        Map session = ActionContext.getContext().getSession();
        String id = (String) session.get("USER");
        UserInfoBLO blo = new UserInfoBLO();
        UserInfo usi = blo.findById(id);
        listAnnoucement = (List)usi.getAnnoucementCollection();
        return "success";
    }

    public List<Annoucement> getListAnnoucement() {
        return listAnnoucement;
    }

    public void setListAnnoucement(List<Annoucement> listAnnoucement) {
        this.listAnnoucement = listAnnoucement;
    }

}
