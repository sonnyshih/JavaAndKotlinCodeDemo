package com.sonny.demo.WordConvertToPDF;

import com.aspose.words.*;
public class Papers implements OfficeType{
    private WORD w;
    private String newPath;
    private String newName;

    public enum WORD {
        odt, pdf, docx, doc
    }

    public Papers(String newPath, String newName, WORD w){
        this.w = w;
        this.newPath = newPath;
        this.newName = newName;
    }


    @Override
    public void convert(String sourceFile) {
        try {
            Document doc = new Document(sourceFile);

            IWarningCallback callback = new IWarningCallback() {
                @Override
                public void warning(WarningInfo warningInfo) {
                    // Only interested in fonts being substituted.
                    if (warningInfo.getWarningType() == WarningType.FONT_SUBSTITUTION) {
                        System.out.println("DEBUG: Font substitution: " + warningInfo.getDescription());
                    }
                }
            };

            doc.setWarningCallback(callback);

            doc.save(newPath + "/" + newName + "." + this.w);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getNewPath() {
        return newPath;
    }

    public void setNewPath(String newPath) {
        this.newPath = newPath;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    public void showSystemFontFolderList() throws Exception {
        for (String systemFontFolder : SystemFontSource.getSystemFontFolders()) {
            System.out.println("DEBUG: systemFontFolder: "+systemFontFolder);
        }
    }
}
