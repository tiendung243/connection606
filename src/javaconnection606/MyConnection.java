/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaconnection606;

import com.mysql.cj.api.jdbc.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;



/**
 *
 * @author Admin
 */
public class MyConnection {

    private  Connection conn = null;  // static
    private  Statement statement = null;  // static
    private  ResultSet resultSet = null;// static
     

    // ham test driver 
    protected void driverTest() throws ClassNotFoundException {
        try {
            Class.forName(Config.DRIVER);
        } catch (ClassNotFoundException ex) {
            throw new ClassNotFoundException("khong the ket noi toi database!");
        }
    }

    public Connection getMyConnection() throws ClassNotFoundException, SQLException {
        if (conn == null) {
            // thuc hien ket noi
            driverTest();
            try {
                conn = DriverManager.getConnection(Config.URL, Config.USER, Config.PASSWORD);

            } catch (Exception e) {
          throw new SQLException("Khong the ket noi den DB "+e.getMessage());
            }
        }
        return conn;
    }
    public Statement getStatement() throws SQLException, ClassNotFoundException{
        if(statement == null ? true : statement.isClosed()){
            statement = (Statement) getMyConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            System.out.println(statement.toString());
        }
        return statement;
    }
    
      public ResultSet excuteStatementQuery(String query) throws SQLException{
          try {
              resultSet =getStatement().executeQuery(query);
          } catch (Exception e) {
              throw new SQLException("ERROR: "+e.getMessage() + ". My Query : "+query);
          }
          return resultSet;
      }
      
      public void closeConection() throws SQLException{
          
          /// close resultset
          if(resultSet != null ){
          resultSet.close();
          }
          if(statement != null){
          statement.close();
          }
          if(conn != null)
          conn.close();
      }
      
}
