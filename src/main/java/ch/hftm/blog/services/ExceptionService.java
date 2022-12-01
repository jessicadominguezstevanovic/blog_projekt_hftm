package ch.hftm.blog.services;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@ApplicationScoped
public class ExceptionService extends WebApplicationException {

    public ExceptionService() {
    }

    public void notFoundException(String responseName, String responseHeaderValue, String responseBody){

        throw new WebApplicationException(Response.status(Status.NOT_FOUND)
            .header(responseName, responseHeaderValue)
            .entity(responseBody).build()); 
    }

    public void entityFoundOk(Object o){
        Response.status(Status.OK).entity(o).build();
    }
    
}
