package org.space.vc.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RepositoryUrlPointerDto { //todo simplify
    private String url;
    private String archiveUrl;
    private String assigneesUrl;
    private String blobsUrl;
    private String branchesUrl;
    private String collaboratorsUrl;
    private String commentsUrl;
    private String commitsUrl;
    private String compareUrl;
    private String contentsUrl;
    private String contributorsUrl;
    private String deploymentsUrl;
    private String downloadsUrl;
    private String eventsUrl;
    private String forksUrl;
    private String gitCommitsUrl;
    private String gitRefsUrl;
    private String gitTagsUrl;
    private String hooksUrl;
    private String homepage;
    private String tagsUrl;
    private String treesUrl;
    private String teamsUrl;
    private String stargazersUrl;
    private String statusesUrl;
    private String subscribersUrl;
    private String subscriptionUrl;
    private String pullsUrl;
    private String releasesUrl;
    private String issuesUrl;
    private String issueCommentUrl;
    private String issueEventsUrl;
    private String keysUrl;
    private String labelsUrl;
    private String languagesUrl;
    private String mergesUrl;
    private String milestonesUrl;
    private String mirrorUrl;
    private String notificationsUrl;
}
