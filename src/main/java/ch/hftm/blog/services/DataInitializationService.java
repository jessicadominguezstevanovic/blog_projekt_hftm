package ch.hftm.blog.services;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.transaction.Transactional;

import ch.hftm.blog.entities.Entry;
import io.quarkus.runtime.StartupEvent;

@ApplicationScoped
public class DataInitializationService {
    
    @Transactional
    void init(@Observes StartupEvent event){
        // if(Entry.count() < 1){
            //for(int i = 0; i <= 10; i++){
                // var entry = new Entry("Title " + i,"Content " + i);
                var entry = new Entry("Title Init Test","Content ");
                entry.persist();
            //}
            
        // }
    }
}
