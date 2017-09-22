package com.dupont.michel.springBoot.demoRESTHateoas;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@RestController
public class GreetingHateoasController {


        private static final String TEMPLATE = "Hello, %s!";

        @RequestMapping("/greetingHateoas")
        public HttpEntity<GreetingHateoas> greeting(
                @RequestParam(value = "name", required = false, defaultValue = "World") String name) {

            GreetingHateoas greeting = new GreetingHateoas(String.format(TEMPLATE, name));
            greeting.add(linkTo(methodOn(GreetingHateoasController.class).greeting(name)).withSelfRel());

            return new ResponseEntity<GreetingHateoas>(greeting, HttpStatus.OK);
        }
    }

