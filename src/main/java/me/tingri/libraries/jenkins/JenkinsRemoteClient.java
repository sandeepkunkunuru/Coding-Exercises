package me.tingri.libraries.jenkins;

import hudson.cli.CLI;

public class JenkinsRemoteClient {

    public static void main(String[] s) throws Exception {
    	CLI._main(new String[]{"-s", "http://localhost:8080", "build", "-v", "-s", "Expose R api", "-p", "a=10"});
    }
}
