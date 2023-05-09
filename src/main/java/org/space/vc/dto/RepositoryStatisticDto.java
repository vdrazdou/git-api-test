package org.space.vc.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RepositoryStatisticDto {
    private Integer forks;
    private Integer openIssues;
    private Integer watchers;
    private Integer openIssuesCount;
    private Integer stargazers;
    private Integer forksCount;
    private Integer stargazersCount;
    private Integer watchersCount;
    private Integer size;
}
