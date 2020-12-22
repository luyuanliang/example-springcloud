package org.web.example.springcloud;

import org.apache.log4j.Logger;

import java.io.File;

public class TestLog {

    private static Logger logger = Logger.getLogger(TestLog.class);

    public static void main(String[] args) {
        TestLog test = new TestLog();

        try {
            test.buildException();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("=================");
            logger.error(e);
        }
    }

    public TestLog(){

    }

    public void buildException()throws  Exception{
        int a = 3/0;
    }
}
