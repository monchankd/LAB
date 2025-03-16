/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.j1.s.p0073;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    public static double checkDouble(String mess, double min, double max) {
        while (true) {
            try {
                System.out.println(mess);
                double input = Double.parseDouble(sc.nextLine());
                if (input < min || input > max) {
                    throw new NumberFormatException();
                }
                return input;
            } catch (NumberFormatException e) {
                System.out.println("Please input an real number in range [" + min + "," + max + "]");
            }
        }
    }

    public static String checkString(String mess) {
        while (true) {
            System.out.println(mess);
            String result = sc.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty.");
            } else {
                return result;
            }
        }
    }

    public static Date checkDate(String mess) {
        while (true) {
            try {
                System.out.println(mess);
                String dateCheck = sc.nextLine();  // Lấy chuỗi nhập vào từ người dùng
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                sdf.setLenient(false);  // Thiết lập không cho phép các ngày tháng không hợp lệ (như 30/02)
                sdf.parse(dateCheck);   // Thử phân tích chuỗi ngày tháng
                Date date = sdf.parse(dateCheck);   // Thử phân tích chuỗi ngày tháng thành đối tượng Date
                return date;   // Nếu hợp lệ, trả về chuỗi ngày tháng
            } catch (ParseException ex) {
                System.out.print("Date: ");
                System.err.println("Date must be in the correct format (dd/MM/yyyy) and valid.");
            }
        }
    }
}
