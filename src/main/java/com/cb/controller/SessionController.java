package com.cb.controller;

import com.cb.model.Session;
import com.cb.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/session")
public class SessionController {

  @Autowired
  private SessionRepository sessionRepository;

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public Mono<Session> getSession(String session){
    return sessionRepository.findBySession(session);
  }
}
