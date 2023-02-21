package mysqlconnect3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * 新增一辆列车信息（自己输入）
 * 始发时间为timestamp类型，输入时需要确保格式正确，如：2019-01-01 00:00:00
 * @author 景苒
 */
public class InsertTrain {
    public void insertTrain() throws SQLException {
        Connection con = new DbConfig().dbConfig();
        Scanner scanner = new Scanner(System.in);
        String sql = "insert into `train_message` values(null, ?, ?, ?, ?, default)";
        System.out.print("请输入列车名：");
        String trainName = scanner.nextLine();
        System.out.print("请输入始发站：");
        String origin = scanner.nextLine();
        System.out.print("请输入终到站：");
        String terminal = scanner.nextLine();
        System.out.print("请输入始发时间：");
        String departureTime = scanner.nextLine();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, trainName);
        ps.setString(2, origin);
        ps.setString(3, terminal);
        ps.setString(4, departureTime);
        try {
            int i = ps.executeUpdate();
            if (i > 0) {
                System.out.println("添加成功");
            }else {
                System.out.println("添加失败");
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ps.close();
            con.close();
        }
    }
}
