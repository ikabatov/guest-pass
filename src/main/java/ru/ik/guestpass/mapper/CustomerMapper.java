package ru.ik.guestpass.mapper;


import org.springframework.stereotype.Component;
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
}
