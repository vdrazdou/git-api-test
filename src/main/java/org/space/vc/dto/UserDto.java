package org.space.vc.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserDto {
    private String login;
    private Integer id;
    private String nodeId;
    private String avatarUrl;
    private String htmlUrl;
    private String gravatarId;
    private String type;
    private Boolean siteAdmin;
    private UserUrlPointerDto urlPointer;
}
