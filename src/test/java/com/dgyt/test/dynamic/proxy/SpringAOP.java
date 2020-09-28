package com.dgyt.test.dynamic.proxy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author hanrongjie
 * @date 2020/9/12 下午10:08
 */
public class SpringAOP {
    public static void main(String[] args) {
        ApplicationContext appContent = new ClassPathXmlApplicationContext("app.xml");
       Tank tank = (Tank) appContent.getBean("tank");

       tank.move();
    }
}
