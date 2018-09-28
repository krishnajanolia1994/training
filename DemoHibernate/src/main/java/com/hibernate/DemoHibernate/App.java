package com.hibernate.DemoHibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import com.hibernate.connect.Connect;
import com.hibernate.many.to.many.anno.School;
import com.hibernate.many.to.many.anno.Teacher;
import com.hibernate.one.to.many.anno.Collage;
import com.hibernate.one.to.many.anno.Student;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		//addCollage();
		//addSchool();
		//hql();
		//cql();
		//cqlLt();
		//cqlLike();
		//cqlBetweenOrder();
		//cqlCombineCriteria();
		//cqlThirdElement();
		//projection();
		netiveSql();
		
	}

	private static void netiveSql() {
		Session session=Connect.SF().openSession();
		Query query=session.createSQLQuery("select * from teacher");
		List<Object[]> list=query.list();
		for(Object[] object :list)
		{
			System.out.println(object[1]);
		}
	}

	private static void projection() {
		// TODO Auto-generated method stub
		Session session=Connect.SF().openSession();
		Criteria criteria=session.createCriteria(Teacher.class);
		criteria.setProjection(Projections.sum("id"));
		List sum=criteria.list();
		System.out.println(sum.get(0));
		
		
		
	}

	private static void cqlThirdElement() {
		// TODO Auto-generated method stub
		Session session=Connect.SF().openSession();
		Criteria criteria=session.createCriteria(Teacher.class);
		criteria.add(Restrictions.between("id", 10,25));
		criteria.setMaxResults(1);
		criteria.setFirstResult(2);
		List<Teacher> teachers=criteria.list();
		System.out.println(teachers);
		for(Teacher teacher:teachers)
		{
			System.out.println(teacher.getName()+"  "+teacher.getId());
		}
		
	}

	private static void cqlCombineCriteria() {
		// TODO Auto-generated method stub
		Session session=Connect.SF().openSession();
		Criteria criteria=session.createCriteria(Teacher.class);
		Criterion criterion=Restrictions.gt("id", 10);
		Criterion criterion2=Restrictions.like("name", "%3");
		LogicalExpression expression=Restrictions.and(criterion, criterion2);
		criteria.add(expression);
		List<Teacher> teachers=criteria.list();
		System.out.println(teachers);
		for(Teacher teacher:teachers)
		{
			System.out.println(teacher.getName()+"  "+teacher.getId());
		}
		
	}

	private static void cqlBetweenOrder() {
		// TODO Auto-generated method stub
		Session session=Connect.SF().openSession();
		Criteria criteria=session.createCriteria(Teacher.class);
		criteria.add(Restrictions.between("id", 10,25));
		criteria.addOrder(Order.desc("id"));
		List<Teacher> teachers=criteria.list();
		System.out.println(teachers);
		for(Teacher teacher:teachers)
		{
			System.out.println(teacher.getName()+"  "+teacher.getId());
		}
		
	}

	private static void cqlLike() {
		// TODO Auto-generated method stub
		Session session=Connect.SF().openSession();
		Criteria criteria=session.createCriteria(Teacher.class);
		criteria.add(Restrictions.like("name", "%3"));
		List<Teacher> teachers=criteria.list();
		System.out.println(teachers);
		for(Teacher teacher:teachers)
		{
			System.out.println(teacher.getName()+"  "+teacher.getId());
		}
		
	}

	private static void cqlLt() {
		// TODO Auto-generated method stub
		Session session=Connect.SF().openSession();
		Criteria criteria=session.createCriteria(Teacher.class);
		criteria.add(Restrictions.gt("id", 28));
		List<Teacher> teachers=criteria.list();
		System.out.println(teachers);
		for(Teacher teacher:teachers)
		{
			System.out.println(teacher.getName()+"  "+teacher.getId());
		}
		
	}

	private static void cql() {
		Session session=Connect.SF().openSession();
		Criteria criteria=session.createCriteria(Teacher.class);
		List<Teacher> teachers=criteria.list();
		System.out.println(teachers);
		for(Teacher teacher:teachers)
		{
			System.out.println(teacher.getName());
		}
		
	}

	private static void hql() {
		Session session=Connect.SF().openSession();
		Query query=session.createQuery("from Teacher");
		List<Teacher> teachers=query.list();
		System.out.println(teachers);
		for(Teacher teacher:teachers)
		{
			System.out.println(teacher.getName());
		}
		
		
	}

	private static void addSchool() {
		School school=new School();
		List<Teacher> teachers=school.getTeachers();
		for(int i=0;i<5;i++)
		{
			Teacher teacher=new Teacher();
			teacher.setName("Manish "+i );
			teachers.add(teacher);
		}
		school.setTeachers(teachers);
		Session session=Connect.SF().openSession();
		Transaction transaction=session.beginTransaction();
		session.save(school);
		transaction.commit();
	}

	private static void addCollage() {
		// TODO Auto-generated method stub
		Collage collage = new Collage();
		collage.setName("IIPS");
		for (int i = 0; i < 5; i++) {
			Student student = new Student();
			student.setCollage(collage);
			student.setName("krishna " + i);
			collage.getStudents().add(student);
		}
		Session session = Connect.SF().openSession();
		Transaction transaction = session.beginTransaction();
		session.save(collage);
		transaction.commit();

	}
}
