package com.sonny.demo.WordConvertToPDF;

import freemarker.core.ParseException;
import freemarker.log.Logger;
import freemarker.template.*;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Map;

/**
 * 使用 freemarker 製作 word
 * version : FreeMarker 2.3.28
 *
 * @see <a href=
 *      "https://www.cnblogs.com/sun-flower1314/p/10126111.html">教學請看這篇</a>
 */

public class ExportWord {

    private Logger log = Logger.getLogger(ExportWord.class.toString());
    private Configuration config = null;
    private File templateFolder;

    @SuppressWarnings("rawtypes")
    private Class classPath;

    @SuppressWarnings("rawtypes")
    public Class getClassPath() {
        return classPath;
    }

    /**
     * 設定讀取模板的路徑
     *
     * @param classPath
     */
    @SuppressWarnings("rawtypes")
    public void setClassPath(Class classPath) {
        this.classPath = classPath;
    }

    public ExportWord() {
        config = new Configuration(Configuration.VERSION_2_3_28);
        config.setDefaultEncoding("utf-8");
    }

    public File getTemplateFolder() {
        return templateFolder;
    }

    public void setTemplateFolder(File templateFolder) {
        this.templateFolder = templateFolder;
    }

    /**
     * FreeMarker生成Word
     *
     * @param dataMap      數據
     * @param templateName 目標名
     * @param saveFilePath 保存文件路徑的全路徑名（路徑+文件名）
     */
    public void createWord(Map<String, Object> dataMap, String templateName, String saveFilePath) {

        Template template = null;
        if (templateName.endsWith(".ftl")) {
            templateName = templateName.substring(0, templateName.indexOf(".ftl"));
        }

        try {
            // 加載模板(路徑)數據
//            config.setClassForTemplateLoading(this.getClassPath(), "");   // 取得class本身所在的路徑
            config.setDirectoryForTemplateLoading(templateFolder);

            // 設置異常處理器 這樣的話 即使沒有屬性也不會出錯 如：${list.name}...不會報錯
            config.setTemplateExceptionHandler(TemplateExceptionHandler.IGNORE_HANDLER);
            template = config.getTemplate(templateName + ".ftl");
        } catch (TemplateNotFoundException e) {
            log.error("模板文件未找到", e);
            e.printStackTrace();
        } catch (MalformedTemplateNameException e) {
            log.error("模板類型不正確", e);
            e.printStackTrace();
        } catch (ParseException e) {
            log.error("解析模板出錯，請檢查模板格式", e);
            e.printStackTrace();
        } catch (IOException e) {
            log.error("IO讀取失敗", e);
            e.printStackTrace();
        }
        File outFile = new File(saveFilePath);
        if (!outFile.getParentFile().exists()) {
            outFile.getParentFile().mkdirs();
        }
        Writer out = null;
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(outFile);
        } catch (FileNotFoundException e) {
            log.error("輸出文件時未找到文件", e);
            e.printStackTrace();
        }
        out = new BufferedWriter(new OutputStreamWriter(fos, StandardCharsets.UTF_8));
        // 將模板中的預先的代碼替換為數據
        try {
            template.process(dataMap, out);
        } catch (TemplateException e) {
            log.error("填充模板時異常", e);
            e.printStackTrace();
        } catch (IOException e) {
            log.error("IO讀取時異常", e);
            e.printStackTrace();
        }
        log.info("由模板文件：" + templateName + ".ftl" + " 生成文件 ：" + saveFilePath + " 成功！！");
        try {
            out.close();// web項目不可關閉
        } catch (IOException e) {
            log.error("關閉Write對象出錯", e);
            e.printStackTrace();
        }
    }

    /**
     * 獲得圖片的Base64編碼
     *
     * @param imgFile
     * @return
     */
    public String getImageStr(String imgFile) {
        InputStream in = null;
        byte[] data = null;
        try {
            in = new FileInputStream(imgFile);
        } catch (FileNotFoundException e) {
            log.error("加載圖片未找到", e);
            e.printStackTrace();
        }
        try {
            data = new byte[in.available()];
            // 註：FileInputStream.available()方法可以從輸入流中阻斷由下一個方法調用這個輸入流中讀取的剩餘字節數
            in.read(data);
            in.close();
        } catch (IOException e) {
            log.error("IO操作圖片錯誤", e);
            e.printStackTrace();
        }
        final Base64.Encoder encoder = Base64.getEncoder();

        return new String(encoder.encode(data));

    }
}
