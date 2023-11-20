package org.zerock.guestbook.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.zerock.guestbook.dto.GuestbookDTO;
import org.zerock.guestbook.dto.PageRequestDTO;
import org.zerock.guestbook.dto.PageResultDTO;
import org.zerock.guestbook.service.GuestbookService;

import java.time.LocalDateTime;

// localhost:8080/guestbook
@RestController // @Controller + @ResponseBody
@RequestMapping("/guestbook")
@RequiredArgsConstructor
@Log4j2
public class GuestbookController {

    private final GuestbookService guestbookService;

    //POST http://localhost:8080/guestbook
    // BODY (JSON)
    // {
    //  "gno" : "10",
    //  "content" : "test",
    //  ....
//     ....
    // }
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public String register(@RequestBody GuestbookDTO dto) {
        guestbookService.register(dto);
        return "CREATED";
    }

    @GetMapping("/{gno}")
    public ResponseEntity<GuestbookDTO> read(
            @PathVariable("gno") Long gno
    ) {
        GuestbookDTO dto = guestbookService.read(gno);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    // /guestbook/list
    @GetMapping("/list")
    public ResponseEntity<PageResultDTO> getList(PageRequestDTO pageRequestDTO) {
        return ResponseEntity.ok(guestbookService.getList(pageRequestDTO));
    }

    //PUT /guestbook
    @PutMapping("")
    public String modify(
            @RequestBody GuestbookDTO dto
    ) {
        guestbookService.modify(dto);
        return "OK";
    }

    // localhost:8080/guestbook/300
    @DeleteMapping("/{gno}")
    public String remove(
    @PathVariable("gno") Long gno
    ) {
        guestbookService.remove(gno);
        return "OK";
    }


}
