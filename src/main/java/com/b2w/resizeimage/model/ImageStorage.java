package com.b2w.resizeimage.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author Leonardo S. Rodrigues <leonardo.silva.rodrigues2@gmail.com>
 * @since 21/12/2017
 * @version 1.0
 */
@Document
public class ImageStorage {

    @Id
    private String id;
    private String name;
    private String base64;

    public ImageStorage(String name, String base64) {
        this.name = name;
        this.base64 = base64;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBase64() {
        return base64;
    }

    public void setBase64(String base64) {
        this.base64 = base64;
    }

}
