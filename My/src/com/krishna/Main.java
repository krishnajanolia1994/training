package com.krishna;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.com.one.to.one.anno.MyCountry;
import com.com.one.to.one.anno.MyOwner;
import com.connect.Connect;
import com.one.to.one.xml.Country;
import com.one.to.one.xml.Owner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration con = new Configuration().configure();
		SessionFactory sf = con.buildSessionFactory();
		Pojo pojo = new Pojo();
		// save();
		// saveCitizen();
		// updatePojo();
		// deletePojo();
		///////////////////////// one-to-one xml mapping
		// saveOwner();
		///////////////////////// one-to-one using annotaion mapping
		saveMyOwner();

	}

	private static void saveMyOwner() {
		MyOwner myOwner = new MyOwner();
		myOwner.setName("Nikhil");
		MyCountry myCountry = new MyCountry();
		myCountry.setName("India");
		myCountry.setMyOwner(myOwner);
		;
		myOwner.setMyCountry(myCountry);
		;
		Session session = Connect.SF().openSession();
		Transaction transaction = session.beginTransaction();
		session.save(myOwner);
		transaction.commit();

	}

	private static void saveOwner() {
		// TODO Auto-generated method stub
		Owner owner = new Owner();
		owner.setName("Nikhil");
		Country country = new Country();
		country.setName("India");
		country.setOwner(owner);
		owner.setCountry(country);
		Session session = Connect.SF().openSession();
		Transaction transaction = session.beginTransaction();
		session.save(owner);
		transaction.commit();

	}

	private static void deletePojo() {
		Pojo pojo = new Pojo();
		pojo.setId(15);
		Session session = Connect.SF().openSession();
		Transaction transaction = session.beginTransaction();
		session.delete(pojo);
		transaction.commit();
	}

	private static void updatePojo() {
		// TODO Auto-generated method stub
		Pojo pojo = new Pojo();
		pojo.setId(13);
		pojo.setName("nikhil");
		Session session = Connect.SF().openSession();
		Transaction transaction = session.beginTransaction();
		session.update(pojo);
		transaction.commit();

	}

	private static void saveCitizen() {
		Citizen citizen = new Citizen();
		Address address = new Address();
		address.setDisttrict("indore");
		address.setFather("vikram");
		address.setState("M.P.");
		address.setVillage("khajaraya");
		citizen.setAddress(address);
		citizen.setName("Sandeep");
		SessionFactory sf = Connect.SF();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(citizen);
		transaction.commit();
		session.close();

	}

	private static void save() {
		int i;
		SessionFactory sf = Connect.SF();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		for (i = 0; i < 10; i++) {
			Pojo pojo = new Pojo();
			pojo.setName("krishna");
			session.save(pojo);
		}
		transaction.commit();
		session.close();

	}

}
