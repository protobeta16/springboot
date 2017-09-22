package com.dupont.michel.springBoot.demoRESTHateoas;


import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GreetingHateoas extends ResourceSupport {

    private final String content;

    @JsonCreator
    public GreetingHateoas(@JsonProperty("content") String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}