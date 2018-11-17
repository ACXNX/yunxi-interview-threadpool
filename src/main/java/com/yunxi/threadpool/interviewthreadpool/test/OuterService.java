package com.yunxi.threadpool.interviewthreadpool.test;

/**
 * @Author 无双
 * @Date 2018/11/14
 * @Description 外部服务
 */
public interface OuterService {
    /**
     * 模拟查询用户
     */
    String queryUser();
    /**
     * 模拟查询订单
     */
    String queryOrder();
    /**
     * 模拟查询地址
     */
    String queryAddress();
}
