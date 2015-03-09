package com.blung.sikios;

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
    public static void main(String [] args){
          String configLocation = "classpath*:com/secondstack/mgm/service/applicationContext.xml";
        ApplicationContext appContext = new ClassPathXmlApplicationContext(configLocation);

//        AplikasiService aplikasiService = appContext.getBean("aplikasiService", AplikasiService.class);
//
//        List result = aplikasiService.findAplikasis();
//        System.out.println(result);
    }
}
