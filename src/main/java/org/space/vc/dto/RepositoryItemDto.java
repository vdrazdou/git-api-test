package org.space.vc.dto;

import lombok.Builder;
import lombok.Getter;
import org.space.vc.integration.github.domain.repository.Permission;

@Getter
@Builder
public class RepositoryItemDto {
    private Integer id;
    private String name;
    private String fullName;
    private String description;
    private Boolean isPrivate;
    private Boolean isArchived;
    private Boolean isPublic;
    private Boolean fork;
    private String gitUrl;
    private String htmlUrl;
    private String cloneUrl;
    private String language;
    private String defaultBranch;
    private Permission permissions;
    private String sshUrl;
    private String svnUrl;
    private String masterBranch;
    private UserDto owner;
    private RepositoryUrlPointerDto urlPointer;
    private RepositoryStatisticDto statistic;
    private EntityInfoDto entityInfo;
    private RepositoryStateDto state;
}
