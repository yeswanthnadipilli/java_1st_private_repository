package database;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;
import java.util.Calendar;

public class DataBaseservice {

    private final Connection connection;

    public DataBaseservice(Connection connection) {
        this.connection = connection;
    }


    public int create(int acNum, int amt, String name, Date date, boolean status) throws SQLException {
        String sql = "insert into bank_account values(?, ?, ?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, acNum);
        ps.setInt(2, amt);
        ps.setString(3, name);
        ps.setDate(4, date);
        ps.setBoolean(5, status);
        int i = ps.executeUpdate();
        return i;
    }

    public void search() throws SQLException {
        String sql = "select * from bank_account";
        PreparedStatement ps = connection.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int acNum = rs.getInt("ac_num");
            int amt = rs.getInt("amount_number");
            String name = rs.getString("ac_hld_nm");
            Date date = rs.getDate("ac_cre_dt_date");
            boolean status = rs.getBoolean("status");
            System.out.println("acNum   " + acNum + "  " + "amt    " + amt + "  " + "name   " + name + "  " + "date   " + date + "  " + "status   " + status);

        }
        rs.close();

    }


    public void selectWhere(int ac_num) throws SQLException {
        String sql = "select * from bank_account where ac_num= ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, ac_num);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int acNum = rs.getInt("ac_num");
            int amt = rs.getInt("amount_number");
            String name = rs.getString("ac_hld_nm");
            Date date = rs.getDate("ac_cre_dt_date");
            boolean status = rs.getBoolean("status");
            System.out.println("acNum   " + acNum + "  " + "amt    " + amt + "  " +
                    "name   " + name + "  " + "date   " + date + "  " + " " +
                    "status   " + status);
        }
        rs.close();


    }

//        public int update() throws SQLException {
//         String sql = "update bank_account set amount_number= ? where ac_num = ?";
//         PreparedStatement ps = connection.prepareStatement(sql);
//         ps.setInt(1,9000);
//         ps.setInt(2,105);


}
















