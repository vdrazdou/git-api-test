package org.space.vc.integration.github;

import org.junit.jupiter.api.Test;
import org.space.vc.exception.IllegalFilterStateException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

class SimpleSearchFilterTest {

    @Test
    void givenCorrectInputShouldReturnValidFilter() {
        SimpleSearchFilter result = SimpleSearchFilter.builder()
                .addCreated(FilterRules.Operation.MORE_THEN, "2023-02-01")
                .addStars(FilterRules.Operation.EQUALS, 10)
                .sort(FilterRules.Sort.STARS)
                .order(FilterRules.Order.ASC)
                .page(10)
                .pageSize(100)
                .build();

        assertEquals(result.getQualifier(), "created:>2023-02-01 stars:10");
        assertEquals(result.getSort(), "stars");
        assertEquals(result.getOrder(), "asc");
        assertEquals(result.getPageSize(), 100);
        assertEquals(result.getPage(), 10);
    }

    @Test
    void givenIncorrectOperationInputShouldThrowException() {
        assertThrowsExactly(IllegalFilterStateException.class,
                () -> SimpleSearchFilter.builder()
                        .addCreated(FilterRules.Operation.EQUALS, "2023-02-01")
                        .build());
    }

    @Test
    void givenIncorrectPerPageInputShouldThrowException() {
        assertThrowsExactly(IllegalFilterStateException.class,
                () -> SimpleSearchFilter.builder()
                        .pageSize(1001)
                        .build());
    }

    @Test
    void givenIncorrectPageInputShouldThrowException() {
        assertThrowsExactly(IllegalFilterStateException.class,
                () -> SimpleSearchFilter.builder()
                        .page(-1)
                        .build());
    }
}