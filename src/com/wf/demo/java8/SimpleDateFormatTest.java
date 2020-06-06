package com.wf.demo.java8;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author wf
 * @create 2020-06-04 21:54
 * @desc
 **/
public class SimpleDateFormatTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        ExecutorService service = Executors.newFixedThreadPool(10);

        // before(service);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        List<Future<LocalDate>> futures = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            futures.add(service.submit(() -> LocalDate.parse("2020-05-25", dtf)));
        }

        for (Future<LocalDate> future : futures) {
            System.out.println(future.get());
        }

        service.shutdown();
    }

    private static void before(ExecutorService service) throws InterruptedException, ExecutionException {
        List<Future<Date>> futures = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            futures.add(service.submit(() -> SimpleDateFormatTest.convert("2020-05-25")));
        }

        for (Future<Date> future : futures) {
            System.out.println(future.get());
        }
    }

    private static final ThreadLocal<DateFormat> tl = new ThreadLocal<DateFormat>() {
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd");
        };
    };

    public static Date convert(String source) throws ParseException {
        return tl.get().parse(source);
    }
}
