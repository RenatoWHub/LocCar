package com.loccar.loccar_api.DadosCarro;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarrosRepository extends JpaRepository<Carro, Long> {
    Page<Carro> findAllByAtivoTrue(Pageable paginacao);
}
