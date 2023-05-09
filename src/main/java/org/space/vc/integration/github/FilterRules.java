package org.space.vc.integration.github;

import java.util.Map;
import java.util.Set;

import static org.space.vc.integration.github.FilterRules.Operation.*;

/**
 * Holder for the github filter rules.
 */
public class FilterRules {
    public static final String STARS_OPTION = "stars";
    public static final String CREATED_OPTION = "created";

    public static final Map<String, Set<Operation>> allowedOperationMap = Map.of(
            STARS_OPTION, Set.of(EQUALS, MORE_THEN, LESS_THEN, LESS_OR_EQUALS_THEN, GREAT_OR_EQUALS_THEN),
            CREATED_OPTION, Set.of(MORE_THEN, LESS_THEN, LESS_OR_EQUALS_THEN, GREAT_OR_EQUALS_THEN)
    );

    public enum Operation {
        EQUALS(":"), MORE_THEN(":>"),
        LESS_THEN(":<"), GREAT_OR_EQUALS_THEN(":>="),
        LESS_OR_EQUALS_THEN(":<=");

        private final String operation;

        Operation(String operation) {
            this.operation = operation;
        }

        public String sign() {
            return operation;
        }
    }

    public enum Sort {
        STARS("stars"), FORKS("forks"), UPDATED("updated");

        private final String sort;

        Sort(String sort) {
            this.sort = sort;
        }

        public String sort() {
            return sort;
        }
    }

    public enum Order {
        ASC("asc"), DESC("desc");

        private final String direction;

        Order(String direction) {
            this.direction = direction;
        }

        public String direction() {
            return direction;
        }
    }

}

