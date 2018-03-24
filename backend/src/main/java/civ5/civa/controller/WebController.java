package civ5.civa.controller;


import civ5.civa.model.User;
import civ5.civa.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/user")
public class WebController{
    @Autowired
    UserRepository userRepository;

//TODO add field token_expires, check it and  rewrite user in db
    @GetMapping(value = "/save", params = {"username", "id", "token"})
    public void saveUser(@RequestParam("username") String username, @RequestParam("id") String id, @RequestParam("token") String token){
        if(userRepository.findByFacebook(id) == null)
            userRepository.save(new User(username, id, token));
    }

    @GetMapping("/hat")
    public String hat(){
        return "Once man bought a hat and it was if a day";
    }

    @GetMapping("/getall")
    public List<User> getAll(){
        System.out.println("\n\nGET USERS\n\n");
        return userRepository.findAll();
    }

    @DeleteMapping("/logout/{id}")
    public void deleteUser(@PathVariable String id){
        userRepository.delete(userRepository.findByFacebook(id));
    }





}

