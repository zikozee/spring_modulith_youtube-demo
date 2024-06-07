package com.zee.modulithdemo.passportcategory;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author : Ezekiel Eromosei
 * @code @created : 07 Jun, 2024
 */

@Repository
interface PassportCategoryRepository extends CrudRepository<PassportCategory, Long> {

    Optional<PassportCategory> findPassportCategoryByName(String name);
}
