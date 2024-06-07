package com.forum.dtos;

import org.springframework.lang.NonNull;

public record RequestTopicDTO(
    @NonNull
    String title,
    @NonNull
    String course,
    @NonNull
    String message
) {
}
