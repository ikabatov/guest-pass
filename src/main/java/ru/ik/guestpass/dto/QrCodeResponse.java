package ru.ik.guestpass.dto;

import java.util.UUID;

public record QrCodeResponse(
        UUID code,
        Integer customerId
) {
}
