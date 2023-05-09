package org.space.vc.web;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;
import org.space.vc.exception.IllegalFilterStateException;
import org.space.vc.integration.github.domain.repository.Repository;
import org.space.vc.integration.github.domain.repository.RepositoryItem;
import org.space.vc.integration.github.domain.repository.RepositoryState;
import org.space.vc.service.GithubVersionControlSearchService;
import org.space.vc.web.controller.SearchController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(controllers = SearchController.class)
public class SearchControllerTest {

    @MockBean
    private GithubVersionControlSearchService service;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnValidRepositoryList() throws Exception {

        RepositoryState repositoryState = new RepositoryState();
        repositoryState.setAllowMergeCommit(true);

        RepositoryItem repositoryItem = new RepositoryItem();
        repositoryItem.setId(12);
        repositoryItem.setState(repositoryState);

        Repository expectedResult = new Repository();
        expectedResult.setTotalCount(50);
        expectedResult.setItems(Lists.newArrayList(repositoryItem));

        when(service.seachTopRepositories(10, 50, "2020-10-10")).thenReturn(expectedResult);

        mockMvc.perform(get("/repositories/rating")
                        .queryParam("date", "2020-10-10")
                        .queryParam("size", "50")
                        .queryParam("stars", "10")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.totalCount").value("50"))
                .andExpect(jsonPath("$.items[0].id").value("12"))
                .andExpect(jsonPath("$.items[0].state.allowMergeCommit").value(true));
    }

    @Test
    public void shouldReturnErrorMessageWhenClientThrowException() throws Exception {
        when(service.seachTopRepositories(10, 50, "2020-10-10")).thenThrow(new IllegalFilterStateException("Illegal state"));

        mockMvc.perform(get("/repositories/rating")
                        .queryParam("date", "2020-10-10")
                        .queryParam("size", "50")
                        .queryParam("stars", "10")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("Illegal state"));
    }

    @Test
    public void shouldReturnErrorMessageWhenSizeIsIncorrect() throws Exception {

        mockMvc.perform(get("/repositories/rating")
                        .queryParam("date", "2020-10-10")
                        .queryParam("size", "5")
                        .queryParam("stars", "10")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("search.size: The size can be one of the following: 10, 50 or 100"));
    }

    @Test
    public void shouldReturnErrorMessageWhenStarsIsIncorrect() throws Exception {

        mockMvc.perform(get("/repositories/rating")
                        .queryParam("date", "2020-10-10")
                        .queryParam("size", "50")
                        .queryParam("stars", "-1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("search.stars: The number of stars should be great or equals to 0"));
    }

    @Test
    public void shouldReturnErrorMessageWhenDateIsIncorrect() throws Exception {

        mockMvc.perform(get("/repositories/rating")
                        .queryParam("date", "220-10-10")
                        .queryParam("size", "50")
                        .queryParam("stars", "1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("search.date: The date should be in format YYYY-MM-DD"));
    }
}
