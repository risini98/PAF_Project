package com;


import java.util.Arrays;
import java.util.List;

//import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("patients")
public class PatientResource 
{
	
	PatientRepository repo = new PatientRepository();
	
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})	public List<Patient> getPatients()
	{
		System.out.println("getPatient called...");
		return repo.getPatients();
	}
	
	@GET
	@Path("patient/{id}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Patient getPatient2(@javax.ws.rs.PathParam("id") int id)
	{
		return repo.getPatient(id);
	}
	
	@POST
	@Path("patient")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Patient createPatient(Patient p1)
	{
		System.out.println(p1);
		repo.create(p1);
		
		return p1;
	}
	
	@PUT
	@Path("patient")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Patient updatePatient(Patient p1)
	{
		System.out.println(p1);
		if(repo.getPatient(p1.getId()).getId()==0)
		{
			repo.create(p1);
		}
		else
		{
			repo.update(p1);
		}
		return p1;
	}
	
	@DELETE
	@Path("patient/{id}")
	public Patient deletePatient(@javax.ws.rs.PathParam("id") int id) {
		Patient p = repo.getPatient(id);
		if(p.getId()!=0) {
			repo.delete(id);
		}
		return p;
	}
	
	
}
