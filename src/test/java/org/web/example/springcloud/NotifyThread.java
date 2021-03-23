package org.web.example.springcloud;

public class NotifyThread extends Thread {

    public NotifyThread getThread() {
        return thread;
    }

    public void setThread(NotifyThread thread) {
        this.thread = thread;
    }

    private NotifyThread thread;


    @Override
    public void run() {
        synFunction1();
    }

    public void synFunction1(){
        synchronized (this){
            try {
                thread.wait(20000L);
                System.out.println("BBBBB");
                thread.notify();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void synFunction2(){
        synchronized (this){
            try {
                while (true){
                    System.out.println("aaa");
                    Thread.sleep(2000L);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
