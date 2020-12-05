package br.com.igti.edugame.domain;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "equipamentos")
public class EquipamentoEntity {

	@Id
	Long id;
	public String name;
	public String slot;
	public Boolean equipado;
	public BigDecimal preco;
	
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
	public String getSlot() {
		return slot;
	}
	public void setSlot(String slot) {
		this.slot = slot;
	}
	public Boolean getEquipado() {
		return equipado;
	}
	public void setEquipado(Boolean equipado) {
		this.equipado = equipado;
	}
	public BigDecimal getPreco() {
		return preco;
	}
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
}
