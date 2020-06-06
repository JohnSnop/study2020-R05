package com.wf.demo.java8;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author wf
 * @create 2020-06-06 20:42
 * @desc
 **/
public class TestAnno {

    @Test
    public void test1() throws Exception {
        Class<TestAnno> testAnnoClass = TestAnno.class;
        Method show = testAnnoClass.getMethod("show", String.class);

        MyAnnotation[] annotationsByType = show.getAnnotationsByType(MyAnnotation.class);
        for (MyAnnotation myAnnotation : annotationsByType) {
            System.out.println(myAnnotation.value());
        }

        System.out.println("------------");
        Annotation[][] parameterAnnotations = show.getParameterAnnotations();
        for (Annotation[] parameterAnnotation : parameterAnnotations) {
            for (Annotation annotation : parameterAnnotation) {
                System.out.println((MyAnnotation)annotation);
            }
        }
    }

    @MyAnnotation("Hello")
    @MyAnnotation("World")
    public void show(@MyAnnotation String arg) {

    }
}
