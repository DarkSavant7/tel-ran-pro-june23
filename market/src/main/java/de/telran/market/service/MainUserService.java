package de.telran.market.service;

import static de.telran.market.service.RoleService.USER_ROLE_ID;

import de.telran.market.dto.UserDto;
import de.telran.market.model.Role;
import de.telran.market.model.User;
import de.telran.market.repository.UserRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

//@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class MainUserService implements UserService {
  private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(MainUserService.class);
  UserRepository userRepository;
  RoleService roleService;

  @Override
  @Transactional
  public UserDto create(UserDto dto) {
    var user = User.builder()
        .enabled(true)
        .lastName(dto.getLastName())
        .phone(dto.getPhone())
        .firstName(dto.getFirstName())
        .email(dto.getEmail())
        .roles(List.of(roleService.getReference(USER_ROLE_ID)))
        .password(dto.getPassword())
        .build();

    log.info("Creating new user");
    return fromEntity(userRepository.save(user));
  }


  private UserDto fromEntity(User user) {
    var roles = user.getRoles().stream()
        .map(Role::getName)
        .toList();
    return UserDto.builder()
        .id(user.getId())
        .lastName(user.getLastName())
        .phone(user.getPhone())
        .firstName(user.getFirstName())
        .email(user.getEmail())
        .roles(roles)
        .build();
  }
}
