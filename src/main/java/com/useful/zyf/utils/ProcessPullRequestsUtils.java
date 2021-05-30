package com.useful.zyf.utils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

public class ProcessPullRequestsUtils {

    public static String getGithubPulls(String web,String name) throws IOException {
        JSONArray jsonarray;
        JSONObject jsonObj;
        String id = "";
        int successCount = 0;
        String[] dir_name_str = name.split("/");
        String dir_name = dir_name_str[dir_name_str.length-1];

        String route = "C:/Users/dell/Desktop/" +dir_name + "-pr" +"/";
        System.out.println(route);
        File dir = new File(route);
        if (!dir.exists()) {// 判断目录是否存在
            dir.mkdir();
        }

        for(int i=0;i<160;i++){
            String web_end = web+i;

            URL U = new URL(web_end);
            HttpURLConnection connection = (HttpURLConnection)U.openConnection();
            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/89.0.4389.90 Safari/537.36");
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
            for(int j=0;j<jsonarray.size();j++){
                jsonObj  = JSONObject.fromObject(jsonarray.getString(j));

                id = jsonObj.get("number").toString();


                String commits_url = (String) jsonObj.get("commits_url");
                URL U3 = new URL(commits_url);
                HttpURLConnection connection3 = (HttpURLConnection)U3.openConnection();
                connection3.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/89.0.4389.90 Safari/537.36");
                connection3.setRequestProperty("Authorization","token 85ff9856fd99987162840dfc927795910cedf65c");
                connection3.setRequestProperty("Content-Type","application/json");
                connection3.setRequestProperty("method","GET");
                connection3.setRequestProperty("Accept","application/json");
                connection3.connect();
                BufferedReader in3 = new BufferedReader(new InputStreamReader(connection3.getInputStream()));
                  String line3;
                String result3 = "";
                while ((line3 = in3.readLine())!= null)
                {
                    result3 += line3;
                }
                in3.close();
                JSONArray jsonarray3 = JSONArray.fromObject(result3);


                System.out.println(id);
                Set<String> filenameSet = new HashSet<String>();
                for(int n=0;n<jsonarray3.size();n++){
                    JSONObject jsonObj3  = JSONObject.fromObject(jsonarray3.getString(n));
                    String every_url = (String) jsonObj3.get("url");
                    URL U4 = new URL(every_url);
                    HttpURLConnection connection4 = (HttpURLConnection)U4.openConnection();
                    connection4.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/89.0.4389.90 Safari/537.36");
                    connection4.setRequestProperty("Authorization","token 85ff9856fd99987162840dfc927795910cedf65c");
                    connection4.setRequestProperty("Content-Type","application/json");
                    connection4.setRequestProperty("method","GET");
                    connection4.setRequestProperty("Accept","application/json");
                    connection4.connect();
                    BufferedReader in4 = new BufferedReader(new InputStreamReader(connection4.getInputStream()));
                    String line4;
                    String result4 = "";
                    while ((line4 = in4.readLine())!= null)
                    {
                        result4 += line4;
                    }
                    in4.close();
                    JSONObject jsonObj4 = JSONObject.fromObject(result4);
                    JSONArray jsonarray4 =JSONArray.fromObject(jsonObj4.get("files"));




                    for(int p=0;p<jsonarray4.size();p++){
                        JSONObject jsonObj5  = JSONObject.fromObject(jsonarray4.getString(p));
//                        System.out.println(jsonObj5.get("filename"));       //相关文件名
                        String filename = (String)jsonObj5.get("filename");

                        System.out.println(filename);
                        filenameSet.add(filename);
                    }
                }
                BufferedWriter bw = new BufferedWriter(
                        new FileWriter(route + id + ".txt"
                                , true));
                for (String str : filenameSet) {
                    try{
                        bw.write(str);
                        bw.newLine();
                    }catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
                bw.close();
                successCount++;
                System.out.println("目前成功数量："+ successCount);
            }
        }
        return "success";
    }
}
