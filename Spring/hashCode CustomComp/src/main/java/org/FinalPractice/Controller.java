package org.FinalPractice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Autowired
    UserRepo userRepo;

    @PostMapping("/")
    public ResponseEntity<String> post(@RequestParam int id, @RequestParam String userName) {
        User user = new User(id, userName);
        if(!userRepo.existsById(id)) {
            return ResponseEntity.status(HttpStatus.CREATED).body("User created");
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body("User already exists");
    }
}
