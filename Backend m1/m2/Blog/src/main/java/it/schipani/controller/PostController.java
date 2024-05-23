package it.schipani.controller;

import it.schipani.entities.Post;

import it.schipani.services.ExceptionHandlingSampleService;
import it.schipani.services.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;



import java.util.Optional;

@RestController
@RequestMapping("/api/posts")
@Slf4j
public class PostController {

    @Autowired
    PostService postService;

    @Autowired
    ExceptionHandlingSampleService exceptionService;

    @PostMapping
    public ResponseEntity<Post> savePost(@RequestBody Post post) {
        var p = postService.savePost(post);
        if (p.isEmpty())
            throw new RuntimeException("Impossibile salvare il post");
        var headers = new HttpHeaders();
        var uri = UriComponentsBuilder
                .fromPath("/api/posts/{id}").buildAndExpand(p.get().getId()).toString();
        headers.add("Location", uri);
        return new ResponseEntity<>(p.get(), headers, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Page<Post>> getAllPosts(Pageable p) {
        return new ResponseEntity<>(postService.getAllPost(p), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable Long id) {
        Optional<Post> postOptional = postService.getPostById(id);
        return postOptional.map(post ->
                new ResponseEntity<>(post, HttpStatus.OK)).orElseGet(() ->
                new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updatePost(@PathVariable Long id, @RequestBody Post updatedPost) {
        postService.updatePost(id, updatedPost);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("exception")
    public ResponseEntity<?> throwException(@RequestParam(defaultValue = "false") boolean activate) {
        exceptionService.testExceptionHandling(activate);
        return ResponseEntity.ok().build();
    }
}
