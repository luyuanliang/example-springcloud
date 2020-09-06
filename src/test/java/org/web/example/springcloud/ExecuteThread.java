package org.web.example.springcloud;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Callable;

public class ExecuteThread implements Callable {

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
