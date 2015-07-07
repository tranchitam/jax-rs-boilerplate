package org.tctam.spring.boilerplate.daos.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tctam.spring.boilerplate.daos.PersonDAO;
import org.tctam.spring.boilerplate.models.Person;

@Component
public class PersonHibernateDAO extends HibernateDAO<Person, Long> implements PersonDAO {

	@Autowired
	public PersonHibernateDAO(SessionFactory sessionFactory) {
		super(sessionFactory);
	}
}
