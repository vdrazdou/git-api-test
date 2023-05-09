package org.space.vc.integration.github.domain.repository;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.Data;
import org.space.vc.integration.github.domain.EntityInfo;
import org.space.vc.integration.github.domain.user.User;

@Data
public class RepositoryItem {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("full_name")
    private String fullName;
    @JsonProperty("description")
    private String description;
    @JsonProperty("private")
    private Boolean isPrivate;
    @JsonProperty("archived")
    private Boolean isArchived;
    @JsonProperty("public")
    private Boolean isPublic;
    @JsonProperty("fork")
    private Boolean fork;
    @JsonProperty("git_url")
    private String gitUrl;
    @JsonProperty("html_url")
    private String htmlUrl;
    @JsonProperty("clone_url")
    private String cloneUrl;
    @JsonProperty("language")
    private String language;
    @JsonProperty("default_branch")
    private String defaultBranch;
    @JsonProperty("permissions")
    private Permission permissions;
    @JsonProperty("ssh_url")
    private String sshUrl;
    @JsonProperty("svn_url")
    private String svnUrl;
    @JsonProperty("master_branch")
    private String masterBranch;
    @JsonProperty("owner")
    private User owner;

    @JsonUnwrapped
    private RepositoryUrlPointer urlPointer;

    @JsonUnwrapped
    private RepositoryStatistic statistic;

    @JsonUnwrapped
    private EntityInfo entityInfo;

    @JsonUnwrapped
    private RepositoryState state;
}
