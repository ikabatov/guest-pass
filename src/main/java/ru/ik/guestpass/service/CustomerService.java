package ru.ik.guestpass.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ik.guestpass.dto.CustomerRequest;
import ru.ik.guestpass.dto.CustomerResponse;
import ru.ik.guestpass.entity.Customer;
import ru.ik.guestpass.exception.NotFoundException;
import ru.ik.guestpass.mapper.CustomerMapper;
import ru.ik.guestpass.repository.CustomerRepository;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public List<CustomerResponse> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream()
                .map(customerMapper::toDto)
                .toList();
    }

    public CustomerResponse getCustomerById(Integer id) {
        Customer customer = customerRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Клиент с id: " + id + " не найден"));
        return customerMapper.toDto(customer);
    }

    public CustomerResponse addNewCustomer(CustomerRequest request) {
        Customer savedCustomer = customerRepository.save(customerMapper.toEntity(request));
        return customerMapper.toDto(savedCustomer);
    }
}
