package com.wf.demo.concurrent;

/**
 * @author wf
 * @create 2020-08-02 10:35
 * @desc
 **/
public class StaticProxy {
    public static void main(String[] args) {
        WeddingCompany weddingCompany = new WeddingCompany(new You());
        weddingCompany.happyMarry();
    }

}

interface Marry {
    void happyMarry();
}

class You implements Marry {
    @Override
    public void happyMarry() {
        System.out.println("就要结婚了，好开心啊");
    }
}

class WeddingCompany implements Marry {
    private Marry marry;

    public WeddingCompany(Marry marry) {
        this.marry = marry;
    }

    @Override
    public void happyMarry() {
        bofore();
        this.marry.happyMarry();
        after();
    }

    private void after() {
        System.out.println("结婚之后：视频制作");
    }

    private void bofore() {
        System.out.println("结婚之前：婚礼安排");
    }
}