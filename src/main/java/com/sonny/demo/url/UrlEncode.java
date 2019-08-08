package com.sonny.demo.url;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class UrlEncode {

    public static void main(String[] args) {

        // 待編碼的網址
        String url = "http://www.gtwang.org/目錄?var1=中文&var2=spa ce";

        try {
            // 進行 URL 百分比編碼
            String encodedURL = URLEncoder.encode(url, "UTF-8");

            // 輸出結果
            System.out.println(encodedURL);

        } catch (UnsupportedEncodingException e) {
            // 例外處理 ...
        }
    }

}
