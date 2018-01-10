/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s3.bl;

import java.util.HashMap;
import s3.bo.Bucket;
import s3.bo.FileInformation;
import s3.bo.User;
import s3.ut.Constants;

/**
 *
 * @author shiraz
 */
public class BucketManager {
    
    private final HashMap<String, Bucket> buckets;
    private final PaymentHandler paymentHandler;
    private int counter;
    
    public BucketManager() {
        buckets = new HashMap<>(100);
        paymentHandler = new PaymentHandler();
        counter = 0;
    }
    
    public boolean addBucket(Bucket bucket) {
        if(counter < 100) {
            ++counter;
            buckets.put(bucket.getBucketName(), bucket);
            return true;
        }
        return false;
    }
    
    public boolean removeBucket(Bucket bucket, User user) {
        HashMap permissions = bucket.getPermissions();
        if(permissions.containsKey(user)) {
            buckets.remove(bucket); /*remove*/
            --counter;
            return true;
        }
        return false;
    }
    
    public boolean uploadToBucket(Bucket bucket, User user, FileInformation fileInformation) {
        
        boolean result = false;
        HashMap permissions = bucket.getPermissions();
        
        if(permissions.containsKey(user)) {
            String permission = permissions.get(user).toString();
            if((permission.contains(Constants.UPLOAD_PERMISSION)) &&
                    (paymentHandler.uploadRequest(fileInformation.getFileSize(), 
                        fileInformation.getFileType(), user))) {
                    // store file to bucket
                    result = true;
            }
        }
        return result;
    }
    
    public Object downloadFromBucket(Bucket bucket, User user, FileInformation fileInformation) {
        
        HashMap permissions = bucket.getPermissions();
        Object object = null;
        
        if(permissions.containsKey(user)) {
            String permission = permissions.get(user).toString();
            if((permission.contains(Constants.DOWNLOAD_PERMISSION)) && 
                    (paymentHandler.downloadRequest(fileInformation.getFileSize(),
                            fileInformation.getFileType(), user))) {
                // get file from bucket
                // object = file
            }
        }
        return object;
    }
    
    public Object readFromBucket(Bucket bucket, User user, FileInformation fileInformation) {
        
        HashMap permissions = bucket.getPermissions();
        Object object = null;
        
        if(permissions.containsKey(user)) {
            String permission = permissions.get(user).toString();
            if((permission.contains(Constants.READ_PERMISSION)) && 
                    (paymentHandler.readRequest(fileInformation.getFileSize(), 
                            fileInformation.getFileType(), user))){
                // get file from bucket
                // object = file
            }
        }
        return object;
    }
    
    public boolean deleteFromBucket(Bucket bucket, User user, FileInformation fileInformation) {
        
        HashMap permissions = bucket.getPermissions();
        boolean result = false;
        
        if(permissions.containsKey(user)) {
            String permission = permissions.get(user).toString();
            if(permission.contains(Constants.DELETE_PERMISSION)) {
                // delete file from bucket
                // object = file
                result = true;
            }
        }
        return result;
    }
}
