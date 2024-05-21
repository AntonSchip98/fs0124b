package it.schipani.services;

import it.schipani.entities.Post;
import it.schipani.entities.User;
import it.schipani.repositories.PostRepository;
import it.schipani.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ApplicationServiceImpl implements PostService, UserService {

    @Autowired
    private UserRepository users;

    @Autowired
    private PostRepository posts;

    ///////////////////////////////////////////////////////////////////
    /*USERS*/
    @Override
    public Optional<Post> savePost(Post p) {

        try {
            return Optional.of(posts.save(p));
        } catch (Exception e) {
            log.error("Error saving post", e);
            return Optional.empty();
        }
    }

    @Override
    public List<Post> getAllPost() {
        return posts.findAll();
    }

    @Override
    public Optional<Post> getPostById(Long id) {
        return posts.findById(id);
    }

    @Override
    public void updatePost(Long id, Post p) {
        Optional<Post> post = posts.findById(id);
        if (post.isPresent()){
            Post postToUpdate = post.get().builder()
                    .withCategory(p.getCategory())
                    .withTitle(p.getTitle())
                    .withCover(p.getCover())
                    .withContent(p.getContent())
                    .withLectureTime(p.getLectureTime())
                    .build();
            try{
                posts.save(postToUpdate);
            }catch (Exception e){
                log.error("{}", e);
            }
        }else {
            log.error("Post with id {} not found", id);
        }
    }

    @Override
    public void deletePost(Long id) {
        posts.deleteById(id);
    }

    ///////////////////////////////////////////////////////////
    /*POSTS*/
    @Override
    public Optional<User> saveUser(User u) {
        try {
            return Optional.of(users.save(u));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public List<User> getAllUsers() {
        return users.findAll();
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return users.findById(id);
    }

    @Override
    public void updateUser(Long id, User u) {
        Optional<User> user = users.findById(id);
        if (user.isPresent()){
            User userToUpdate = user.get().builder()
                    .withFirstName(u.getFirstName())
                    .withLastName(u.getLastName())
                    .withEmail(u.getEmail())
                    .withAvatar(u.getAvatar())
                    .withBirthDate(u.getBirthDate())
                    .build();
            try{
                users.save(userToUpdate);
            }catch (Exception e){
                log.error("{}", e);
            }
        }else {
            log.error("User with id {} not found", id);
        }
    }

    @Override
    public void deleteUser(Long id) {
        users.deleteById(id);
    }
}
