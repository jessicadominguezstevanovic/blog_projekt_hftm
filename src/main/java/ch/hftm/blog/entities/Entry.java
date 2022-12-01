package ch.hftm.blog.entities;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Entry extends PanacheEntity{
    
    public String title;

    public String content;

    public Entry(){}

    public Entry(String title, String content){
        this.title = title;
        this.content = content;
    }
    
}
