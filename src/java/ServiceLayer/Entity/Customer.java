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
public class Customer {
    private String username;
    private String password;
    private int user_id;
    private String user_role;

    public Customer(String username, String password, int user_id, String user_role) {
        this.username = username;
        this.password = password;
        this.user_id = user_id;
        this.user_role = user_role;
    }

    public Customer(String username, int user_id, String user_role) {
        this.username = username;
        this.user_id = user_id;
        this.user_role = user_role;
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

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_role() {
        return user_role;
    }

    public void setUser_role(String user_role) {
        this.user_role = user_role;
    }
}