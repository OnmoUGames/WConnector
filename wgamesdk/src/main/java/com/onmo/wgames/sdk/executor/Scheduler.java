package com.onmo.wgames.sdk.executor;


import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Scheduler {
	private static String TAG = "Scheduler";
	private PausableThreadPoolExecutor executor;
    private LinkedBlockingQueue<Runnable> queue;
    private static Scheduler instance = new Scheduler( );
    
    private  Scheduler() {
        int processors = Runtime.getRuntime().availableProcessors();
       // SDKLog.d(TAG, ">>>>>>>>>>> processors = "+processors, SDKLoggerConstant.PRIORITY_LEVEL_PROD);
        int maxPoolSize = 4;
        queue = new LinkedBlockingQueue<Runnable>();
        executor = new PausableThreadPoolExecutor(processors < maxPoolSize? processors : maxPoolSize , 
        									maxPoolSize, 10, TimeUnit.SECONDS, queue);
    }
 
    /* Static 'instance' method */
    public static Scheduler getInstance( ) {
       return instance;
    }
    
    public void schedule(Runnable runnable) {
        executor.execute(runnable);
    }
    
    public void pause() {
        executor.pause(); 
    }
 
    public void resume() {
        executor.resume();
    }
 
    public void clear() {
        queue.clear();
    }
 
    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
