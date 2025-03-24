/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.j1.s.p0055;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class Menu {

    private static List<Doctor> dList = new ArrayList<>();
    private static List<Doctor> searchList = new ArrayList<>();

    public static int menu() {
        System.out.println("1. Add Doctor");
        System.out.println("2. Update Doctor");
        System.out.println("3. Delete Doctor");
        System.out.println("4. Search Doctor");
        System.out.println("5. Display");
        System.out.println("6. Exist");
        int choice = Validation.checkInt("Enter your choice: ", 1, 6);
        return choice;
    }

    public static void display() {
        while (true) {
            Scanner sc = new Scanner(System.in);
            int choice = menu();
            switch (choice) {
                case 1:
                    String code = Validation.checkString("Enter code: ");
                    String name = Validation.checkString("Enter name: ");
                    String specialization = Validation.checkString("Enter specialization: ");
                    int availability = Validation.checkInt("Enter availability: ", 0, Integer.MAX_VALUE);
                    if (Manager.addDoctor(dList, new Doctor(code, name, specialization, availability))) {
                        System.out.println("Add succesfully");
                    }
                    break;
                case 2:
                    String codeUP = Validation.checkString("Enter code: ");
                    System.out.println("Enter name (leave blank to keep unchanged): ");
                    String newName = sc.nextLine();
                    System.out.println("Enter specialization (leave blank to keep unchanged): ");
                    String newspecialization = sc.nextLine();
                    int newavailability = Validation.checkInt("Enter availability (enter -1 to keep unchanged): ", -1, Integer.MAX_VALUE);
                    Manager.updateDoctor(dList, codeUP, newName, newspecialization, newavailability);
                    break;
                case 3:
                    String codeDelete = Validation.checkString("Enter code: ");
                    Manager.deleteDoctor(dList, codeDelete);
                    break;
                case 4:
                    String searchStr = Validation.checkString("Enter search string: ");
                    searchList = Manager.searchDoctor(dList, searchList, searchStr);
                    Manager.displayAll(searchList);
                    searchList.clear();

                    break;
                case 5:
                    Manager.displayAll(dList);
                    break;
                case 6:
                    return;
            }
        }
    }
}
