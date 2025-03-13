/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.j1.s.p0052;

/**
 *
 * @author admin
 */
public class Menu {

    public static int menu() {
        System.out.println("\nMenu:");
        System.out.println("1. Enter country information");
        System.out.println("2. Display all countries");
        System.out.println("3. Search country by name");
        System.out.println("4. Display countries in ascending order");
        System.out.println("5. Exit");
        int choice = Validation.checkInt("Enter your choice: ", 1, 5);
        return choice;
    }

    public static void display() {
        while (true) {
            int choice = menu();
            switch (choice) {
                case 1:
                    System.out.println("Enter code");
                    String code = Validation.checkString();
                    System.out.println("Enter name:");
                    String name = Validation.checkString();
                    double area = Validation.checkDouble("Enter total area", 0, Double.MAX_VALUE);
                    System.out.println("Enter terrain");
                    String terrain = Validation.checkString();
                    Manager.addCountry(new EastAsiaCountries(code, name, area, terrain));
                    break;
                case 2:
                    Manager.getInformation();
                    break;
                case 3:
                    System.out.println("Enter name:");
                    String nameSearch = Validation.checkString();
                    EastAsiaCountries result = Manager.searchByName(nameSearch);
                    if (result != null) {
                        System.out.printf("%-10s %-20s %-15s %-20s\n", "Code", "Name", "Total Area", "Terrain");
                        System.out.println(result);
                    } else {
                        System.out.println("Country not found.");
                    }
                    break;
                case 4:
                    System.out.printf("%-10s %-20s %-15s %-20s\n", "Code", "Name", "Total Area", "Terrain");
                    for (EastAsiaCountries c : Manager.sortByAscOrder()) {
                        System.out.println(c);
                    }
                    break;
                case 5:
                    return;
            }
        }
    }
}
