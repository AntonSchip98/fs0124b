package it.schipani.demo.runners;

import it.schipani.demo.entities.AppConfig;
import it.schipani.demo.entities.menu.Item;
import it.schipani.demo.entities.menu.Menu;
import it.schipani.demo.entities.ordini.Order;
import it.schipani.demo.entities.ordini.Table;
import it.schipani.demo.entities.ordini.TableState;
import it.schipani.demo.services.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class OrderGeneratorRunner implements CommandLineRunner {

    @Autowired
    OrderService service;

    @Override
    public void run(String... args) throws Exception {
        try (var ctx = new AnnotationConfigApplicationContext(AppConfig.class)) {
            List<Item> items = new ArrayList<>();
            items.add((Item) ctx.getBean("hawaiian_pizza"));
            var table1 = new Table(1, 4, TableState.FREE);
            Order order = new Order();
            var order1 = service.printOrder(order);
            log.info("{}", order1);
            /*menu.printMenu();*/
        } catch (BeansException e) {
            e.printStackTrace();
        }

    }
}
