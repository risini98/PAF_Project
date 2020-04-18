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

@Path("payments")
public class PaymentResource {
	
	
	PaymentRepository repo = new PaymentRepository();
	
	@GET
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public List<Payment> getPayments() {
		
		//System.out.println("getPayment called");
		
		return repo.getPayments();
		
	}
	

	@GET
	@Path("payment/{paymentId}")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Payment getPayment(@PathParam("paymentId")int PaymentId){
		
		return repo.getPayment(PaymentId);
		
	}
	
	
	@POST
	@Path("payment")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Payment createPayment(Payment p1)
	{
		System.out.println(p1);
		repo.create(p1);
		return p1;
		
	}
	
	@PUT
	@Path("payment")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Payment updatePayment(Payment p1)
	{
		System.out.println(p1);
		if(repo.getPayment(p1.getPaymentId()).getPaymentId()==0) {
			repo.create(p1);
		}
		else 
		{
			repo.update(p1);
		}
		
		return p1;
		
	}
	
	@DELETE
	@Path("payment/{PaymentId}")
	public Payment deletePayment(@PathParam("PaymentId") int PaymentId)
	{
		Payment p = repo.getPayment(PaymentId);
		
		if(p.getPaymentId()!=0)
			repo.delete(PaymentId);
	
		
		return p;

	}
	
	
	
	
	

}
