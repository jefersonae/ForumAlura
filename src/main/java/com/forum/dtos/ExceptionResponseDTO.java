package com.forum.dtos;

import java.time.LocalDateTime;

public record ExceptionResponseDTO(
    LocalDateTime timestamp,
    Integer status,
    String message,
    String path
) {
    
}
