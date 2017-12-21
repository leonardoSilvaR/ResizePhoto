package com.b2w.resizeimage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.b2w.resizeimage.model.service.image.transformation.ImageTransformationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Leonardo S. Rodrigues <leonardo.silva.rodrigues2@gmail.com>
 * @since 20/12/2017
 * @version 1.0
 */
@RestController
@RequestMapping("/api")
public class ResizeController {

    @Autowired
    private ImageTransformationService imageTransformationService;

    @RequestMapping(value = "/resize", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity transform() {

        return new ResponseEntity(imageTransformationService.getTransformation(), HttpStatus.OK);

    }

}
