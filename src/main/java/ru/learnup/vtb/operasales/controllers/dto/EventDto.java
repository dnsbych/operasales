package ru.learnup.vtb.operasales.controllers.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EventDto {

    @JsonProperty
    private Long id;

    @JsonProperty
    private String name;

    @JsonProperty
    private List<TicketDto> tickets;
}

