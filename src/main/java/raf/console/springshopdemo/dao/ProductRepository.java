package raf.console.springshopdemo.dao;

import raf.console.springshopdemo.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
