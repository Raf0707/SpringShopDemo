package raf.console.springshopdemo.dao;

import raf.console.springshopdemo.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
