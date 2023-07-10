package com.example.autopartsstore.service;

import com.example.autopartsstore.entity.Comments;
import com.example.autopartsstore.entity.User;

import java.util.List;

public interface CommentService {
    List<Comments> findAllByProduct_Id(int product_id);
    Comments save(User currentUser, Comments comments);

    Comments findById(int id);
    void deleteById(int id);
}
