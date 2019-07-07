//
//  package com.example.demo.autservice;
//  
//  import java.util.HashSet;
//  
//  import org.springframework.beans.factory.annotation.Autowired; import
//  org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//  
//  import com.example.demo.modal.User; import
//  com.example.demo.securityConfiguration.RoleRepository; import
//  com.example.demo.securityConfiguration.UserRepository;
//  
//  
//  public class UserServiceImpl implements UserService {
//  
//  @Autowired private UserRepository userRepository;
//  
//  @Autowired private RoleRepository roleRepository;
//  
//  @Autowired private BCryptPasswordEncoder bCryptPasswordEncoder;
//  
//  @Override public void save(User user) {
//  user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
////  user.setRoles(new HashSet<>(roleRepository.findAll()));
//  userRepository.save(user); }
//  
//  @Override public User findByUsername(String userName) { return
//  userRepository.findByUserName(userName); } }
// 