package org.tctam.spring.boilerplate.rests;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tctam.spring.boilerplate.models.Person;
import org.tctam.spring.boilerplate.services.PersonService;

@Component
@Path("/person")
public class PersonResource {
	@Autowired
	private PersonService personService;

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Person> getAllPersons() {
		return personService.getAllPersons();
	}

	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({ MediaType.APPLICATION_JSON })
	public Person savePerson(Person person) {
		return personService.savePerson(person);
	}
}
