package com.api.locadoradejogos.repositories;

import com.api.locadoradejogos.models.JogosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface JogosRepository extends JpaRepository<JogosModel, UUID> {
}
