package ch.hftm.blog.ressources;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.reactive.NoCache;

import ch.hftm.blog.entities.User;
import ch.hftm.blog.services.DataInitializationService;
import io.quarkus.runtime.Startup;
import io.quarkus.security.identity.SecurityIdentity;

@Startup
@Path("/blog")
public class BlogResource {

    @Inject
    DataInitializationService dataInitializationService;

    @Inject
    SecurityIdentity identity;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Willkommen im Blog!";
    }


    @GET
    @Path("/login-norole")
    @NoCache
    public User loginNoRole(){
        return new User(identity);
    }



}
