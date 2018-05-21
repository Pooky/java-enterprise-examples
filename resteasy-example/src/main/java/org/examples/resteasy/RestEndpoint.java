package org.examples.resteasy;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/test")
public class RestEndpoint
{
    @GET
    @Path("/hello")
    public String test()
    {
        return "Hello REST";
    }
    
    
	@GET
	@Path("/{param}")
	public Response printMessage(@PathParam("param") String msg) {

		String result = "Restful example : " + msg;

		return Response.status(200).entity(result).build();

	}
	
    @GET
    @Produces("text/json")
    @Path("/helloWorld")
    public Response helloWorld() {
		return Response.status(200).entity("Hello world").build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON) 
    @Path("/testPost")
    public Response testPost(MyObject object) {
    	return Response.status(200).entity(object.getName()).build();
    	
    }
    
    public static class MyObject {
    	
    	public MyObject(){
    		
    	}
    	
        public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		private String name;
        private String description;
    	
    }

}