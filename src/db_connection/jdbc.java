/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author LABS- 119
 */
public class jdbc {
     PreparedStatement ps;
    public static Connection con;
    ResultSet re;

    public jdbc() {
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(jdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
            con = DriverManager.getConnection("jdbc:mysql://localhost/CAR", "root","root");
        } catch (SQLException ex) {
            Logger.getLogger(jdbc.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
      public int tb_count(String table_name) {
        int count = 0;
        try {
            ps = con.prepareStatement("select count(customer_id) from " + table_name + ";");
            re = ps.executeQuery();
            while (re.next()) {
               count = count + re.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(jdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }
      
    public ResultSet SELECTall() {
        try {
            ps = con.prepareStatement("select * from address where flag  = 0");
            re = ps.executeQuery();
            re.next();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE, null);
        }
        return re;
    }
    
     public Object[][] Fillitems(ResultSet res) {
         int rows = 2;
        Object arr[][] = new Object[rows][3];
        try {
            int i = 0;
            res.beforeFirst();
            while (res.next()) {
                arr[i][0] = res.getInt(1);
                arr[i][1] = res.getString(2);
                i++;
                rows = rows + 2;
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(jdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }
     
        public void UPDATEaddress(int id) {        //   String a=c.;
        try {
            //ps = con.prepareStatement("update booking set name='" + name + "',last_name='" + last_name +"',day='"+day+"',date='"+date+"',beginning='"+beginning+"',duration='"+time+"',finish='"+finish+"',paid='"+paid+"',remain'"+remain+"'where id=" + id);
            ps = con.prepareStatement("update address set flag = 1  where customer_id=" + id + "");
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(jdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


      //-------------------------------------------------------------------------------------------//
    public int create_database(String db_name) throws SQLException {
        int flag = 0;
        try {
            String sql_stmt = "CREATE database  " + db_name + ";";
            ps = con.prepareStatement(sql_stmt);
            ps.executeUpdate(sql_stmt);
        } catch (SQLException ex) {
            flag = 1;
        }
        return flag;
}
      //-------------------------------------------------------------------------------------------//
      public int  createTable_customers(String db_name,String table_name) throws SQLException {
          int flag = 0;
          try {
    String sql_stmt = "CREATE TABLE  "+db_name+".`"+table_name+"` (\n"
            + "    `customer_id` SMALLINT(5) UNSIGNED NOT NULL AUTO_INCREMENT,\n"
            + "    `first_name` VARCHAR(45) NOT NULL,\n"
            + "    `last_name` VARCHAR(45) NOT NULL,\n"
            + "    `email` VARCHAR(50) DEFAULT NULL,\n"
            + "    `active` TINYINT(1) NOT NULL DEFAULT '1',\n"
            + "    PRIMARY KEY (`customer_id`)\n"
            + ");";
    ps = con.prepareStatement(sql_stmt);
     ps.executeUpdate(sql_stmt);
          }catch (SQLException ex) {
              flag = 1;
        }
          return flag;
}
      //-------------------------------------------------------------------------------------------//
           public int createTable_add(String db_name, String table_name) throws SQLException {
        int flag = 0;
        try {
            String sql_stmt = "CREATE TABLE  " + db_name + ".`" + table_name + "` (\n"
                    + "    `customer_id` SMALLINT(5) UNSIGNED NOT NULL AUTO_INCREMENT,\n"
                    + "    `first_name` VARCHAR(45) NOT NULL,\n"
                      + "    PRIMARY KEY (`customer_id`)\n"
                    + ");";
            ps = con.prepareStatement(sql_stmt);
            ps.executeUpdate(sql_stmt);
        } catch (SQLException ex) {
            flag = 1;
        }
        return flag;
    }
                 //-------------------------------------------------------------------------------------------//
           public int createTable_adet(String db_name, String table_name) throws SQLException {
        int flag = 0;
        try {
            String sql_stmt = "CREATE TABLE  " + db_name + ".`" + table_name + "` (\n"
                    + "    `customer_id` SMALLINT(5) UNSIGNED NOT NULL AUTO_INCREMENT,\n"
                      + "    PRIMARY KEY (`customer_id`)\n"
                    + ");";
            ps = con.prepareStatement(sql_stmt);
            ps.executeUpdate(sql_stmt);
        } catch (SQLException ex) {
            flag = 1;
        }
        return flag;
    }
      //-------------------------------------------------------------------------------------------//
      public static void main(String[] args) throws SQLException {
          jdbc b = new jdbc();
          b.create_database("soft");
          Object data [][];
          ResultSet rr;
          rr = b.SELECTall();
          data = b.Fillitems(rr);
          System.out.println(data.length);
          int id = (int) data[0][0];
//            for (int i = 0; i < data.length; i++) {
//                System.out.println("rows" + data[i][0]);
//                System.out.println("cols" + data[i][1]);
//                                        
//               
//            }
            
          
         
     
    }
    
}
