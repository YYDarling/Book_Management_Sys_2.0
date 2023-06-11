package book.manage.Entities;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @title: Book
 * @Auther: Yun
 * @Date: 6/6/23 15:54
 * @Version 1.0
 */
@Data
@NoArgsConstructor
public class Book {
    int bid;
    String title;;
    String desc;
    double price;

    public Book(String title, String desc, double price) {
        this.title = title;
        this.desc = desc;
        this.price = price;
    }
}
