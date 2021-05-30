package com.useful.zyf.utils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

public class muban {
    public static void main(String[] args) throws IOException {
        JSONArray jsonarray;
        JSONObject jsonObj;
        String id = "";
        int successCount = 0;

        for(int i=0;i<160;i++){

            String web = "https://api.github.com/repos/spring-projects/spring-boot/commits?&per_page=30&page="+i;

            URL U = new URL(web);
            HttpURLConnection connection = (HttpURLConnection)U.openConnection();
            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/89.0.4389.90 Safari/537.36");
            connection.setRequestProperty("Authorization","token 75ad99ddb28f634f21cd25d8e694bbb3e5d4031f");
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
//                System.out.println(jsonObj.get("title"));       //任务描述
//                System.out.println(jsonObj.get("body"));        //发起者评论
                id = jsonObj.get("sha").toString();
                JSONObject first_name;
                first_name = JSONObject.fromObject(jsonObj.get("user"));
//                System.out.println(first_name.get("login"));     //发起者name

//                String comments_url = (String) jsonObj.get("comments_url");
//                URL U2 = new URL(comments_url);
//                HttpURLConnection connection2 = (HttpURLConnection)U2.openConnection();
//                connection2.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
//                connection2.setRequestProperty("Authorization","token d1eb5704e490103e56d1e95dd020a63192d0f695");
//                connection2.setRequestProperty("Content-Type","application/json");
//                connection2.setRequestProperty("method","GET");
//                connection2.setRequestProperty("Accept","application/json");
//                connection2.connect();
//                BufferedReader in2 = new BufferedReader(new InputStreamReader(connection2.getInputStream()));
//                String line2;
//                String result2 = "";
//                while ((line2 = in2.readLine())!= null)
//                {
//                    result2 += line2;
//                }
//                in2.close();
//                JSONArray jsonarray2 = JSONArray.fromObject(result2);
//                for(int m=0;m<jsonarray2.size();m++){
//                    JSONObject jsonObj2  = JSONObject.fromObject(jsonarray2.getString(m));
//                    System.out.println(jsonObj2.get("body"));       //相关评论
//                    JSONObject last_name;
//                    last_name = JSONObject.fromObject(jsonObj2.get("user"));
//                    System.out.println(last_name.get("login"));     //相关name
//                }


                String commits_url = (String) jsonObj.get("commits_url");
                URL U3 = new URL(commits_url);
                HttpURLConnection connection3 = (HttpURLConnection)U3.openConnection();
                connection3.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/89.0.4389.90 Safari/537.36");
                connection3.setRequestProperty("Authorization","token 75ad99ddb28f634f21cd25d8e694bbb3e5d4031f");
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
                    connection4.setRequestProperty("Authorization","token 75ad99ddb28f634f21cd25d8e694bbb3e5d4031f");
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
                for (String str : filenameSet) {
                    BufferedWriter bw = null;
                    try{
                        bw = new BufferedWriter(
                                new FileWriter("C:/Users/dell/Desktop/springboot-pr1/" + id + ".txt"
                                        , true));
                        bw.write(str);
                        bw.newLine();
                    }catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }finally{
                        bw.flush();
                        bw.close();
                    }
                }
                successCount++;
                System.out.println("目前成功数量："+ successCount);
            }
        }
    }
}
