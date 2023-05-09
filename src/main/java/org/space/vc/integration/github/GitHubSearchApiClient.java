package org.space.vc.integration.github;

import org.space.vc.integration.github.domain.repository.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Github API Client.
 */
public interface GitHubSearchApiClient {

    @GetMapping("/search/repositories")
    Repository searchRepositories(@RequestParam("q") String query,
                                  @RequestParam("sort") String sort,
                                  @RequestParam("order") String order,
                                  @RequestParam("per_page") Integer perPage,
                                  @RequestParam("page") Integer page);
}
