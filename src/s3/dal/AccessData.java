/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s3.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import s3.bo.User;

/**
 *
 * @author shiraz
 */
public class AccessData {
    
    private Connection conn = null;
    private String database = "s3bucket", user = "root", password = "local";
    
    public AccessData() {        
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AccessData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public User addUser(User user) {
        
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/"
                    + database, this.user, password);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(AccessData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public User loadUser(String userName) {
        return null;
    }
    
    public User updateUser(User user) {
        return null;
    }
    
    public boolean removeUser(User user) {
        return true;
    }
}
