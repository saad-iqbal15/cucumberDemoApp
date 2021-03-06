package org.demo.cucumber.config;

import org.demo.cucumber.entity.Post;
import org.demo.cucumber.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Profile("test")
public class InitTestData implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    private PostService service;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        service.deleteAll();
        service.save(new Post("1", "Title 1", "Content 1"));
        service.save(new Post("2", "Title 2", "Content 2"));
        service.save(new Post("3", "Title 3", "Content 3"));
        service.save(new Post("4", "Title 4", "Content 4"));

        System.out.println("4 posts saved");
    }
}
