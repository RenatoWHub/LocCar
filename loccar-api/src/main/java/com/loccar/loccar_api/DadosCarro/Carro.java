package com.loccar.loccar_api.DadosCarro;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "carros")
@Entity(name = "Carro")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String marca;
    @Column
    private String modelo;
    @Column
    private Integer ano;
    @Column
    private String placa;

    private boolean ativo;

    public Carro(DadosCadastroCarro dados) {
        this.marca = dados.marca();
        this.modelo = dados.modelo();
        this.ano = dados.ano();
        this.placa = dados.placa();
        this.ativo = true;
    }
    public void excluir() {
        this.ativo = false;
    }
}

