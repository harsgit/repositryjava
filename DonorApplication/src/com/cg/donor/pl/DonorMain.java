package com.cg.donor.pl;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.cg.donor.bean.DonorBean;
import com.cg.donor.exception.DonorException;
import com.cg.donor.service.IDonorService;
import com.cg.donor.service.IDonorServiceImpl;

public class DonorMain {
	static Scanner sc = new Scanner(System.in);
	static IDonorService donorService = null;
	static IDonorServiceImpl donorserviceImpl = null;

	public static void main(String[] args) {
		DonorBean donorbean = null;
		String donorId = null;
		int option = 0;
		while (true) {
			System.out.println();
			System.out.println();
			System.out.println("capg trust");
			System.out.println("====================");
			System.out.println("1.Add donator");
			System.out.println("2.veiw donator");
			System.out.println("3.Retrive all");
			System.out.println("4.exit");
			System.out.println("---------------------");
			System.out.println("select an option");
			try {
				option = sc.nextInt();
				switch (option) {
				case 1:
					while (donorbean == null) {
						donorbean = populateDonorBean();
					}
					try
					{
						donorService=new IDonorServiceImpl();
						donorId=donorService.addDonor(donorbean);
					}
					catch(DonorException donorException)
					{
						System.err.println("ERROR: "+donorException.getMessage());
					}
					finally
					{
						donorId=null;
						donorService=null;
						donorbean=null;
					}
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;

				default:
					break;

				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}

	}

	private static DonorBean populateDonorBean() {
		// TODO Auto-generated method stub
		DonorBean donorBean = new DonorBean();
		System.out.println("Enter the details");
		System.out.println("enter donor name");
		donorBean.setDonorName(sc.next());
		System.out.println("enter donor contact");
		donorBean.setPhoneNumber(sc.next());
		System.out.println("Enter donor address");
		donorBean. setAddress(sc.next());
		System.out.println("Enter donation amount");
		try {
			donorBean.setDonationAmount(sc.nextFloat());
		} catch (InputMismatchException ime) {
			sc.nextLine();
			System.err.println("please enter a numeric value");
		}
		donorserviceImpl=new IDonorServiceImpl();
		try
		{
			donorserviceImpl.validateDonor(donorBean);
			return donorBean;
		}
		catch(DonorException donorException)
		{
			System.err.println("Invalid data:");
			System.err.println(donorException.getMessage()+"\n Try again..");
			System.exit(0);
		}
		return null;
	}

}
