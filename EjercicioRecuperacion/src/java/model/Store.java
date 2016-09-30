/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**

 */
public class Store {

    private int idPid;
    private String state;
    private String type;
    private int version;
    private String du;
    

    public Store(int idPid, String state, String type, int version, String du) {
        this.idPid = idPid;
        this.state = state;
        this.type = type;
        this.version = version;
        this.du = du;

    }

    public Store() {
        this(0, "", "", 0, "");
    }

    public int getIdPid() {
        return idPid;
    }

    public void setIdPid(int idPid) {
        this.idPid = idPid;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getDu() {
        return du;
    }

    public void setDu(String du) {
        this.du = du;
    }

    @Override
    public String toString() {
        return "Store{" + "idPid=" + idPid + ", state=" + state + ", type=" + type + ", version=" + version + ", du=" + du + '}';
    }

    

    

}
