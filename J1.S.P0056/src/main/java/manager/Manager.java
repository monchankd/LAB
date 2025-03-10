/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manager;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import model.SalaryHistory;
import model.Worker;

/**
 *
 * @author admin
 */
public class Manager {

    private static final Scanner sc = new Scanner(System.in);
    private static List<Worker> wList = new ArrayList<>();
    private static List<SalaryHistory> shList = new ArrayList<>();

    public static void addWorker(Worker worker) {
        for (Worker w : wList) {
            if (w.getId().equals(worker.getId())) {
                System.err.println("Code have been exist");
                return;
            }
        }
        wList.add(worker);
        System.out.println("Worker added successfully!");
    }

    public static void SalaryUpdate(String status, String code, double money) {
        for (Worker w : wList) {
            if (w.getId().equals(code)) {
                if (status.equals("UP")) {
                    w.setSalary(w.getSalary() + money);
                } else {
                    if (money >= w.getSalary()) {
                        w.setSalary(0);
                    } else {
                        w.setSalary(w.getSalary() - money);
                    }
                }
                shList.add(new SalaryHistory(w.getId(), w.getName(), w.getAge(), w.getSalary(), status));
                return;
            }
        }
        System.err.println("Id not been exist");
    }

    public static void getInformation() {
        display(shList);
    }

    public static void display(List list) {
        for (Object object : list) {
            System.out.println(object);
        }
    }
}
