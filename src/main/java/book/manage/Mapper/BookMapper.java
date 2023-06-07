package book.manage.Mapper;

import book.manage.Entities.Book;
import book.manage.Entities.Student;
import org.apache.ibatis.annotations.Insert;

public interface BookMapper {

    //要求： 在线录入学生信息和书籍信息

    //1. 在BookMapper接口中定义一个方法，用于添加学生信息
    @Insert("insert into student(name, sex, grade) values(#{name}, #{sex}, #{grade})")
    int addStudent(Student student);

    //2. 在BookMapper接口中定义一个方法，用于添加书籍信息
    //要求： 在线录入学生信息和书籍信息
    //`desc` 是关键字，需要用 `` 包裹起来, 否则会报错
    //我怎么判断desc是关键字呢？ 用mysql的关键字列表
    //https://dev.mysql.com/doc/refman/8.0/en/keywords.html
    @Insert("insert into book(title, `desc`, price) values(#{title}, #{desc}, #{price})")
    int addBook(Book book);

}
