//
//  package com.example.demo.autservice;
//  
//  import org.springframework.beans.factory.annotation.Autowired; import
//  org.springframework.context.annotation.Bean; import
//  org.springframework.security.config.annotation.authentication.builders.
//  AuthenticationManagerBuilder; import
//  org.springframework.security.config.annotation.web.builders.HttpSecurity;
//  import org.springframework.security.config.annotation.web.configuration.
//  WebSecurityConfigurerAdapter; import
//  org.springframework.security.core.userdetails.UserDetailsService; import
//  org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//  
//  public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//  
//  @Autowired private UserDetailsService userDetailsService;
//  
//  @Bean public BCryptPasswordEncoder bCryptPasswordEncoder() { return new
//  BCryptPasswordEncoder(); }
//  
//  @Override protected void configure(HttpSecurity http) throws Exception { http
//  .authorizeRequests() .antMatchers("/resources/**",
//  "/registration","/css/**","/fonts/**","/OneCSS/**","/image/**",
//  "/images/**","/js/**","/OneJS/**","/scss/**","file:///D:/upload_dir/").permitAll() .anyRequest().authenticated() .and()
//  .formLogin() .loginPage("/login") .permitAll() .and() .logout() .permitAll();
//  }
//  
//  @Autowired public void configureGlobal(AuthenticationManagerBuilder auth)
//  throws Exception {
//  auth.userDetailsService(userDetailsService).passwordEncoder(
//  bCryptPasswordEncoder()); } }
// 