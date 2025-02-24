/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manager;

import java.util.List;
import java.util.Scanner;
import model.Worker;

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

    public static String getCode(String mess, String err, List<Worker> wList, int mode) {
        while (true) {
            System.out.println(mess);
            String input = sc.nextLine();
            if (!input.isEmpty()) {
                if ((mode == 1 && getWorker(input, wList) == null)
                        || (mode == 2 && getWorker(input, wList) != null)) {
                    return input;
                }
            }
            System.out.println(err);
        }
    }

    public static Worker getWorker(String id, List<Worker> wList) {
        for (Worker worker : wList) {
            if (worker.getId().equals(id)) {
                return worker;
            }
        }
        return null;
    }
}
