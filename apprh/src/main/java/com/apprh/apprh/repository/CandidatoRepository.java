package com.apprh.apprh.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.apprh.apprh.models.Candidato;
import com.apprh.apprh.models.Vaga;
public interface CandidatoRepository extends CrudRepository<Candidato, Long> {
    Iterable<Candidato> findByVaga(Vaga vaga);
}
