package com.zee.modulithdemo.passport;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author : Ezekiel Eromosei
 * @code @created : 07 Jun, 2024
 */

@Repository
interface PassportRepository extends CrudRepository<Passport, Long> {
}
