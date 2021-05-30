package com.useful.zyf.github.src;

import com.useful.zyf.github.src.util.FiltFrequent;

import java.io.IOException;

public class GithubMain {
    public static void artifactCreateMethod(String name,String type) throws IOException {
        FiltFrequent filtfrequent = new FiltFrequent();
        filtfrequent.getfiltfrequent(name,type);
    }
}
