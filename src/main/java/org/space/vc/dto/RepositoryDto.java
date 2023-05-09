package org.space.vc.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class RepositoryDto {
    private Integer totalCount;
    private List<RepositoryItemDto> items;
}
