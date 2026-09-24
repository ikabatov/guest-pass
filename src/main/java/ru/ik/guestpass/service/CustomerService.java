package ru.ik.guestpass.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ik.guestpass.dto.CustomerResponse;
import ru.ik.guestpass.entity.Customer;
import ru.ik.guestpass.exception.NotFoundException;
import ru.ik.guestpass.mapper.CustomerMapper;
import ru.ik.guestpass.repository.CustomerRepository;


@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerResponse getCustomerById(Integer id) {
        Customer customer = customerRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Клиент с id: " + id + " не найден"));
        return customerMapper.toDto(customer);
    }
}
