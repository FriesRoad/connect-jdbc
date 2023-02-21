package mysqlconnect3;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 查询状态为正常的列车数量
 * @author 景苒
 */
public class GetNumber {
    public void getNumber() throws SQLException {
        Connection con = new DbConfig().dbConfig();
        String sql = "select count(state) from `train_message` where state = '正常'";
        Statement statement = con.createStatement();
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                System.out.println("状态为正常的列车数量为：" + resultSet.getInt(1));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            statement.close();
            con.close();
        }
    }
}