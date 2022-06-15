package pl.sda.sapiens.ep.service;

import java.time.LocalDateTime;

public interface TimeProvider {
    LocalDateTime getCurrentDateTime();
}
