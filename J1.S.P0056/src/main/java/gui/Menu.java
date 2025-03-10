/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import java.util.Scanner;
import manager.Manager;
import manager.Validation;
import model.Worker;

/**
 *
 * @author admin
 */
public class Menu {

    public static int menu() {
        System.out.println("1. Add worker.");
        System.out.println("2. Increase salary for worker.");
        System.out.println("3. Decrease for worker");
        System.out.println("4. Show adjusted salary worker information");
        System.out.println("5. Exist");
        int choice = Validation.checkInt("Enter your choice: ", 1, 5);
        return choice;
    }

    public static void display() {
        while (true) {
            Scanner sc = new Scanner(System.in);
            int choice = menu();
            switch (choice) {
                case 1:
                    System.out.println("Enter id: ");
                    String id = sc.nextLine();
                    System.out.println("Enter Name: ");
                    String name = sc.nextLine();
                    int age = Validation.checkInt("Enter age:",18,50);
                    double salary = Validation.checkDouble("Enter salary: ",0,Double.MAX_VALUE);
                    System.out.println("Enter work location:");
                    String workLocatin = sc.nextLine();
                    Manager.addWorker(new Worker(id, name, age, salary,workLocatin));
                    break;
                case 2:
                    System.out.println("Enter id: ");
                    String upid = sc.nextLine();
                    double upmoney = Validation.checkDouble("Enter Amount: ",0,Double.MAX_VALUE);
                    Manager.SalaryUpdate("UP", upid, upmoney);
                    break;
                case 3:
                    System.out.println("Enter id: ");
                    String downid = sc.nextLine();
                    double downmoney = Validation.checkDouble("Enter Amount", 0, Double.MAX_VALUE);
                    Manager.SalaryUpdate("DOWN", downid, downmoney);
                    break;
                case 4:
                    System.out.printf("%5s | %5s | %5s | %5s | %5s | %5s", "Code", "Name", "Age",
                            "Salary", "Status", "Date");
                    System.out.println();
                    Manager.getInformation();
                    break;
                case 5:
                    return;
            }
        }
    }
}
