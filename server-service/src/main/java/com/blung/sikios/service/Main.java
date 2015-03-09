package com.blung.sikios.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Latief
 * Date: 10/10/11
 * Time: 12:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String [] args) {
        String configLocation = "classpath*:com/secondstack/mgm/service/applicationContext.xml";
        ApplicationContext appContext = new ClassPathXmlApplicationContext(configLocation);

//        TestService testService = appContext.getBean("testService", TestService.class);
//
//
//        List<SimpleTest> simpleTestList = testService.findSimpleTest();
//        System.out.println("");
//
//        BankService bankService = appContext.getBean("bankService", BankService.class);
    }
}
