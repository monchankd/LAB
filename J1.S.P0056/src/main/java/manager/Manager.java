/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manager;

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
    private List<Worker> wList;
    private List<SalaryHistory> shList;
    final double epsi = 0.00001;

    public Manager() {
        wList = new ArrayList<>();
        shList = new ArrayList<>();
    }

    public void addWorker() {
        String id, name, workLocation;
        int age;
        double salary;
        id = Validation.getCode("Enter worker id", "Id should be unique and not null", wList, 1);
        System.out.println("Enter worker name: ");
        name = sc.nextLine();

        age = Validation.checkInt("Enter worker age: ", 18, 50);
        salary = Validation.checkDouble("Enter worker salary: ", epsi, Double.MAX_VALUE);

        System.out.println("Enter work location: ");
        workLocation = sc.nextLine();

        wList.add(new Worker(id, name, age, salary, workLocation));

    }

    public void updateSalary(int mode) {
        String id = Validation.getCode("Enter worker id to be updated: ", "ID must exited and not null", wList, 2);
        double money = Validation.checkDouble("Amount of money", epsi, Double.MAX_VALUE);
        Worker o = Validation.getWorker(id, wList);
        double update = 0;
        String status = "";
        if (mode == 1) {
            update = o.getSalary() + money;
            status = "UP";
        } else if (mode == 2) {
            if (o.getSalary() > money) {
                update = o.getSalary() - money;
                status = "DOWN";
            }
        }
        o.setSalary(update);
        shList.add(new SalaryHistory(id, o.getName(), o.getAge(), o.getSalary(), status, getCurrentDate()));
    }

    public Date getCurrentDate() {
        Calendar calendar = Calendar.getInstance();
        return calendar.getTime();
    }

    public void getInformation() {
        display(shList);
    }

    public void displayAll() {
        display(wList);
    }

    public void display(List list) {
        for (Object object : list) {
            System.out.println(object);
        }
    }
}
