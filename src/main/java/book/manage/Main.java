package book.manage;

import book.manage.Entities.Book;
import book.manage.Entities.Student;
import book.manage.sql.SqlUtil;
import lombok.extern.java.Log;
import org.apache.ibatis.io.Resources;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.LogManager;

/**
 * @title: Main
 * @Auther: Yun
 * @Date: 6/6/23 15:11
 * @Version 1.0
 */
@Log
public class Main {
    public static <e> void main(String[] args){
//        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis-config.xml"));
//        try (SqlSession sqlSession = factory.openSession(true)){
//            BookMapper b_Mapper = sqlSession.getMapper(BookMapper.class);
//            //要求： 在线录入学生信息和书籍信息
//            System.out.println(b_Mapper.addBook(new Book("life in city", "here is my ddehi", 890.89)));
//        }
        /*
        UI
         */
        System.out.println("Welcome to the Library Management System V2.0!");

        /*
        try
         */
        try (Scanner scanner = new Scanner(System.in)) {
            //日志
            LogManager manager = LogManager.getLogManager();
            manager.readConfiguration(Resources.getResourceAsStream("logging.properties"));

            //
            while (true) {
                System.out.println("=============Library Management System 2.0===========");
                System.out.println("1. Enter student information");
                System.out.println("2. Enter book information");
                System.out.println("3. Adding book borrowing records");
                System.out.print("Please enter the operation you wish to perform (Enter any other number to exit): ");
                int input;

                //定位更加精准
                try{
                    input = scanner.nextInt();
                }catch (Exception e){
                    return;
                }
                scanner.nextLine();
                switch (input) {
                    case 1:
                    /*
                    Enter student information
                     */
                        addStudent(scanner);
                        break;
                    case 2:
                    /*
                    Enter book information
                     */
                        addBook(scanner);
                        break;
                    case 3:
                        addBorrow(scanner);
                        break;
                    default:
                        return;
                }

            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    /*
        case 1 ; add student information
         */
    private static void addStudent(Scanner scanner){
        System.out.print("Please enter the student's name: ");
        String name = scanner.nextLine();
        System.out.print("Please enter the student's sex(male/female): ");
        String sex = scanner.nextLine();
        System.out.print("Please enter the student's grade: ");
        String grade = scanner.nextLine();
        int g = Integer.parseInt(grade); //将字符串强制转换为整数
        Student student = new Student(name, sex, g);

        //调用数据库操作
        SqlUtil.doSqlWork(b_Mapper -> {
            int i = b_Mapper.addStudent(student);
            if (i > 0) {
                System.out.println("Add student information successfully!");
                log.info("add a new student information" + student);
            }
            else System.out.println("Add student information failed! Please try again!");
        });
    }

    /*
    case 2 ; add book information
     */
    private static void addBook(Scanner scanner){
        System.out.print("Please enter the book's title: ");
        String title = scanner.nextLine();
        System.out.print("Please enter the book's description: ");
        String desc = scanner.nextLine();
        System.out.print("Please enter the book's price: ");
        String price = scanner.nextLine();
        double p = Double.parseDouble(price); //将字符串强制转换为整数
        Book book = new Book(title, desc, p);

        //调用数据库操作
        SqlUtil.doSqlWork(b_Mapper -> {
            int i = b_Mapper.addBook(book);
            if (i > 0) {
                System.out.println("Add book information successfully!");
                log.info("add a new book information" + book);
            }
            else System.out.println("Add book information failed! Please try again!");
        });
    }

    /*
    case 3 ; add book borrowing records
     */
    private static void addBorrow(Scanner scanner){
        System.out.print("Please enter the book's id: ");
        String b = scanner.nextLine();
        int bid = Integer.parseInt(b); //将字符串强制转换为整数
        System.out.print("Please enter the student's id: ");
        String s = scanner.nextLine();
        int sid = Integer.parseInt(s); //将字符串强制转换为整数

        //调用数据库操作
        SqlUtil.doSqlWork(b_Mapper -> {
            int i = b_Mapper.addBorrow(bid, sid);
            if (i > 0) {
                System.out.println("Add borrowing records successfully!");
                log.info("add a new borrowing records" + bid + "borrow" + sid);
            }
            else System.out.println("Add borrowing records failed! Please try again!");
        });
        //test测试
    }
}
