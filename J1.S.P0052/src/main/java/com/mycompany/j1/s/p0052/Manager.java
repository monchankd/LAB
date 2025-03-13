/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.j1.s.p0052;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author admin
 */
public class Manager {

    private static List<EastAsiaCountries> countryList = new ArrayList<>();

    public static void addCountry(EastAsiaCountries country) {
        for (EastAsiaCountries c : countryList) {
            if (c.getCountryCode().equals(country.getCountryCode())) {
                System.err.println("Code have been exist");
                return;
            }
        }
        countryList.add(country);
    }

    public static EastAsiaCountries searchByName(String name) {
        for (EastAsiaCountries country : countryList) {
            if (country.getCountryName().equalsIgnoreCase(name)) {
                return country;
            }
        }
        return null;
    }

    public static List<EastAsiaCountries> sortByAscOrder() {
        List<EastAsiaCountries> sortedList = new ArrayList<>(countryList);
        sortedList.sort(Comparator.comparing(EastAsiaCountries::getCountryName));
        return sortedList;
    }

    public static void getInformation() {
        System.out.printf("%-10s %-20s %-15s %-20s\n", "Code", "Name", "Total Area", "Terrain");
        for (Object object : countryList) {
            System.out.println(object);
        }
    }
}
