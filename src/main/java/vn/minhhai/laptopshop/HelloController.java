package vn.minhhai.laptopshop;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
  @GetMapping("/")
    public String index() {
    return "Hello World with minhhai205!";
  }
  @GetMapping("/user")
    public String user() {
    return "Hello World with minhhai205!";
  }
}
