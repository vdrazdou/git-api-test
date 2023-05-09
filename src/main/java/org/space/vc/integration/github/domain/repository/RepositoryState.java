package org.space.vc.integration.github.domain.repository;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RepositoryState {
    @JsonProperty("allow_squash_merge")
    private Boolean allowSquashMerge;
    @JsonProperty("allow_merge_commit")
    private Boolean allowMergeCommit;
    @JsonProperty("allow_rebase_merge")
    private Boolean allowRebaseMerge;
    @JsonProperty("has_issues")
    private Boolean hasIssues;
    @JsonProperty("has_wiki")
    private Boolean hasWiki;
    @JsonProperty("has_pages")
    private Boolean hasPages;
    @JsonProperty("has_downloads")
    private Boolean hasDownloads;
}
