package org.space.vc.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class IllegalFilterStateException extends RuntimeException {
    private final String message;
}
