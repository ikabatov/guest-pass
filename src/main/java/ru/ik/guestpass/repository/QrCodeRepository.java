package ru.ik.guestpass.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ik.guestpass.entity.QrCode;

import java.util.UUID;

public interface QrCodeRepository extends JpaRepository<QrCode, UUID> {
}
