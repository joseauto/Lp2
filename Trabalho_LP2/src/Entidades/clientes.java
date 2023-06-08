package Entidades;

import java.io.Serializable;
import java.util.Objects;

public class clientes implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer Id_cliente;
	private String nome;
	private String telefone;
	private String email;
	
	
	public clientes() {
	}
	
	public Integer getId_cliente() {
		return Id_cliente;
	}

	public void setId_cliente(Integer id_cliente) {
		Id_cliente = id_cliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Id_cliente);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		clientes other = (clientes) obj;
		return Objects.equals(Id_cliente, other.Id_cliente);
	}
	
	@Override
	public String toString() {
		return "clientes [Id_cliente=" + Id_cliente + ", nome=" + nome + ", telefone=" + telefone + ", email=" + email
				+ "]";
	}
	
}
