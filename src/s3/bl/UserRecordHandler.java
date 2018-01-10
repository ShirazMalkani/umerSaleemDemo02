/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s3.bl;

import s3.bo.User;
import s3.dal.AccessData;
import s3.ut.Constants;

/**
 *
 * @author shiraz
 */
public class UserRecordHandler {
    
    AccessData ad = new AccessData();
    
    public User confirmSignIn(User user) {
        return ad.loadUser(user.getUserName());
    }
    
    public User addUser(User user) {
        return ad.addUser(user);
    }
    
    public User addAmount(User user, Double amount) {
        user.setCreditRemaining(user.getCreditRemaining() + amount);
        return user;
    }
    
    public User deductAmount(User user, Double amount) {
        
        if(user.getCreditRemaining() >= amount){
            user.setCreditRemaining(user.getCreditRemaining() - amount);
            ad.updateUser(user);
            return user;
        }
        return null;
    }
    
    public Double avaiableAmount(User user) {
        return user.getCreditRemaining();
    }
    
    public User blockUser(User user) {
        user.setStatus(Constants.BLOCK_USER);
        return user;
    }
    
    public User unblockUser(User user) {
        user.setStatus(Constants.UNBLOCK_USER);
        return user;
    }
}
