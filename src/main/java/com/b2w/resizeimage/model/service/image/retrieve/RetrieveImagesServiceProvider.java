package com.b2w.resizeimage.model.service.image.retrieve;

import com.b2w.resizeimage.model.Images;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Leonardo S. Rodrigues <leonardo.silva.rodrigues2@gmail.com>
 * @since 20/12/2017
 * @version 1.0
 */
@Service
public class RetrieveImagesServiceProvider implements RetrieveImagesService {

    @Override
    public Images getImages(String api) {
        RestTemplate restTemplate = new RestTemplate();
        Images images = restTemplate.getForObject(api, Images.class);
        return images;
    }

}
