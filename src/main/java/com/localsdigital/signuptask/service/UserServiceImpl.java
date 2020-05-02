package com.localsdigital.signuptask.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.localsdigital.signuptask.model.User;
import com.localsdigital.signuptask.repository.UserRepository;



@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public void save(User user) {
		System.out.println("user: "+ user);
		
		User userNew = new User();
		userNew.setEmail(user.getEmail());
		userNew.setName(user.getName());
		userNew.setLastName(user.getLastName());
		userNew.setPassword(user.getPassword());
		userNew.setPassword(passwordEncoder.encode(userNew.getPassword()));
		
		userRepository.save(userNew);
	}

	@Override
	public User findByEmail(String email) {
		
		return userRepository.findByEmail(email);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepository.findByEmail(username);
		if (user == null) {
			throw new UsernameNotFoundException("Invalid email and password");
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), grantAuh());
	}

	private Collection<? extends GrantedAuthority> grantAuh() {
		List<GrantedAuthority> authorities = new ArrayList<>();
		GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("USER");
		authorities.add(grantedAuthority);
		return authorities;
	}

}
