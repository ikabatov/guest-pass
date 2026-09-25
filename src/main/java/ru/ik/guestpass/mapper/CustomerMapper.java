package ru.ik.guestpass.mapper;

import org.springframework.stereotype.Component;
import ru.ik.guestpass.dto.CustomerRequest;
import ru.ik.guestpass.dto.CustomerResponse;
import ru.ik.guestpass.entity.Customer;

@Component
public class CustomerMapper {

    public CustomerResponse toDto(Customer customer) {
        return new CustomerResponse(
                customer.getId(),
                customer.getFirstName(),
                customer.getLastName());
    }

    public Customer toEntity(CustomerRequest request) {
        Customer newCustomer = new Customer();
        newCustomer.setFirstName(request.firstName());
        newCustomer.setLastName(request.lastName());
        return newCustomer;
    }
}
