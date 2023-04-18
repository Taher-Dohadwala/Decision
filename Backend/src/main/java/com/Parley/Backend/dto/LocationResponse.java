package com.Parley.Backend.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;


@Data
@Builder
public class LocationResponse {

    private BigDecimal latitude;
    private BigDecimal longitude;
}
