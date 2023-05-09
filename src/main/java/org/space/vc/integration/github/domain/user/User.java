package org.space.vc.integration.github.domain.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.Data;

@Data
public class User {
    @JsonProperty("login")
    private String login;

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("node_id")
    private String nodeId;

    @JsonProperty("avatar_url")
    private String avatarUrl;

    @JsonProperty("html_url")
    private String htmlUrl;

    @JsonProperty("gravatar_id")
    private String gravatarId;

    @JsonProperty("type")
    private String type;

    @JsonProperty("site_admin")
    private Boolean siteAdmin;

    @JsonUnwrapped
    private UserUrlPointer urlPointer;
}