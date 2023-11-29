package de.telran.market.web;

import de.telran.market.dto.UserDto;
import de.telran.market.service.UserService;
import java.net.HttpURLConnection;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class RegistrationController {

    UserService userService;

    @PostMapping
    public ResponseEntity<Void> register(UserDto userRegisterDto) {
        userService.create(userRegisterDto);
        return ResponseEntity.status(HttpURLConnection.HTTP_CREATED).build();
    }

}
