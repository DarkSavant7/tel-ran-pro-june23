package de.telran.market.service;

import de.telran.market.dto.UserDto;
import de.telran.market.model.User;

public interface UserService {
   UserDto create(UserDto dto);
   User getByEmail(String email);
}
