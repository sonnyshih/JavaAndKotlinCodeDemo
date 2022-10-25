package com.sonny.demo.CreateWord;

import com.spire.pdf.FileFormat;
import com.spire.pdf.PdfDocument;

public class PdfConvertToWordDemo {
    public static void main(String[] args) {
        String workingDir = System.getProperty("user.dir");
        System.out.println("Working Directory = " + workingDir);

        String dirPath = workingDir + "/src/main/java/com/sonny/demo/CreateWord/";
        System.out.println("dirPath = " + dirPath);

        pdfConvertToWord(dirPath);

    }

    public static void pdfConvertToWord(String dirPath){
        // 要注意有沒有裝需要的字型
        String pdfPath = dirPath + "test.pdf";
        String docPath = dirPath + "ToDoc.doc";
        String docxPath = dirPath + "ToDocx.docx";

        //Create a PdfDocument object
        PdfDocument doc = new PdfDocument();

        //Load a sample PDF document
        doc.loadFromFile(pdfPath);

        //Convert PDF to Doc and save it to a specified path
        doc.saveToFile(docPath, FileFormat.DOC);

        //Convert PDF to Docx and save it to a specified path
        doc.saveToFile(docxPath, FileFormat.DOCX);

        doc.close();

    }

}
