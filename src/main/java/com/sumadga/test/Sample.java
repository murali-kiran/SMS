package com.sumadga.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sumadga.sms.dao.AddressDao;
import com.sumadga.sms.dto.Address;

public class Sample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ClassPathXmlApplicationContext  applicationContext=new ClassPathXmlApplicationContext("/test-applicationcontext.xml");

		AddressDao addressDao=(AddressDao)applicationContext.getBean("addressDao");
		Address address=new Address();
		
		address.setAddress1("1");
		address.setAddress2("2");
		address.setAddress3("3");
		address.setDistrict("hyd");
		address.setState("ap");
		address.setPincode("500006");
		
		addressDao.save(address);
	}

}
