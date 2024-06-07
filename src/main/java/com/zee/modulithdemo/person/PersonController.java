package com.zee.modulithdemo.person;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Ezekiel Eromosei
 * @code @created : 07 Jun, 2024
 */

@RestController
@RequestMapping(path = "person")
@RequiredArgsConstructor
public class PersonController {
    private final PersonService personService;

    @PostMapping(path = "register")
    public ResponseEntity<PersonDto> register(@RequestBody PersonDto personDto) {
        return ResponseEntity.ok(personService.registerPerson(personDto));
//        return new ResponseEntity<>(personService.registerPerson(personDto), HttpStatus.OK);
    }
}
