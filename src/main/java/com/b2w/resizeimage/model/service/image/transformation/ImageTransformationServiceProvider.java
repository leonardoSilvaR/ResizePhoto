package com.b2w.resizeimage.model.service.image.transformation;

import com.b2w.resizeimage.core.ImageManipulation;
import com.b2w.resizeimage.model.Image;
import com.b2w.resizeimage.model.ImageStorage;
import com.b2w.resizeimage.model.service.image.retrieve.RetrieveImagesService;
import com.b2w.resizeimage.repository.ImageStorageRepository;
import com.b2w.resizeimage.utils.Constantes;
import com.b2w.resizeimage.utils.ImageConverter;
import com.mongodb.MongoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Leonardo S. Rodrigues <leonardo.silva.rodrigues2@gmail.com>
 * @since 21/12/2017
 * @version 1.0
 */
@Service
public class ImageTransformationServiceProvider implements ImageTransformationService {

    @Autowired
    private ImageStorageRepository storageRepository;

    @Autowired
    private RetrieveImagesService retrieve;

    @Override
    public String getTransformation() {
        persist();

        for (ImageStorage ab : storageRepository.findAll()) {
            ImageManipulation.exposeImage(ImageConverter.decode(ab.getBase64()), ab.getName());
        }

        return "A";
    }

    public void persist() {
        for (Image img : retrieve.getImages(Constantes.IMAGES_URI).getImages()) {
            String imageEncoded = ImageConverter.encode(ImageManipulation.consumeImages(img));
            String imgName = img.getUrl().substring(28, img.getUrl().length());
            try {
                storageRepository.save(new ImageStorage(imgName, imageEncoded));
            } catch (MongoException e) {
                e.printStackTrace();
            }

        }

    }

}
