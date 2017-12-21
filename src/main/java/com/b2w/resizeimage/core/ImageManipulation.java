package com.b2w.resizeimage.core;

import com.b2w.resizeimage.model.Image;
import com.b2w.resizeimage.utils.Constantes;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import javax.imageio.ImageIO;
import org.apache.log4j.Logger;

/**
 *
 * @author Leonardo S. Rodrigues <leonardo.silva.rodrigues2@gmail.com>
 * @since 20/12/2017
 * @version 1.0
 */
public class ImageManipulation {

    private final Logger LOGGER = Logger.getLogger(ImageManipulation.class);

    public static byte[] consumeImages(Image img) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte buffer[] = new byte[Constantes.BUFFER_SIZE];

        URL url;
        try {
            url = new URL(img.getUrl());
            BufferedInputStream stream = new BufferedInputStream(url.openStream(), Constantes.BUFFER_SIZE);
            int read = 0;
            while ((read = stream.read(buffer, 0, buffer.length)) != -1) {
                baos.write(buffer, 0, read);
            }
            baos.flush();
        } catch (MalformedURLException ex) {
            java.util.logging.Logger.getLogger(ImageManipulation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(ImageManipulation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return baos.toByteArray();
    }

    public static ImageIO exposeImage(byte[] img, String nome) {
        try {
            final BufferedImage bufferedImage = ImageIO.read(new ByteArrayInputStream(img));
            ImageIO.write(bufferedImage, "jpg", new File("/home/leonardo/Documents/"+nome));
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
