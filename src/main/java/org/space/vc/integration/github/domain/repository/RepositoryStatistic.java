package org.space.vc.integration.github.domain.repository;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RepositoryStatistic {
    @JsonProperty("forks")
    private Integer forks;

    @JsonProperty("open_issues")
    private Integer openIssues;

    @JsonProperty("watchers")
    private Integer watchers;

    @JsonProperty("open_issues_count")
    private Integer openIssuesCount;

    @JsonProperty("stargazers")
    private Integer stargazers;

    @JsonProperty("forks_count")
    private Integer forksCount;

    @JsonProperty("stargazers_count")
    private Integer stargazersCount;

    @JsonProperty("watchers_count")
    private Integer watchersCount;

    @JsonProperty("size")
    private Integer size;
}
