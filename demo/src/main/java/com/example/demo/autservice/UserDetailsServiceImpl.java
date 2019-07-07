//
//package com.example.demo.autservice;
//
//import java.util.HashSet;
//import java.util.Set;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.example.demo.modal.Role;
//import com.example.demo.modal.User;
//import com.example.demo.securityConfiguration.UserRepository;
//
//@Configuration("userDetailsService")
//public class UserDetailsServiceImpl implements UserDetailsService {
//
//	@Autowired
//	private UserRepository userRepository;
//
//	@Override
//
//	@Transactional(readOnly = true)
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		User user = userRepository.findByUserName(username);
//
//		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
//		for (Role role : user.getRoles()) {
//			grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
//		}
//
//		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
//				grantedAuthorities);
//	}
//
//}
