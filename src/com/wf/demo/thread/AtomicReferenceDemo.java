package com.wf.demo.thread;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author wf
 * @create 2020-05-05 15:08
 * @desc
 **/
public class AtomicReferenceDemo {
    public static void main(String[] args) {
        User zhangsan = new User("zhangsan", 22);
        User lisi = new User("lisi", 25);
        AtomicReference<User> atomicReference = new AtomicReference<>();
        atomicReference.set(zhangsan);

        System.out.println(atomicReference.compareAndSet(zhangsan, lisi));
        System.out.println(atomicReference.get().toString());

        System.out.println(atomicReference.compareAndSet(zhangsan, lisi));
        System.out.println(atomicReference.get().toString());
    }
}

@Data
@ToString
@AllArgsConstructor
class User {
    String username;
    int age;
}