package com.sonny.demo.WordConvertToPDF;

import freemarker.ext.beans.BeansWrapper;
import freemarker.template.TemplateModel;
import freemarker.template.Version;

import java.io.File;
import java.net.URISyntaxException;
import java.util.Map;

public class ConvertPDFTool {

    public void startConvertPDF(Map<String, Object> models, String templateFileName,
                                        String docFilePath, String newPath, String pdfFileName) {


        /** ##### 可在 ftl 檔案中設定assign，這樣可使用java function (Start) #####
         * 說明: https://stackoverflow.com/questions/39082563/freemarker-call-a-static-util-method-from-a-template-file-ftl
         * */
        BeansWrapper wrapper = new BeansWrapper(new Version(2,3,27));
        TemplateModel statics = wrapper.getStaticModels();
        models.put("statics", statics);
        /** ##### 可在 ftl 檔案中設定assign，這樣可使用java function (End) ##### */

        // Create the Word file
        ExportWord word = new ExportWord();
//        word.setClassPath(this.getClass());
        File file = null;

        try {
            // 取得檔案資料
            file = new File(ConvertPDFTool.class.getResource("/PDFTemp.ftl").toURI());

            // 取得檔案的folder
            File folder = file.getParentFile();

            word.setTemplateFolder(folder);
            word.createWord(models, templateFileName, docFilePath);

        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        // 轉為pdf
        ConvertOffice.convert(docFilePath, new Papers(newPath, pdfFileName, Papers.WORD.pdf));
        // 刪除doc
        File f = new File(docFilePath);
        f.delete();

    }
}
