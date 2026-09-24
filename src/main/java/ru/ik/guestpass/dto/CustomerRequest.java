package ru.ik.guestpass.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CustomerRequest(
        @NotBlank(message = "Имя не может быть пустым")
        @Size(max = 100, message = "Размер не может превышать 100 символов")
        String firstName,
        @NotBlank(message = "Фамилия не может быть пустой")
        @Size(max = 100, message = "Размер не может превышать 100 символов")
        String lastName
) {
}
