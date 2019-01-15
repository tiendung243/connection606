/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaconnection606;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class Main {
      public static  MyConnection myConnection = new MyConnection();
      public static  PreparedStatement ps = null;
      


    public static void main(String[] args) throws SQLException, ClassNotFoundException {

//        ArrayList<Customer> list = new ArrayList<>();
//        list = (ArrayList<Customer>) getListCustommer("CUSTOMER");
//        for (Customer customer : list) {
//            System.out.println(customer);
//
//       }
        // getAccount(myConnection);
//        Customer c = null;
//        c = getCustomer( 12);
//        System.out.println(c.toString());

        //    getCustomer(myConnection);
        
       
     //   select(myConnection, "CUSTOMER");\
      //  getBranch(myConnection, "BRANCH", "BRANCH_ID", "1"); 
      
       // System.out.println( getCustomer( "CUSTOMER","STATE").toString());
      //  searchCustomer("372");
       // System.out.println( getCustomer("CUSTOMER", "STATE").toString()
//);
//  getCustomer1("NH");
  /*
  cust id : 5
address : 2341 Main St
city : Salem
cust-type-cd : I
fed id : 555-55-5555
postal code : 03079
State : NH
  */
        updateCustomer("2431 main sd", "salem", "I", "55-555-5555", "0331111", "NK");
     
      
    }

    public static void getBranch(String tableName,String columName,String condition) throws SQLException {
        ResultSet resultSet = select( tableName, condition, columName);
        while (resultSet.next()) {
            System.out.println(resultSet.getInt("BRANCH_ID"));
            System.out.println(resultSet.getString("ADDRESS"));
            System.out.println(resultSet.getString("CITY"));
            System.out.println(resultSet.getString("NAME"));
            System.out.println(resultSet.getString("STATE"));
            System.out.println(resultSet.getString("ZIP_CODE"));

        }
    }

    public static void getEmployee(String tableName) throws SQLException {
        ResultSet resultSet = select( tableName);
        while (resultSet.next()) {
            System.out.println("emp-id: " + resultSet.getInt("EMP_ID"));
            System.out.println("end-date: " + resultSet.getDate("END_DATE"));
            System.out.println("first-name: " + resultSet.getString("FIRST_NAME"));
            System.out.println("last-name: " + resultSet.getString("LAST_NAME"));
            try {
                System.out.println("start-date: " + resultSet.getDate("START_DATE"));
            } catch (Exception e) {
                System.out.println("start date: null");
            }
            System.out.println("title: " + resultSet.getString("TITLE"));
            System.out.println("assigned branch id: " + resultSet.getInt("ASSIGNED_BRANCH_ID"));
            System.out.println("dept-id: " + resultSet.getInt("DEPT_ID"));
            System.out.println("superior-emp-id: " + resultSet.getInt("SUPERIOR_EMP_ID"));
        }

    }

    public static void getAccount(String tableName) throws SQLException {
        ResultSet resultSet = select( tableName);
        while (resultSet.next()) {
            System.out.println("account id : " + resultSet.getInt("ACCOUNT_ID"));
            System.out.println("avail balance : " + resultSet.getFloat("AVAIL_BALANCE"));
            System.out.println("close date : " + resultSet.getDate("CLOSE_DATE"));
            System.out.println("last activity date : " + resultSet.getDate("LAST_ACTIVITY_DATE"));
            System.out.println("open date : " + resultSet.getDate("OPEN_DATE"));
            System.out.println("pending balance: " + resultSet.getFloat("PENDING_BALANCE"));
            System.out.println("status: " + resultSet.getString("STATUS"));
            System.out.println("Customer id : " + resultSet.getInt("CUST_ID"));
            System.out.println("open branch id : " + resultSet.getInt("OPEN_BRANCH_ID"));
            System.out.println("open emp id : " + resultSet.getInt("OPEN_EMP_ID"));
            System.out.println("product cd : " + resultSet.getString("PRODUCT_CD"));

        }

    }

    public static void getCustomer1(String result) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = preparestatement(result);
        while (resultSet.next()) {
            System.out.println("cust id : " + resultSet.getInt("CUST_ID"));
            System.out.println("address : " + resultSet.getString("ADDRESS"));
            System.out.println("city : " + resultSet.getString("CITY"));
            System.out.println("cust-type-cd : " + resultSet.getString("CUST_TYPE_CD"));
            System.out.println("fed id : " + resultSet.getString("FED_ID"));
            System.out.println("postal code : " + resultSet.getString("POSTAL_CODE"));
            System.out.println("State : " + resultSet.getString("STATE"));
        }
    }

    public static Customer getCustomer( String tableName , String columeName) throws SQLException {
       
        ResultSet resultSet =select( tableName, columeName);
        Customer c = null;
        if (resultSet != null) {
            try {
                while (resultSet.next()) {
                    c = new Customer();
                    c.setAddress(resultSet.getString("ADDRESS"));
                    c.setCity(resultSet.getString("CITY"));
                    c.setCust_id(resultSet.getInt("CUST_ID"));
                    c.setCustomer_type_cd(resultSet.getString("CUST_TYPE_CD"));
                    c.setFed_id(resultSet.getString("FED_ID"));
                    c.setPostal_code(resultSet.getString("POSTAL_CODE"));
                    c.setState(resultSet.getString("STATE"));
                }
            } catch (Exception e) {
                System.out.println("error get customer" + e.getMessage());
                e.printStackTrace();
            }

        }
        return c;
    }

    public static Customer getObjectCustomer( int id) throws SQLException {
        String query = "SELECT * FROM CUSTOMER WHERE CUST_ID = " + id;
        ResultSet resultSet = myConnection.excuteStatementQuery(query);
        Customer c = new Customer();
        resultSet.next();
        c.setCust_id(resultSet.getInt("CUST_ID"));
        c.setAddress(resultSet.getString("ADDRESS"));
        c.setCity(resultSet.getString("ADDRESS"));
        c.setCustomer_type_cd(resultSet.getString("CUST_TYPE_CD"));
        c.setFed_id(resultSet.getString("FED_ID"));
        c.setPostal_code(resultSet.getString("POSTAL_CODE"));
        c.setState(resultSet.getString("STATE"));

        return c;
    }

    public static void getIndividual(String tableName) throws SQLException {
        ResultSet resultSet = select( tableName);
        while (resultSet.next()) {
            System.out.println("birth date : " + resultSet.getDate("BIRTH_DATE"));
            System.out.println("first name : " + resultSet.getString("FIRST_NAME"));
            System.out.println("last name : " + resultSet.getString("LAST_NAME"));
            System.out.println("cust id : " + resultSet.getInt("CUST_ID"));

        }
    }

    public static void getOfficer(String tableName) throws SQLException {
        ResultSet resultSet = select( tableName);
        while (resultSet.next()) {
            System.out.println("officer id : " + resultSet.getInt("OFFICER_ID"));
            System.out.println("end date: " + resultSet.getDate("END_DATE"));
            System.out.println("First name : " + resultSet.getString("FIRST_NAME"));
            System.out.println("Last name : " + resultSet.getString("LAST_NAME"));
            System.out.println("start date : " + resultSet.getDate("START_DATE"));
            System.out.println("Titlt : " + resultSet.getString("TITLE"));
            System.out.println("CUST-ID: " + resultSet.getInt("CUST_ID"));
        }
    }

    public static void getBusiness(String tableName) throws SQLException {
        ResultSet resultSet = select( tableName);
        while (resultSet.next()) {
            System.out.println("incorp date : " + resultSet.getDate("INCORP_DATE"));
            System.out.println("name : " + resultSet.getString("NAME"));
            System.out.println("state id : " + resultSet.getString("STATE_ID"));
            System.out.println("CUST ID : " + resultSet.getDate("CUST_ID"));
        }
    }

    public static List<Customer> getListCustommer() throws SQLException {
        
        ResultSet resultset = select( "CUSTOMER");
        List<Customer> listCustomer = new ArrayList<>();
        Customer c = null;
        if (resultset != null) {
            try {
                while (resultset.next()) {
                    c = new Customer();
                    c.setAddress(resultset.getString("ADDRESS"));
                    c.setCity(resultset.getString("CITY"));
                    c.setCust_id(resultset.getInt("CUST_ID"));
                    c.setCustomer_type_cd(resultset.getString("CUST_TYPE_CD"));
                    c.setFed_id(resultset.getString("FED_ID"));
                    c.setPostal_code(resultset.getString("POSTAL_CODE"));
                    c.setState(resultset.getString("STATE"));
                    listCustomer.add(c);
                }
            } catch (Exception e) {
                System.out.println("error get listcustomer " + e.getMessage());
            }
        }

        return listCustomer;
    }

    public static ResultSet select(String tableName) throws SQLException {
        String query = "SELECT *FROM "+tableName;
        return myConnection.excuteStatementQuery(query);
    }
    
    
    public static ResultSet select( String tableName,String nameColume,String condition) throws SQLException{
        String str = "SELECT * FROM " + tableName + " WHERE " + nameColume + " = '" + condition + "'"  ;
        return myConnection.excuteStatementQuery(str);
    }
    
    
    
    public static ResultSet select(String nameTable , String columeName ) throws SQLException{
        String query = "SELECT *  FROM " + nameTable + " GROUP BY " + columeName;
        return myConnection.excuteStatementQuery(query);
    }
  // SEARCH THEO  ADDRESS CUA LOP CUSTOMER
    
    public static void searchCustomer(String address) throws SQLException{
      ArrayList<Customer> list =  (ArrayList<Customer>) getListCustommer();
        for (Customer customer : list) {
            if (customer.getAddress().contains(address)) {
                System.out.println(customer.toString());
                
            }
        }
    }
    public static ResultSet preparestatement(String result) throws ClassNotFoundException, SQLException{
        ResultSet rs = null;
        String sql = "SELECT * FROM CUSTOMER WHERE STATE = ?";
        ps = myConnection.getMyConnection().prepareStatement(sql);
      //  ps.setString(1, "CUST_ID");
       // ps.setString(1,columeName);
        ps.setString(1, result);

        ps.execute();
        //System.out.println(ps.toString());
        rs = ps.executeQuery();
        return rs;
    }
    public static ResultSet preparestatement(String address,String city, int cusID,String custtypeCD,String fed,String postal,String state) throws ClassNotFoundException, SQLException{
        ResultSet rs = null;
        String sql = "SELECT * FROM CUSTOMER WHERE STATE = ?";
        ps = myConnection.getMyConnection().prepareStatement(sql);
        ps.setString(1,address);
        ps.setString(2,city);
        ps.setInt(3,cusID);
        ps.setString(4, custtypeCD);
        ps.setString(5,fed);
        ps.setString(6,postal);
        ps.setString(7,state);
       
      
           


        ps.execute();
        //System.out.println(ps.toString());
        rs = ps.executeQuery();
        return rs;
    }
    
    
    public static void  updateCustomer(String address,String city,String custtypeCD,String fed,String postal,String state) throws ClassNotFoundException, SQLException{
        String sql = "INSERT INTO CUSTOMER(ADDRESS,CITY,CUST_TYPE_CD,FED_ID,POSTAL_CODE,STATE) VALUES(?,?,?,?,?,?)";
        
        PreparedStatement ps = myConnection.getMyConnection().prepareStatement(sql);
        ps.setString(1,address);
        ps.setString(2,city);
        ps.setString(3, custtypeCD);
        ps.setString(4,fed);
        ps.setString(5,postal);
        ps.setString(6,state);
        
         int rs = ps.executeUpdate();
         
      if(rs > 0){
          System.out.println("insert sucsess");
      }
      else{
          System.out.println("fail");
      }
      String query =" SELECT * FROM CUSTOMER WHERE POSTAL_CODE = " + postal ;
      
      ResultSet result = myConnection.excuteStatementQuery(query);
      while(result.next()){
          System.out.println("id = " + result.getInt("CUST_ID"));
      }
      
    }
    

}
