package raf.console.springshopdemo.service;

import raf.console.springshopdemo.domain.Order;

public interface OrderService {
    void saveOrder(Order order);

    Order getOrder(Long id);
}
