package ru.ik.guestpass.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ik.guestpass.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
