package arv.simplemicroservice.controller;

import org.springframework.web.bind.annotation.*;

/**
 * @author ArvikV
 * @version 1.0
 * @since 15.05.2022
 */
@RestController
@RequestMapping("hello")
public class HelloController {

    @GetMapping("/{firstName}")
    public String hello(
            @PathVariable ("firstName") String firstName,
            @RequestParam ("lastName") String lastName) {
        return String.format("{\"message\":\"Hello %s %s\"}", firstName, lastName);
    }
}
