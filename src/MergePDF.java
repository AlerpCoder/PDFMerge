import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.tools.ant.types.Path;

import java.io.File;
import java.io.IOException;

/**
 * Created by AlerpCoder on 31.07.2016.
 */
public class MergePDF {
    /*TODO Java FX multi pdfs*/

    /*aktuelles Programm ist dafür da das man nur 2 Programme miteinander verschmelzt diese abfrage braucht man wenn man mehr als eine datei verschmelzen will*/
    private static boolean isPath(String pathOrTarget) {

        if (pathOrTarget.contains("=") || pathOrTarget.contains("-")) {
            return false;
        } else {
            return true;
        }
    }

    private static void getArgumentsforMerge(String[] args) throws IOException {
        /*if( arraywithProgramNameAndArguments== null){
            System.out.println("Bitte geben sie die Argumente richtig an: [cmd] "[Path]" "[Path]" -"[targetPath]"=[mergeName]");
            return null;
        }
        if (arraywithProgramNameAndArguments[0]!= null) {
            if (arraywithProgramNameAndArguments[1] != null && arraywithProgramNameAndArguments[2] != null) {
                if(isPath())*/

        File newFile1 = new File(args[0]);
        File newFile2 = new File(args[1]);
        PDDocument file1 = PDDocument.load(newFile1);
        PDDocument file2 = PDDocument.load(newFile2);
        file1.addPage(file2.getPages().get(0));
        file1.save(args[2]+".pdf");
        file1.close();
        file2.close();


    }


    public static void main(String[] args) throws IOException {
        String[] testeingabe =new String[3];
        testeingabe[0]="path1";
        testeingabe[1]="path2";
        testeingabe[2]="bla";
        getArgumentsforMerge(testeingabe);

    }
}
