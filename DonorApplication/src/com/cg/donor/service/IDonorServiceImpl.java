package com.cg.donor.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cg.donor.bean.DonorBean;
import com.cg.donor.dao.IDonorDAO;
import com.cg.donor.dao.IDonorDAOImpl;
import com.cg.donor.exception.DonorException;

public class IDonorServiceImpl implements IDonorService {
	IDonorDAO donordao=new IDonorDAOImpl();
	@Override
	public String addDonor(DonorBean donor) throws DonorException, ClassNotFoundException, IOException, SQLException {
		// TODO Auto-generated method stub
		String donorSeq;
		donorSeq=donordao.addDonor(donor);
		return donorSeq;
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
	public void validateDonor(DonorBean bean)throws DonorException
	{
		List<String> validationErrors=new ArrayList<String>();
		if(!(isValidName(bean.getDonorName())))
		{
			validationErrors.add("\ndonar name should be in alphabetsand minimum 3 characters long");
		}
		if(!(isValidPhoneNumber(bean.getPhoneNumber())))
		{
			validationErrors.add("\ndonor phone number should be in numbers");
		}
		if(!(isValidAmount(bean.getDonationAmount())))
		{
			validationErrors.add("\n donation amount");
		}
	
		
	}

	private boolean isValidAmount(double donationAmount) {
		// TODO Auto-generated method stub
		return donationAmount>0;
	}

	private boolean isValidPhoneNumber(String phoneNumber) {
		// TODO Auto-generated method stub
		Pattern phonePattern=Pattern.compile("^[6-9]{1}[0-9]{9}$");
		Matcher phoneMatcher=phonePattern.matcher(phoneNumber);
		return phoneMatcher.matches();
	}

	private boolean isValidName(String donorName) {
		Pattern namePattern=Pattern.compile("^[A-Z][a-z]");
		Matcher nameMatcher=namePattern.matcher(donorName);
		return nameMatcher.matches();
	}
	

}
