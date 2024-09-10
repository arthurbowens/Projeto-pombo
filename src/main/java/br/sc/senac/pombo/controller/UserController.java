package br.sc.senac.pombo.controller;

import br.sc.senac.pombo.exception.PomboException;
import br.sc.senac.pombo.model.entity.User;
import br.sc.senac.pombo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User create(@Valid @RequestBody User user) throws PomboException {
        return ResponseEntity.ok(userService.create(user)).getBody();
    }

    @PutMapping
    public User update(@Valid @RequestBody User user) throws PomboException {
        return userService.update(user);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable String id) {
        return ResponseEntity.ok(userService.findById(id));
    }
}