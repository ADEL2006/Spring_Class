package org.zerock.guestbook.sample;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

@Component
@ToString
//@AllArgsConstructor
//@NoArgsConstructor
@RequiredArgsConstructor
public class Restaurant {
    private  final Chef chef;
    private  final Guest guest;
}
