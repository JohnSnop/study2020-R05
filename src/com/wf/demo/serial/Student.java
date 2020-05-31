package com.wf.demo.serial;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/**
 * @author wf
 * @create 2020-05-31 11:32
 * @desc
 **/
@Data
@ToString
@AllArgsConstructor
public class Student implements Serializable {

    private String name;
    private Integer age;
    private Integer score;

    // private Long id;
    private transient String password;

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        if (score < 0 || score > 100) {
            throw new IllegalArgumentException("分数非法");
        }
    }
}
