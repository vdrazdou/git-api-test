package org.space.vc.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.space.vc.integration.github.FilterRules;
import org.space.vc.integration.github.GithubSearchService;
import org.space.vc.integration.github.SimpleSearchFilter;
import org.space.vc.integration.github.domain.repository.Repository;


@Slf4j
@RequiredArgsConstructor
public class GithubVersionControlSearchService implements VersionControlSearchService {

    private static final int DEFAULT__NUMBER = 1;

    private final GithubSearchService githubSearchService;

    public Repository seachTopRepositories(Integer stars, Integer size, String created) {
        log.debug("Got request to search top repositories: stars: {}, size: {}, created: {}", stars, size, created);
        return githubSearchService.repositories(
                SimpleSearchFilter.builder()
                        .addStars(FilterRules.Operation.EQUALS, stars)
                        .addCreated(FilterRules.Operation.GREAT_OR_EQUALS_THEN, created)
                        .order(FilterRules.Order.DESC)
                        .sort(FilterRules.Sort.STARS)
                        .pageSize(size)
                        .page(DEFAULT__NUMBER)
                        .build()
        );
    }
}
