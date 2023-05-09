package org.space.vc.integration.github;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.space.vc.integration.github.domain.repository.Repository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GithubSearchServiceTest {

    @Mock
    private GitHubSearchApiClient client;

    private GithubSearchService service;

    @BeforeEach
    public void setUp() {
        service = new GithubSearchService(client);
    }

    @Test
    public void shouldReturnValidResult() {

        SimpleSearchFilter filter = SimpleSearchFilter.builder()
                .addCreated(FilterRules.Operation.MORE_THEN, "2023-02-01")
                .addStars(FilterRules.Operation.EQUALS, 10)
                .sort(FilterRules.Sort.STARS)
                .order(FilterRules.Order.ASC)
                .page(10)
                .pageSize(100)
                .build();

        Repository expectedResult = new Repository();

        when(client.searchRepositories(filter.getQualifier(), filter.getSort(), filter.getOrder(),
                filter.getPageSize(), filter.getPage())).thenReturn(expectedResult);

        Repository actualResult = service.repositories(filter);

        assertEquals(expectedResult, actualResult);

        verify(client).searchRepositories(filter.getQualifier(), filter.getSort(), filter.getOrder(),
                filter.getPageSize(), filter.getPage());
    }

}