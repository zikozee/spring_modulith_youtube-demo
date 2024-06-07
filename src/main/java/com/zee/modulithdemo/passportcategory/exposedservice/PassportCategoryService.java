package com.zee.modulithdemo.passportcategory.exposedservice;

import java.util.Optional;

/**
 * @author : Ezekiel Eromosei
 * @code @created : 07 Jun, 2024
 */

public interface PassportCategoryService {
    Optional<PassportCategoryDto> getPassportCategory(String name);
}
