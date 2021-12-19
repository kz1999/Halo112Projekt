package com.example.halo112_generic.dao;

import com.example.halo112_generic.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query("SELECT r FROM Comment r where r.id = :id")
    Optional<Comment> findCommentById(@Param("id")Long id);

    @Transactional
    @Modifying
    @Query("UPDATE Comment k SET k.owner = :user_id WHERE k.id = :id")
    void editCommentOwner(@Param("user_id") Long user_id, @Param("id") Long id);

    @Transactional
    @Modifying
    @Query("UPDATE Comment k SET k.text = :text WHERE k.id = :id")
    void editCommentText(@Param("text") String text, @Param("id") Long id);

}
