package ru.learnup.vtb.operasales.controllers.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class ExceptionDto {

    @JsonProperty
    public Integer errCode;

    @JsonProperty
    public String mess;

    @JsonProperty
    public String err;


}
