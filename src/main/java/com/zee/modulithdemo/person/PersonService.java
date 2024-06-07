package com.zee.modulithdemo.person;

import com.zee.modulithdemo.passportcategory.PassportCategoryServiceImpl;
import com.zee.modulithdemo.passportcategory.exposedservice.PassportCategoryDto;
import com.zee.modulithdemo.passportcategory.exposedservice.PassportCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author : Ezekiel Eromosei
 * @code @created : 07 Jun, 2024
 */

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;
    private final PassportCategoryService passportCategoryService;
    private final PersonEventService personEventService;

    public PersonDto registerPerson(PersonDto personDto) {

        Person person = new Person();
        person.setFirstName(personDto.firstName());
        person.setLastName(personDto.lastName());
        person.setAge(personDto.age());
        person.setEmail(personDto.email());

        Optional<PassportCategoryDto> optionalPassportCategory = passportCategoryService.getPassportCategory(personDto.category());
        if(optionalPassportCategory.isEmpty()) throw new RuntimeException();
        PassportCategoryDto passportCategoryDto = optionalPassportCategory.get();

        Person registeredPerson = personRepository.save(person);

        PersonDto eventPersonDto = map(registeredPerson, passportCategoryDto.name(), passportCategoryDto.durationInYrs());
        personEventService.createPassport(eventPersonDto);

        return responsePersonDto(eventPersonDto);
    }

    PersonDto map(Person person, String category, long duration) {
        return new PersonDto(
                person.getId(),
                person.getFirstName(),
                person.getLastName(),
                person.getEmail(),
                person.getAge(),
                category,
                duration
        );
    }

    PersonDto responsePersonDto(PersonDto personDto) {
        return new PersonDto(
                null,
                personDto.firstName(),
                personDto.lastName(),
                personDto.email(),
                personDto.age(),
                personDto.category(),
                personDto.duration()
        );
    }
}
