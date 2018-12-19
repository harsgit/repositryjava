package com.cg.hotelMenu.dao;

public interface QueryMapper {
	public static final String insert_Query="Insert into HotelMenu values(?,?)";
	public static final String insertIntoCustomer_Query="Insert into Customer values(custId.nextval,?,?)";
	public static final String update_Query="update  HotelMenu  SET dish_price=? where dish_Name= ?";
	public static final String delete_Query="delete from customer where cust_phno=?";
	public static final String viewDishDetails_Query="select * from HotelMenu where dish_Name=?";
	public static final String retrieveAll_Query="select * from hotelMenu";
	public static final String count_rows="select count(*) AS total from customer";
	public static final String max_id="select max(cust_Id) from customer";
	public static final String viewCustomerDetails_Query="select cust_name from customer where cust_phno=?";
	
}
