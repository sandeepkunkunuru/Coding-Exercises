package me.tingri.libraries.jenkins;

import hudson.cli.CLI;
import hudson.cli.CLIConnectionFactory;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JenkinsRemoteClient {

    public static void main(String[] s) throws Exception {
        URL url = new URL("http://localhost:8080");

        //Simulating command line invocation
        String[] args =new String[]{"-s", url.toString() , "build", "-v", "-s", "Expose R api", "-p", "a=10"};
    	CLI._main(args);


        //Using slightly better approach to ensure that output can be captured into a string
        //Took reference from CLI source code at https://github.com/jenkinsci/jenkins/blob/master/cli/src/main/java/hudson/cli/CLI.java
        List<String> argsList = Arrays.asList(args);
        argsList = argsList.subList(2,argsList.size());
        argsList = new ArrayList<String>(argsList);

        CLIConnectionFactory factory = new CLIConnectionFactory().url(url);
        CLI cli = factory.connect();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        BufferedOutputStream bos = new BufferedOutputStream(baos);

        cli.execute(argsList, System.in, bos, bos);

        String output = new String(baos.toByteArray());

        cli.close();

        System.out.println(output);
    }
}
