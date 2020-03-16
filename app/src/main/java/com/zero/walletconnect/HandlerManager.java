package com.zero.walletconnect;

import android.os.Handler;
import android.os.HandlerThread;

public class HandlerManager {

    private static HandlerManager handlerManager = new HandlerManager();
    private Handler mainHandler = new Handler();
    private Handler slowHandler;
    private Handler accountRequestHandler;
    private Handler collectHandler;

    private HandlerManager() {
        HandlerThread slowThread = new HandlerThread("slow");
        slowThread.start();
        slowHandler = new Handler(slowThread.getLooper());

        HandlerThread collectThread = new HandlerThread("collect");
        collectThread.start();
        collectHandler = new Handler(collectThread.getLooper());

        HandlerThread accountRequestThread = new HandlerThread("accountRequest");
        accountRequestThread.start();
        accountRequestHandler = new Handler(accountRequestThread.getLooper());
    }

    public static HandlerManager getInstance() {
        return handlerManager;
    }

    public void init() {

    }

    public void postMain(Runnable runnable) {
        mainHandler.post(runnable);
    }

    public void postMainDelay(Runnable runnable, int delayTime) {
        mainHandler.postDelayed(runnable, delayTime);
    }

    public void removeMain(Runnable runnable) {
        mainHandler.removeCallbacks(runnable);
    }

    /**
     * 非主线程，请尽量不要滥用
     * @param runnable
     */
    public void postSlow(Runnable runnable) {
        slowHandler.post(runnable);
    }

    public void postSlowDelay(Runnable runnable, int delayTime) {
        slowHandler.postDelayed(runnable, delayTime);
    }

    public void removeSlow(Runnable runnable) {
        slowHandler.removeCallbacks(runnable);
    }

    /**
     * 非主线程，请尽量不要滥用, 账户请求专用，那里会用到各种锁
     * @param runnable
     */
    public void postAccountRequest(Runnable runnable) {
        accountRequestHandler.post(runnable);
    }

    public void postAccountRequest(Runnable runnable, int delayTime) {
        accountRequestHandler.postDelayed(runnable, delayTime);
    }

    public void removeAccountRequest(Runnable runnable) {
        accountRequestHandler.removeCallbacks(runnable);
    }

    /**
     * 非主线程，搜集信息用
     * @param runnable
     */
    public void postCollect(Runnable runnable) {
        collectHandler.post(runnable);
    }

    public void postCollectDelay(Runnable runnable, int delayTime) {
        collectHandler.postDelayed(runnable, delayTime);
    }

    public void removeColect(Runnable runnable) {
        collectHandler.removeCallbacks(runnable);
    }
}
