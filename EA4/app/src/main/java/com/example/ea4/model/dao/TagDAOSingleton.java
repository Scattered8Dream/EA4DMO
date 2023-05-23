package com.example.ea4.model.dao;

import com.example.ea4.model.entities.Tag;

import java.util.ArrayList;
import java.util.List;

public class TagDAOSingleton implements  ITagDao{

    private static TagDAOSingleton instance;
    private  List<Tag> dataset;

    private TagDAOSingleton(){
        dataset = new ArrayList<>();
    }

    public static TagDAOSingleton getInstance(){
        if(instance == null) {
            instance = new TagDAOSingleton();
        }
        return instance;
    }

    @Override
    public void create(Tag tag) {
        if (tag != null){
            if(find(tag.getTagName()) == null){
                dataset.add(tag);
            }
        }
    }

    @Override
    public boolean delete(Tag tag) {
        return dataset.remove(tag);
    }

    @Override
    public Tag find(String tagName) {
        return dataset.stream().filter(tag -> tag.getTagName().equals(tagName))
                .findFirst().orElse(null);
    }

    @Override
    public List<Tag> findAll() {
        return dataset;
    }
}
