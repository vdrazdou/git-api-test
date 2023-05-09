package org.space.vc.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RepositoryStateDto {
    private Boolean allowSquashMerge;
    private Boolean allowMergeCommit;
    private Boolean allowRebaseMerge;
    private Boolean hasIssues;
    private Boolean hasWiki;
    private Boolean hasPages;
    private Boolean hasDownloads;
}
