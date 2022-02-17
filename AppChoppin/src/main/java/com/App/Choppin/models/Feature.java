package com.App.Choppin.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Feature implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String nome;
	private String data_nasc;
	private String cpf;
	private String rg;
	private String email;
	private String sexo;

	private String CEPRes;
	private String ruaRes;
	private String numRuaRes;
	private String complementoRes;
	private String bairroRes;
	private String cidadeRes;
	private String estadoREs;
	
	private String CEPEntrega;
	private String ruaEntrega;
	private String numRuaEntrega;
	private String complementoEntrega;
	private String bairroEntrega;
	private String cidadeEntrega;
	private String estadoEntrega;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getData_nasc() {
		return data_nasc;
	}
	public void setData_nasc(String data_nasc) {
		this.data_nasc = data_nasc;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getCEPRes() {
		return CEPRes;
	}
	public void setCEPRes(String cEPRes) {
		CEPRes = cEPRes;
	}
	public String getRuaRes() {
		return ruaRes;
	}
	public void setRuaRes(String ruaRes) {
		this.ruaRes = ruaRes;
	}
	public String getNumRuaRes() {
		return numRuaRes;
	}
	public void setNumRuaRes(String numRuaRes) {
		this.numRuaRes = numRuaRes;
	}
	public String getComplementoRes() {
		return complementoRes;
	}
	public void setComplementoRes(String complementoRes) {
		this.complementoRes = complementoRes;
	}
	public String getBairroRes() {
		return bairroRes;
	}
	public void setBairroRes(String bairroRes) {
		this.bairroRes = bairroRes;
	}
	public String getCidadeRes() {
		return cidadeRes;
	}
	public void setCidadeRes(String cidadeRes) {
		this.cidadeRes = cidadeRes;
	}
	public String getEstadoREs() {
		return estadoREs;
	}
	public void setEstadoREs(String estadoREs) {
		this.estadoREs = estadoREs;
	}
	public String getCEPEntrega() {
		return CEPEntrega;
	}
	public void setCEPEntrega(String cEPEntrega) {
		CEPEntrega = cEPEntrega;
	}
	public String getRuaEntrega() {
		return ruaEntrega;
	}
	public void setRuaEntrega(String ruaEntrega) {
		this.ruaEntrega = ruaEntrega;
	}
	public String getNumRuaEntrega() {
		return numRuaEntrega;
	}
	public void setNumRuaEntrega(String numRuaEntrega) {
		this.numRuaEntrega = numRuaEntrega;
	}
	public String getComplementoEntrega() {
		return complementoEntrega;
	}
	public void setComplementoEntrega(String complementoEntrega) {
		this.complementoEntrega = complementoEntrega;
	}
	public String getBairroEntrega() {
		return bairroEntrega;
	}
	public void setBairroEntrega(String bairroEntrega) {
		this.bairroEntrega = bairroEntrega;
	}
	public String getCidadeEntrega() {
		return cidadeEntrega;
	}
	public void setCidadeEntrega(String cidadeEntrega) {
		this.cidadeEntrega = cidadeEntrega;
	}
	public String getEstadoEntrega() {
		return estadoEntrega;
	}
	public void setEstadoEntrega(String estadoEntrega) {
		this.estadoEntrega = estadoEntrega;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
