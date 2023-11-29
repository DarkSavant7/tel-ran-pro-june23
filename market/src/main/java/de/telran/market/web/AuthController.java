package de.telran.market.web;

import de.telran.market.bean.JwtTokenUtil;
import de.telran.market.dto.JwtRequest;
import de.telran.market.dto.JwtResponse;
import de.telran.market.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AuthController {

    UserService userService;
    JwtTokenUtil jwtTokenUtil;
    AuthenticationManager authenticationManager;

    @PostMapping()
    public ResponseEntity<JwtResponse> authenticate(@RequestBody JwtRequest jwtRequest) {
        log.info("User trying to log in with login: {}", jwtRequest.getUsername());
        var user = userService.getByEmail(jwtRequest.getUsername());
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(),
                jwtRequest.getPassword()));

        var token = jwtTokenUtil.generateTokenFromUser(user);
        return ResponseEntity.ok(new JwtResponse(token));
    }
}
