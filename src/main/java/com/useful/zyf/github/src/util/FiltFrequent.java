package com.useful.zyf.github.src.util;

import com.useful.zyf.entity.Artifact;
import com.useful.zyf.entity.ItemCategory;
import com.useful.zyf.github.src.apriori.MainTestApriori_saveToFile;
import com.useful.zyf.service.ArtifactService;
import com.useful.zyf.service.ItemCategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.*;
import java.util.Map;
import java.util.regex.Pattern;


public class FiltFrequent {

    @Autowired
    ArtifactService artifactService;

    @Autowired
    ItemCategoryService itemCategoryService;

    public void getfiltfrequent(String name,String type) throws IOException {

//        String[] dir_name_str = name.split("/");
//        String dir_name = dir_name_str[dir_name_str.length-1];
//
//        String route = "C:/Users/dell/Desktop/" +dir_name +"-"+type+".txt";
//        File file_artifact = new File(route);
//        if(!file_artifact.exists()){
//            file_artifact.createNewFile();
//        }
        Artifact artifact = new Artifact();



        GithubTransferToNum githubTransferToNum = new GithubTransferToNum();
        githubTransferToNum.transfertonum();

        MainTestApriori_saveToFile mainTestApriori_saveToFile = new MainTestApriori_saveToFile();
        mainTestApriori_saveToFile.computeApriori();

        Map<String, Integer> tempmap = githubTransferToNum.getMap();


        String path = "src/main/java/com/useful/zyf/github/output/githuboutput.txt";
        File file = new File(path);
        BufferedReader reader;

        reader = new BufferedReader(new FileReader(file));
        String tempStr;

//        BufferedWriter bw = new BufferedWriter(new FileWriter("src/com/zyf/sequencefile/" + "result.txt", true));

        BufferedWriter bw = null;
        while ((tempStr = reader.readLine()) != null) {

            StringBuilder result = new StringBuilder();
            if (isfrequent(tempStr)) {

                String[] str = tempStr.split(" ");

                for (Map.Entry<String, Integer> entry : tempmap.entrySet()) {

                    if (entry.getValue() == (Integer.parseInt(str[0]))) {
                        result.append(entry.getKey());
                        result.append("  ,  ");
                    }
                }
                for (Map.Entry<String, Integer> entry : tempmap.entrySet()) {

                    if (entry.getValue() == (Integer.parseInt(str[1]))) {
                        result.append(entry.getKey());
                        result.append("  ,  ");
                    }
                }
                result.append(str[3] + str[4]);
                String[] artifact_str = result.toString().split("  ,  ");
                artifact.setArtifactone(artifact_str[0]);
                artifact.setArtifacttwo(artifact_str[1]);

                String sup=artifact_str[2].substring(artifact_str[2].indexOf(":")+1);
                artifact.setSupport(sup);

                ItemCategory itemcategory = itemCategoryService.getname(name);

                artifact.setItemcategory(itemcategory);
                artifact.setType(type);
                artifactService.addOrUpdate(artifact);




            }

        }
    }

    private static boolean isfrequent(String tempStr) {
        String res=String.valueOf(tempStr);
        String[] temp = res.split(" ");
        Pattern pattern = Pattern.compile("[0-9]*");
        int count=0;
        if (pattern.matcher(temp[0]).matches() && pattern.matcher(temp[1]).matches()){
            return true;
        }
        else
            return false;
    }
}
