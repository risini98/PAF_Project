package com;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("hospitals")
public class HospitalResource 
{

HospitalRepository repo = new HospitalRepository();
	
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Hospital> getHospitals()
	{
		System.out.println("getHospital called..");
		
			
		return repo.getHospitals();
	}
	
	@GET
	@Path("hospital/{id}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Hospital getHospital(@PathParam("id") int id)
	{
		return repo.getHospital(id);
	}
	
	@POST
	@Path("hospital")
	public Hospital createHospital(Hospital hs)
	{
		System.out.println(hs);
		repo.create(hs);
		
		return hs;
	}
	
	@PUT
	@Path("hospital")
	public Hospital updateHospital(Hospital hs)
	{
		System.out.println(hs);
		if(repo.getHospital(hs.getId()).getId()==0)
		{
			repo.create(hs);
		}
		else {
		repo.update(hs);
		}
		return hs;
	}
	
	@DELETE
	@Path("hospital/{id}")
	public Hospital deleteHospital(@PathParam("id") int id)
	{
		Hospital a = repo.getHospital(id);
		
		if(a.getId()!=0) {
			repo.delete(id);
		}
		return a;
	}
	
}
