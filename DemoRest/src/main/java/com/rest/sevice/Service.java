package com.rest.sevice;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rest.dao.Dao;
import com.rest.pojo.Pojo;

@Path("/service")
public class Service {
	ObjectMapper mapper=new ObjectMapper();
	Dao dao=new Dao();
	String SUCCESS="SUCCESS RESULT";
	String FAILURE="FAIL RESULT";
	
	@POST
	@Path("/create")
	@Produces(MediaType.APPLICATION_JSON)
	public Response create(@FormParam("name") String name,@FormParam("lName") String lName) throws JsonProcessingException
	{
		String result=SUCCESS;
		System.out.println(name+"  " +lName);
		boolean flag=dao.create(name,lName);
		if(!flag)
			result=FAILURE;
		String json=mapper.writeValueAsString(result);
		return Response.ok().entity(json).build();
		
	}
	
	@GET
	@Path("/create/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getById(@PathParam("id") int id) throws JsonProcessingException
	{
		System.out.println(id);
		Pojo pojo=new Pojo();
		pojo=dao.getPojo(id);
		String json=mapper.writeValueAsString(pojo);
		return Response.ok().entity(json).build();
	}
	
	@GET
	@Path("/create")
	@Produces(MediaType.APPLICATION_JSON)
	public Response get() throws JsonProcessingException
	{
		List<Pojo> pojos=dao.getPojos();
		String json=mapper.writeValueAsString(pojos);
		return Response.ok().entity(json).build();
	}
	
	@PUT
	@Path("/create")
	@Produces(MediaType.APPLICATION_JSON)
	public Response update(@FormParam("id") int id,@FormParam("name") String name,@FormParam("lName") String lName) throws JsonProcessingException
	{
		String result=SUCCESS;
		System.out.println(id+"  "+name+"  " +lName);
		boolean flag=dao.update(id,name,lName);
		if(!flag)
			result=FAILURE;
		String json=mapper.writeValueAsString(result);
		return Response.ok().entity(json).build();
		
	}
	
	@DELETE
	@Path("/create/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response delete(@PathParam("id") int id) throws JsonProcessingException
	{
		String result=SUCCESS;
		System.out.println(id);
		boolean flag=dao.delete(id);
		if(!flag)
			result=FAILURE;
		String json=mapper.writeValueAsString(result);
		return Response.ok().entity(json).build();
	}
	

}
