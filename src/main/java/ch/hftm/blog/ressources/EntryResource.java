package ch.hftm.blog.ressources;


import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import ch.hftm.blog.entities.Entry;
import ch.hftm.blog.services.EntryService;

@Path("/entries")
public class EntryResource {

    /**
     * @return 
     */
    @GET
    @Inject
    public List<Entry> getEntries(EntryService entryService) { 
        entryService.addDummyEntries();
        return entryService.getEntries();
    }

    @GET
    @Path("/add")
    @Transactional
    public void addEntry(){
        var entry = new Entry("Title 2","content2");
        entry.persist();
    }
    
}
