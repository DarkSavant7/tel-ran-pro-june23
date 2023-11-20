package de.telran.market.service;

import de.telran.market.model.Role;
import de.telran.market.repository.RoleRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class MainRoleService implements RoleService {
  private static final Long USER_ROLE_ID = 1L;
  RoleRepository roleRepository;


  @Override
  public Role get(Long id) {
    return roleRepository.findById(id).orElseThrow();
  }

  @Override
  public Role getReference(Long id) {
    return roleRepository.getReferenceById(id);
  }
}
