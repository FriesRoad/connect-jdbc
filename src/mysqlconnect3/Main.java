package mysqlconnect3;

import java.sql.SQLException;

/**
 * 主函数，调用功能
 * @author 景苒
 */
public class Main {
    public static void main(String[] args) throws SQLException {
        new GetMessage().getMessage();

//        new UpdateTrainState().updateTrainState();
//        new InsertTrain().insertTrain();
//        new GetNumber().getNumber();
    }
}