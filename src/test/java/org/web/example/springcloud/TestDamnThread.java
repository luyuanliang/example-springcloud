package org.web.example.springcloud;

public class TestDamnThread extends Thread {
    public static void main(String[] args) {
        TestDamnThread t = new TestDamnThread();
        //t.setDaemon(false);
        t.start();
    }

    @Override
    public void run() {

        try {
            while (true){
                System.out.println("aaaa");
                Thread.sleep(1000L);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
