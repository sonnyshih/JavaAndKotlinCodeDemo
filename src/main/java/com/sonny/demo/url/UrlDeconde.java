package com.sonny.demo.url;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class UrlDeconde {
    public static void main(String[] args) {
        // 待解碼的網址
        String encodedURL = "http%3A%2F%2Fwww.gtwang.org%2F%E7%9B%AE%E9%8C%84%3Fvar1%3D%E4%B8%AD%E6%96%87%26var2%3Dspa+ce";

        try {
            // 進行 URL 百分比解碼
            String url = URLDecoder.decode(encodedURL, "UTF-8");

            // 輸出結果
            System.out.println(url);

        } catch (UnsupportedEncodingException e) {
            // 例外處理 ...
        }
    }
}
