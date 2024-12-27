package com.dylan.service;

import com.dylan.entity.CommentEntity;

import java.util.Optional;

public interface CommentService {
    Optional<CommentEntity> getCommentById(Long id);

    void createComment(CommentEntity comment);

    void deleteComment(Long id, CommentEntity comment);

    void deleteComment(Long id);
}
