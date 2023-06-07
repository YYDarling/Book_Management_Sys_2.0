package book.manage.Entities;

import lombok.Data;

/**
 * @title: Student
 * @Auther: Yun
 * @Date: 6/6/23 15:52
 * @Version 1.0
 */

@Data
public class Student {
    int sid;
    final String name;
    final String sex;
    final int grade;
}
