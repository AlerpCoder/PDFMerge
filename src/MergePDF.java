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

    public static String merge() throws IOException {
        PDDocument pdf = PDDocument.load(pdfFiles.get(0));
        System.out.println(pdf.toString());
        String save = null;
        for (int i = 1; i < pdfFiles.size(); i++) {
            System.out.println(i);
            PDDocument pdfN = PDDocument.load(pdfFiles.get(i));
            for (int j = 0; j < pdfFiles.size(); j++) {
                System.out.println(j);
                System.out.println("Gesamtlänge =" + pdfFiles.size());
                pdf.addPage(pdfN.getPages().get(j));//index out of Bounds

            }
            pdf.save("blubb.pdf");//dummy name
            save = pdf.getResourceCache().toString();
            System.out.println(save);
            pdfN.close();
        }
        pdf.close();
        return save.toString();
    }

    /*aktuelles Programm ist dafür da das man nur 2 Programme miteinander verschmelzt diese abfrage braucht man wenn man mehr als eine datei verschmelzen will*/


/*    private static void getArgumentsforMerge(String[] args) throws IOException {
        if( arraywithProgramNameAndArguments== null){
            System.out.println("Bitte geben sie die Argumente richtig an: [cmd] "[Path]" "[Path]" -"[targetPath]"=[mergeName]");
            return null;
        }
        if (arraywithProgramNameAndArguments[0]!= null) {
            if (arraywithProgramNameAndArguments[1] != null && arraywithProgramNameAndArguments[2] != null) {
                if(isPath())

        File newFile1 = new File(args[0]);
        File newFile2 = new File(args[1]);
        PDDocument file1 = PDDocument.load(newFile1);
        PDDocument file2 = PDDocument.load(newFile2);
        file1.addPage(file2.getPages().get(0));
        file1.save(args[2] + ".pdf");
        file1.close();
        file2.close();


    }

*/
}
