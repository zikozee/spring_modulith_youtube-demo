package com.zee.modulithdemo.passport;


import com.zee.modulithdemo.person.PersonDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.datafaker.Faker;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


/**
 * @author : Ezekiel Eromosei
 * @code @created : 07 Jun, 2024
 */

@Slf4j
@Component
@RequiredArgsConstructor
public class PassportEventService {
    private final PassportRepository passportRepository;
    private final Faker faker;

    @ApplicationModuleListener
    void createPassport(PersonDto personDto) {

        log.info("Person details for passport creation received: {}", personDto);
        LocalDate localDate = LocalDate.now();
        Passport passport = new Passport();
        passport.setPersonId(personDto.id());
        passport.setPassportNumber(faker.passport().valid());
        passport.setIssueDate(localDate);
        passport.setExpiryDate(localDate.plusYears(personDto.duration()));

        passportRepository.save(passport);
    }
}
