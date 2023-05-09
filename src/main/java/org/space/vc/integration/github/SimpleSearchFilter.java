package org.space.vc.integration.github;

import com.google.common.collect.Lists;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.space.vc.exception.IllegalFilterStateException;
import org.space.vc.integration.github.FilterRules.Operation;
import org.space.vc.integration.github.FilterRules.Order;
import org.space.vc.integration.github.FilterRules.Sort;

import java.util.List;
import java.util.stream.Collectors;

import static org.space.vc.integration.github.FilterRules.*;

/**
 * Simple github filter. Implements stars and create date filering.
 */
@Getter
@EqualsAndHashCode
public class SimpleSearchFilter {
    private final String qualifier;
    private final String sort;
    private final String order;
    private final Integer pageSize;
    private final Integer page;

    private SimpleSearchFilter(Builder builder) {
        this.qualifier = builder.qualifiers.stream().map(Qualifier::element).collect(Collectors.joining(" "));
        this.sort = builder.sort.sort();
        this.order = builder.order.direction();
        this.pageSize = builder.pageSize;
        this.page = builder.page;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final List<Qualifier> qualifiers = Lists.newArrayList();
        private Sort sort;
        private Order order;
        private Integer pageSize;
        private Integer page;

        Builder() {
        }

        public Builder addStars(Operation operation, Integer value) {
            if (!allowedOperationMap.get(STARS_OPTION).contains(operation)) {
                throw new IllegalFilterStateException("The operation %s is not applicable for %s"
                        .formatted(operation.sign(), STARS_OPTION));
            }
            this.qualifiers.add(new Qualifier(STARS_OPTION, operation, value.toString()));
            return this;
        }

        public Builder addCreated(Operation operation, String value) {
            if (!allowedOperationMap.get(CREATED_OPTION).contains(operation)) {
                throw new IllegalFilterStateException("The operation %s is not applicable for %s"
                        .formatted(operation.sign(), CREATED_OPTION));
            }
            this.qualifiers.add(new Qualifier(CREATED_OPTION, operation, value));
            return this;
        }


        public Builder sort(Sort sort) {
            this.sort = sort;
            return this;
        }

        public Builder order(Order order) {
            this.order = order;
            return this;
        }

        public Builder pageSize(Integer perPage) {
            if (perPage <= 0 || perPage > 1000) {
                throw new IllegalFilterStateException("The number of records per page should be great then zero and less or equals then 1000");
            }
            this.pageSize = perPage;
            return this;
        }

        public Builder page(Integer page) {
            if (page <= 0) {
                throw new IllegalFilterStateException("The number of pages should be great then zero");
            }
            this.page = page;
            return this;
        }

        public SimpleSearchFilter build() {
            return new SimpleSearchFilter(this);
        }
    }
}
