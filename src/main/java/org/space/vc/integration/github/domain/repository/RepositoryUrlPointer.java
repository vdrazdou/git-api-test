package org.space.vc.integration.github.domain.repository;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RepositoryUrlPointer {
    @JsonProperty("url")
    private String url;

    @JsonProperty("archive_url")
    private String archiveUrl;

    @JsonProperty("assignees_url")
    private String assigneesUrl;

    @JsonProperty("blobs_url")
    private String blobsUrl;

    @JsonProperty("branches_url")
    private String branchesUrl;

    @JsonProperty("collaborators_url")
    private String collaboratorsUrl;

    @JsonProperty("comments_url")
    private String commentsUrl;

    @JsonProperty("commits_url")
    private String commitsUrl;

    @JsonProperty("compare_url")
    private String compareUrl;

    @JsonProperty("contents_url")
    private String contentsUrl;

    @JsonProperty("contributors_url")
    private String contributorsUrl;

    @JsonProperty("deployments_url")
    private String deploymentsUrl;

    @JsonProperty("downloads_url")
    private String downloadsUrl;

    @JsonProperty("events_url")
    private String eventsUrl;

    @JsonProperty("forks_url")
    private String forksUrl;

    @JsonProperty("git_commits_url")
    private String gitCommitsUrl;

    @JsonProperty("git_refs_url")
    private String gitRefsUrl;

    @JsonProperty("git_tags_url")
    private String gitTagsUrl;

    @JsonProperty("hooks_url")
    private String hooksUrl;

    private String homepage;

    @JsonProperty("tags_url")
    private String tagsUrl;

    @JsonProperty("trees_url")
    private String treesUrl;

    @JsonProperty("teams_url")
    private String teamsUrl;

    @JsonProperty("stargazers_url")
    private String stargazersUrl;

    @JsonProperty("statuses_url")
    private String statusesUrl;

    @JsonProperty("subscribers_url")
    private String subscribersUrl;

    @JsonProperty("subscription_url")
    private String subscriptionUrl;

    @JsonProperty("pulls_url")
    private String pullsUrl;

    @JsonProperty("releases_url")
    private String releasesUrl;

    @JsonProperty("issues_url")
    private String issuesUrl;

    @JsonProperty("issue_comment_url")
    private String issueCommentUrl;

    @JsonProperty("issue_events_url")
    private String issueEventsUrl;

    @JsonProperty("keys_url")
    private String keysUrl;

    @JsonProperty("labels_url")
    private String labelsUrl;

    @JsonProperty("languages_url")
    private String languagesUrl;

    @JsonProperty("merges_url")
    private String mergesUrl;

    @JsonProperty("milestones_url")
    private String milestonesUrl;

    @JsonProperty("mirror_url")
    private String mirrorUrl;

    @JsonProperty("notifications_url")
    private String notificationsUrl;
}
