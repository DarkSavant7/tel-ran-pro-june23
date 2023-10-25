package de.telran.market.web;

import de.telran.market.model.TestModel;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


//@Controller
//@Component
//@Repository
//@Service
@RestController
@RequestMapping(value = "/test")
public class TestController {

  @GetMapping("/data")
//  @PostMapping
//  @PutMapping
//  @RequestMapping(method = {RequestMethod.GET, RequestMethod.DELETE})
  public ResponseEntity<TestModel> testEndpoint() {
    var data = new TestModel("Test", UUID.randomUUID());
    return ResponseEntity.ok(data);
  }
}
