package Testing;

/**
 *
 * @author Jesus Cortez
 */
import java.io.*;
import net.sourceforge.tess4j.*;


public class testTesseract {
    
    public static void main(String[] args) throws IOException {
        //the image file will be changed to whatever is uploaded by the User
        File imageFile = new File("C:\\Users\\Cortez\\Desktop\\ModifiedCheckTemplate.jpg"); //edit path to image of check
        Tesseract instance = Tesseract.getInstance(); //
        //must set path to wherever the target language file is at        
        instance.setDatapath("C:\\Users\\Cortez\\Documents\\NetBeansProjects\\TestTesseract\\src\\TesseractSources\\tessdata");
        //name of target language file: eng
        instance.setLanguage("eng");

        try {

            String result = instance.doOCR(imageFile);
            File file = new File("Scanned ouput.txt");
            BufferedWriter output = null;
            output = new BufferedWriter(new FileWriter(file));
            //writes the extracted data from image into text file
            output.write(result);
            output.close();
            
            System.out.println(result);

        } catch (TesseractException e) {
            System.err.println(e.getMessage());
        }
    }
}