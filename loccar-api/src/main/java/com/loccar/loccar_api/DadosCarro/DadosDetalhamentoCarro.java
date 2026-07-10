package com.loccar.loccar_api.DadosCarro;

public record DadosDetalhamentoCarro(
        Long id,
        String marca,
        String modelo,
        Integer ano,
        String placa
) {

    public DadosDetalhamentoCarro(Carro carro) {
        this(carro.getId(), carro.getMarca(), carro.getModelo(), carro.getAno(), carro.getPlaca());
    }
}