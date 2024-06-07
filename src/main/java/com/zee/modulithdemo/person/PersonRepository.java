package com.zee.modulithdemo.person;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author : Ezekiel Eromosei
 * @code @created : 07 Jun, 2024
 */

@Repository
interface PersonRepository extends CrudRepository<Person, Long> {
}
