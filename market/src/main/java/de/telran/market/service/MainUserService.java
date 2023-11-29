package de.telran.market.service;

import static de.telran.market.service.RoleService.USER_ROLE_ID;

import de.telran.market.dto.UserDto;
import de.telran.market.model.Role;
import de.telran.market.model.User;
import de.telran.market.repository.UserRepository;
import jakarta.transaction.Transactional;
import java.util.Collection;
import java.util.List;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

//@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class MainUserService implements UserService, UserDetailsService {
  private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(MainUserService.class);
  UserRepository userRepository;
  RoleService roleService;
  BCryptPasswordEncoder passwordEncoder;

  @Override
  @Transactional
  public UserDto create(UserDto dto) {
    if (userRepository.existsByEmail(dto.getEmail())) {
      throw new IllegalArgumentException("User with this login already exists");
    }
    var user = User.builder()
        .enabled(true)
        .lastName(dto.getLastName())
        .phone(dto.getPhone())
        .firstName(dto.getFirstName())
        .email(dto.getEmail())
        .roles(List.of(roleService.getReference(USER_ROLE_ID)))
        .password(passwordEncoder.encode(dto.getPassword()))
        .build();

    log.info("Creating new user");
    return fromEntity(userRepository.save(user));
  }

  @Override
  public User getByEmail(String email) {
    return userRepository.findUserByEmail(email).orElseThrow();
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

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepository.findUserByEmail(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
        mapRolesToAuthorities(user.getRoles()));
  }

  private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
    return roles.stream().map(r -> new SimpleGrantedAuthority(r.getName())).toList();
  }
}
