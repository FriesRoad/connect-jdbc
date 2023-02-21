package mysqlconnect2;

import java.sql.*;
import java.util.Date;

public class connectext {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //加载驱动类
        Class.forName("com.mysql.cj.jdbc.Driver");

        //创建连接对象,连接到指定数据库
        String url = "jdbc:mysql://localhost:3306/datatest";
        String username = "root";
        String password = "123456";
        Connection connection = DriverManager.getConnection(url, username, password);

        //通过连接对象创建Statement工具类
        Statement statement = connection.createStatement();

        //执行相应sql语句,得出结果
        String sql = "select * from users";
        ResultSet resultSet = statement.executeQuery(sql);

        //处理结果,使用while循环,输出表内容
        while (resultSet.next()){
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String pas = resultSet.getString(3);
            String email = resultSet.getString(4);
            Date birthday = resultSet.getDate(5);

            //创建对象
            connect b = new connect(id,name,pas,email,birthday);
            System.out.println(b);
        }
    }
}
