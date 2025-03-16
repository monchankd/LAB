/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.j1.s.p0073;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class J1SP0073 {

    private static List<Expense> expenseList = new ArrayList<>();
    private static int currentId = 1;

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nHandy Expense Management");
            System.out.println("1. Add an expense");
            System.out.println("2. Display all expenses");
            System.out.println("3. Remove an expense");
            System.out.println("4. Exit");
            int choice = Validation.checkInt("Choose an option: ", 1, 4);

            switch (choice) {
                case 1:
                    addExpense();
                    break;
                case 2:
                    displayAll();
                    break;
                case 3:
                    int id = Validation.checkInt("Enter expense ID to delete: ", 1, Integer.MAX_VALUE);
                    deleteExpense(id);
                    break;
                case 4:
                    System.out.println("Exiting program.");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public static void addExpense() {
        Date date = Validation.checkDate("Enter date (dd/MM/yyyy): ");
        double amount = Validation.checkDouble("Enter amount: ", 0, Double.MAX_VALUE);
        String content = Validation.checkString("Enter content: ");
        expenseList.add(new Expense(currentId++, date, amount, content));
        System.out.println("Expense added successfully!");
    }

    public static void displayAll() {
        System.out.println("\nID    Date             Amount          Content");
        System.out.println("------------------------------------------------------");
        double total = 0;
        for (Expense expense : expenseList) {
            System.out.println(expense);
            total += expense.getAmount();
        }
        System.out.println("------------------------------------------------------");
        System.out.printf("Total: %.2f\n", total);
    }

    public static void deleteExpense(int id) {
        if (expenseList.isEmpty()) {
            System.out.println("No expenses available to delete. Exiting.");
            return; 
        }
        while (!expenseExists(id)) {
            System.out.println("Delete an expense fail");
            id = Validation.checkInt("Enter expense ID to delete: ", 1, Integer.MAX_VALUE);
        }

        for (int i = 0; i < expenseList.size(); i++) {
            if (expenseList.get(i).getId() == id) {
                expenseList.remove(i);
                System.out.println("Delete an expense successful");
                return;
            }
        }
    }

    private static boolean expenseExists(int id) {
        for (Expense expense : expenseList) {
            if (expense.getId() == id) {
                return true;
            }
        }
        return false;
    }

}
