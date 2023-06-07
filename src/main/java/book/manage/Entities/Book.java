package book.manage.Entities;

import lombok.Data;

/**
 * @title: Book
 * @Auther: Yun
 * @Date: 6/6/23 15:54
 * @Version 1.0
 */
@Data
public class Book {
    int bid;
    final String title;;
    final String desc;
    final double price;

}
