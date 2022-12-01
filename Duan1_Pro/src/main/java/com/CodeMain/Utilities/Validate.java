/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.CodeMain.Utilities;

/**
 *
 * @author hungs
 */
public class Validate {

    public boolean validateNumber(String num) {
        try {
            int number = Integer.parseInt(num);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
}
