package ch.hftm.blog.ressources;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ch.hftm.blog.services.DataInitializationService;
import io.quarkus.runtime.Startup;

@Startup
@Path("/blog")
public class BlogResource {

    @Inject
    DataInitializationService dataInitializationService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Willkommen im Blog!";
    }

}
