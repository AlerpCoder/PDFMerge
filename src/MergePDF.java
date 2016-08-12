import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.tools.ant.types.Path;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by AlerpCoder on 31.07.2016.
 */
public class MergePDF {

    private static List<File> pdfFiles = new LinkedList<>();
    private static int counter = 0;

    public static void pdfGet(File file) {
        pdfFiles.add(file);
        counter++;
    }

    public static void merge() throws IOException {
        PDDocument pdf = PDDocument.load(pdfFiles.get(0));
        String save = null;
        for (int i = 1; i < pdfFiles.size(); i++) {

            PDDocument pdfN = PDDocument.load(pdfFiles.get(i));
            for (int j = 0; j < pdfFiles.size(); j++) {

               try {
                   pdf.addPage(pdfN.getPages().get(j));//index out of Bounds
               }catch(Exception ex){
                   System.out.println(ex.getStackTrace());
                }

            }
            System.out.printf(pdfFiles.get(0).getParent());
            pdf.save(pdfFiles.get(0).getParent()+"\\blubb.pdf");//dummy name;
            pdfN.close();
        }
        pdf.close();
    }


}
