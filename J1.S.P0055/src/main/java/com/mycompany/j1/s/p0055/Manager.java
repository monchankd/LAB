/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.j1.s.p0055;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class Manager {

    public static boolean addDoctor(List<Doctor> dList, Doctor doctor) {
        while (doctorExists(dList, doctor.getCode()) != null) {
            System.out.println("Code exist");
            doctor.setCode(Validation.checkString("Enter other ID to add: "));
        }
        dList.add(doctor);
        return true;
    }

    public static Doctor doctorExists(List<Doctor> dList, String id) {
        for (Doctor d : dList) {
            if (d.getCode().equals(id)) {
                return d;
            }
        }
        return null;
    }

    public static boolean updateDoctor(List<Doctor> dList, String codeUp, String newName, String newspec, int newavail) {
//        if (dList.isEmpty()) {
//            System.out.println("No list");
//            return false;
//        }
        Doctor d = null;
        while (d == null) {
            d = doctorExists(dList, codeUp);
            if (d == null) {
                System.out.println("Code not exist");
                codeUp = Validation.checkString("Enter code: ");
            }
        }
        d.setName(newName.isEmpty() ? d.getName() : newName);
        d.setSpecialization(newspec.isEmpty() ? d.getSpecialization() : newspec);
        d.setAvailability(newavail == -1 ? d.getAvailability() : newavail);
        System.out.println("Updated done");
        return true;

    }

    public static boolean deleteDoctor(List<Doctor> dList, String code) {
//        if (dList.isEmpty()) {
//            System.out.println("No list");
//            return false;
//        }
        for (Doctor d : dList) {
            if (d.getCode().equals(code)) {
                dList.remove(d);
                System.out.println("Delete successful");
                return true;
            }
        }
        System.out.println("Doctor code doesn't exist");
        return false;
    }

    public static List<Doctor> searchDoctor(List<Doctor> dList, List<Doctor> result, String input) {
//        if (dList.isEmpty()) {
//            System.out.println("No doctor records available.");
//            return null;
//        }
        for (Doctor d : dList) {
            if (d.getCode().equals(input)
                    || d.getName().equals(input)
                    || d.getSpecialization().equals(input)
                    || String.valueOf(d.getAvailability()).equals(input)) {
                result.add(d);
            }
        }
        return result;
    }

    public static void displayAll(List<Doctor> dList) {
        if (dList.isEmpty()) {
            System.out.println("No doctor records available.");
        } else {
            for (Doctor d : dList) {
                System.out.println(d);
            }
        }
    }
}
