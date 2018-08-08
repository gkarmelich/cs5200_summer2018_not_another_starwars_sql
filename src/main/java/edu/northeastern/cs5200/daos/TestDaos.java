package edu.northeastern.cs5200.daos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import edu.northeastern.cs5200.Cs5200ProjectApplication;


@Component
public class TestDaos implements CommandLineRunner {
	
	@Autowired
	InvestorDao investorDao;
	
	@Autowired
	ManagerDao managerDao;
	
	@Autowired
	StaffDao staffDao;
	
	@Autowired
	PhoneDao phoneDao;
	
	@Autowired
	AddressDao addressDao;
	
	@Autowired
	CashDao cashDao;
	
	@Autowired
	StockDao stockDao;
	
	@Autowired
	PortfolioDao portfolioDao;
	
	@Autowired
	MessageDao messageDao;
	
	public static void main(String[] args) throws Exception {
		Cs5200ProjectApplication.main(new String[] {});
	}
	
	@Override
	public void run(String... args) throws Exception {

//		addressDao.test();
//		phoneDao.test();
		investorDao.test();
		managerDao.test();
		staffDao.test();
		cashDao.test();
		stockDao.test();
		portfolioDao.test();
		messageDao.test();
		
	}
	

}
