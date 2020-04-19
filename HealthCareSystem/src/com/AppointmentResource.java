package com;


import java.util.Arrays;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("apps")
public class AppointmentResource {
	
AppointmentRepo repo = new AppointmentRepo();
	
	
	@GET
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public List<Appointment> getAppointments() {
		
		System.out.println("App called...");
		return repo.getAppointments();
	}
	
	@GET
	@Path("app/{id}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Appointment getAppointment(@PathParam("id") int id)
	{	
		return repo.getAppointment(id);
	}
	
	//create
	@POST
	@Path("app")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Appointment createAppointment(Appointment a1) {
		
		System.out.println(a1);
		repo.create(a1);
		
		return a1;
	}
	
	//update
	@PUT
	@Path("app")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Appointment updateAppointment(Appointment a1) {
		
		System.out.println(a1);
		
		if(repo.getAppointment(a1.getId()).getId()==0)
		{
			repo.create(a1);
		}
		repo.update(a1);
		
		return a1;
	}
	
	//delete
	@DELETE
	@Path("app/{id}")
	public Appointment deleteAppointment(@PathParam("id") int id) {
		
		Appointment a = repo.getAppointment(id);
		if(a.getId()!=0)
			repo.delete(id);
		
		return a;
		
	}
	
}
