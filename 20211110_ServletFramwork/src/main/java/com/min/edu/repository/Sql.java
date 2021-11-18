package com.min.edu.repository;

public class Sql {

	protected static final String CUSTOMER_SELECT_ALL_SQL
		= "select * from customer";
	protected static final String CUSTOMER_SELECT_BY_CUSTOMERID_SQL
		= "select * from customer where customerid = ?";
	protected static final String CUSTOMER_SELECT_BY_NAME_SQL
		= "select * from customer where name like ?";
	protected static final String CUSTOMER_INSERT_SQL
		= "insert into customer values (seqCustomer.nextval, ?, ?, ?, ?, ?, ?, ?, ?)";
	protected static final String CUSTOMER_UPDATE_SQL
		= "update customer set name = ?, password = ?, postcode = ?, address = ?, address2 = ?, phone = ?, email =?  where customerid = ?";
	protected static final String CUSTOMER_DELETE_SQL
		= "delete from customer where customerid = ?";
}
