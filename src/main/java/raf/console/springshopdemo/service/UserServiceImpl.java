package raf.console.springshopdemo.service;

import raf.console.springshopdemo.dao.UserRepository;
import raf.console.springshopdemo.domain.Role;
import raf.console.springshopdemo.domain.User;
import raf.console.springshopdemo.dto.UserDto;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public List<UserDto> getAll() {
		return userRepository.findAll().stream()
				.map(this::toDto)
				.collect(Collectors.toList());
	}

	@Override
	@javax.transaction.Transactional
	public boolean save(UserDto userDto) {
		if(!Objects.equals(userDto.getPassword(), userDto.getMatchingPassword())){
			throw new RuntimeException("Password is not equal");
		}
		User user = User.builder()
				.name(userDto.getUsername())
				.password(passwordEncoder.encode(userDto.getPassword()))
				.email(userDto.getEmail())
				.role(Role.CLIENT)
				.build();
		userRepository.save(user);
		return true;
	}

	@Override
	public User findByName(String name) {
		return userRepository.findFirstByName(name);
	}

	@Override
	@Transactional
	public void updateProfile(UserDto dto) {
		User savedUser = userRepository.findFirstByName(dto.getUsername());
		if(savedUser == null){
			throw new RuntimeException("User not found by name " + dto.getUsername());
		}

		boolean changed = false;
		if(dto.getPassword() != null && !dto.getPassword().isEmpty()){
			savedUser.setPassword(passwordEncoder.encode(dto.getPassword()));
			changed = true;
		}
		if(!Objects.equals(dto.getEmail(), savedUser.getEmail())){
			savedUser.setEmail(dto.getEmail());
			changed = true;
		}
		if(changed){
			userRepository.save(savedUser);
		}
	}

	@Override
	public void save(User user) {
		userRepository.save(user);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findFirstByName(username);
		if(user == null){
			throw new UsernameNotFoundException("User not found with name: " + username);
		}

		List<GrantedAuthority> roles = new ArrayList<>();
		roles.add(new SimpleGrantedAuthority(user.getRole().name()));

		return new org.springframework.security.core.userdetails.User(
				user.getName(),
				user.getPassword(),
				roles);
	}

	private UserDto toDto(User user){
		return UserDto.builder()
				.username(user.getName())
				.email(user.getEmail())
				.build();
	}
}
