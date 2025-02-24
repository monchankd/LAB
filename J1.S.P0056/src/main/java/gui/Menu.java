/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import manager.Manager;
import manager.Validation;

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
        Manager m = new Manager();
        while (true) {
            int choice = menu();
            switch (choice) {
                case 1:
                    m.addWorker();
                    break;
                case 2:
                    m.updateSalary(1);
                    break;
                case 3:
                    m.updateSalary(2);
                    break;
                case 4:
                    System.out.printf("%5s | %5s | %5s | %5s | %5s | %5s", "Code", "Name", "Age",
                            "Salary", "Status", "Date");
                    System.out.println();
                    m.getInformation();
                    break;
                case 5:
                    return;
            }
        }
    }
}
