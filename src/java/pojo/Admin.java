   package pojo;
// Generated Oct 12, 2022 10:33:49 PM by Hibernate Tools 4.3.1

import DAO.DAOAdmin;
import java.util.List;
import javax.faces.bean.ManagedBean;
import DAO.DAOLogin;
import javax.faces.application.FacesMessage;
   

/**
 * Admin generated by hbm2java
 */
@ManagedBean
public class Admin  implements java.io.Serializable {


     private Integer id;
     private String username;
     private String password;

    public Admin() {
    }

    public Admin(String username, String password) {
       this.username = username;
       this.password = password;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    public String validasiUser() {
        DAOLogin uDao = new DAOLogin();
        List<Admin> us = uDao.getBy(username, password);
        if (us != null) {
            username = us.get(0).username;
            password = us.get(0).password;
            return "view_writer";
        }
        return "error";
    }

    public void save() {
        DAOAdmin adm = new DAOAdmin();
        adm.addAdmin(this);
    }

    public void delete() {
        DAOAdmin adm = new DAOAdmin();
        adm.deleteAdmin(id);
        username = "";
        password = "";
    }

    public String getbyid() {
        DAOAdmin adm = new DAOAdmin();
        List<Admin> lAdm = adm.getbyID(id);
        username = lAdm.get(0).username;
        password = lAdm.get(0). password;
        return "crud_admin";
    }

    public List<Admin> getallrecords() {
        DAOAdmin adm = new DAOAdmin();
        List<Admin> lAdm = adm.retrieveAdmin();
        return lAdm;
    }

    public void update() {
        DAOAdmin adm = new DAOAdmin();
        adm.updateAdmin(this);
        username = "";
        password = "";
        FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sukses Mengupdate Data", null);
    }
}

