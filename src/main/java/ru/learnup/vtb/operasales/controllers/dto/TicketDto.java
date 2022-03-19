package ru.learnup.vtb.operasales.controllers.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TicketDto {

    @JsonProperty
    private Long id;

    @JsonProperty
    private int price;

    @JsonProperty
    private String eventName;
}
