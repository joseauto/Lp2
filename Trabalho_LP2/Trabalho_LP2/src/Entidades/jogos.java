package Entidades;

import java.io.Serializable;
import java.util.Objects;

public class jogos implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer id_jogos;
	private String nome;
	private String plataforma;
	private String genero;
	private Double preco;
	
	public jogos(){
	}

	public Integer getId_jogos() {
		return id_jogos;
	}

	public void setId_jogos(Integer id_jogos) {
		this.id_jogos = id_jogos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_jogos);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		jogos other = (jogos) obj;
		return Objects.equals(id_jogos, other.id_jogos);
	}
	
	@Override
	public String toString() {
		return "jogos [id_jogos=" + id_jogos + ", nome=" + nome + ", plataforma=" + plataforma + ", genero=" + genero
				+ ", preco=" + preco + "]";
	}
	
	
	
}
