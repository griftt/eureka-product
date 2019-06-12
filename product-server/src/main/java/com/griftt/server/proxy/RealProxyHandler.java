package com.griftt.server.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class RealProxyHandler implements InvocationHandler {

    private Object target;

    public RealProxyHandler(Object object) {
        this.target = object;
    }

    private  <T> T getProxy(){
        Class<?> aClass = target.getClass();
        System.out.println(1);
        return(T) Proxy.newProxyInstance(aClass.getClassLoader(),aClass.getInterfaces(),this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String name = method.getName();
        System.out.println(name);
        System.out.println("before");
        Object invoke = method.invoke(target, args);
        System.out.println("after");
        return invoke;
    }

    public static void main(String[] args) {
        //System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        ProxyInterface proxy = (ProxyInterface) new RealProxyHandler(new ProxyImpl()).getProxy();
        System.out.println(proxy.say());
    }
}
