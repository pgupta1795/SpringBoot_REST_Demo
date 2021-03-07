package com.rest.alienrestdemo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlienResource {

  @Autowired
  AlienDAO dao;

  @GetMapping("/aliens")
  public List<Alien> getAliens() {
    List<Alien> aliens = (List<Alien>) dao.findAll();
    return aliens;
  }

  @PostMapping("/aliens/create")
  public Alien getAliens(@RequestBody Alien alien) {
    dao.save(alien);
    return alien;
  }

  @DeleteMapping("/aliens/delete")
  public void deleteAlien(@RequestParam int id) {
    Optional<Alien> alien = dao.findById(id);
    System.out.println("********* ALIEN : " + alien.get().getId());
    dao.delete(alien.get());
  }

}
