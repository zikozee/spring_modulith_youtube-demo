package com.zee.modulithdemo.person;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author : Ezekiel Eromosei
 * @code @created : 07 Jun, 2024
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
public record PersonDto(
        Long id,
        String firstName,
        String lastName,
        String email,
        int age,
        String category,
        Long duration) {
}
