package main.ed_sis.domain.models;

public class Admin extends Usuario {

	public Admin() {
		super();
	}

	public Admin(String _linha) {
		this.setId(Integer.parseInt(_linha.split(";")[0]));
		this.setNome(_linha.split(";")[1]);
		this.setCPF(_linha.split(";")[2]);
		this.setEmail(_linha.split(";")[3]);
		this.setSenha(_linha.split(";")[4]);
		this.setRG(_linha.split(";")[5]);
		this.setSexo(_linha.split(";")[6]);
	}

	@Override
	public String toString() {
		return "Admin [getId()=" + getId() + ", getNome()=" + getNome() + ", getRG()=" + getRG() + ", getCPF()="
				+ getCPF() + ", getSexo()=" + getSexo() + ", getEmail()=" + getEmail() + ", getSenha()=" + getSenha()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

}
