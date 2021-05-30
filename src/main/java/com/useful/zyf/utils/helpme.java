package com.useful.zyf.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class helpme {
    public static void main(String[] args) {

        Set<String> set = new HashSet<>();
        try {
            FileReader fr = new FileReader("C:/Users/dell/Desktop/springboot-commits.txt");
            BufferedReader bf = new BufferedReader(fr);
            String str;
            while ((str = bf.readLine()) != null) {
                String[] st = str.split("  ,  ");
                set.add(st[0]);
                set.add(st[1]);
            }
            bf.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileReader fr = new FileReader("C:/Users/dell/Desktop/springboot-pull requests.txt");
            BufferedReader bf = new BufferedReader(fr);
            String str;
            while ((str = bf.readLine()) != null) {
                String[] st = str.split("  ,  ");
                set.add(st[0]);
                set.add(st[1]);
            }
            bf.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileReader fr = new FileReader("C:/Users/dell/Desktop/springboot-context_prs.txt");
            BufferedReader bf = new BufferedReader(fr);
            String str;
            while ((str = bf.readLine()) != null) {
                String[] st = str.split("  ,  ");
                set.add(st[0]);
                set.add(st[1]);
            }
            bf.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(set.size());

    }
}
