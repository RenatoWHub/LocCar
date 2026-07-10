package com.loccar.loccar_api.DadosListagemCarro;

import com.loccar.loccar_api.DadosCarro.Carro;

public record DadosListagemCarro(Long id, String marca, String modelo, String placa) {


    public DadosListagemCarro(Carro carro) {
        this(carro.getId(), carro.getMarca(), carro.getModelo(), carro.getPlaca());
    }
}