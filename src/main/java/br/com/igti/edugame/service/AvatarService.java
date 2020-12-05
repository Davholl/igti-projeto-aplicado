package br.com.igti.edugame.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.igti.edugame.domain.Avatar;
import br.com.igti.edugame.domain.Equipamento;
import br.com.igti.edugame.domain.EquipamentoEntity;
import br.com.igti.edugame.domain.User;
import br.com.igti.edugame.repository.AvatarRepository;
import br.com.igti.edugame.repository.EquipamentoRepository;
import br.com.igti.edugame.repository.UserRepository;

public class AvatarService {
	
	@Autowired
	EquipamentoRepository equipamentoRepository;
	
	@Autowired
	AvatarRepository avatarRepository;
	
	@Autowired
	UserRepository userRepository;
	
	public void comprarItem(Long avatarId, Long itemId) {
		Avatar avatar = avatarRepository.findById(avatarId).get();
		EquipamentoEntity equipamentoEntity = equipamentoRepository.findById(itemId).get();
		
		if (avatar.getOuro().compareTo(equipamentoEntity.getPreco()) >= 0) {
			avatar.diminuirOuro(equipamentoEntity.getPreco());
			avatar.adicionarEquipamento(equipamentoEntity);
			avatarRepository.save(avatar);
		}else {
			throw new RuntimeException("Infelizmente você não possui ouro o bastante para este item");
		}
	}
	
	public void equiparItem(Long avatarId, Long idItem) {
		Avatar avatar = avatarRepository.findById(avatarId).get();
		EquipamentoEntity equipamentoEntity = equipamentoRepository.findById(idItem).get();
		Equipamento equipamento = avatar.findEquipamentoByEntity(equipamentoEntity);
		
		avatar.equiparItem(equipamento);
		
		avatarRepository.save(avatar);
	}
	
	public Avatar detalharAvatar(Long avatarId) {
		Avatar avatar = avatarRepository.findById(avatarId).get();
		return avatar;
	}
	
	public List<Avatar> buscarAvataresPorTurma(Long idTurma){
		return null;
	}
	
	public void criarAvatar(String idUser, String nomeAvatar) {
		User user = userRepository.findById(idUser).get();
		Avatar avatar = new Avatar(nomeAvatar);
		avatarRepository.save(avatar);
		user.getAvatares().add(avatar);
		userRepository.save(user);
	}

}
