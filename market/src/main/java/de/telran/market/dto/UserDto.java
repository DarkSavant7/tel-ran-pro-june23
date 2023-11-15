package de.telran.market.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
  private Long id;
  private String phone;
  private String password;
  private String email;
  private String firstName;
  @NotNull
  @Size(min = 3, max = 50, message = "Last name should be not null and from 3 to 50 symbols")
  private String lastName;
  private List<String> roles;
}
