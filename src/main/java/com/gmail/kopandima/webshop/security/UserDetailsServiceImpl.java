package com.gmail.kopandima.webshop.security;

import com.gmail.kopandima.webshop.models.User;
import com.gmail.kopandima.webshop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service("userDetailServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {

  @Autowired
  UserService userService;

  @Override
  @Transactional
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userService.findByUsername(username);
    if (user==null) throw new UsernameNotFoundException("There is no such username: "+ username);

    Set<GrantedAuthority> roles = new HashSet<>(user.getRoles());
    return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), roles);
  }

}
