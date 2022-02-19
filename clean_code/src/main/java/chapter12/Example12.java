package chapter12;

import com.sun.imageio.plugins.common.ImageUtil;

public class Example12 {
    public void scaleToOneDimension(float desiredDimension, float imageDimansion){
        if(Math.abs(desiredDimension - imageDimansion) <errorThreshold)
            return;
        float scaleFactor = desiredDimension / imageDimansion;
        scaleFactor = (float)(Math.floor(scaleFactor * 100) * 0.01f);

        RenderedOp newImage = ImageUtilities.getScaledImage(image, scalingFactor, scalingFactor);
        image.dispose();
        System.gc();
        image = newImage;
    }
    public synchronized void rotate(int degrees) {
        RenderedOp newImage = ImageUtilies.getRotatedImage(image, degrees);
        image.dispose();
        System.gc();
        image = newImage;
    }
}
