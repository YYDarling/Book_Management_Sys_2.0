package com.test;

import book.manage.sql.SqlUtil;
import org.junit.Test;

/**
 * @title: MainTest
 * @Auther: Yun
 * @Date: 6/11/23 14:56
 * @Version 1.0
 */

public class MainTest {
    @Test
    public void test_1(){
        SqlUtil.doSqlWork(mapper -> {
            mapper.getBorrowList().forEach(System.out::println);
        });
    }

    @Test
    public void test_2(){
        SqlUtil.doSqlWork(mapper -> {
            mapper.getStudentList().forEach(System.out::println);
        });
    }

    @Test
    public void test_3(){
        SqlUtil.doSqlWork(mapper -> {
            mapper.getBookList().forEach(System.out::println);
        });
    }
}
