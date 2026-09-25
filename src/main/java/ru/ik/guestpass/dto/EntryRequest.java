package ru.ik.guestpass.dto;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record EntryRequest(
        @NotNull
        UUID code
) {
}
