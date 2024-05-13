package it.schipani.demo;

import it.schipani.demo.entities.AppConfig;
import it.schipani.demo.entities.Menu;
import it.schipani.demo.entities.Topping;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
@Slf4j
public class DemoApplication {

    public static void main(String[] args) {
        try (var ctx = new AnnotationConfigApplicationContext(AppConfig.class)) {
            Menu menu = (Menu) ctx.getBean("menu");
            menu.printMenu();
        } catch (BeansException e) {
            e.printStackTrace();
        }
    }

}
