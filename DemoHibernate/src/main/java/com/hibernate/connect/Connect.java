package com.hibernate.connect;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.many.to.many.anno.School;
import com.hibernate.many.to.many.anno.Teacher;
import com.hibernate.one.to.many.anno.Collage;
import com.hibernate.one.to.many.anno.Student;

public class Connect {
	private Connect() {}
	
	public static SessionFactory SF()
	{
		Configuration configuration=new Configuration().configure().
				addAnnotatedClass(Collage.class).addAnnotatedClass(Student.class)
				.addAnnotatedClass(School.class).addAnnotatedClass(Teacher.class);
		return configuration.buildSessionFactory();
	}

}
