package org.space.vc.service;

import org.space.vc.integration.github.domain.repository.Repository;

/**
 * Interface provide the API to get top source code repositories.
 */
public interface VersionControlSearchService {

    /**
     * Returns top repositories for the give criteria.
     */
    Repository seachTopRepositories(Integer starts, Integer size, String created);
}
