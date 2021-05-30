package com.useful.zyf.utils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class create {
    public static void main(String args[]) throws IOException {
        JSONArray jsonarray;
        JSONObject jsonObj;
        String web ="https://api.github.com/repos/"+"apache/maven"+"/"+"commits"+"?&per_page=100&page=";
        URL U = new URL(web);
        HttpURLConnection connection = (HttpURLConnection)U.openConnection();
        connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/88.0.4324.11 Safari/537.36");
        connection.setRequestProperty("Authorization","token 85ff9856fd99987162840dfc927795910cedf65c");
        connection.setRequestProperty("Content-Type","application/json");
        connection.setRequestProperty("method","GET");
        connection.setRequestProperty("Accept","application/json");
        connection.connect();

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;
        String result = "";
        while ((line = in.readLine())!= null)
        {
            result += line;
        }
        in.close();

        jsonarray = JSONArray.fromObject(result);
        System.out.println(jsonarray.size());

    }
}
