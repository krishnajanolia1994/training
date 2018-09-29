package com.rest.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rest.connect.Connect;
import com.rest.many.School;
import com.rest.many.Teacher;
import com.rest.pojo.Pojo;

public class Dao {

	public boolean create(String name, String lName) {
		boolean flag = true;
		try {
			Pojo pojo = new Pojo();
			pojo.setName(name);
			pojo.setLastName(lName);
			Session session = Connect.SF().openSession();
			Transaction transaction = session.beginTransaction();
			session.save(pojo);
			transaction.commit();
			session.close();
		} catch (Exception e) {

			flag = false;
		}
		return flag;
	}

	public Pojo getPojo(int id) {
		// TODO Auto-generated method stub
		Pojo pojo = null;
		try {
			Session session = Connect.SF().openSession();
			pojo = session.get(Pojo.class, id);
			System.out.println(pojo);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return pojo;
	}

	public List<Pojo> getPojos() {
		List<Pojo> pojos = null;
		try {
			Session session = Connect.SF().openSession();
			Criteria criteria = session.createCriteria(Pojo.class);
			pojos = criteria.list();

		} catch (Exception e) {
			// TODO: handle exception
		}
		return pojos;
	}

	public boolean update(int id, String name, String lName) {
		boolean flag = false;
		try {
			Pojo pojo = new Pojo();
			pojo.setId(id);
			pojo.setLastName(lName);
			pojo.setName(name);
			Session session = Connect.SF().openSession();
			Transaction transaction = session.beginTransaction();
			session.update(pojo);
			transaction.commit();
			flag = true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return flag;
	}

	public boolean delete(int id) {
		boolean flag = false;
		try {
			Session session = Connect.SF().openSession();
			Transaction transaction = session.beginTransaction();
			Pojo pojo = session.get(Pojo.class, id);
			session.delete(pojo);
			transaction.commit();
			flag = true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return flag;
	}

	public List<Teacher> getTeacher() {
		List<Teacher> teachers = null;
		try {
			Session session = Connect.SF().openSession();
			Criteria criteria = session.createCriteria(Teacher.class);
			teachers = criteria.list();
			System.out.println(teachers);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return teachers;
	}

}
