package com.useful.zyf.utils;

import java.io.IOException;

public class gethelpme {
    public static void main(String[] args) throws IOException {
        String web ="https://api.github.com/repos/"+"apache/maven"+"/"+"pulls"+"?state=closed&per_page=100&page=";
        ProcessPullRequestsUtils processPullRequestsUtils =new ProcessPullRequestsUtils();
        processPullRequestsUtils.getGithubPulls(web,"apache/maven");
    }
}
