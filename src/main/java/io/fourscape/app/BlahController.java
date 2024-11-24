package io.fourscape.app;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlahController {

    private static final String template = "Foo, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/")
    public Blah greeting(@RequestParam(value = "message", defaultValue = "Bar") String name) {
        return new Blah(counter.incrementAndGet(), String.format(template, name));
    }
}