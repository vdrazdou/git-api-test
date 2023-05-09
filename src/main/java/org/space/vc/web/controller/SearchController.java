package org.space.vc.web.controller;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.space.vc.converter.RepositoryDtoConverter;
import org.space.vc.dto.RepositoryDto;
import org.space.vc.dto.RepositoryItemDto;
import org.space.vc.service.VersionControlSearchService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

@Validated
@RestController
@RequiredArgsConstructor
public class SearchController {
    private final VersionControlSearchService service;

    @GetMapping("/repositories/rating")
    @ApiOperation(value = "Search top repositories", response = RepositoryItemDto.class)
    public RepositoryDto search(
            @RequestParam("stars") @Min(value = 0, message = "The number of stars should be great or equals to 0") Integer stars,
            @RequestParam("size") @Pattern(regexp = "10|50|100", message = "The size can be one of the following: 10, 50 or 100")  String size,
            @RequestParam("date") @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "The date should be in format YYYY-MM-DD") String date
    ) {
        return RepositoryDtoConverter.repositoryToDto(service.seachTopRepositories(stars, Integer.valueOf(size), date));
    }

}
