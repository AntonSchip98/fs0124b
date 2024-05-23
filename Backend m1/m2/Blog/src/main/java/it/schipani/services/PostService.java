package it.schipani.services;

import it.schipani.entities.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface PostService {
    /*Post*/
    Optional<Post> savePost(Post p);

    Page<Post> getAllPost(Pageable p);

    Optional<Post> getPostById(Long id);

    Post updatePost(Long id, Post p);

    void deletePost(Long id);
}
