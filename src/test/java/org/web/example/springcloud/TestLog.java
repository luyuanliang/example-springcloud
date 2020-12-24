package org.web.example.springcloud;

import org.apache.log4j.Logger;
import org.web.helper.ServiceExceptionHelper;

import java.io.File;

public class TestLog {

    private static Logger logger = Logger.getLogger(TestLog.class);

    public static void main(String[] args) {
        TestLog test = new TestLog();

        try {
            test.buildException();
        } catch (Exception e) {
            System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
            e.printStackTrace();
            System.out.println("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB");
            logger.error(e);
            System.out.println("CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC");
            logger.error(e.getMessage(),e);
            System.out.println("DDDDDDDDDDDDDDDDDDDDDD");
            logger.error(ServiceExceptionHelper.getExceptionInfo(e));
            System.out.println("EEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE");
            logger.error(e.getMessage());
        }
    }

    public TestLog(){

    }

    public void buildException()throws  Exception{
        int a = 3/0;
    }
}
