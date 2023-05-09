package org.space.vc.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
@Builder
public class EntityInfoDto {
    private Date createdAt;
    private Date updatedAt;
    private Date pushedAt;
}
