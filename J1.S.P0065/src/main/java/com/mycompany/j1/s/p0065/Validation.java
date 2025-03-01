/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.j1.s.p0065;

import java.util.Scanner;

/**
 *
 * @author admin
 */
public class Validation {

    private static final Scanner in = new Scanner(System.in);

    public static String checkInputString() {
        while (true) {
            String result = in.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty.");
            } else {
                return result;
            }
        }
    }

    public static int checkInputMark(String nameSubject) {
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine());
                if (result < 0 || result > 10) {
                    System.err.println(nameSubject + " is invalid");
                    continue;
                }
                return result;
            } catch (NumberFormatException ex) {
                System.err.println(nameSubject + " must be digit");
            }
        }
    }

    public static boolean checkYN() {
        while (true) {
            String result = checkInputString();
            if (result.equalsIgnoreCase("y")) {
                return true;
            }
            if (result.equalsIgnoreCase("n")) {
                return false;
            }
        System.err.println("Please input Y/N");
        }
    }
    
}
