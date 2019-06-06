package com.sonny.demo.util;

//import android.content.Context;
//import android.graphics.Bitmap;
//import android.graphics.BitmapFactory;
//import android.graphics.Color;
//import android.text.Spannable;
//import android.text.SpannableStringBuilder;
//import android.text.Spanned;
//import android.text.style.StyleSpan;
//
//import com.newegg.core.R.string;
//import com.newegg.webservice.type.ErrorType;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class StringUtil {
    public static String encodeURL(String value)
            throws UnsupportedEncodingException {
        if (!isEmpty(value)) {
            return URLEncoder.encode(value, "UTF-8");
        }
        return "";
    }

    public static String decodeURL(String value)
            throws UnsupportedEncodingException {
        if (!isEmpty(value)) {
            return URLDecoder.decode(value, "UTF-8");
        }
        return "";
    }

    public static String encodeBase64(String value) {
        if (!isEmpty(value)) {
            return Base64.encodeBytes(value.getBytes());
        }
        return "";
    }

    public static String decodeBase64(String value) throws IOException {
        if (!isEmpty(value)) {
            return new String(Base64.decode(value));
        }
        return "";
    }

//    public static Bitmap convertBase64ToBitmap(String data) throws IOException {
//        if (isEmpty(data)) {
//            return null;
//        }
//        byte[] imageAsBytes = Base64
//                .decode(data.substring(data.indexOf(",") + 1));
//        Bitmap bitmap = BitmapFactory.decodeByteArray(imageAsBytes, 0,
//                imageAsBytes.length);
//        return bitmap;
//    }

    public static boolean isEmpty(String value) {
        return value == null || value.trim().equals("") || value.length() == 0;
    }

    public static boolean isLong(String str) {
        if ("0".equals(str.trim())) {
            return true;
        }
        Pattern pattern = Pattern.compile("^[^0]\\d*");
        Matcher isNum = pattern.matcher(str);
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }

    public static boolean isFloat(String str) {
        if (isLong(str)) {
            return true;
        }
        Pattern pattern = Pattern.compile("\\d*\\.{1}\\d+");
        Matcher isNum = pattern.matcher(str);
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }

    public static boolean isFloat(String str, int precision) {
        String regStr = "\\d*\\.{1}\\d{" + precision + "}";
        Pattern pattern = Pattern.compile(regStr);
        Matcher isNum = pattern.matcher(str);
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }

    public static boolean isNumber(String str) {
        if (isLong(str)) {
            return true;
        }
        Pattern pattern = Pattern.compile("(-)?(\\d*)\\.{0,1}(\\d*)");
        Matcher isNum = pattern.matcher(str);
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }

    public static boolean isEMail(String str) {
        Pattern pattern = Pattern
                .compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");
        Matcher isEMail = pattern.matcher(str);
        if (!isEMail.matches()) {
            return false;
        }
        return true;
    }

    public static String format(String str, Object... args) {
        if (isEmpty(str))
            return "";
        if (args.length == 0)
            return str;
        String result = str;
        Pattern p = java.util.regex.Pattern.compile("\\{(\\d+)\\}");
        Matcher m = p.matcher(str);
        while (m.find()) {
            int index = Integer.parseInt(m.group(1));
            if (index < args.length && args[index] != null) {
                result = result.replace(m.group(), args[index].toString());
            }
        }
        return result;
    }

    public static String numberToCommaString(float number) {
    	String commaString = new DecimalFormat("###,###,###")
                .format((double) Math.abs(number));
    	return commaString;
    }
    
    public static String priceToString(float price) {
        String priceString = new DecimalFormat("###,###,###.##")
                .format((double) Math.abs(price));
        if (!priceString.contains(".")) {
            priceString = priceString + ".00";
        } else {
            DecimalFormat format = new DecimalFormat("###,###,###.00");
            priceString = format.format(price);
        }
        if (price < 0) {
            if (priceString.startsWith("-")) {
                priceString = priceString.replace("-", "");
            }
            return "-$" + priceString;
        } else if (price < 1) {
            return "$0" + priceString;
        } else {
            return "$" + priceString;
        }
    }

    public static float stringToPrice(String inputString) {
        if (isEmpty(inputString))
            return 0.0f;
        if (inputString.contains("$")) {
            inputString = inputString.replace("$", "");
        }
        inputString = inputString.replaceAll(",", "");
        float priceFloat = 0.0f;
        try {
            priceFloat = Float.parseFloat(inputString);
        } catch (Exception ex) {
            priceFloat = 0.0f;
        }
        return priceFloat;
    }

    public static String getAmountString(String inputString) {
        String grandTotalAmount = inputString.replace("$", "").replaceAll(",", "");
        grandTotalAmount = grandTotalAmount
                .matches("^[+-]?[0-9]+[.]?[0-9]{1,2}$") ? grandTotalAmount
                : "0";
        return grandTotalAmount.trim();
    }

    public static String listConvertToString(List<String> listStrings) {
        String resultString = "";
        for (int i = 0; i < listStrings.size(); i++) {
            resultString += "\n" + listStrings.get(i);
        }
        return resultString;
    }

    public static String getURLEncodeStr(String url) {
        try {
            url = URLEncoder.encode(url, "utf-8");
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
        }
        return url;
    }

    public final static int CALC_TYPE_ADD = 1;
    public final static int CALC_TYPE_SUBTRACT = 2;
    public final static int CALC_TYPE_MULTIPLY = 3;
    public final static int CALC_TYPE_DIVIDE = 4;

    public static String stringCalculation(String str1, String str2,
                                           String token, int calcType) {
        str1 = str1.replace(token, "").replaceAll(",", "").trim();
        str2 = str2.replace(token, "").replaceAll(",", "").trim();
        float value1 = Float.parseFloat(str1);
        float value2 = Float.parseFloat(str2);
        float result = 0f;
        try {
            BigDecimal decimalVal_1 = new BigDecimal(Float.toString(value1));
            BigDecimal decimalVal_2 = new BigDecimal(Float.toString(value2));
            switch (calcType) {
                case CALC_TYPE_ADD:
                    result = decimalVal_1.add(decimalVal_2).floatValue();
                    break;
                case CALC_TYPE_SUBTRACT:
                    result = decimalVal_1.subtract(decimalVal_2).floatValue();
                    break;
                case CALC_TYPE_MULTIPLY:
                    result = decimalVal_1.multiply(decimalVal_2).floatValue();
                    break;
                case CALC_TYPE_DIVIDE:
                    result = decimalVal_1.divide(decimalVal_2, 2,
                            BigDecimal.ROUND_HALF_UP).floatValue();
                    break;
            }
        } catch (NumberFormatException nfe) {
            result = 0f;
        }

        DecimalFormat format = new DecimalFormat("###,###,###.00");
        String priceString = format.format(result);

        return token + priceString;
    }

    public static HashMap<String, String> getQueryParams(String queryString) {
        HashMap<String, String> paramHashMap = new HashMap<String, String>();
        String[] queryStr = stringToken(queryString, "&");
        for (String param : queryStr) {
            String[] paramStr = stringToken(param, "=");
            if (paramStr != null && paramStr.length > 1) {
                paramHashMap.put(paramStr[0].toLowerCase(), paramStr[1]);
            }
        }

        return paramHashMap;
    }

    public static String[] stringToken(String oriStr, String confi) {
        StringTokenizer token = new StringTokenizer(oriStr, confi);
        String[] strArray = new String[token.countTokens()];
        int i = 0;
        while (token.hasMoreTokens()) {
            strArray[i] = token.nextToken();
            i += 1;
        }

        return strArray;
    }

    //TODO - resetZipCode
    public static String resetZipCode(String zipCode) {

        //if (SettingManager.getInstance().isLocationUSA()) {
        //    zipCode = resetUsaZipCode(zipCode);
        //} else {
        //    zipCode = resetCanPostalCode(zipCode);
        //}

        return zipCode;
    }

    private static String resetUsaZipCode(String zipCode) {
        int codeLen = zipCode != null ? zipCode.length() : 0;
        if (codeLen > 5) {
            if (codeLen < 10) {
                zipCode = zipCode.substring(0, 5) + "-"
                        + zipCode.substring(5, codeLen);
            } else {
                zipCode = zipCode.substring(0, 5);
            }
        }
        return zipCode;
    }

    private static String resetCanPostalCode(String zipCode) {

        zipCode = zipCode.trim();
        int codeLen = zipCode.length();
        if (isEmpty(zipCode)) {
            return null;
        }
        if (codeLen == 7) {
            return zipCode;
        } else {
            zipCode = zipCode.substring(0, 3) + " "
                    + zipCode.substring(3, codeLen);
        }
        return zipCode;
    }

    public static boolean isGeneralDeliveryAddress(String strAddress1,
                                                   String strAddress2) {

        String strAddress = strAddress1 + strAddress2;
        strAddress = strAddress.trim().replace(" ", "").replace("�@", "")
                .replace(".", "").replace("�D", "").toUpperCase();

        int iCharIndex1 = strAddress.indexOf("GENERAL");
        int iCharIndex2 = strAddress.indexOf("DELIVERY");

        if (iCharIndex1 > -1 && iCharIndex2 > -1 && iCharIndex1 < iCharIndex2) {
            return true;
        } else {
            return false;
        }
    }

//    public static int parseThreeHexColorToColorInteger(
//            String threeHexColorString) {
//        String regularExpression = "[#][0-9A-F]{3}";
//
//        if (threeHexColorString != null
//                && threeHexColorString.matches(regularExpression)) {
//            String r = threeHexColorString.substring(1, 2);
//            String g = threeHexColorString.substring(2, 3);
//            String b = threeHexColorString.substring(3, 4);
//            r += r;
//            g += g;
//            b += b;
//            return Color.parseColor("#" + r + g + b);
//        }
//        return Color.parseColor(threeHexColorString);
//    }

    public static String countSavingPercentage(String originalPrice,
                                               String diffPrice) {
        float oriPriceF = Float.parseFloat(originalPrice);
        float diffPriceF = Float.parseFloat(diffPrice) * 100f;
        float result = 0f;
        try {
            BigDecimal decimalVal_1 = new BigDecimal(Float.toString(oriPriceF));
            BigDecimal decimalVal_2 = new BigDecimal(Float.toString(diffPriceF));
            result = decimalVal_2.divide(decimalVal_1, 0,
                    BigDecimal.ROUND_HALF_UP).intValue();
        } catch (NumberFormatException nfe) {
            result = 0f;
        }
        DecimalFormat format = new DecimalFormat("###");
        String savingMount = format.format(result);

        return savingMount;
    }

    /**
     * whether the text is Price text.
     *
     * @param priceString
     * @return
     */

    public static boolean isPrice(String priceString) {
        priceString = priceString.replace(",", "");
        if (priceString.contains("$")) {
            return true;
        } else {
            if (StringUtil.isFloat(priceString)) {
                return true;
            }
            return false;
        }
    }

//    public static String getServiceErrorString(ErrorType errorType,
//                                               Context context) {
//
//        switch (errorType) {
//            case JSON_ERROR:
//                return context.getResources().getString(string.json_error_message);
//            case WEB_CLIENT_ERROR:
//                return context.getResources().getString(
//                        string.web_client_error_message);
//            case WEB_IO_ERROR:
//                return context.getResources()
//                        .getString(string.web_io_error_message);
//            case WEB_SERVER_ERROR:
//                return context.getResources().getString(
//                        string.web_server_error_message);
//            case UNKNOWN_ERROR:
//            default:
//                return context.getResources().getString(string.unknown_error);
//        }
//    }
//
//    public static Spannable setStringBold(String string, int start, int end){
//        Spannable span = new SpannableStringBuilder(string);
//        final StyleSpan bss = new StyleSpan(android.graphics.Typeface.BOLD);
//        span.setSpan(bss,start,end, Spanned.SPAN_INCLUSIVE_INCLUSIVE );
//        return span;
//    }

}

