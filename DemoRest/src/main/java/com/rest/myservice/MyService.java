package com.rest.myservice;

import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rest.dao.Dao;
import com.rest.many.School;
import com.rest.many.Teacher;
@Path("/my")
public class MyService {
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
	@Path("schools")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSchools() throws JsonProcessingException
	{
		
		List<Teacher> teachers=null;
		teachers=(List<Teacher>) dao.getTeacher();
		String json=mapper.writeValueAsString(teachers);
		return Response.ok().entity(json).build();
		
	}

}
