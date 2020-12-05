package br.com.igti.edugame.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.igti.edugame.domain.EquipamentoEntity;

public interface EquipamentoRepository extends MongoRepository<EquipamentoEntity, Long> {
	
}
