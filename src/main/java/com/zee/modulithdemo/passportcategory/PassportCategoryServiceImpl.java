package com.zee.modulithdemo.passportcategory;

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
public class PassportCategoryServiceImpl implements PassportCategoryService {
    private final PassportCategoryRepository passportCategoryRepository;

    public Optional<PassportCategoryDto> getPassportCategory(String name){
        return passportCategoryRepository.findPassportCategoryByName(name)
                .map(this::mapDto);
    }


    PassportCategoryDto mapDto(PassportCategory category){
        return new PassportCategoryDto(category.getName(), category.getDurationInYrs());
    }
}
