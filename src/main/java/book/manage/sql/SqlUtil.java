package book.manage.sql;

import book.manage.Mapper.BookMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.util.function.Consumer;

/**
 * @title: SqlUtil
 * @Auther: Yun
 * @Date: 6/6/23 16:33
 * @Version 1.0
 */

public class SqlUtil {

    // SqlSessionFactory 是线程安全的，所以可以作为单例
    // 但是 SqlSession 不是线程安全的，所以不能作为单例
    private SqlUtil(){}
    private static SqlSessionFactory factory;

    static {
        try {
            factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis-config.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // 通过 SqlUtil.getFactory() 获取 SqlSessionFactory
//    public SqlSession getSession(){
//        return factory.openSession(true);
//    }

    public static void doSqlWork(Consumer<BookMapper> consumer){
        try (SqlSession sqlSession = factory.openSession(true)){
            BookMapper b_Mapper = sqlSession.getMapper(BookMapper.class);
            consumer.accept(b_Mapper);
        }
    }

}
