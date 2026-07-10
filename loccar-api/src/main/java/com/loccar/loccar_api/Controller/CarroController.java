package com.loccar.loccar_api.Controller;

import com.loccar.loccar_api.DadosCarro.Carro;
import com.loccar.loccar_api.DadosCarro.CarrosRepository;
import com.loccar.loccar_api.DadosCarro.DadosCadastroCarro;
import com.loccar.loccar_api.DadosCarro.DadosDetalhamentoCarro;

import com.loccar.loccar_api.DadosListagemCarro.DadosListagemCarro;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/carros")
public class CarroController {

    @Autowired
    private CarrosRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarCarro(@RequestBody @Valid DadosCadastroCarro dados, UriComponentsBuilder uriBuilder) {

        var carro = new Carro(dados);
        repository.save(carro);
        var uri = uriBuilder.path("/carros/{id}").buildAndExpand(carro.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoCarro(carro));
    }
    @GetMapping
    public ResponseEntity<Page<DadosListagemCarro>> listarCarros(@PageableDefault(size = 10, sort = {"marca"}) Pageable paginacao) {
        var carrosDoBanco = repository.findAllByAtivoTrue(paginacao);
        var paginaDto = carrosDoBanco.map(DadosListagemCarro::new);
        return ResponseEntity.ok(paginaDto);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        var carro = repository.getReferenceById(id);
        carro.excluir();

        return ResponseEntity.noContent().build();
    }
}