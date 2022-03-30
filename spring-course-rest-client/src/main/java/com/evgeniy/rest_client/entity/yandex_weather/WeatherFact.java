package com.evgeniy.rest_client.entity.yandex_weather;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class WeatherFact {

    @JsonProperty("temp")
    private Long temp;

    @JsonProperty("feels_like")
    private Long feels_like;
}
