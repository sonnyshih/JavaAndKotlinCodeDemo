package com.sonny.demo.detectVideo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class DetectVideoDemo {
    public static void main(String[] args) {
        String workingDir = System.getProperty("user.dir");
        System.out.println("Working Directory = " + workingDir);

        String dirPath = workingDir + "/src/main/java/com/sonny/demo/detectVideo/";
        System.out.println("dirPath = " + dirPath);

        final String[] RESOLUTIONS = {"640x360", "800x480", "1280x720", "1920x1080"};

        String videoPath = dirPath + "ocean.mp4"; // 替換為實際影片的路徑

        try {
            /** Server 要有裝 安裝FFmpeg 軟體
             * https://www.ffmpeg.org/
            */

            String resolution = "";

            ProcessBuilder processBuilder = new ProcessBuilder("ffmpeg", "-i", videoPath);
            Process process = processBuilder.start();

            // 讀取FFmpeg的輸出
            InputStream inputStream = process.getErrorStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println("line: " + line);

                // 搜尋包含解析度資訊的行
                if (line.contains("Stream") && line.contains("Video")) {
                    System.out.println("Have :" +line);
                    String[] parts = line.split(",");

                    // 提取解析度資訊
                    for (String part : parts) {
                        System.out.println("Part: " + part);
                        if (part.contains("[SAR")) {
                            resolution = part.trim();
                            break;
                        }
                    }

                    break;
                }
            }

            // 等待命令執行結束
            process.waitFor();

            // 關閉資源
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();

            System.out.println("目前影片解析度: " + resolution);

//            String currentResolution = "1920x1080";
            String currentResolution = "";
            String[] partList = resolution.split(" ");
            for (String part: partList) {
                if (part.contains("x")){
                    currentResolution = part.trim();
                }
            }

            int index = 0;
            for (int i=0; i<RESOLUTIONS.length; i++){
                if (RESOLUTIONS[i].equalsIgnoreCase(currentResolution)){
                    index = i;
                }
            }

            int startIndex = index - 1; // 往下一級
            if (startIndex<0){
                startIndex = 0;
            }
//            System.out.println("startIndex="+ startIndex);

            for (int i= startIndex; i< index+1; i++){
                System.out.println("需轉解析度為 : " + RESOLUTIONS[i]);
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }
}
