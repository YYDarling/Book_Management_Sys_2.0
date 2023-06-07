package book.manage;

import java.util.Scanner;

/**
 * @title: Main
 * @Auther: Yun
 * @Date: 6/6/23 15:11
 * @Version 1.0
 */

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
            while (true) {
                System.out.println("=============Library Management System 2.0===========");
                System.out.println("1. Enter student information");
                System.out.println("2. Enter book information");
                System.out.print("Please enter the operation you wish to perform (Enter any other number to exit): ");
                int input;

                //定位更加精准
                try{
                    input = scanner.nextInt();
                }catch (Exception e){
                    return;
                }
                switch (input) {
                    case 1:
                    /*
                    Enter student information
                     */
                        break;
                    case 2:
                    /*
                    Enter book information
                     */
                        break;
                    default:
                        return;
                }

            }
        }catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
