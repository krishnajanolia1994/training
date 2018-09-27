package com.connect;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.com.one.to.one.anno.MyCountry;
import com.com.one.to.one.anno.MyOwner;
import com.krishna.Citizen;
import com.krishna.Pojo;

public class Connect {
	private Connect() {};

	public static SessionFactory SF() {
		Configuration con = new Configuration().configure().addAnnotatedClass(Pojo.class)
				.addAnnotatedClass(Citizen.class).addAnnotatedClass(MyCountry.class)
				.addAnnotatedClass(MyOwner.class);
		return con.buildSessionFactory();
	}
}
