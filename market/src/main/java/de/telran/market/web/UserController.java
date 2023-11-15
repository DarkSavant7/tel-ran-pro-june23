package de.telran.market.web;

import de.telran.market.api.UserApi;
import de.telran.market.dto.UserDto;
import de.telran.market.service.UserService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class UserController implements UserApi {

  UserService userService;

  @Override
  public ResponseEntity<UserDto> create(@Valid UserDto dto) {
    log.debug("User create called");
    return ResponseEntity
        .status(HttpStatus.CREATED)
        .body(userService.create(dto));
  }

}
