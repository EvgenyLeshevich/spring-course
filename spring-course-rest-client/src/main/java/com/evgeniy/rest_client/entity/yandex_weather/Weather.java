package com.evgeniy.rest_client.entity.yandex_weather;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Weather {

    @JsonProperty("now")
    private Long now;

    @JsonProperty("fact")
    private WeatherFact fact;

    @JsonProperty("info")
    private WeatherInfo info;
}
