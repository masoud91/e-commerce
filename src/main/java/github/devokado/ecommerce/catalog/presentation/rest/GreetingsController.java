package github.devokado.ecommerce.catalog.presentation.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greetings")
public class GreetingsController {

    @GetMapping("")
    ResponseEntity<String> sayHi() {
        return ResponseEntity.ok("Hi!");
    }

}
