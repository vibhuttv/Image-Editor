import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
// import java.awt.*;

public class ImageEditor {

    public static BufferedImage ToGrayScale(BufferedImage inputImage)
    {
        int width = inputImage.getWidth();
        int height = inputImage.getHeight();

        //                TYPE OF IMAGE YOU WANT TO BUILD
        BufferedImage outputImage = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY );

        //                GIVE RESPECTIVE RBG VALUES TO OUTPUT IMAGE
        for (int i=0; i<height; i++)
            for(int j=0; j<width; j++)
                outputImage.setRGB(j, i, inputImage.getRGB(j,i));

        return outputImage;

    }


    public static void main(String[] args)
    {
        File inputFile = new File("/resources/images/image.jpg");
        try {
            BufferedImage inputImage = ImageIO.read(inputFile);
            BufferedImage greyscale_image = ToGrayScale(inputImage);
            File greyscale_file = new File("greyscale_img.jpg");

            ImageIO.write(greyscale_image, "jpg", greyscale_file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
