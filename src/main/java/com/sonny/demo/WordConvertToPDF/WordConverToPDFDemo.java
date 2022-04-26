package com.sonny.demo.WordConvertToPDF;

import com.sonny.demo.util.StringUtil;
import freemarker.ext.beans.BeansWrapper;
import freemarker.template.TemplateModel;
import freemarker.template.Version;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordConverToPDFDemo {
    public static void main(String[] args) {

        String workingDir = System.getProperty("user.dir");
        System.out.println("Working Directory = " + workingDir);

        String dirPath = workingDir + "/src/main/java/com/sonny/demo/WordConvertToPDF/";

        System.out.println("dirPath = " + dirPath);

        List<Map<String, Object>> items = new ArrayList<Map<String, Object>>();
        for (int i=0; i<10; i++) {

            HashMap<String, Object> map = new HashMap<String, Object>();

            map.put("area", "area_" + i);
            map.put("number", "number_"+ i);
            map.put("name", "hello name_" + i);
            items.add(map);
        }

        Map<String, Object> models = new HashMap<String, Object>();
//        models.put("examYear", "111");
//        models.put("examBatch", "102");
//        models.put("today", StringUtil.getTodayString());
//        models.put("name", "Sam");
        models.put("items", items);

        // 設定加載模板的路徑
        String templateFileName = "PDFTemp.ftl";
        String tempName = "Export_Tag_";

        String docRealName = tempName + ".doc";
        String docFilePath = dirPath + docRealName;

        System.out.println("docFilePath="+docFilePath);

        String newPath = dirPath;
        String pdfFileName = tempName;

        // Start Convert pdf file
        ConvertPDFTool pdfTool = new ConvertPDFTool();
        pdfTool.startConvertPDF(models, templateFileName, docFilePath, newPath, pdfFileName);

    }



}
