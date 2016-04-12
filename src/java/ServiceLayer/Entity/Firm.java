/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLayer.Entity;

/**
 *
 * @author philliphbrink
 */
public class Firm {
    private String firm_name;
    private int firm_leader_id;
    private int firm_id;

    public Firm(String firm_name, int firm_leader_id, int firm_id) {
        this.firm_name = firm_name;
        this.firm_leader_id = firm_leader_id;
        this.firm_id = firm_id;
    }

    public String getFirm_name() {
        return firm_name;
    }

    public void setFirm_name(String firm_name) {
        this.firm_name = firm_name;
    }

    public int getFirm_leader_id() {
        return firm_leader_id;
    }

    public void setFirm_leader_id(int firm_leader_id) {
        this.firm_leader_id = firm_leader_id;
    }

    public int getFirm_id() {
        return firm_id;
    }

    public void setFirm_id(int firm_id) {
        this.firm_id = firm_id;
    }
    
    
}
