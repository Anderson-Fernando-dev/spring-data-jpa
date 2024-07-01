package com.rafexanderson5.alAboutJPA.dtos;

import java.util.Set;
import java.util.UUID;

public record BookRecordDto(String title,
                            UUID publisherId,
                            Set<UUID> authorIds,
                            String reviewComment) {
}
