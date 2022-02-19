package chapter12;

public class Example12 {
    public void scaleToOneDimension(float desiredDimension, float imageDimansion){
        if(Math.abs(desiredDimension - imageDimansion) <errorThreshold)
            return;
        float scaleFactor = desiredDimension / imageDimansion;
        scaleFactor = (float)(Math.floor(scaleFactor * 100) * 0.01f);

        replaceImage(ImageUtilities.getScaledImage(image, scalingFactor, scalingFactor));
    }
    public synchronized void rotate(int degrees) {
        replaceImage(ImageUtilies.getRotatedImage(image, degrees));
    }

    public void replaceImage(RenderedOp newImage){
        image.dispose();
        System.gc();
        image = newImage;
    }
}
