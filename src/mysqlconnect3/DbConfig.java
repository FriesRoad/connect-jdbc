package mysqlconnect3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *  数据库配置类
 *  @author 景苒
 */
public class DbConfig {
    public Connection dbConfig() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("加载驱动成功");
        }catch (Exception e) {
            System.out.print("加载驱动失败!");
            e.printStackTrace();
        }
        String url = "jdbc:mysql://localhost:3306/datatest?useSSL=false&useUnicode=true&characterEncoding=utf-8&serverTimezone=GMT%2B8&allowPublicKeyRetrieval=true";
        String user = "root";
        String password = "123456";
        return DriverManager.getConnection(url, user, password);
    }
}