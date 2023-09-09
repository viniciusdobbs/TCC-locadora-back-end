package com.api.locadoradejogos.repositories;

import com.api.locadoradejogos.models.LocacaoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LocacaoRepository extends JpaRepository<LocacaoModel, UUID> {

    @Query(value = "SELECT COUNT(l) FROM public.tb_locacao l WHERE l.id_cliente=?1 AND l.dt_devolucao IS NULL", nativeQuery = true)
    long countCliente(UUID idPessoa);
}
