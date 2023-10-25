package de.tel.ran.domain;

import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {

  String telegramId;
  String name;
  String phoneNumber;
  LocalDateTime lastSmoke;
  Integer minutesBetweenSmoking;
  Integer cigarettesCount;
}
