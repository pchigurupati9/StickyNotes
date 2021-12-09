package com.edwardjones.codefest.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.v3.oas.annotations.media.Schema;

@JsonIgnoreProperties(ignoreUnknown = true)
@Schema(description = "Sticky Note Reminder")
public class Reminder {

    @Schema(description = "unique ID")
    private String id;

    @Schema(description = "ID of parent sticky note")
    private String stickyNoteId;

    @Schema(description = "when the reminder should be sent")
    private LocalDateTime time;

    @Schema(description = "how the reminder will be sent - email, sms, voice, or outlook")
    private String type;

    @Schema(description = "value required to execute the reminder ex email address, phone number")
    private String value;

    @Schema(description = "if the reminder was sent")
    private boolean sent = false;

}
