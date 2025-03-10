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
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nHandy Expense Management");
            System.out.println("1. Add an expense");
            System.out.println("2. Display all expenses");
            System.out.println("3. Remove an expense");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = getValidInteger();

            switch (choice) {
                case 1:
                    addExpense();
                    break;
                case 2:
                    displayAll();
                    break;
                case 3:
                    deleteExpense();
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
        System.out.print("Enter date (dd/MM/yyyy): ");
        Date date = getValidDate();
        System.out.print("Enter amount: ");
        double amount = getValidDouble();
        System.out.print("Enter content: ");
        String content = scanner.nextLine();
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

    public static void deleteExpense() {
        System.out.print("Enter expense ID to delete: ");
        int id = getValidInteger();
        if (!expenseExists(id)) {
            System.out.println("Delete an expense fail");
        }
        expenseList.remove(id);
        System.out.println("Delete an expense successful");
    }

    private static boolean expenseExists(int id) {
        for (Expense expense : expenseList) {
            if (expense.getId() == id) {
                return true;
            }
        }
        return false;
    }

    private static int getValidInteger() {
        while (true) {
            try {
                int num = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                return num;
            } catch (InputMismatchException e) {
                System.out.print("Invalid input. Please enter a valid integer: ");
                scanner.nextLine(); // Clear buffer
            }
        }
    }

    private static double getValidDouble() {
        while (true) {
            try {
                double num = scanner.nextDouble();
                scanner.nextLine(); // Consume newline
                if (num < 0) {
                    System.out.print("Amount cannot be negative. Enter again: ");
                } else {
                    return num;
                }
            } catch (InputMismatchException e) {
                System.out.print("Invalid input. Please enter a valid amount: ");
                scanner.nextLine(); // Clear buffer
            }
        }
    }

    private static Date getValidDate() {
        while (true) {
            try {
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                return formatter.parse(scanner.nextLine());
            } catch (ParseException e) {
                System.out.print("Invalid date format. Please use dd/MM/yyyy: ");
            }
        }
    }
}
