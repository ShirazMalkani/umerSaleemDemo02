/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s3.bo;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author shiraz
 */
@Getter
@Setter
public class User {
    
    private String userName;
    private String password;
    private String emailAddr;
    private Double creditLimit;
    private Double creditUsed;
    private Double creditRemaining;
    private String status;
}
