/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s3.bl;

import s3.bo.User;
import s3.ut.Constants;

/**
 *
 * @author shiraz
 */
public class PaymentHandler {
    
    UserRecordHandler userRecordHandler = new UserRecordHandler();
    
    public boolean uploadRequest(Long fileSize, String fileType, User user) {
        return userRecordHandler.deductAmount(user, fileSize * Constants.UPLOAD_COST) != null;
    }
    
    public boolean downloadRequest(Long fileSize, String fileType, User user) {
        return userRecordHandler.deductAmount(user, fileSize * Constants.DOWNLOAD_COST) != null;
    }
    
    public boolean readRequest(Long fileSize, String fileType, User user) {
        return userRecordHandler.deductAmount(user, fileSize * Constants.READ_COST) != null;
    }
    
    //delete is free
}
