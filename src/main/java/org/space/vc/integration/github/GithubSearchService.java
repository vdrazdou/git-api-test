package org.space.vc.integration.github;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.space.vc.integration.github.domain.repository.Repository;

/**
 * Service wrapper for the Github API client. Allow to use filtering interface.
 */
@Slf4j
@RequiredArgsConstructor
public class GithubSearchService {

    private final GitHubSearchApiClient client;

    public Repository repositories(SimpleSearchFilter filter) {
        log.debug("Github service got request to search repositories based on filter: {}", filter);
        return client.searchRepositories(filter.getQualifier(), filter.getSort(),
                filter.getOrder(), filter.getPageSize(), filter.getPage());
    }
}
