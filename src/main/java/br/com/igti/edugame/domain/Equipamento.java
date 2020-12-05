package br.com.igti.edugame.domain;


public class Equipamento {
	
	public Long id;
	public String name;
	public String slot;
	public Boolean equipado;
	
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
	public Boolean isEquipado() {
		return equipado;
	}
	public void setEquipado(Boolean equipado) {
		this.equipado = equipado;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
}
