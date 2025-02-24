/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author admin
 */
public class Worker {

    private String id;
    private String name;
    private int age;
    private double salary;
    private String workLocatin;

    public Worker() {
    }

    public Worker(String id, String name, int age, double salary, String workLocatin) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.workLocatin = workLocatin;
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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getWorkLocatin() {
        return workLocatin;
    }

    public void setWorkLocatin(String workLocatin) {
        this.workLocatin = workLocatin;
    }

    @Override
    public String toString() {
        return String.format("%s | %-8s | %2d | %-7.1f | %15s", id, name, age, salary, workLocatin);
    }

}
