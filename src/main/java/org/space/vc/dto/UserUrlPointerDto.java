package org.space.vc.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserUrlPointerDto {
    private String url;
    private String followersUrl;
    private String followingUrl;
    private String gistsUrl;
    private String starredUrl;
    private String subscriptionsUrl;
    private String organizationsUrl;
    private String reposUrl;
    private String eventsUrl;
    private String receivedEventsUrl;
}
