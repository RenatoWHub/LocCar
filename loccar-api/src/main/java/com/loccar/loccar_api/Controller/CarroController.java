package com.loccar.loccar_api.Controller;


import DadosCarro.Carro;
import DadosCarro.CarrosRepository;
import DadosCarro.DadosCadastroCarro;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carros")
@Transactional
public class CarroController {

    @Autowired
    private CarrosRepository repository;

    @PostMapping
    public void cadastrarCarro(@RequestBody @Valid DadosCadastroCarro dados){
        repository.save(new Carro(dados));
    }
}
