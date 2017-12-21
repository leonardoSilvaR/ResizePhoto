package com.b2w.resizeimage.repository;

import com.b2w.resizeimage.model.ImageStorage;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author Leonardo S. Rodrigues <leonardo.silva.rodrigues2@gmail.com>
 */
public interface ImageStorageRepository extends MongoRepository<ImageStorage, String>{
    
}
