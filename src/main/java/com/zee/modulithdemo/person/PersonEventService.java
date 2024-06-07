package com.zee.modulithdemo.person;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author : Ezekiel Eromosei
 * @code @created : 07 Jun, 2024
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class PersonEventService {

    private final ApplicationEventPublisher eventPublisher;

    @Transactional
    public void createPassport(PersonDto personDto) {

        log.info("Creating passport for::::: {}", personDto);
        eventPublisher.publishEvent(personDto);
    }
}
