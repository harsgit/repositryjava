package com.cg.donor.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.cg.donor.bean.DonorBean;
import com.cg.donor.exception.DonorException;
import com.cg.donor.util.DbConnection;

public class IDonorDAOImpl implements IDonorDAO {

	@Override
	public String addDonor(DonorBean donor) throws ClassNotFoundException, IOException, SQLException  {
		// TODO Auto-generated method stub
		Connection connection=DbConnection.getConnection();
		return null;
	}

	@Override
	public DonorBean viewDonorDetails(String donorId) throws DonorException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List retriveAll() throws DonorException {
		// TODO Auto-generated method stub
		return null;
	}

}
