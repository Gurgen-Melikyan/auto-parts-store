package com.example.autopartsstore.repository;

import com.example.autopartsstore.entity.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentsRepository extends JpaRepository<Comments,Integer> {
    List<Comments> findAllByProduct_Id(int id);
}
