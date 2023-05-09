package org.space.vc.integration.github;

import lombok.AllArgsConstructor;

/**
 * Github search filter single criteria.
 */
@AllArgsConstructor
public class Qualifier {
    private String filed;
    private FilterRules.Operation operation;
    private String value;

    public String element() {
        return filed + operation.sign() + value;
    }
}
