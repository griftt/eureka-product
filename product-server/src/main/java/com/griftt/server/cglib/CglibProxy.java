package com.griftt.server.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy  implements MethodInterceptor {


    //处理逻辑
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        //执行方法
        method.invoke(o,objects);
        return o;
    }

    public static void main(String[] args) {
        //cglib实现
        CglibProxy cglibProxy = new CglibProxy();
        CglibWork cglibWork = new CglibWork();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(cglibWork.getClass());
        enhancer.setCallback(cglibProxy);
        CglibWork cglibWork1 = (CglibWork) enhancer.create();
        System.out.println(cglibWork1.hello());

    }
}
