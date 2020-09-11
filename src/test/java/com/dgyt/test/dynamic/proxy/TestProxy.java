package com.dgyt.test.dynamic.proxy;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author hanrongjie
 * @date 2020/9/11 下午9:53
 */
public class TestProxy {


    @Test
    public  void testProxy(){
       // Tank tank = new Tank();
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        Tank tank = new Tank();
        Moveable moveable =(Moveable) Proxy.newProxyInstance(Tank.class.getClassLoader(), new Class[]{Moveable.class},
                (proxy, method, args) -> {
            System.out.println("proxy start");
            //理解错了，看生成的proxy源码，这里传proxy 不对，应该传tank
            Object o = method.invoke(tank,args);
            System.out.println("proxy end");
            return o;
        });
        moveable.move();
    }

    public static void main(String[] args) {
        //放到junit 测试里还真生成不了
        // jdk 8 sun.misc.ProxyGenerator.saveGeneratedFiles
        // jdk 11 jdk.proxy.ProxyGenerator.saveGeneratedFiles
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        Tank tank = new Tank();
        Moveable moveable =(Moveable) Proxy.newProxyInstance(Tank.class.getClassLoader(), new Class[]{Moveable.class},
                (proxy, method, args1) -> {
                    System.out.println("proxy start");
                    //理解错了，看生成的proxy源码，这里传proxy 不对，应该传tank
                    Object o = method.invoke(tank,args1);
                    System.out.println("proxy end");
                    return o;
                });
        moveable.move();
    }

}
