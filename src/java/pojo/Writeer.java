package pojo;
// Generated Oct 12, 2022 10:33:49 PM by Hibernate Tools 4.3.1

import DAO.DAOWriter;
import DAO.DAOLoginWriter;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;




/**
 * Writeer generated by hbm2java
 */
@ManagedBean
public class Writeer  implements java.io.Serializable {


     private Integer id;
     private String username;
     private String password;

    public Writeer() {
    }

    public Writeer(String username, String password) {
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
        DAOLoginWriter uDao = new DAOLoginWriter();
        List<Writeer> us = uDao.getBy(username, password);
        if (us != null) {
            username = us.get(0).username;
            password = us.get(0).password;
            return "view_berita_writer";
        }
        return "error";
    }

    public void save() {
        DAOWriter wrt = new DAOWriter();
        wrt.addWriter(this);
    }

    public void delete() {
        DAOWriter wrt = new DAOWriter();
        wrt.deleteWriter(id);
        username = "";
        password = "";
    }

    public String getbyid() {
        DAOWriter wrt = new DAOWriter();
        List<Writeer> lWrt = wrt.getbyID(id);
        username = lWrt.get(0).username;
        password = lWrt.get(0). password;
        return "crud_writer";
    }

    public List<Writeer> getallrecords() {
        DAOWriter wrt = new DAOWriter();
        List<Writeer> lWrt = wrt.retrieveWriter();
        return lWrt;
    }

    public void update() {
        DAOWriter wrt = new DAOWriter();
        wrt.updateWriter(this);
        username = "";
        password = "";
        FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sukses Mengupdate Data", null);
    }


}


