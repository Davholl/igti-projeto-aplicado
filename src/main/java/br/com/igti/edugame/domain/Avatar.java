/**
 * 
 */
package br.com.igti.edugame.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author dav-h
 *
 */
@Document(collection = "avatars")
public class Avatar {
	
	  @Id
	  public Long id;
	
	  public String name;	  
	  
	  private List<Equipamento> equipamentos;
	  
	  private BigDecimal ouro;
	
	  public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getOuro() {
		return ouro;
	}

	public void adicionarOuro(BigDecimal ouro) {
		this.ouro.add(ouro);
	}
	
	public void diminuirOuro(BigDecimal ouro) {
		this.ouro.subtract(ouro);
	}
	
	public Equipamento findEquipamentoByEntity(EquipamentoEntity equipamentoEntity) {
		for (Equipamento equipamento : equipamentos) {
			if (equipamento.getId().equals(equipamentoEntity.getId())){
				return equipamento;
			}
		}
		return null;
	}
	
	public void adicionarEquipamento(EquipamentoEntity equipamentoEntity) {
		Equipamento equipamento = new Equipamento();
		equipamento.setId(equipamentoEntity.getId());
		equipamento.setName(equipamentoEntity.getName());
		equipamento.setSlot(equipamentoEntity.getSlot());
		equipamento.setEquipado(false);
		this.equipamentos.add(equipamento);
	}
	
	public void equiparItem(Equipamento aEquipar) {			
		for (Equipamento equipamento : equipamentos) {
			if (equipamento.isEquipado() && equipamento.getSlot().equals(aEquipar.getSlot())) {
				equipamento.setEquipado(false);
			}
		}
		aEquipar.setEquipado(true);
	}

	public Avatar() {}
	
	  public Avatar(String name) {
	    this.name = name;
	    this.ouro = BigDecimal.ZERO;
	    this.equipamentos = new ArrayList<Equipamento>();
	  }
}
