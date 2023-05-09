package org.space.vc.converter;

import org.space.vc.dto.UserDto;
import org.space.vc.dto.UserUrlPointerDto;
import org.space.vc.integration.github.domain.user.User;
import org.space.vc.integration.github.domain.user.UserUrlPointer;

/**
 * Convert {@link User} class to DTO {@link UserDto}.
 */
public class UserDtoConverter {

    /**
     * Convert user.
     *
     * @param user domain object.
     * @return User DTO.
     */
    public static UserDto userToDto(User user) {
        if (user == null) {
            return null;
        }
        return UserDto.builder()
                .login(user.getLogin())
                .id(user.getId())
                .nodeId(user.getNodeId())
                .avatarUrl(user.getAvatarUrl())
                .htmlUrl(user.getHtmlUrl())
                .gravatarId(user.getGravatarId())
                .type(user.getType())
                .siteAdmin(user.getSiteAdmin())
                .urlPointer(userPointerToDto(user.getUrlPointer()))
                .build();
    }

    private static UserUrlPointerDto userPointerToDto(UserUrlPointer urlPointer) {
        if (urlPointer == null) {
            return null;
        }
        return UserUrlPointerDto.builder()
                .url(urlPointer.getUrl())
                .followersUrl(urlPointer.getFollowersUrl())
                .followingUrl(urlPointer.getFollowingUrl())
                .gistsUrl(urlPointer.getGistsUrl())
                .starredUrl(urlPointer.getStarredUrl())
                .subscriptionsUrl(urlPointer.getSubscriptionsUrl())
                .organizationsUrl(urlPointer.getOrganizationsUrl())
                .reposUrl(urlPointer.getReposUrl())
                .eventsUrl(urlPointer.getEventsUrl())
                .receivedEventsUrl(urlPointer.getReceivedEventsUrl())
                .build();
    }
}
