package de.telran.market.service;

import de.telran.market.model.Role;

public interface RoleService {
   Role get(Long id);
   Role getReference(Long id);
}
