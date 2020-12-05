package br.com.igti.edugame.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.igti.edugame.domain.Avatar;

@Repository
public interface AvatarRepository extends MongoRepository<Avatar, Long> {
	Optional<Avatar> findById(Long id);
}
