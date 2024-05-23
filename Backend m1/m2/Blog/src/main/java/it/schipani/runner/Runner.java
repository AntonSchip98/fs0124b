package it.schipani.runner;

import com.github.javafaker.Faker;
import it.schipani.entities.Post;
import it.schipani.entities.User;
import it.schipani.services.PostService;
import it.schipani.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.stream.IntStream;

@Component
@Slf4j
public class Runner implements CommandLineRunner {

    @Autowired
    PostService posts;

    @Autowired
    UserService users;

    private static final Faker faker = Faker.instance();

    @Override
    public void run(String... args) throws Exception {
        log.info("Populating database...");
        IntStream.range(0, 10) //
                .mapToObj(n -> User.builder() //
                        .withAvatar(faker.avatar().image())//
                        .withBirthDate(
                                LocalDate.ofInstant(faker.date().birthday(16, 60).toInstant(), ZoneId.systemDefault())) //
                        .withEmail(faker.internet().emailAddress()) //
                        .withFirstName(faker.name().firstName()) //
                        .withLastName(faker.name().lastName()) //
                        .build())
                .forEach(users::saveUser);
        var a = users.getAllUsers();
        IntStream.range(0, 100) //
                .mapToObj(n -> Post.builder() //
                        .withUser(a.get(faker.random().nextInt(a.size()))) //
                        .withCategory( //
                               faker.numerify("Category #")//
                        ) //
                        .withContent(faker.lorem().paragraph(faker.random().nextInt(20))) //
                        .withCover(faker.avatar().image()) //
                        .withLectureTime(faker.random().nextInt(30)) //
                        .withTitle(faker.lorem().sentence()) //
                        .build())
                .forEach(posts::savePost);
        log.info("Database populated");
    }
}
