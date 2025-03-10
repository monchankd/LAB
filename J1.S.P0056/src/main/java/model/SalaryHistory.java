/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author admin
 */
public class SalaryHistory {
    private String id;
    private String name;
    private int age;
    private double updateSalary;
    private String status;
    private String date;

    public SalaryHistory() {
    }

    public SalaryHistory(String id, String name, int age, double updateSalary, String status) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.updateSalary = updateSalary;
        this.status = status;
        this.date = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getUpdateSalary() {
        return updateSalary;
    }

    public void setUpdateSalary(double updateSalary) {
        this.updateSalary = updateSalary;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return String.format("%5s | %-5s | %5d | %-7.1f | %-4s | %-10s", id, name, age, updateSalary, status, date);
    }
    
    
}
