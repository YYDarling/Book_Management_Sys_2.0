package book.manage.Mapper;

import book.manage.Entities.Book;
import book.manage.Entities.Borrow;
import book.manage.Entities.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

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

    //3. 在BookMapper接口中定义一个方法，用于添加借阅信息
    @Insert("insert into borrow(sid, bid) values(#{sid}, #{bid})")
    int addBorrow(@Param("sid") int sid, @Param("bid") int bid);

    //4. 在BookMapper接口中定义一个方法，用于显示借阅信息, 包括学生信息和书籍信息
    @Results({
            @Result(column = "id", property = "id", id = true),
            @Result(column = "sid", property = "student", one = @One(select = "getStudentById")),
            @Result(column = "bid", property = "book", one = @One(select = "getBookById"))
    })

    //获取borrow信息
    @Select("select * from borrow")
    List<Borrow> getBorrowList();

//    //单独做映射
//    @Results({
//            @Result(column = "sid", property = "sid", id = true),
//            @Result(column = "name", property = "name"),
//            @Result(column = "sex", property = "sex", jdbcType = JdbcType.VARCHAR, javaType = String.class),
//            @Result(column = "grade", property = "grade")
//    })

    //5. 在BookMapper接口中定义一个方法，用于显示学生信息
    @Select("select * from student")
    List<Student> getStudentList();


    //6. 在BookMapper接口中定义一个方法，用于显示书籍信息
    @Select("select * from book")
    List<Book> getBookList();



    //获取student通过sid
    @Select("select * from student where sid = #{sid}")
    Student getStudentById(int sid);


    //获取book通过bid
    @Select("select * from book where bid = #{bid}")
    Book getBookById(int bid);

}
