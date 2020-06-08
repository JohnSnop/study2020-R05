package com.wf.demo.jvm;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author wf
 * @create 2020-06-08 22:00
 * @desc
 **/
public class MetaspaceOOMDemo {
    // -XX:MetaspaceSize=8m -XX:MaxMetaspaceSize=8m
    public static void main(String[] args) {
        int i = 0;
        try {
            while (true) {
                i++;
                Enhancer enhancer = new Enhancer();
                enhancer.setSuperclass(MetaspaceOOMDemo.class);
                enhancer.setUseCache(false);
                enhancer.setCallback(new MethodInterceptor() {
                    @Override
                    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                        return methodProxy.invoke(o, objects);
                    }
                });
                enhancer.create();
            }
        } catch (Throwable e) {
        	e.printStackTrace();
        }
    }

    static class MetaTest {}
}
