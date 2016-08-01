import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.File;
import java.io.IOException;

/**
 * Created by AlerpCoder on 31.07.2016.
 */
public class MergePDF {
    /*TODO*/

    /*aktuelles Programm ist dafür da das man nur 2 Programme miteinander verschmelzt diese abfrage braucht man wenn man mehr als eine datei verschmelzen will*/
    private static boolean isPath(String pathOrTarget) {

        if (pathOrTarget.contains("=")||pathOrTarget.contains("-")) {
            return false;
        } else {
            return true;
        }
    }

    private static void getArgumentsforMerge(String[] arraywithProgramNameAndArguments) throws IOException {
        /*if( arraywithProgramNameAndArguments== null){
            System.out.println("Bitte geben sie die Argumente richtig an: [cmd] [Path] [Path] -[targetPath]=[mergeName]");
            return null;
        }
        if (arraywithProgramNameAndArguments[0]!= null) {
            if (arraywithProgramNameAndArguments[1] != null && arraywithProgramNameAndArguments[2] != null) {
                if(isPath())*/
        File newFile1= new File(arraywithProgramNameAndArguments[0]);
        File newFile2= new File(arraywithProgramNameAndArguments[1]);
        PDDocument file1 = PDDocument.load(newFile1);
        PDDocument file2 = PDDocument.load(newFile2);
        file1.addPage(file2.getPages().get(1));
        file1.save(arraywithProgramNameAndArguments[2]);
        file1.close();
        file2.close();


    }


    public static void main(String[] args) throws IOException {
        File newFile1= new File(args[0]);
        File newFile2= new File(args[1]);
        System.out.println(newFile1.toString());
        PDDocument file1 = PDDocument.load(newFile1);
        PDDocument file2 = PDDocument.load(newFile2);
        file1.addPage(file2.getPages().get(1));
        file1.save(args[2]+".pdf");
        file1.close();
        file2.close();
        System.out.println("Fertig");
    }
}
