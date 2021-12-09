package com.edwardjones.codefest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.v3.oas.annotations.media.Schema;

@JsonIgnoreProperties(ignoreUnknown = true)
@Schema(description = "Sticky Note")
public class StickyNote {

    @Schema(description = "unique ID")
    private String id;

    @Schema(description = "lookup key from frontend")
    private String key;

    @Schema(description = "title")
    private String title;

    @Schema(description = "the content of the note")
    private String description;

    @Schema(description = "a reminder to send or that was sent")
    private Reminder reminder;

}
