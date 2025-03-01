/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.j1.s.p0065;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author admin
 */
public class Manager {

    public static void createStudent(List<Student> ls) {
        while (true) {
            System.out.print("Name: ");
            String name = Validation.checkInputString();
            System.out.print("Classes: ");
            String className = Validation.checkInputString();
            System.out.print("Maths: ");
            double math = Validation.checkInputMark("Maths");
            System.out.print("Chemistry: ");
            double chemistry = Validation.checkInputMark("Chemistry");
            System.out.print("Physics: ");
            double physics = Validation.checkInputMark("Physics");
            double average = (math + chemistry + physics) / 3;
            char type = checkTypeStudent(average);
            ls.add(new Student(name, className, math, physics, chemistry, average, type));
            System.out.print("Do you want to enter more student information?(Y/N): ");
            if (!Validation.checkYN()) {
                return;
            }
        }
    }

    public static char checkTypeStudent(double average) {
        if (average > 7.5) {
            return 'A';
        } else if (average >= 6 && average <= 7.5) {
            return 'B';
        } else if (average >= 4 && average < 6) {
            return 'C';
        } else {
            return 'D';
        }
    }

    public static void displayAllStudent(List<Student> ls) {
        int i = 0;
        for (Student s : ls) {
            System.out.println((++i) + "| Name: " + s.getStudentName() + "| Classes: " + s.getClassName()
                    + "| AVG: " + s.getAverage() + "| Type: " + s.getType());
        }
    }

    public static Map getPercentType(List<Student> ls) {
        Map<String, Double> percentType = new HashMap<>();
        int totalStudent = ls.size();
        double typeA = 0;
        double typeB = 0;
        double typeC = 0;
        double typeD = 0;
        for (int i = 0; i < totalStudent; i++) {
            if (ls.get(i).getType() == 'A') {
                typeA++;
            }
            if (ls.get(i).getType() == 'B') {
                typeB++;
            }
            if (ls.get(i).getType() == 'C') {
                typeC++;
            }
            if (ls.get(i).getType() == 'D') {
                typeD++;
            }
        }
        percentType.put("A", typeA / totalStudent * 100);
        percentType.put("B", typeB / totalStudent * 100);
        percentType.put("C", typeC / totalStudent * 100);
        percentType.put("D", typeD / totalStudent * 100);
        return percentType;
    }

    public static void display() {
        List<Student> ls = new ArrayList<>();
        createStudent(ls);
        displayAllStudent(ls);
        Map<String, Double> getPercentType = getPercentType(ls);
        for (String key : getPercentType.keySet()) {
            System.out.println(key + " :" + getPercentType.get(key) + "%");
        }
    }
}
