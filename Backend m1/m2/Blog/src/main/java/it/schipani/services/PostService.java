package it.schipani.services;

import it.schipani.entities.Post;
import it.schipani.entities.User;

import java.util.List;
import java.util.Optional;

public interface PostService {
    /*Post*/
    Optional<Post> savePost(Post p);

    List<Post> getAllPost();

    Optional<Post> getPostById(Long id);

    void updatePost(Long id, Post p);

    void deletePost(Long id);
}
