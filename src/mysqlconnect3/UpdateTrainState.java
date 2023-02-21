package mysqlconnect3;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 修改T2255列车的状态为停运
 * @author 景苒
 */
public class UpdateTrainState {
    public void updateTrainState() throws SQLException {
        Connection con = new DbConfig().dbConfig();
        String sql = "UPDATE `train_message` SET state = '停运' WHERE train_name = 'T2255'";
        Statement statement = con.createStatement();
        try {
            int i = statement.executeUpdate(sql);
            if (i > 0) {
                System.out.println("更新成功");
            }else {
                System.out.println("更新失败");
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            statement.close();
            con.close();
        }
    }
}