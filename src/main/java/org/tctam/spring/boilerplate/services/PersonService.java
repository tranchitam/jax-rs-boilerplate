package org.tctam.spring.boilerplate.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tctam.spring.boilerplate.daos.PersonDAO;
import org.tctam.spring.boilerplate.models.Person;

@Component
public class PersonService {

	@Autowired
	private PersonDAO personHibernateDAO;

	public List<Person> getAllPersons() {
		return personHibernateDAO.findAll();
	}

	public Person getPersonById(Long id) {
		return personHibernateDAO.findById(id);
	}
	
	public Person savePerson(Person person){
		personHibernateDAO.save(person);
		return person;
	}
}
