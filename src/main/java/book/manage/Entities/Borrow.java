package book.manage.Entities;

import lombok.Data;

/**
 * @title: Borrow
 * @Auther: Yun
 * @Date: 6/11/23 14:58
 * @Version 1.0
 */
@Data
public class Borrow {
    int id;
    //学生id
    //映射
    Student student;
    //书籍id
    //映射
    Book book;
}
