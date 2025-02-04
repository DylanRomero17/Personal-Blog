package com.dylan.service;

import com.dylan.entity.CommentEntity;
import com.dylan.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService{
    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Optional<CommentEntity> getCommentById(Long id) {
        return commentRepository.findById(id);
    }

    @Override
    public void createComment(CommentEntity comment) {
        commentRepository.save(comment);
    }

    @Override
    public void deleteComment(Long id, CommentEntity comment) {
        CommentEntity commentDB = getCommentById(id).orElseThrow(() -> new InvalidParameterException("Invalid comment Id"));
        commentDB.setContent(comment.getContent());
        commentRepository.save(commentDB);
    }

    @Override
    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }
}
