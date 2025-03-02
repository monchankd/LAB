/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import com.mycompany.j1.s.p0058.Validation;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author admin
 */
public class Dictionary {

    private Map<String, String> dict;

    public Dictionary() throws IOException {
        dict = new HashMap<>();
        loadData();
    }

    private void loadData() throws IOException {
        File f = new File("dictionary.txt");
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        while (true) {
            String line = br.readLine();
            if (line == null || line.isEmpty()) {
                break;
            }
            String[] words = line.split("[-]");
            String eng = words[0].trim();
            String vi = words[1].trim();
            dict.put(eng, vi);
        }
        br.close();
        fr.close();
    }

    private void saveData() throws IOException {
        File f = new File("dictionary.txt");
        FileWriter fw = new FileWriter(f);
        BufferedWriter bw = new BufferedWriter(fw);

        for (Map.Entry<String, String> entry : dict.entrySet()) {
            bw.write(entry.getKey() + " - " + entry.getValue() + "\n");
        }

        bw.close();
        fw.close();
    }

    public void addWord() throws IOException {
        System.out.println("Enter English: ");
        String eng = Validation.checkString();
        if (dict.containsKey(eng) && !Validation.checkYN()) {
            return;
        }

        System.out.println("Enter Vietnamese: ");
        String vi = Validation.checkString();
        dict.put(eng, vi);
        saveData();
        System.out.println("ADD SUCCESSFUL");
    }

    public void removeWord() throws IOException {
        System.out.println("Enter English: ");
        String eng = Validation.checkString();
        if (!dict.containsKey(eng)) {
            System.out.println("Not found");
            return;
        }
        saveData();
        System.out.println("DELETE SUCCESSFUL");
    }

    public void translate() {
        System.out.println("Enter English: ");
        String eng = Validation.checkString();
        if (!dict.containsKey(eng)) {
            System.out.println("Not found");
            return;
        }
        System.out.println("Vietnamese: "+ dict.get(eng));
    }
}
