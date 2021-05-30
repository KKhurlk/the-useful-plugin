package com.useful.zyf.github.src.util;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GithubTransferToNum {
    Map<String, Integer> map;


    static List<File> sourcefileList = new ArrayList<>();


    public void transfertonum() throws IOException {


        List<File> fileList = new ArrayList<>();

        String sourcepath = "C:/Users/dell/Desktop/springboot-commits/";

        copytofileList(fileList,sourcepath);


        map = new HashMap<>();
        List<String> tempList = new ArrayList();
        for (File f : fileList) {

            transfer(f,map,tempList);

        }

        createsequence(map,fileList);
    }

    private static void copytofileList(List<File> fileList , String sourcepath) {
        File source = new File(sourcepath);
        if (source.isDirectory()) {
            File[] files = source.listFiles();
            if (files.length == 0) {
                return;
            } else {
                for (File fs : files) {
                        fileList.add(fs);
                    }
                }
            }
    }



    public static void transfer(File file, Map<String, Integer> map, List<String> tempList) throws IOException {
        try {
            BufferedReader reader;
            StringBuilder sb = new StringBuilder();
            reader = new BufferedReader(new FileReader(file));
            String tempStr;

            Map<String,Integer> delmap= new HashMap<>();

            while ((tempStr = reader.readLine()) != null) {
                if (delmap.containsKey(tempStr)) {
                    delmap.put(tempStr, delmap.get(tempStr) + 1);
                } else {
                    delmap.put(tempStr, 1);
                }
            }

            for (Map.Entry<String, Integer> entry : delmap.entrySet()) {
//                System.out.println("key = " + entry.getKey() + ", value = " + entry.getValue());
                if(!tempList.contains(entry.getKey())){
                    tempList.add(entry.getKey());
                    map.put(entry.getKey(),tempList.size()-1);

                }
                else{
                    continue;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void createsequence(Map<String, Integer> map,List<File> fileList) throws IOException {

        deletdir("src/main/java/com/useful/zyf/github/output/githubfilenameresult.txt");  //清空文件

        BufferedWriter bw = new BufferedWriter(new FileWriter("src/main/java/com/useful/zyf/github/output/"+"githubfilenameresult.txt",true));

        for(File f : fileList){
            try {
                BufferedReader reader;
                StringBuilder sb = new StringBuilder();
                reader = new BufferedReader(new FileReader(f));
                String tempStr;


                while ((tempStr = reader.readLine()) != null) {
                    if (map.containsKey(tempStr)) {
                        bw.write(map.get(tempStr)+" ");
                    }
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
            bw.newLine();
        }
        bw.close();

    }



    private static void deletdir(String path) throws IOException{
        File log = new File(path);

        FileWriter fileWriter =new FileWriter(log);
        fileWriter.write("");
        fileWriter.flush();
        fileWriter.close();
    }

    public Map<String, Integer> getMap(){
        return map;
    }

}
