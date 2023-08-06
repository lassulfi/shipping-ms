package br.com.kabum.msshipping.infrastructure.api.shippingcompany.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Dimension(
    @JsonProperty("altura") Integer height,
    @JsonProperty("largura") Integer width) {

}
