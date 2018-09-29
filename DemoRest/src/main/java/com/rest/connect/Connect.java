package com.rest.connect;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.rest.pojo.Pojo;

public class Connect {
	private Connect() {
	}

	public static SessionFactory SF() {
		Configuration configuration = new Configuration().configure().addAnnotatedClass(Pojo.class);
		return configuration.buildSessionFactory();
	}
}
