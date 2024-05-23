package it.schipani.services;

import it.schipani.controller.excpetions.ApiValidationException;
import it.schipani.entities.Post;
import it.schipani.entities.User;
import it.schipani.repositories.PostRepository;
import it.schipani.repositories.UserRepository;
import it.schipani.services.dto.PostDto;
import it.schipani.utils.EntitiesUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Slf4j
public class ApplicationServiceImpl implements PostService, UserService {

    @Autowired
    private UserRepository users;

    @Autowired
    private PostRepository posts;

    @Autowired
    private EntitiesUtils utils;


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
    public Page<Post> getAllPost(Pageable p) {
        return posts.findAll(p);
    }

    @Override
    public Optional<Post> getPostById(Long id) {
        return posts.findById(id);
    }

    @Override
    public Post updatePost(Long id, Post p) {
       /* Optional<Post> post = posts.findById(id);
        if (post.isPresent()) {
            Post postToUpdate = post.get().builder()
                    .withCategory(p.getCategory())
                    .withTitle(p.getTitle())
                    .withCover(p.getCover())
                    .withContent(p.getContent())
                    .withLectureTime(p.getLectureTime())
                    .build();
            try {
                posts.save(postToUpdate);
            } catch (Exception e) {
                log.error("{}", e);
            }
        } else {
            log.error("Post with id {} not found", id);
        }*/
        try {
            var post = posts.findById(id).orElseThrow();
            utils.copy(p, post);
            return p;
        } catch (NoSuchElementException e) {
            log.error(String.format("Cannot find post with id = %s", id), e);
            throw new RuntimeException("Cannot find post...");
        } catch (Exception e) {
            log.error(String.format("Error deleting post with id = %s", id), e);
            throw new RuntimeException();
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
    public Optional<User> updateUser(Long id, User u) {
        Optional<User> user = users.findById(id);
        if (user.isPresent()) {
            User userToUpdate = user.get();

            if (u.getFirstName() != null) {
                userToUpdate.setFirstName(u.getFirstName());
            }
            if (u.getLastName() != null) {
                userToUpdate.setLastName(u.getLastName());
            }
            if (u.getEmail() != null) {
                userToUpdate.setEmail(u.getEmail());
            }
            if (u.getAvatar() != null) {
                userToUpdate.setAvatar(u.getAvatar());
            }
            if (u.getBirthDate() != null) {
                userToUpdate.setBirthDate(u.getBirthDate());
            }
            try {
                users.save(userToUpdate);
                return Optional.of(userToUpdate);
            } catch (Exception e) {
                log.error("{}", e);
                return Optional.empty();

            }
        } else {
            log.error("User with id {} not found", id);
            return Optional.empty();
        }
    }


    @Override
    public Optional<User> deleteUser(Long id) {
        Optional<User> userOptional = users.findById(id);
        if (userOptional.isPresent()) {
            try {
                users.deleteById(id);
                return userOptional;
            } catch (Exception e) {
                log.error("Error deleting user with id {}: {}", id, e);
                return Optional.empty();
            }
        } else {
            log.error("User with id {} not found", id);
            return Optional.empty();
        }
    }

  /*  @Override
    public void testExceptionHandling(boolean activate) {
        if (activate)
            throw new MyProjectException("Ops... si è verificato un problema");
    }*/

}
