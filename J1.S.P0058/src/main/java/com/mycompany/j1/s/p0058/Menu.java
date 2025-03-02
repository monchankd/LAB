/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.j1.s.p0058;

import Model.Dictionary;
import java.io.IOException;

/**
 *
 * @author admin
 */
public class Menu {

    public static int menu() {
        System.out.println("1. Add word");
        System.out.println("2. Delete word");
        System.out.println("3. Translate word");
        System.out.println("4. Exist");
        int choice = Validation.checkInt("Enter your choice: ", 1, 5);
        return choice;
    }
    
    
    public static void display() throws IOException {
        Dictionary d = new Dictionary();
        while (true) {
            int choice = menu();
            switch (choice) {
                case 1:
                    d.addWord();
                    break;
                case 2:
                    d.removeWord();
                    break;
                case 3:
                    d.translate();
                    break;
                case 4:
                    return;
            }
        }
    }
}
