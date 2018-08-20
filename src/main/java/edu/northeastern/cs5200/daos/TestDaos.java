package edu.northeastern.cs5200.daos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import edu.northeastern.cs5200.Cs5200ProjectApplication;
import edu.northeastern.cs5200.api.RunAPI;
import edu.northeastern.cs5200.objects.Address;
import edu.northeastern.cs5200.objects.Phone;
import edu.northeastern.cs5200.objects.Portfolio;
import edu.northeastern.cs5200.repositories.UserRepo;


@Component
public class TestDaos implements CommandLineRunner {
	
	@Autowired
	AdminDao adminDao;
	
	@Autowired
	UserRepo userRepo;
	
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
	
	@Autowired
	TradeDao tradeDao;
	
	public static void main(String[] args) throws Exception {
		Cs5200ProjectApplication.main(new String[] {});
	}
	
	@Override
	public void run(String... args) throws Exception {

		addressDao.test();
		phoneDao.test();
//		adminDao.test();
		investorDao.test();
		managerDao.test();
		staffDao.test();
		cashDao.test();
		stockDao.test();
		portfolioDao.test();
		messageDao.test();
		tradeDao.test();
	}
	

}
