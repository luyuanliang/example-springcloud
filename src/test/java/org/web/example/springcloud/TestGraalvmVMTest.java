package org.web.example.springcloud;

import java.sql.SQLOutput;
import java.util.*;
import java.util.concurrent.*;

public class TestGraalvmVMTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println(System.getProperty("java.version")+"  begin.....");
        new JVMResource().printSummary();
        int count = 5000;
        int executeTimes = 1000;
        ExecutorService executorService = Executors.newFixedThreadPool(1000);
        List<Future<Integer>> list = new ArrayList<>();
        for (int i = 0; i < executeTimes; i++) {
            list.add(executorService.submit(new ExecuteThread(count)));
        }
        executorService.shutdown();
        while (true) {
            if (executorService.isTerminated()) {
                int total = 0;
                for (Future future : list) {
                    total = total + Integer.valueOf(future.get().toString());
                }
                System.out.println("List size is " + list.size());
                System.out.println("total is " + total);
                System.out.println("avarage is " + total / list.size());
                break;
            }
        }
        System.out.println("end");
        System.exit(1);
    }

}

class ExecuteThread implements Callable {

    private int count = 0;

    public ExecuteThread(int count) {
        this.count = count;
    }

    @Override
    public Object call() throws Exception {
        long current = System.currentTimeMillis();
        Map map = new HashMap<Object, Object>();
        for (int iter = 0; iter < count; iter++) {
            map.put(count, UUID.randomUUID());
        }
        current = System.currentTimeMillis() - current;
        return current;
    }
}