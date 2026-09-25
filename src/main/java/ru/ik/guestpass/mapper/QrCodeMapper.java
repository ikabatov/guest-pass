package ru.ik.guestpass.mapper;

import org.springframework.stereotype.Component;
import ru.ik.guestpass.dto.QrCodeResponse;
import ru.ik.guestpass.entity.QrCode;

@Component
public class QrCodeMapper {

    public QrCodeResponse toDto(QrCode qrCode) {
        return new QrCodeResponse(qrCode.getCode(), qrCode.getCustomerId());
    }
}
