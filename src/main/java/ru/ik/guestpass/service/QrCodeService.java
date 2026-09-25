package ru.ik.guestpass.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ik.guestpass.dto.CustomerResponse;
import ru.ik.guestpass.dto.EntryRequest;
import ru.ik.guestpass.dto.QrCodeRequest;
import ru.ik.guestpass.dto.QrCodeResponse;
import ru.ik.guestpass.entity.Customer;
import ru.ik.guestpass.entity.QrCode;
import ru.ik.guestpass.exception.NotFoundException;
import ru.ik.guestpass.mapper.CustomerMapper;
import ru.ik.guestpass.mapper.QrCodeMapper;
import ru.ik.guestpass.repository.CustomerRepository;
import ru.ik.guestpass.repository.QrCodeRepository;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class QrCodeService {

    private final QrCodeRepository qrCodeRepository;
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    private final QrCodeMapper qrCodeMapper;

    @Transactional
    public CustomerResponse enterByQrCode(EntryRequest requestCode) {
        QrCode qrCode = getCodeOrThrow(requestCode.code());
        Integer customerId = qrCode.getCustomerId();

        QrCode newQrCode = new QrCode();
        newQrCode.setCustomerId(customerId);
        qrCodeRepository.save(newQrCode);
        qrCodeRepository.delete(qrCode);

        Customer customer = customerRepository.findById(customerId).orElseThrow();
        return customerMapper.toDto(customer);
    }

    public QrCodeResponse addNewCode(QrCodeRequest request) {
        if (customerRepository.existsById(request.customerId())) {
            QrCode newQrCode = new QrCode();
            newQrCode.setCustomerId(request.customerId());
            newQrCode = qrCodeRepository.save(newQrCode);
            return qrCodeMapper.toDto(newQrCode);
        } else {
            throw new NotFoundException("Клиент с таким id: " + request.customerId() + " не найден.");
        }
    }

    public QrCodeResponse reassignCode(UUID code, QrCodeRequest request) {
        if (customerRepository.existsById(request.customerId())) {
            QrCode qrCode = getCodeOrThrow(code);
            qrCode.setCustomerId(request.customerId());
            QrCode updatedQrCode = qrCodeRepository.save(qrCode);
            return qrCodeMapper.toDto(updatedQrCode);
        } else {
            throw new NotFoundException("Клиент с таким id: " + request.customerId() + " не найден.");
        }
    }

    private QrCode getCodeOrThrow(UUID code) {
        return qrCodeRepository.findById(code).orElseThrow(
                () -> new NotFoundException("QR code не найден"));
    }
}
