/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.j1.s.p0058;

import java.util.Scanner;

/**
 *
 * @author admin
 */
public class Validation {

    private static final Scanner sc = new Scanner(System.in);

    public static int checkInt(String mess, int min, int max) {
        while (true) {
            try {
                System.out.println(mess);
                int input = Integer.parseInt(sc.nextLine());
                if (input < min || input > max) {
                    throw new NumberFormatException();
                }
                return input;
            } catch (NumberFormatException e) {
                System.out.println("Please input an integer in range [" + min + "," + max + "]");
            }
        }
    }

    public static String checkString() {
        while (true) {
            String result = sc.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty.");
            } else {
                return result;
            }
        }
    }

    public static boolean checkYN() {
        while (true) {
            String result = checkString();
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
