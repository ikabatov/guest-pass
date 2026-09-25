package ru.ik.guestpass.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.ik.guestpass.dto.CustomerResponse;
import ru.ik.guestpass.dto.EntryRequest;
import ru.ik.guestpass.dto.QrCodeRequest;
import ru.ik.guestpass.dto.QrCodeResponse;
import ru.ik.guestpass.service.QrCodeService;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/qrcodes")
@RequiredArgsConstructor
public class QrCodeController {

    private final QrCodeService qrCodeService;

    @PostMapping("/entry")
    public CustomerResponse enterByQrCode(@Valid @RequestBody EntryRequest requestCode) {
        return qrCodeService.enterByQrCode(requestCode);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public QrCodeResponse addNewCode(@Valid @RequestBody QrCodeRequest request) {
        return qrCodeService.addNewCode(request);
    }

    @PutMapping("/{code}")
    public QrCodeResponse reassignCode(@PathVariable UUID code, @Valid @RequestBody QrCodeRequest request) {
        return qrCodeService.reassignCode(code, request);
    }
}
