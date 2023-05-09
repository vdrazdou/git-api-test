package org.space.vc.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.space.vc.integration.github.FilterRules;
import org.space.vc.integration.github.GithubSearchService;
import org.space.vc.integration.github.SimpleSearchFilter;
import org.space.vc.integration.github.domain.repository.Repository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GithubVersionControlSearchServiceTest {
    @Mock
    private GithubSearchService githubSearchService;

    private GithubVersionControlSearchService service;

    @BeforeEach
    public void setUp() {
        service = new GithubVersionControlSearchService(githubSearchService);
    }


    @Test
    public void givenCorrectInputShouldReturnValidFilter() {
        Integer stars = 5;
        Integer size = 10;
        String created = "2022-01-01";

        SimpleSearchFilter filter = SimpleSearchFilter.builder()
                .addStars(FilterRules.Operation.EQUALS, stars)
                .addCreated(FilterRules.Operation.GREAT_OR_EQUALS_THEN, created)
                .order(FilterRules.Order.DESC)
                .sort(FilterRules.Sort.STARS)
                .pageSize(size)
                .page(1)
                .build();

        Repository expected = new Repository();

        when(githubSearchService.repositories(eq(filter))).thenReturn(expected);

        Repository actual = service.seachTopRepositories(stars, size, created);

        assertEquals(expected, actual);
        verify(githubSearchService).repositories(eq(filter));
    }
}