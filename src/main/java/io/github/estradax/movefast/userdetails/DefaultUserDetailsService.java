package io.github.estradax.movefast.userdetails;

import io.github.estradax.movefast.penumpang.Penumpang;
import io.github.estradax.movefast.penumpang.PenumpangService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class DefaultUserDetailsService implements UserDetailsService {
  Logger logger = LoggerFactory.getLogger(DefaultUserDetailsService.class);

  @Autowired
  private PenumpangService penumpangService;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Penumpang penumpang = penumpangService.findByEmail(username);

    if (penumpang == null) {
      logger.warn("username not found - username={}", username);
      throw new UsernameNotFoundException("username not found");
    }

    return new DefaultUserDetails(penumpang.getEmail(), penumpang.getPassword());
  }
}
