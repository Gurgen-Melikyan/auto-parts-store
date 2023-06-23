package com.example.autopartsstore.repository;

import com.example.autopartsstore.entity.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentsRepository extends JpaRepository<Comments,Integer> {
}
