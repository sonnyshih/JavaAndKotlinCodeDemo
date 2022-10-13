package com.sonny.demo.readWriteExcel;

import org.apache.poi.hssf.usermodel.*;

import java.io.FileOutputStream;
import java.io.IOException;

public class ExportExcelDemo {
    public static void main(String[] args) {
        String workingDir = System.getProperty("user.dir");
        System.out.println("Working Directory = " + workingDir);

        String dirPath = workingDir + "/src/main/java/com/sonny/demo/readWriteExcel/";

        System.out.println("dirPath = " + dirPath);

        //表頭資料
        String[] header = {"ID","姓名","性別","年齡","地址","分數"};
        //資料內容
        String[] student1 = {"1","小紅","女","23","台北市中山區","96"};
        String[] student2 = {"2","小強","男","26","台中市東區","91"};
        String[] student3 = {"3","小明","男","28","新北市三峽區","90"};

        //宣告一個工作簿
        HSSFWorkbook workbook = new HSSFWorkbook();

        //生成一個表格，設定表格名稱為"學生表"
        HSSFSheet sheet = workbook.createSheet("學生表");

        //設定表格列寬度為10個位元組
        sheet.setDefaultColumnWidth(10);

        //建立第一行表頭
        HSSFRow sheetRow = sheet.createRow(0);  // 建立第1個row
        for (int i = 0; i < header.length; i++) {
            //建立一個單元格
            HSSFCell cell = sheetRow.createCell(i);
            //建立一個內容物件
            HSSFRichTextString text = new HSSFRichTextString(header[i]);
            //將內容物件的文字內容寫入到單元格中
            cell.setCellValue(text);
        }


        // 寫入小紅 的資料
        HSSFRow row1 = sheet.createRow(1);  //建立第2個row
        for (int i = 0; i < student1.length; i++) {
            HSSFCell cell = row1.createCell(i);
            HSSFRichTextString text = new HSSFRichTextString(student1[i]);
            cell.setCellValue(text);
        }

        // 寫入小強 的資料
        HSSFRow row2 = sheet.createRow(2);  //建立第3個row
        for (int i = 0; i < student2.length; i++) {
            HSSFCell cell = row2.createCell(i);
            HSSFRichTextString text = new HSSFRichTextString(student2[i]);
            cell.setCellValue(text);
        }

        // 寫入小明 的資料
        HSSFRow row3 = sheet.createRow(3);  //建立第4個row
        for (int i = 0; i < student3.length; i++) {
            HSSFCell cell = row3.createCell(i);
            HSSFRichTextString text = new HSSFRichTextString(student3[i]);
            cell.setCellValue(text);
        }

        // Export Excel file
        try {
            String path = dirPath + "student.xls";
            FileOutputStream fos = new FileOutputStream(path);
            workbook.write(fos);
            fos.flush();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
