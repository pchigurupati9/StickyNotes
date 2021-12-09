package com.edwardjones.codefest.controller;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edwardjones.codefest.service.StickyNotesService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@Validated
public class StickyNotesRestController {

    @Autowired
    StickyNotesService stickyNotesService;


    @GetMapping(
        path = "/sticky-notes/getStickyNote",
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(
        summary = "get sticky note",
        description = "gets the sticky note")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Success", content =
            @Content(schema = @Schema(implementation = String.class))),
        @ApiResponse(responseCode = "400", description = "Bad Request"),
        @ApiResponse(responseCode = "403", description = "Access Denied"),
        @ApiResponse(responseCode = "404", description = "Not found"),
        @ApiResponse(responseCode = "500", description = "Internal Error")
    })
    public ResponseEntity<String> getGoalInputByRelationshipIdAndCountryCode(
//                @Valid
//                @Min(value = 1, message = "Relationship ID is invalid")
//                @Max(value = 999999999999999L, message = "Relationship ID is invalid")
//                @Parameter(description = "Relationship Identifier", required = true)
//                @PathVariable(value = "relationshipId", required = true)
//                long relationshipId,
//
//                @Valid
//                @Pattern(regexp = "US|CA", message = "Invalid Country Code")
//                @Parameter(
//                    description = "Country Code",
//                    required = true,
//                    schema = @Schema(type = "string", allowableValues = {"US","CA"}, example = "US")
//                )
//                @PathVariable(value = "countryCode", required = true)
//                String countryCode,
//
//                @Valid
//                @Pattern(regexp="[A-Z]{3}", message="Calling App System Identifer must be 3 letters long and uppercase")
//                @Parameter(
//                    description = "System ID",
//                    required = false
//                )
//                @RequestParam(
//                    value = "sysId",
//                    required = false,
//                    defaultValue = "UNK"
//                )
//                String sysId,
//
//                @Valid
//                @Size(min = 0, max = 100)
//                @Pattern(regexp="^[a-zA-Z_]+$", message="Application Name may only contain letters and underscores")
//                @Parameter(
//                    description ="Application Name",
//                    required = false
//                )
//                @RequestParam(
//                    value = "appName",
//                    required = false,
//                    defaultValue = "Unknown"
//                )
//                String appName
            ) {

        String stickyNote =
            stickyNotesService.getStickyNote();

        return new ResponseEntity<String>(stickyNote, HttpStatus.OK);
    }

}
