/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.CodeMain.Utilities;

import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author hungs
 */
public class Validate {

    public boolean validateNullAndisNumber(String num) {
        try {
            double number = Double.parseDouble(num);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

//    public boolean checkJtextField(String txt) {
//        if (txt == null) {
//            return false;
//        } else if (validateNumber(txt) == false) {
//            return false;
//        } else {
//            return true;
//        }
//    }
    public String deleteLastKey(String str) {
        if (str.charAt(str.length() - 1) == 'đ') {
            str = str.replace(str.substring(str.length() - 1), "");
            return str;
        } else {
            return str;
        }
    }

    public String fomartDouble(String txt) {
        String pattern = deleteLastKey(txt);
        return pattern = pattern.replaceAll(",", "");
    }

    public static void main(String[] args) {
        Locale lc = new Locale("nv", "VN");
        NumberFormat nf = NumberFormat.getInstance(lc);

        Validate vali = new Validate();

        String a = nf.format(100000) + " đ";
        
        
        System.out.println(a);
    }

}
