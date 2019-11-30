package com.gmail.kopandima.webshop.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
  private final UserDetailsService userDetailsService;

  @Autowired
  public WebSecurityConfig(@Qualifier("userDetailServiceImpl") UserDetailsService userDetailsService) {
    this.userDetailsService = userDetailsService;
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
      .csrf().disable()
      .headers().frameOptions().disable()
      .and()
      .authorizeRequests()
      .antMatchers("/", "/registration").permitAll()
      .antMatchers("/h2-console/*").permitAll()
      .anyRequest().authenticated()
      .and()
      .formLogin()
      .loginPage("/login")
      .permitAll()
      .and()
      .logout()
      .permitAll();
  }

  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDetailsService).passwordEncoder(getBCryptPasswordEncoder());
  }
   /* @Bean
    public DataSource dataSource() {
        DataSourceBuilder dataSource = DataSourceBuilder.create();
        dataSource.url(environment.getRequiredProperty("spring.datasource.url"));
        dataSource.username(environment.getRequiredProperty("spring.datasource.username"));
        dataSource.password(environment.getRequiredProperty("spring.datasource.password"));
        return dataSource.build();
    }*/



  @Bean
  PasswordEncoder getBCryptPasswordEncoder() {
    return new BCryptPasswordEncoder();
  }
}

