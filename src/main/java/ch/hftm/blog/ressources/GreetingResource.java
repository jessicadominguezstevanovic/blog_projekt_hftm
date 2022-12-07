package ch.hftm.blog.ressources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.oracle.svm.core.annotate.Inject;

import io.quarkus.security.Authenticated;
import io.quarkus.security.identity.SecurityIdentity;

@Path("/hello")
@Authenticated
public class GreetingResource {
    
    @Inject
    SecurityIdentity identity;
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from RESTEasy Reactive";
    }

    @GET
    @Path("/admin")
    @Produces(MediaType.TEXT_PLAIN)
    public String admin(){
        return "Admin logged in";
    }

}