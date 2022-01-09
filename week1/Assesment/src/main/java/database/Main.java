package database;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

public class Main {

    public static void main(String args[]) throws SQLException, ClassNotFoundException {
        Connectivity connectivity = new Connectivity();

        DataBaseservice db = new DataBaseservice(connectivity.getConnection());
//        db.create(
//                 105,
//                5000,
//                "pqr",
//                Date.valueOf(LocalDate.now()),
//                false

        //      );

           // db.search();
       // db.selectWhere(103);
        db.update();

    }
}
