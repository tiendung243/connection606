/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaconnection606;


public class Customer {
    private int cust_id;
    private String address;
    private String city;
    private String customer_type_cd;
    private String fed_id;
    private String postal_code;
    private String state;

    public Customer() {
    }

    public int getCust_id() {
        return cust_id;
    }

    public void setCust_id(int cust_id) {
        this.cust_id = cust_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCustomer_type_cd() {
        return customer_type_cd;
    }

    public void setCustomer_type_cd(String customer_type_cd) {
        this.customer_type_cd = customer_type_cd;
    }

    public String getFed_id() {
        return fed_id;
    }

    public void setFed_id(String fed_id) {
        this.fed_id = fed_id;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return  "cust_id= " + cust_id + " address =  " + address + "city = " + city + " customer_type_cd = " + 
                customer_type_cd + " fed_id = " + fed_id + " postal_code = " + postal_code + "  state=  " + state ;
    }
    
    
    
}
