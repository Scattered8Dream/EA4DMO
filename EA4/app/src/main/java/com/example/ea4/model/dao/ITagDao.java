package com.example.ea4.model.dao;

import com.example.ea4.model.entities.Tag;

import java.util.List;

public interface ITagDao {

    void create(Tag tag);
    boolean delete(Tag tag);
    Tag find(String tagName);
    List<Tag> findAll();
}
