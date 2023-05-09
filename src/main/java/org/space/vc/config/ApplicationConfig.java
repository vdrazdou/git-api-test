package org.space.vc.config;

import feign.Feign;
import org.space.vc.integration.github.GitHubSearchApiClient;
import org.space.vc.integration.github.GithubSearchService;
import org.space.vc.service.GithubVersionControlSearchService;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.cloud.openfeign.support.SpringMvcContract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.validation.Validator;


@Configuration
public class ApplicationConfig {

    @Bean
    public Validator localValidatorFactoryBean() {
        return new LocalValidatorFactoryBean();
    }

    @Bean
    public GithubSearchService githubSearchService(GitHubSearchApiClient gitHubSearchApiClient) {
        return new GithubSearchService(gitHubSearchApiClient);
    }

    @Bean
    public GithubVersionControlSearchService githubVersionControlSearchService(GithubSearchService githubSearchService) {
        return new GithubVersionControlSearchService(githubSearchService);
    }

    @Bean
    public GitHubSearchApiClient gitHubApiSearchClient(ObjectFactory<HttpMessageConverters> converter,
                                                       @Value("${github.url}") String githubUrl) {
        return Feign.builder()
                .contract(new SpringMvcContract())
                .decoder(new SpringDecoder(converter))
                .encoder(new SpringEncoder(converter))
                .target(GitHubSearchApiClient.class, githubUrl);
    }
}
