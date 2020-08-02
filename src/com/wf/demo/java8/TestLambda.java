package com.wf.demo.java8;

/**
 * @author wf
 * @create 2020-08-02 10:58
 * @desc
 **/
public class TestLambda {
    // 静态内部类
    static class Like2 implements ILike {
        @Override
        public void lambda() {
            System.out.println("Lambda---two");
        }
    }
    public static void main(String[] args) {
        ILike like = new Like();
        like.lambda();

        like = new Like2();
        like.lambda();
        // 局部内部类
        class Like3 implements ILike {

            @Override
            public void lambda() {
                System.out.println("Lambda---three");
            }
        }
        like = new Like3();
        like.lambda();
        // 匿名内部类
        like = new ILike() {
            @Override
            public void lambda() {
                System.out.println("Lambda---four");
            }
        };
        like.lambda();
        // Lambda
        like = () -> System.out.println("Lambda---牛逼");
        like.lambda();
    }
}

interface ILike {
    void lambda();
}

class Like implements ILike {

    @Override
    public void lambda() {
        System.out.println("Lambda---one");
    }
}
