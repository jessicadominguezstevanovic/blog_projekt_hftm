package ch.hftm.blog.entities;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import ch.hftm.blog.dto.NewEntryDto;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;


@Entity
public class Entry extends PanacheEntityBase{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonbTransient
    public Long id;
    
    public String title;
    @NotBlank
    public String content;


    public Entry(NewEntryDto entryDto){
        this(entryDto.getTitle(), entryDto.getContent());
    }

    public Entry(){}

    public Entry(String title, String content){
        this.title = title;
        this.content = content;
    }
    
}
