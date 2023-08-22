package raf.console.springshopdemo.dao;

import raf.console.springshopdemo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
	User findFirstByName(String name);
}
