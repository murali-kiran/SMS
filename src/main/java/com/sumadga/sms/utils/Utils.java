package com.sumadga.sms.utils;

import javax.servlet.http.HttpSession;

public class Utils {

    public static boolean isAlphabetic(String target){
        return target.matches("[a-zA-Z]*");
    }

    public static boolean isNumeric(String target) {
        return target.matches("[-+]?\\d*\\.?\\d+");
    }

    public static boolean isValidZipCode(String target) {
        return target.matches("^\\d{5}\\p{Punct}?\\s?(?:\\d{4})?$");
    }

    public static boolean isValidPhoneNumber(String target) {
        return target.matches("(\\d-)?(\\d{3}-)?\\d{3}-\\d{4}");
    }

    public static boolean isValidEmail(String target) {
        return target.matches("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$");
    }

    public static boolean isValidLength(String target,Long size) {
        return target.length() == size;
    }

    public static boolean isEmpty(String str) {
        return (str == null || str.equals(""));
    }
  
    public static boolean isValidSession(HttpSession session) {
        if(session != null && session.isNew()){
            return true;
        }
        return false;
    }


   

}