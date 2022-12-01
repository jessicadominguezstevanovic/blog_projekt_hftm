package ch.hftm.blog.services;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import ch.hftm.blog.entities.Entry;

@ApplicationScoped
public class EntryService {
 
    private List<Entry> entries = new ArrayList<>();

    public void addDummyEntries(){
        this.entries.add(new Entry("Title","content"));
    }

    public List<Entry> getEntries(){
        return this.entries;
    }
}
