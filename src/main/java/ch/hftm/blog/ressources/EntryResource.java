package ch.hftm.blog.ressources;


import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import ch.hftm.blog.entities.Entry;
import ch.hftm.blog.services.EntryService;

@Path("/entries")
public class EntryResource {

    @Inject
    EntryService entryService;

    @GET
    public List<Entry> getEntries() { 
        return entryService.getEntries();
    }

    @POST
    @Path("addEntry")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON) //not neccessary, bc its default
    public void addEntry(Entry entry){
        this.entryService.persistEntry(entry);
    }

    @GET
    @Path("{id}")
    public Entry getEntryById(long id){
        return this.entryService.getEntryById(id);
    }
    
}
