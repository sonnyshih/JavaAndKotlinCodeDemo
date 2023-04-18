package com.sonny.demo.readWriteExcel;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ExportExcelDemo {
    public static void main(String[] args) {
        String workingDir = System.getProperty("user.dir");
        System.out.println("Working Directory = " + workingDir);

        String dirPath = workingDir + "/src/main/java/com/sonny/demo/readWriteExcel/";

        System.out.println("dirPath = " + dirPath);

        complexDemo(dirPath);
//        basicDemo(dirPath);
    }

    /**
     * 1. set font setting: https://www.ez2o.com/Blog/Post/csharp-Excel-NPOI-Font-Style
     * 2. set Cell Font Style: https://www.baeldung.com/apache-poi-change-cell-font
     * 3. set cell format Style: https://cloud.tencent.com/developer/article/1337088?from=15425&areaSource=102001.1&traceId=9gw1KZyvhicTYnNWWBtLK
     * */
    private static void complexDemo(String dirPath){


        //宣告一個工作簿
        HSSFWorkbook workbook = new HSSFWorkbook();

        //生成一個表格，設定表格名稱
        HSSFSheet sheet = workbook.createSheet("名單");
        sheet.setColumnWidth(0, getLengthByWordNum(10));  // 設定第1欄寬度
        sheet.setColumnWidth(1, getLengthByWordNum(10));  // 設定第2欄寬度
        sheet.setColumnWidth(2, getLengthByWordNum(15));  // 設定第3欄寬度
        sheet.setColumnWidth(3, getLengthByWordNum(15));
        sheet.setColumnWidth(4, getLengthByWordNum(10));
        sheet.setColumnWidth(5, getLengthByWordNum(10));
        sheet.setColumnWidth(6, getLengthByWordNum(25));
        sheet.setColumnWidth(7, getLengthByWordNum(20));


        //設定表格列寬度為10個位元組
        sheet.setDefaultColumnWidth(10);

        int index = 0;
        // 明志科技大學
        sheet.addMergedRegion(CellRangeAddress.valueOf("A1:H1"));
        HSSFRow sheetRow0 = sheet.createRow(index);  // 建立第1個row
        sheetRow0.setHeight(getHeightByPixel(36));    // -1: 自動
        HSSFCell cell0 = sheetRow0.createCell(0);
        cell0.setCellStyle(getBoldFontStyle(workbook));
        HSSFRichTextString text0 = new HSSFRichTextString("hello world");
        cell0.setCellValue(text0);	//將內容物件的文字內容寫入到單元格中


        // xxx學年度學生赴合作機構面談錄取名單
        index++;
        sheet.addMergedRegion(CellRangeAddress.valueOf("A2:H2"));
        HSSFRow sheetRow1 = sheet.createRow(index);  // 建立row
        sheetRow1.setHeight(getHeightByPixel(36));    // -1: 自動
        HSSFCell cell1 = sheetRow1.createCell(0);
        cell1.setCellStyle(getBoldFontStyle(workbook));
        HSSFRichTextString text1 = new HSSFRichTextString("名單");
        cell1.setCellValue(text1);	//將內容物件的文字內容寫入到單元格中

        // 合作機構名稱
        index++;
        sheet.addMergedRegion(CellRangeAddress.valueOf("A3:B3"));
        HSSFRow sheetRow2 = sheet.createRow(index);  // 建立row
        sheetRow2.setHeight(getHeightByPixel(45));    // -1: 自動
        HSSFCell cell2_1 = sheetRow2.createCell(0);
        cell2_1.setCellStyle(getBoldFontStyle(workbook));
        HSSFRichTextString text2_1 = new HSSFRichTextString("名稱");
        cell2_1.setCellValue(text2_1);
        sheet.addMergedRegion(CellRangeAddress.valueOf("C3:H3"));
        HSSFCell cell2_2 = sheetRow2.createCell(2);
        cell2_2.setCellStyle(getBoldFontStyle(workbook));
        HSSFRichTextString text2_2 = new HSSFRichTextString("hello");
        cell2_2.setCellValue(text2_2);

        // 面試方式
        index++;
        sheet.addMergedRegion(CellRangeAddress.valueOf("A4:B4"));
        HSSFRow sheetRow3 = sheet.createRow(index);  // 建立row
        sheetRow3.setHeight(getHeightByPixel(45));    // -1: 自動
        HSSFCell cell3_1 = sheetRow3.createCell(0);
        cell3_1.setCellStyle(getBoldFontStyle(workbook));
        HSSFRichTextString text3_1 = new HSSFRichTextString("面試");
        cell3_1.setCellValue(text3_1);
        sheet.addMergedRegion(CellRangeAddress.valueOf("C4:H4"));
        HSSFCell cell3_2 = sheetRow3.createCell(2);
        CellStyle cell3_2Style = getNormalStyle(workbook);
        cell3_2Style.setAlignment(HorizontalAlignment.CENTER);         // set the data Horizontal center position
        cell3_2Style.setVerticalAlignment(VerticalAlignment.CENTER);   // set the data vertical center position
        Font cell3_2Font = workbook.createFont();
        cell3_2Font.setFontName("標楷體");
        cell3_2Font.setFontHeightInPoints((short) 14);      // set the font size
        cell3_2Style.setFont(cell3_2Font);
        cell3_2.setCellStyle(cell3_2Style);
        HSSFRichTextString text3_2 = new HSSFRichTextString("視訊面試");
        cell3_2.setCellValue(text3_2);

        // 面試日期
        index++;
        sheet.addMergedRegion(CellRangeAddress.valueOf("A5:B5"));
        HSSFRow sheetRow4 = sheet.createRow(index);  // 建立row
        sheetRow4.setHeight(getHeightByPixel(45));    // -1: 自動
        HSSFCell cell4_1 = sheetRow4.createCell(0);
        cell4_1.setCellStyle(getBoldFontStyle(workbook));
        HSSFRichTextString text4_1 = new HSSFRichTextString("面試日期");
        cell4_1.setCellValue(text4_1);
        sheet.addMergedRegion(CellRangeAddress.valueOf("C5:H5"));
        HSSFCell cell4_2 = sheetRow4.createCell(2);
        CellStyle cell4_2Style = getNormalStyle(workbook);
        cell4_2Style.setAlignment(HorizontalAlignment.CENTER);         // set the data Horizontal center position
        cell4_2Style.setVerticalAlignment(VerticalAlignment.CENTER);   // set the data vertical center position
        Font cell4_2Font = workbook.createFont();
        cell4_2Font.setFontName("標楷體");
        cell4_2Font.setFontHeightInPoints((short) 14);      // set the font size
        cell4_2Style.setFont(cell4_2Font);
        cell4_2.setCellStyle(cell4_2Style);
        HSSFRichTextString text4_2 = new HSSFRichTextString("111年06月13日 (星期一)");
        cell4_2.setCellValue(text4_2);

        // 面試主管
        index++;
        sheet.addMergedRegion(CellRangeAddress.valueOf("A6:B6"));
        HSSFRow sheetRow5 = sheet.createRow(index);  // 建立row
        sheetRow2.setHeight(getHeightByPixel(52));    // -1: 自動
        sheetRow5.setHeight((short) getHeightByPixel(50));    // -1: 自動
        HSSFCell cell5_1 = sheetRow5.createCell(0);
        CellStyle cell5_1Style = getBoldFontStyle(workbook);
        cell5_1Style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        cell5_1Style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cell5_1.setCellStyle(cell5_1Style);
        HSSFRichTextString text5_1 = new HSSFRichTextString("面試主管");
        cell5_1.setCellValue(text5_1);
        sheet.addMergedRegion(CellRangeAddress.valueOf("C6:H6"));
        HSSFCell cell5_2 = sheetRow5.createCell(2);
        CellStyle cell5_2Style = getNormalStyle(workbook);
        cell5_2Style.setAlignment(HorizontalAlignment.CENTER);         // set the data Horizontal center position
        cell5_2Style.setVerticalAlignment(VerticalAlignment.BOTTOM);   // set the data vertical center position
        Font cell5_2Font = workbook.createFont();
        cell5_2Font.setFontName("標楷體");
        cell5_2Font.setColor(IndexedColors.RED.getIndex()); // set the font color
        cell5_2Font.setFontHeightInPoints((short) 10);      // set the font size
        cell5_2Style.setFont(cell5_2Font);
        cell5_2.setCellStyle(cell5_2Style);

        HSSFRichTextString text5_2 = new HSSFRichTextString("(面試主管請簽名)");
        cell5_2.setCellValue(text5_2);

        // 面試名單/合作機構錄取記錄 Title
        index++;
        sheet.addMergedRegion(CellRangeAddress.valueOf("A7:c7"));
        HSSFRow sheetRow6 = sheet.createRow(index);  // 建立row
        sheetRow6.setHeight(getHeightByPixel(45));    // -1: 自動
        HSSFCell cell6_1 = sheetRow6.createCell(0);
        cell6_1.setCellStyle(getBoldFontStyle(workbook));
        HSSFRichTextString text6_1 = new HSSFRichTextString("面試名單");
        cell6_1.setCellValue(text6_1);
        sheet.addMergedRegion(CellRangeAddress.valueOf("D7:H7"));
        HSSFCell cell6_2 = sheetRow6.createCell(3);
        CellStyle cell6_2Style = getBoldFontStyle(workbook);
        cell6_2Style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        cell6_2Style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cell6_2.setCellStyle(cell6_2Style);
        HSSFRichTextString text6_2 = new HSSFRichTextString("合作機構錄取記錄");
        cell6_2.setCellValue(text6_2);

        // 班級/姓名/手機/面試報到/錄取結果/錄取部門或職務/ 實習地點 Title
        index++;
        HSSFRow sheetRow7 = sheet.createRow(index);  // 建立row
        sheetRow7.setHeight(getHeightByPixel(24));    // -1: 自動

        HSSFCell cell7_0 = sheetRow7.createCell(0);
        cell7_0.setCellStyle(getBoldFontStyle(workbook));
        HSSFRichTextString text7_0 = new HSSFRichTextString("班級");
        cell7_0.setCellValue(text7_0);

        HSSFCell cell7_1 = sheetRow7.createCell(1);
        cell7_1.setCellStyle(getBoldFontStyle(workbook));
        HSSFRichTextString text7_1 = new HSSFRichTextString("姓名");
        cell7_1.setCellValue(text7_1);

        HSSFCell cell7_2 = sheetRow7.createCell(2);
        cell7_2.setCellStyle(getBoldFontStyle(workbook));
        HSSFRichTextString text7_2 = new HSSFRichTextString("手機");
        cell7_2.setCellValue(text7_2);

        HSSFCell cell7_3 = sheetRow7.createCell(3);
        CellStyle cell7_3Style = getBoldFontStyle(workbook);
        cell7_3Style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        cell7_3Style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cell7_3.setCellStyle(cell7_3Style);
        HSSFRichTextString text7_3 = new HSSFRichTextString("面試報到");
        cell7_3.setCellValue(text7_3);

        sheet.addMergedRegion(CellRangeAddress.valueOf("E8:F8"));
        HSSFCell cell7_4 = sheetRow7.createCell(4);
        CellStyle cell7_4Style = getBoldFontStyle(workbook);
        cell7_4Style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        cell7_4Style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cell7_4.setCellStyle(cell7_4Style);
        HSSFRichTextString text7_4 = new HSSFRichTextString("錄取結果");
        cell7_4.setCellValue(text7_4);

        HSSFCell cell7_6 = sheetRow7.createCell(6);
        cell7_6.setCellStyle(getBoldFontStyle(workbook));
        HSSFRichTextString text7_6 = new HSSFRichTextString("錄取部門\n或職務");
        cell7_6.setCellValue(text7_6);

        HSSFCell cell7_7 = sheetRow7.createCell(7);
        cell7_7.setCellStyle(getBoldFontStyle(workbook));
        HSSFRichTextString text7_7 = new HSSFRichTextString("實習地點");
        cell7_7.setCellValue(text7_7);

        index++;
        HSSFRow sheetRow8 = sheet.createRow(index);  // 建立row
        HSSFCell cell8_4 = sheetRow8.createCell(4);
        CellStyle cell8_4Style = getBoldFontStyle(workbook);
        cell8_4Style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        cell8_4Style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cell8_4.setCellStyle(cell8_4Style);
        HSSFRichTextString text8_4 = new HSSFRichTextString("正取\n備取\n不錄取");
        cell8_4.setCellValue(text8_4);

        HSSFCell cell8_5 = sheetRow8.createCell(5);
        CellStyle cell8_5Style = getBoldFontStyle(workbook);
        cell8_5Style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        cell8_5Style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cell8_5.setCellStyle(cell8_5Style);
        HSSFRichTextString text8_5 = new HSSFRichTextString("排序");
        cell8_5.setCellValue(text8_5);

        sheet.addMergedRegion(CellRangeAddress.valueOf("A8:A9"));   // 班級 欄位merge
        sheet.addMergedRegion(CellRangeAddress.valueOf("B8:B9"));   // 姓名 欄位merge
        sheet.addMergedRegion(CellRangeAddress.valueOf("C8:C9"));   // 手機 欄位merge
        sheet.addMergedRegion(CellRangeAddress.valueOf("D8:D9"));   // 面試報到 欄位merge
        sheet.addMergedRegion(CellRangeAddress.valueOf("G8:G9"));   // 錄取部門或職務 欄位merge
        sheet.addMergedRegion(CellRangeAddress.valueOf("H8:H9"));   // 實習地點 欄位merge

        for (int i=0; i<5; i++){
            index++;
            HSSFRow sheetRow = sheet.createRow(index);  // 建立第個row
            sheetRow.setHeight(getHeightByPixel(30));    // -1: 自動
            HSSFCell dataCell0 = sheetRow.createCell(0);
            dataCell0.setCellStyle(setDataCell(workbook));
            HSSFRichTextString dataText0 = new HSSFRichTextString("aaa_"+i);
            dataCell0.setCellValue(dataText0);

            HSSFCell dataCell1 = sheetRow.createCell(1);
            dataCell1.setCellStyle(setDataCell(workbook));
            HSSFRichTextString dataText1 = new HSSFRichTextString("bbb_"+i);
            dataCell1.setCellValue(dataText1);

            HSSFCell dataCell2 = sheetRow.createCell(2);
            dataCell2.setCellStyle(setDataCell(workbook));
            HSSFRichTextString dataText2 = new HSSFRichTextString("ccc_"+i);
            dataCell2.setCellValue(dataText2);

            HSSFCell dataCell3 = sheetRow.createCell(3);
            dataCell3.setCellStyle(setDataCell(workbook));
            HSSFRichTextString dataText3 = new HSSFRichTextString("ddd_"+i);
            dataCell3.setCellValue(dataText3);

            HSSFCell dataCell4 = sheetRow.createCell(4);
            dataCell4.setCellStyle(setDataCell(workbook));
            HSSFRichTextString dataText4 = new HSSFRichTextString("eee_"+i);
            dataCell4.setCellValue(dataText4);

            HSSFCell dataCell5 = sheetRow.createCell(5);
            dataCell5.setCellStyle(setDataCell(workbook));
            HSSFRichTextString dataText5 = new HSSFRichTextString("fff_"+i);
            dataCell5.setCellValue(dataText5);

            HSSFCell dataCell6 = sheetRow.createCell(6);
            dataCell6.setCellStyle(setDataCell(workbook));
            HSSFRichTextString dataText6 = new HSSFRichTextString("ggg_"+i);
            dataCell6.setCellValue(dataText6);

            HSSFCell dataCell7 = sheetRow.createCell(7);
            dataCell7.setCellStyle(setDataCell(workbook));
            HSSFRichTextString dataText7 = new HSSFRichTextString("hhh_"+i);
            dataCell7.setCellValue(dataText7);

        }

        setMergedCellBorder(sheet);

        long no = System.currentTimeMillis();
        String fileName = "complexDemo-" + no + ".xls";

        // Export Excel file
        try {
            String path = dirPath + fileName;
            FileOutputStream fos = new FileOutputStream(path);
            workbook.write(fos);
            fos.flush();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * if the cell is not the merged cell, using this function to set border
     */
    private static CellStyle getNormalStyle(Workbook workbook){
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setWrapText(true);    // can add the return symbol in the cell

        cellStyle.setBorderTop(BorderStyle.THIN);                       // add top border
        cellStyle.setTopBorderColor(IndexedColors.BLACK.getIndex());    // border color
        cellStyle.setBorderBottom(BorderStyle.THIN);                    // add bottom border
        cellStyle.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        cellStyle.setBorderRight(BorderStyle.THIN);                     // add right border
        cellStyle.setRightBorderColor(IndexedColors.BLACK.getIndex());
        cellStyle.setBorderLeft(BorderStyle.THIN);                      // add left border
        cellStyle.setLeftBorderColor(IndexedColors.BLACK.getIndex());

        return cellStyle;
    }

    private static CellStyle getBoldFontStyle(HSSFWorkbook workbook){
        CellStyle cellStyle = getNormalStyle(workbook);
        Font font = workbook.createFont();              // set the font
//        font.setFontName("Courier New");                // set font Name
        font.setFontName("標楷體");                // set font Name
        font.setBold(true);                             // set the bold font
//        font.setColor(IndexedColors.RED.getIndex());    // set the font color
        font.setFontHeightInPoints((short) 14);         // set the font size
        cellStyle.setFont(font);
        cellStyle.setAlignment(HorizontalAlignment.CENTER);         // set the data Horizontal center position
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);   // set the data vertical center position

        return cellStyle;
    }

    /**
     * if the cell is the merged cell, using this function to set border
     */
    private static void setMergedCellBorder(Sheet sheet){

        List<CellRangeAddress> mergedRegions = sheet.getMergedRegions();
        for (CellRangeAddress rangeAddress : mergedRegions) {
            RegionUtil.setBorderTop(BorderStyle.THIN, rangeAddress, sheet);
            RegionUtil.setBorderLeft(BorderStyle.THIN, rangeAddress, sheet);
            RegionUtil.setBorderRight(BorderStyle.THIN, rangeAddress, sheet);
            RegionUtil.setBorderBottom(BorderStyle.THIN, rangeAddress, sheet);
        }

    }

    private static CellStyle setDataCell(Workbook workbook){
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setWrapText(true);    // can add the return symbol in the cell

        cellStyle.setBorderTop(BorderStyle.THIN);                       // add top border
        cellStyle.setTopBorderColor(IndexedColors.BLACK.getIndex());    // border color
        cellStyle.setBorderBottom(BorderStyle.THIN);                    // add bottom border
        cellStyle.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        cellStyle.setBorderRight(BorderStyle.THIN);                     // add right border
        cellStyle.setRightBorderColor(IndexedColors.BLACK.getIndex());
        cellStyle.setBorderLeft(BorderStyle.THIN);                      // add left border
        cellStyle.setLeftBorderColor(IndexedColors.BLACK.getIndex());

        Font font = workbook.createFont();              // set the font
        font.setFontName("標楷體");                // set font Name
//        font.setBold(true);                             // set the bold font
//        font.setColor(IndexedColors.RED.getIndex());    // set the font color
        font.setFontHeightInPoints((short) 12);         // set the font size
        cellStyle.setFont(font);
        cellStyle.setAlignment(HorizontalAlignment.CENTER);         // set the data Horizontal center position
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);   // set the data vertical center position

        return cellStyle;
    }

    /**
     *
     * @param value: pixel
     * @return
     */
    private static short getHeightByPixel(int value){
        short pixel = (short) (value * 20);

        return pixel;
    }

    /**
     *
     * @param value: word number 字數
     * @return
     */
    private static int getLengthByWordNum(int value){
        int width = value * 256;
        return width;
    }

    private static void setRegionBorderWithMedium(CellRangeAddress region, Sheet sheet) {
        RegionUtil.setBorderBottom(BorderStyle.THIN, region, sheet);
        RegionUtil.setBorderLeft(BorderStyle.THIN, region, sheet);
        RegionUtil.setBorderRight(BorderStyle.THIN, region, sheet);
        RegionUtil.setBorderTop(BorderStyle.THIN, region, sheet);
    }

    private static void basicDemo(String dirPath) {
        //表頭資料
        String[] header = {"ID","姓名","性別","年齡","地址","分數"};
        //資料內容
        String[] student1 = {"1","小紅","女","23","台北市中山區","96"};
        String[] student2 = {"2","小強","男","26","台中市東區","91"};
        String[] student3 = {"3","小明","男","28","新北市三峽區","90"};

        // HSSFWorkbook: 產生 .xls  檔案
        // XSSFWorkbook: 產生 .xlsx 檔案
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

            if (i==0 || i==5){
                //設置自定義顏色（背景色）
                CellStyle cellStyle = workbook.createCellStyle();
                cellStyle.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.getIndex());
                cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                cell.setCellStyle(cellStyle);
            }
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
