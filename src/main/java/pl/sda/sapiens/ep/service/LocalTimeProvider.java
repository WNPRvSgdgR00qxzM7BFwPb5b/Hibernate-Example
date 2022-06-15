package pl.sda.sapiens.ep.service;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class LocalTimeProvider implements TimeProvider{

    @Override
    public LocalDateTime getCurrentDateTime() {
        return LocalDateTime.now();
    }
}
