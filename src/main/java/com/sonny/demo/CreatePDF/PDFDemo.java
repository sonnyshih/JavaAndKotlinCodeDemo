package com.sonny.demo.CreatePDF;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

/**
 * Reference to: https://www.itread01.com/content/1548816868.html
 * */

public class PDFDemo {

    public static void main(String[] args) {

        // 新建document物件
        // Setting the A4 size paper
        Document document = new Document(PageSize.A4, 3, 3, 3, 3);
//        Document document = new Document(PageSize.A4, 10, 10, 40, 40);

        try {
            // 建立一個書寫器(Writer)與document物件關聯，通過書寫器(Writer)可以將文件寫入到磁碟中。
            // 建立 PdfWriter 物件 第一個引數是對文件物件的引用，第二個引數是檔案的實際名稱，在該名稱中還會給出其輸出路徑。
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("/Users/hongjie/Downloads/temp/test.pdf"));

            // 開啟文件
            document.open();

            // 3列的表.
            PdfPTable table = new PdfPTable(3);
            table.setWidthPercentage(100); // 寬度100%填充
            table.setSpacingBefore(10f); // 前間距
            table.setSpacingAfter(10f); // 後間距

            List<PdfPRow> listRow = table.getRows();

            //設定列寬
            float[] columnWidths = { 1f, 2f, 3f };
            table.setWidths(columnWidths);

            //行1
            PdfPCell cells1[]= new PdfPCell[3];
            PdfPRow row1 = new PdfPRow(cells1);

            //單元格
            cells1[0] = new PdfPCell(new Paragraph("111"));//單元格內容
            cells1[0].setBorderColor(BaseColor.BLUE);//邊框驗證
            cells1[0].setPaddingLeft(20);//左填充20
            cells1[0].setHorizontalAlignment(Element.ALIGN_CENTER);//水平居中
            cells1[0].setVerticalAlignment(Element.ALIGN_MIDDLE);//垂直居中

            cells1[1] = new PdfPCell(new Paragraph("222"));
            cells1[2] = new PdfPCell(new Paragraph("333"));

            //把第一行新增到集合
            listRow.add(row1);
//          listRow.add(row2);
            //把表格新增到檔案中
            document.add(table);

//            PdfPTable pdfPTable = new PdfPTable(1);  //create PDF table with the given widths
//            pdfPTable.setTotalWidth(200f);                      // set table width a percentage of the page width



//            PdfPTable firstRow = getFirstRow();
//            addToMainTable(pdfPTable, firstRow);



            // Add The header table
//            PdfPTable headerPdfPTable = getHeaderPdfPTable();
//            addToMainTable(pdfPTable, headerPdfPTable);

            // Add Maintenance No
//            PdfPTable maintenanceNoPdfPTable = getMaintenanceNoPdfPTable();;
//            addToMainTable(pdfPTable, maintenanceNoPdfPTable);

            // Add customer data table (2 columns)
//            PdfPTable customerDataPdfPTable_2 = getCustomerDataPdfPTable_2();
//            addToMainTable(pdfPTable, customerDataPdfPTable_2);

            // Add customer data table (3 columns)
//            PdfPTable customerDataPdfPTable_3 = getCustomerDataPdfPTable_3();
//            addToMainTable(pdfPTable, customerDataPdfPTable_3);


            // 新增一個內容段落
//            document.add(new Paragraph("Hello World!"));

//            document.add(pdfPTable);

            // 5.關閉文件
            document.close();
            writer.close();

        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    private static void addTableNoBorderCell(PdfPTable table, int textSize, String text){
        BaseFont baseFont = null;
        try {
            baseFont = BaseFont.createFont("STSong-Light","UniGB-UCS2-H",BaseFont.NOT_EMBEDDED);
            Font font = new Font(baseFont, textSize);
            PdfPCell pdfPcell = new PdfPCell(new Phrase(text,font));
            pdfPcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            pdfPcell.setBorder(Rectangle.NO_BORDER);
            table.addCell(pdfPcell);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void addToMainTable(PdfPTable pdfPTable, PdfPTable subtable){
        PdfPCell pdfPcell = new PdfPCell(subtable);
        pdfPcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        pdfPcell.setBorder(Rectangle.NO_BORDER);
        pdfPTable.addCell(pdfPcell);

    }

    private static void addTableCell(PdfPTable table, int textSize, String text){
        BaseFont baseFont = null;
        try {
            baseFont = BaseFont.createFont("STSong-Light","UniGB-UCS2-H",BaseFont.NOT_EMBEDDED);
            Font font = new Font(baseFont, textSize);
            table.addCell(new PdfPCell(new Phrase(text,font)));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    private static PdfPTable getFirstRow(){
        float[] tableColumnWidths = {1f, 1f, 1f};   // each column width
        PdfPTable pdfPTable = new PdfPTable(tableColumnWidths);  //create PDF table with the given widths
        pdfPTable.setTotalWidth(200f);                      // set table width a percentage of the page width

        // Row Data
        addTableNoBorderCell(pdfPTable, 12, "□ 領回轉發 □ 畫撥入帳 ");
        addTableNoBorderCell(pdfPTable, 12, "");
        addTableNoBorderCell(pdfPTable, 12, "aaa國testsadfasdaf3 ");
        return pdfPTable;
    }

    private static PdfPTable getHeaderPdfPTable(){

        PdfPTable pdfpTable = new PdfPTable(1);  //create PDF table with the given widths
        pdfpTable.setTotalWidth(530f);                      // set table width a percentage of the page width

        /** Company Name */
        addTableNoBorderCell(pdfpTable, 32,  "hello direk\n");

        /** Company Tel, Fax */
        addTableNoBorderCell(pdfpTable, 12, "\nTel: " + "   FAX: ");

        /** Company Address */
        addTableNoBorderCell(pdfpTable, 12, "address\n\n");

        /** Order Name */
//        String documentName = maintenanceEntity.getDocumentName() ;

        addTableNoBorderCell(pdfpTable, 18, "yeaarasd\n\n");

        return pdfpTable;
    }

    private static PdfPTable getMaintenanceNoPdfPTable(){
        /** Customer Data Table */
        float[] tableColumnWidths = {1f};   // each column width (have 2 columns)
        PdfPTable pdfPTable = new PdfPTable(tableColumnWidths);  //create PDF table with the given widths
        pdfPTable.setTotalWidth(800f);                      // set table width a percentage of the page width

        // Row Data
        addTableCell(pdfPTable, 12, "aaa國testsadfasdaf: ");
        return pdfPTable;
    }

    private static PdfPTable getCustomerDataPdfPTable_2(){
        /** Customer Data Table */
        float[] tableColumnWidths = {1f, 1f};   // each column width (have 2 columns)
        PdfPTable pdfPTable = new PdfPTable(tableColumnWidths);  //create PDF table with the given widths
        pdfPTable.setTotalWidth(530f);                      // set table width a percentage of the page width

        // Row Data
        addTableCell(pdfPTable, 12, "公  司: ");
//        switch (maintenanceEntity.getDocumentType()){
//            case DOC_TYPE_A:    // 保養單
//                addTableCell(pdfPTable, 12, "保管人: " + maintenanceEntity.getConPerson());
//                break;
//
//            case DOC_TYPE_B:    // 維修單
//                addTableCell(pdfPTable, 12, "報價日期: " + maintenanceEntity.getQuoteDate());
//                break;
//        }

        // Row Data
        addTableCell(pdfPTable, 12, "科  系: ");
//        switch (maintenanceEntity.getDocumentType()) {
//            case DOC_TYPE_A:    // 保養單
//                addTableCell(pdfPTable, 12, "財產編號: " + maintenanceEntity.getPropertyNum());
//                break;
//
//            case DOC_TYPE_B:    // 維修單
//                addTableCell(pdfPTable, 12, "維修編號: " + maintenanceEntity.getRepairNum());
//                break;
//        }

        return pdfPTable;
    }

    private static PdfPTable getCustomerDataPdfPTable_3(){
        /** Customer Data Table */
        float[] tableColumnWidths = {1f, 1f, 1f};   // each column width (have 3 columns)
        PdfPTable pdfPTable = new PdfPTable(tableColumnWidths);  //create PDF table with the given widths
        pdfPTable.setTotalWidth(530f);                      // set table width a percentage of the page width

        // Row Data
        addTableCell(pdfPTable, 12, "電  話: ");
        addTableCell(pdfPTable, 12, "Email: ");
        addTableCell(pdfPTable, 12, "醫工Mail: ");

        // Row Data
        addTableCell(pdfPTable, 12, "機器廠牌: " );
        addTableCell(pdfPTable, 12, "機器型號: " );
        addTableCell(pdfPTable, 12, "機器序號: " );

        return pdfPTable;
    }

}
