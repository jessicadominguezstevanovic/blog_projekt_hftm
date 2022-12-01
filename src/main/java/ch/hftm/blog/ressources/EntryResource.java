package ch.hftm.blog.ressources;


import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.Status;

import ch.hftm.blog.entities.Entry;
import ch.hftm.blog.services.EntryService;

@Path("/entries")
public class EntryResource {

    @Inject
    EntryService entryService;

    @GET
    public List<Entry> getEntriesWithPaging(@QueryParam("pageSize") int pageSize, @QueryParam("page") int page) { 
        return entryService.getEntriesWithPaging(pageSize, page);
    }

    @GET
    @Path("/searchByTitle")
    public List<Entry> getEntriesWithTitleLike(String searchString) { 
        if(searchString != null && !searchString.isEmpty()){
            return entryService.searchEntriesByTitle(searchString);
        } else{
            return entryService.getEntries();
        }
    }

    @GET
    @Path("/searchByContent")
    public List<Entry> getEntriesWithContentLike(@QueryParam("search") String searchString) { 
        if(searchString != null && !searchString.isEmpty()){
            return entryService.searchEntriesByContent(searchString);
        } else{
            return entryService.getEntries();
        }
    }

    @PATCH
    @Path("{id}")
    @Transactional
    public void patchEntry(Entry entry, long id){
        var reqEntry = entryService.getEntryById(id);

        if(entry.title != null && !"".equals(entry.title)){
            reqEntry.title = entry.title;
        }
        if(entry.content != null && !"".equals(entry.content)){
            reqEntry.content = entry.content;
        }
        if(entry != reqEntry){
            entryService.persistEntry(reqEntry);
        } else{
            //return msg to user and do nothing
        }
    }

    @POST
    @Path("addEntry")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON) //not neccessary, bc its default
    public Response addEntry(Entry entry, @Context UriInfo uriInfo){
        var villain = this.entryService.persistEntry(entry);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder().path(Long.toString(villain.id));
        
        return Response.created(builder.build()).build();
    }

    @GET
    @Path("{id}")
    public Response getEntryById(long id){
        Entry entry = this.entryService.getEntryById(id);
        if(entry == null){
            return Response.status(Status.NOT_FOUND).header("Info", "Whoops! Not Found").entity("No entry with this ID found").build();
        } else{
            return Response.status(Status.OK).entity(entry).build();
        }
    }
    
}
