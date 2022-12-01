package ch.hftm.blog.services;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import ch.hftm.blog.entities.Entry;

@ApplicationScoped
public class EntryService {
 
    public List<Entry> getEntries(){
        return Entry.listAll();
    }

    public void persistEntry(Entry entry){
        entry.persist();
    }

    public Entry getEntryById(long id){
        return Entry.findById(id);
    }
}
