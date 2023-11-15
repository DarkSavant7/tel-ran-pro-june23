package de.telran.market.api;

import de.telran.market.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface UserApi {

  @PostMapping("/users")
  ResponseEntity<UserDto> create(@RequestBody UserDto dto);
}
