package ru.ik.guestpass.dto;

import jakarta.validation.constraints.NotNull;

public record QrCodeRequest(
        @NotNull(message = "ID клиента не может быть пустым")
        Integer customerId
) {
}
