package com.dgswhs.mid.controller;

import com.dgswhs.mid.dto.User;
import jakarta.annotation.PostConstruct;

import java.util.HashMap;
import java.util.Map;

public class UserController {
    private Map<String, User> userMap;

    @PostConstruct
    public void init() {
        userMap = new HashMap<>();
        userMap.put("1", new User("1", "학생1", "010-1234-0001", "대구광역시 달성군 구지면"));
        userMap.put("2", new User("2", "학생2", "010-1234-0002", "대구광역시 달성군 구지면"));
        userMap.put("3", new User("3", "학생3", "010-1234-0003", "대구광역시 달성군 구지면"));
    }
}
