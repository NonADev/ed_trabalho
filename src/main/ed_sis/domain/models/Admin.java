package main.ed_sis.domain.models;

public class Admin extends Usuario {

	public Admin() {
		super();
	}

	@Override
	public String toString() {
		return "Admin [getId()=" + getId() + ", getNome()=" + getNome() + ", getRG()=" + getRG() + ", getCPF()="
				+ getCPF() + ", getSexo()=" + getSexo() + ", getEmail()=" + getEmail() + ", getSenha()=" + getSenha()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

}
