package com.jsoft.roomschedule.about;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/about")
public class AboutController {
    @GetMapping("/version")
    public ResponseEntity<String> getVersion(){
        return ResponseEntity.ok().body("v1");
    }
}
