package com.sonny.demo.readWriteExcel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadExcelDemo {
    public static void main(String[] args) {
        String workingDir = System.getProperty("user.dir");
        System.out.println("Working Directory = " + workingDir);

        String dirPath = workingDir + "/src/main/java/com/sonny/demo/readWriteExcel/";

        System.out.println("dirPath = " + dirPath);

        String fileName="test.xls";
        String path = dirPath + fileName;


        try {
            Workbook workbook;
            FileInputStream file = new FileInputStream(path);

            if (fileName.endsWith(".xls")) {
                workbook = new HSSFWorkbook(file);
            } else if (fileName.endsWith(".xlsx")){
                workbook = new XSSFWorkbook(file);
            } else {
                System.out.println("上傳的檔案非Excel檔案");
                return;
            }
            Sheet sheet = workbook.getSheetAt(0);   // 取得第1個sheet
            int rows = sheet.getPhysicalNumberOfRows();     // 有多少筆資料

            System.out.println("共有 " + rows + " 筆資料");

            for (int i=0; i<rows; i++){
                Row row = sheet.getRow(i);  // 取得每一個row

                for (Cell cell : row) { // 取得每一個欄位

                    String data = "";

                    // if only get string, using the DataFormatter
//                    DataFormatter formatter = new DataFormatter();
//                    data = formatter.formatCellValue(cell);

                    switch (cell.getCellType()) {
                        case STRING:
                            data = cell.getStringCellValue();
                            System.out.print(data + "\t\t");
                            break;

                        case NUMERIC:
                            data = String.valueOf(cell.getNumericCellValue());
                            System.out.print(data + "\t\t");
                            break;

                        case BOOLEAN:
                            data = String.valueOf(cell.getBooleanCellValue());
                            System.out.print(data + "\t\t");
                            break;

                        case FORMULA:
                            break;

                        default:
                            break;
                    }
                }

                System.out.println("#####");

            }// End for

            // 利用for each
//            for (Row row : sheet) {
//                for (Cell cell : row) {
//                    String data = "";
//                    switch (cell.getCellType()) {
//                        case STRING:
//                            data = cell.getStringCellValue();
//                            System.out.print(data + "\t\t");
//                            break;
//
//                        case NUMERIC:
//                            data = String.valueOf(cell.getNumericCellValue());
//                            System.out.print(data + "\t\t");
//                            break;
//
//                        case BOOLEAN:
//                            data = String.valueOf(cell.getBooleanCellValue());
//                            System.out.print(data + "\t\t");
//                            break;
//
//                        case FORMULA:
//                            break;
//
//                        default:
//                            break;
//                    }
//                }
//
//                System.out.println("#####");
//
//            }// End for

            file.close();
            workbook.close();
        } catch (IOException e) {

            throw new RuntimeException(e);
        }
    }
}
