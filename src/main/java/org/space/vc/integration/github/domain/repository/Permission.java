package org.space.vc.integration.github.domain.repository;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Permission {
    @JsonProperty("admin")
    private Boolean admin;

    @JsonProperty("push")
    private Boolean push;

    @JsonProperty("pull")
    private Boolean pull;
}
