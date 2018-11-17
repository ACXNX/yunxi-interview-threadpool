package com.yunxi.threadpool.interviewthreadpool.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * @Author 无双
 * @Date 2018/11/14
 * @Description
 */
@RestController
public class TestController {
    @Autowired
    private OuterService outerService;
    @Autowired
    private ExecutorService executorService;
    @RequestMapping("/testSingle")
    public String testSingle() {
        // 开始计时
        long start = System.currentTimeMillis();
        // 单线程远程调用
        String result = outerService.queryUser() + " ; " + outerService.queryOrder() + " ; " + outerService.queryAddress();
        // 结束计时
        long end = System.currentTimeMillis();
        return "time cost " + (end - start) + " ; " + result;
    }

    @RequestMapping("/testMulti")
    public String testMulti() throws ExecutionException, InterruptedException {
        // 开始计时
        long start = System.currentTimeMillis();
        // 多线程远程调用
        Future<String> userFuture = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return outerService.queryUser();
            }
        });
        Future<String> orderFuture = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return outerService.queryOrder();
            }
        });
        Future<String> addressFuture = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return outerService.queryAddress();
            }
        });
        String result = userFuture.get()  + " ; " + orderFuture.get() + " ; " + addressFuture.get();
        // 结束计时
        long end = System.currentTimeMillis();
        return "time cost " + (end - start) + " ; " + result;
    }

}
