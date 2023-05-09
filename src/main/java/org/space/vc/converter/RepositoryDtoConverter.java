package org.space.vc.converter;

import org.space.vc.dto.*;
import org.space.vc.integration.github.domain.EntityInfo;
import org.space.vc.integration.github.domain.repository.*;

import java.util.stream.Collectors;

import static org.space.vc.converter.UserDtoConverter.userToDto;

/**
 * Convert {@link Repository} class to DTO {@link RepositoryDto}.
 */
public class RepositoryDtoConverter {

    /**
     * Convert repository.
     *
     * @param repository domain object.
     * @return Repository DTO.
     */
    public static RepositoryDto repositoryToDto(Repository repository) {
        if (repository == null) {
            return null;
        }
        return RepositoryDto.builder()
                .totalCount(repository.getTotalCount())
                .items(repository.getItems().stream().map(RepositoryDtoConverter::repositoryItemToDto).collect(Collectors.toList()))
                .build();
    }

    private static RepositoryItemDto repositoryItemToDto(RepositoryItem repositoryItem) {
        if (repositoryItem == null) {
            return null;
        }
        return RepositoryItemDto.builder()
                .id(repositoryItem.getId())
                .name(repositoryItem.getName())
                .fullName(repositoryItem.getFullName())
                .description(repositoryItem.getDescription())
                .isPrivate(repositoryItem.getIsPrivate())
                .isArchived(repositoryItem.getIsArchived())
                .isPublic(repositoryItem.getIsPublic())
                .fork(repositoryItem.getFork())
                .gitUrl(repositoryItem.getGitUrl())
                .htmlUrl(repositoryItem.getHtmlUrl())
                .cloneUrl(repositoryItem.getCloneUrl())
                .language(repositoryItem.getLanguage())
                .defaultBranch(repositoryItem.getDefaultBranch())
                .permissions(repositoryItem.getPermissions())
                .sshUrl(repositoryItem.getSshUrl())
                .svnUrl(repositoryItem.getSvnUrl())
                .masterBranch(repositoryItem.getMasterBranch())
                .owner(userToDto(repositoryItem.getOwner()))
                .urlPointer(repositoryUrlPointerToDto(repositoryItem.getUrlPointer()))
                .statistic(tepositoryStatisticToDto(repositoryItem.getStatistic()))
                .entityInfo(entityInfoToDto(repositoryItem.getEntityInfo()))
                .state(repositoryStateToDto(repositoryItem.getState()))
                .build();
    }

    private static EntityInfoDto entityInfoToDto(EntityInfo entityInfo) {
        if (entityInfo == null) {
            return null;
        }
        return EntityInfoDto.builder()
                .pushedAt(entityInfo.getPushedAt())
                .createdAt(entityInfo.getCreatedAt())
                .updatedAt(entityInfo.getUpdatedAt())
                .build();
    }

    private static RepositoryUrlPointerDto repositoryUrlPointerToDto(RepositoryUrlPointer repositoryUrlPointer) {
        if (repositoryUrlPointer == null) {
            return null;
        }
        return RepositoryUrlPointerDto.builder()
                .url(repositoryUrlPointer.getUrl())
                .archiveUrl(repositoryUrlPointer.getArchiveUrl())
                .assigneesUrl(repositoryUrlPointer.getAssigneesUrl())
                .blobsUrl(repositoryUrlPointer.getBlobsUrl())
                .branchesUrl(repositoryUrlPointer.getBranchesUrl())
                .collaboratorsUrl(repositoryUrlPointer.getCollaboratorsUrl())
                .commentsUrl(repositoryUrlPointer.getCommentsUrl())
                .commitsUrl(repositoryUrlPointer.getCommitsUrl())
                .compareUrl(repositoryUrlPointer.getCompareUrl())
                .contentsUrl(repositoryUrlPointer.getContentsUrl())
                .contributorsUrl(repositoryUrlPointer.getContributorsUrl())
                .deploymentsUrl(repositoryUrlPointer.getDeploymentsUrl())
                .downloadsUrl(repositoryUrlPointer.getDownloadsUrl())
                .eventsUrl(repositoryUrlPointer.getEventsUrl())
                .forksUrl(repositoryUrlPointer.getForksUrl())
                .gitCommitsUrl(repositoryUrlPointer.getGitCommitsUrl())
                .gitRefsUrl(repositoryUrlPointer.getGitRefsUrl())
                .gitTagsUrl(repositoryUrlPointer.getGitTagsUrl())
                .hooksUrl(repositoryUrlPointer.getHooksUrl())
                .homepage(repositoryUrlPointer.getHomepage())
                .tagsUrl(repositoryUrlPointer.getTagsUrl())
                .treesUrl(repositoryUrlPointer.getTreesUrl())
                .teamsUrl(repositoryUrlPointer.getTeamsUrl())
                .stargazersUrl(repositoryUrlPointer.getStargazersUrl())
                .statusesUrl(repositoryUrlPointer.getStatusesUrl())
                .subscribersUrl(repositoryUrlPointer.getSubscribersUrl())
                .subscriptionUrl(repositoryUrlPointer.getSubscriptionUrl())
                .pullsUrl(repositoryUrlPointer.getPullsUrl())
                .releasesUrl(repositoryUrlPointer.getReleasesUrl())
                .issuesUrl(repositoryUrlPointer.getIssuesUrl())
                .issueCommentUrl(repositoryUrlPointer.getIssueCommentUrl())
                .issueEventsUrl(repositoryUrlPointer.getIssueEventsUrl())
                .keysUrl(repositoryUrlPointer.getKeysUrl())
                .labelsUrl(repositoryUrlPointer.getLabelsUrl())
                .languagesUrl(repositoryUrlPointer.getLanguagesUrl())
                .mergesUrl(repositoryUrlPointer.getMergesUrl())
                .milestonesUrl(repositoryUrlPointer.getMilestonesUrl())
                .mirrorUrl(repositoryUrlPointer.getMirrorUrl())
                .notificationsUrl(repositoryUrlPointer.getNotificationsUrl())
                .build();
    }


    private static RepositoryStatisticDto tepositoryStatisticToDto(RepositoryStatistic repositoryStatistic) {
        if (repositoryStatistic == null) {
            return null;
        }
        return RepositoryStatisticDto.builder()
                .forks(repositoryStatistic.getForks())
                .openIssues(repositoryStatistic.getOpenIssues())
                .watchers(repositoryStatistic.getWatchers())
                .openIssuesCount(repositoryStatistic.getOpenIssues())
                .stargazers(repositoryStatistic.getStargazers())
                .forksCount(repositoryStatistic.getForksCount())
                .stargazersCount(repositoryStatistic.getStargazersCount())
                .watchersCount(repositoryStatistic.getWatchersCount())
                .size(repositoryStatistic.getSize())
                .build();
    }

    private static RepositoryStateDto repositoryStateToDto(RepositoryState repositoryState) {
        if (repositoryState == null) {
            return null;
        }
        return RepositoryStateDto.builder()
                .allowSquashMerge(repositoryState.getAllowSquashMerge())
                .allowMergeCommit(repositoryState.getAllowMergeCommit())
                .allowRebaseMerge(repositoryState.getAllowRebaseMerge())
                .hasIssues(repositoryState.getHasIssues())
                .hasWiki(repositoryState.getHasWiki())
                .hasPages(repositoryState.getHasPages())
                .hasDownloads(repositoryState.getHasDownloads())
                .build();
    }
}
