/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s3.bo;

import java.io.File;
import java.util.HashMap;
import lombok.Getter;
import lombok.Setter;
import s3.bl.PaymentHandler;
import s3.ut.Constants;

/**
 *
 * @author shiraz
 */
@Getter
@Setter
public class Bucket {
    
    private final HashMap permissions;
    private final PaymentHandler paymentHandler;
    private String bucketName;
    
    public Bucket() {
         permissions = new HashMap();
         paymentHandler = new PaymentHandler();
    }
    
    public boolean addUserPermissions(User user, String permission) {
        permissions.put(user, permission);
        return true;
    }
    
    public String checkPermissions(User user) {
        return permissions.get(user) == null ? "null" : permissions.get(user).toString();
    }
    
    public boolean uploadData(FileInformation fileInformation, User user) {
        return paymentHandler.uploadRequest(fileInformation.getFileSize(), 
                fileInformation.getFileType(), user);
    }
    
    public boolean downloadData(FileInformation fileInformation, User user) {
        return paymentHandler.downloadRequest(fileInformation.getFileSize(), 
                fileInformation.getFileType(), user);
    }
    
    private String checkFileType(File file) {
        String fileName = file.getName();
        String fileType;
        
        if((fileName.endsWith(".png")) || (fileName.endsWith(".jpeg"))
                || (fileName.endsWith(".jpg"))){
            fileType = Constants.FILE_TYPE_IMAGE;
        }
        else if((fileName.endsWith(".mp4")) || (fileName.endsWith(".avi"))
                || (fileName.endsWith(".wmv"))){
            fileType = Constants.FILE_TYPE_VIDEO;
        }
        else if((fileName.endsWith(".txt")) || (fileName.endsWith(".docx"))
                || (fileName.endsWith(".rtf"))){
            fileType = Constants.FILE_TYPE_DOC;
        }
        else{
            fileType = Constants.FILE_TYPE_AUDIO;
        }
        
        return fileType;
    }
}
