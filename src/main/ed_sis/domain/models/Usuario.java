package main.ed_sis.domain.models;

public class Usuario {
    private Integer id;
    private String nome;
    private String RG;
    private String CPF;
    private String sexo;
    private String email;
    private String senha;

    public Usuario() {
    }

    public String toString() {
        return String.format("%s;%s;%s;%s;%s;%s;%s", this.getId(), this.getNome(), this.getCPF(), this.getEmail(), this.getSenha(), this.getRG(), this.getSexo());
    }

    public Usuario(String _linha) {
        this.id = Integer.parseInt(_linha.split(";")[0]);
        this.nome = _linha.split(";")[1];
        this.CPF = _linha.split(";")[2];
        this.email = _linha.split(";")[3];
        this.senha = _linha.split(";")[4];
        this.RG = _linha.split(";")[5];
        this.sexo = _linha.split(";")[6];
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String rG) {
        RG = rG;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String cPF) {
        CPF = cPF;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
