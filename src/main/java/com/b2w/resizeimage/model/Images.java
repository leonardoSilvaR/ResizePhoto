package com.b2w.resizeimage.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

/**
 *
 * @author Leonardo S. Rodrigues <leonardo.silva.rodrigues2@gmail.com>
 * @since 20/12/2017
 * @version 1.0
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Images {

    private List<Image> images;

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    @Override
    public String toString() {
        return "Images{" + "images=" + images + '}';
    }

}
