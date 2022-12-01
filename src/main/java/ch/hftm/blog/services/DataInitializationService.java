package ch.hftm.blog.services;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.transaction.Transactional;

import ch.hftm.blog.entities.Entry;
import io.quarkus.runtime.StartupEvent;

@ApplicationScoped
public class DataInitializationService {
    
    @Inject
    EntryService entryService;

    @Transactional
    void init(@Observes StartupEvent event){
        List<Entry> entries = entryService.getEntries();
        if(entries.isEmpty()){
                for(int i = 0; i <= 40; i++){
                    entryService.persistEntry(new Entry("Title " + i,"Content " + i));
                }
        }           
    }
}
