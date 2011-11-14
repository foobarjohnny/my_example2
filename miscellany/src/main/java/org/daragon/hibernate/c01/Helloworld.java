package org.daragon.hibernate.c01;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class Helloworld {
	public static void main(String[] args) {

		Teacher t = new Teacher();
		t.setName("david john");
		t.setTitle("Teacher");
		t.setZhicheng(ZhiCheng.A);
		Configuration conf = new AnnotationConfiguration();
		SessionFactory sf = conf.configure().buildSessionFactory();

		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.save(t);
		tx.commit();
		session.close();

	}
}
