package mysqlconnect3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 查询沈阳到武汉的所有列车信息，按出发时间先后排序
 * @author 景苒
 */
public class GetMessage {
    public void getMessage() throws SQLException {
        Connection con = new DbConfig().dbConfig();
        String sql = "select * from `train_message` where origin = ? and terminal = ? ORDER BY departure_time ASC";
        String origin = "呼伦贝尔";
        String terminal = "乌兰察布";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, origin);
        ps.setString(2, terminal);
        ResultSet rs = ps.executeQuery();
        try {
            while (rs.next()) {
                System.out.println("列车名：" + rs.getString("train_name")
                        + " 始发站：" + rs.getString("origin")
                        + " 终到站：" + rs.getString("terminal")
                        + " 出发时间：" + rs.getString("departure_time")
                        + " 列车状态：" + rs.getString("state"));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ps.close();
            con.close();
        }
    }
}