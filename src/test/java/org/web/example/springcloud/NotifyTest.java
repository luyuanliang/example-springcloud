package org.web.example.springcloud;

import java.util.concurrent.locks.Lock;

public class NotifyTest {

    public static void main(String[] args) {
        System.out.println("begin");
        NotifyThread test = new NotifyThread();
        test.start();
        test.synFunction2();
    }
}
