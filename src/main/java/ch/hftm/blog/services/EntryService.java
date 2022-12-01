package ch.hftm.blog.services;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import ch.hftm.blog.entities.Entry;

@ApplicationScoped
public class EntryService {


 
    public List<Entry> getEntries(){
        return Entry.listAll();
    }
    public List<Entry> getEntriesWithPaging(int pageSize, int page){
        int defaultPage = 0;
        int defaultPageSize = 10;

        if(page != defaultPage || (pageSize != defaultPageSize && pageSize > 0)){
            return Entry.findAll().page(page, pageSize).list();
        } else{
            return Entry.findAll().page(defaultPage, defaultPageSize).list();
        }
    }

    public void persistEntry(Entry entry){
        entry.persist();
    }

    public Entry getEntryById(long id){
        return Entry.findById(id);
    }

    public List<Entry> searchEntriesByTitle(String searchString){
        return Entry.list("title LIKE ?1",  "%" + searchString + "%");
    }

    public List<Entry> searchEntriesByContent(String searchString){
        return Entry.list("content LIKE ?1",  "%" + searchString + "%");
    }
}
