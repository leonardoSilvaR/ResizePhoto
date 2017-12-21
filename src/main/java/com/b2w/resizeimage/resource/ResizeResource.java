package com.b2w.resizeimage.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.b2w.resizeimage.model.service.image.transformation.ImageTransformationService;
import java.util.List;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Leonardo S. Rodrigues <leonardo.silva.rodrigues2@gmail.com>
 * @since 20/12/2017
 * @version 1.0
 */
@RestController
@RequestMapping("/api")
public class ResizeResource {

    @Autowired
    private ImageTransformationService imageTransformationService;

    @ResponseBody
    @RequestMapping(value = "/resize", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> transform() {
        HttpHeaders headers = new HttpHeaders();
        headers.setCacheControl(CacheControl.noCache().getHeaderValue());
        return new ResponseEntity<>(imageTransformationService.getTransformation(), headers, HttpStatus.OK);

    }

}
