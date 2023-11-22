package de.telran.market.service;

import de.telran.market.model.Role;

public interface RoleService {
   Long USER_ROLE_ID = 1L;
   Role get(Long id);
   Role getReference(Long id);
}
