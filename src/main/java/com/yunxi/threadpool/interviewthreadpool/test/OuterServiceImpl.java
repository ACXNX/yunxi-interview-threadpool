package com.yunxi.threadpool.interviewthreadpool.test;

import org.springframework.stereotype.Service;

/**
 * @Author 无双
 * @Date 2018/11/14
 * @Description
 */
@Service
public class OuterServiceImpl implements OuterService {
    /**
     * 模拟查询用户
     */
    @Override
    public String queryUser() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "user name is zhangsan";
    }

    /**
     * 模拟查询订单
     */
    @Override
    public String queryOrder() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "user order is 2018111700000001";
    }

    /**
     * 模拟查询地址
     */
    @Override
    public String queryAddress() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "user address is shanghai";
    }
}
