/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s3.bo;

import java.io.File;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author shiraz
 */
@Getter
@Setter
public class FileInformation {
    
    private File file;
    private String fileName;
    private String fileType;
    private Long fileSize;
    private String fileLocation;
    
}
