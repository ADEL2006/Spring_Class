package com.dgswhs.mid.controller;

import com.dgswhs.mid.dto.User;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class UserController {
    private Map<String, User> userMap;

    @PostConstruct
    public void init() {
        userMap = new HashMap<>();
        userMap.put("1", new User("1", "학생1", "010-1234-0001", "대구광역시 달성군 구지면"));
        userMap.put("2", new User("2", "학생2", "010-1234-0002", "대구광역시 달성군 구지면"));
        userMap.put("3", new User("3", "학생3", "010-1234-0003", "대구광역시 달성군 구지면"));
    }
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void register(
            @RequestBody User user
    ) {
        userMap.put(
                user.getId(),
                user
        );
    }

    @GetMapping("/{id}")
    public User get(
            @PathVariable("id") String id
    ) {
        return userMap.get(id);
    }


    @GetMapping("/all")
    public List<User> getAll() {
        return userMap
                .values()
                .stream()
                .collect(Collectors.toList());
    }

    @GetMapping("/duplicate/{id}")
    public ResponseEntity duplicate2(
            @PathVariable("id") String id
    ) {
        return userMap.containsKey(id) ? ResponseEntity.status(HttpStatus.CONFLICT).build() : ResponseEntity.ok().build();
    }

    @PutMapping("")
    public ResponseEntity<User> modify(
            @RequestBody User user
    ) {
        User uptUser = userMap.get(user.getId());
        uptUser.setName(user.getName());
        return ResponseEntity.ok(uptUser);
    }


    @DeleteMapping("/{id}")
    public void remove(
            @PathVariable("id") String id
    ) {
        userMap.remove(id);
    }

}
