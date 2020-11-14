package main.ed_sis.domain.models;

public class Usuario {
    private int id;
    private String nome;
    private String RG;
    private Long CPF;
    private Character sexo;

    public Usuario() {
    }

    public Usuario(String _nome) {
        this.nome = _nome;
    }

    public static void test(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public void setRG(String RG) {
        this.RG = RG;
    }

    public Long getCPF() {
        return CPF;
    }

    public void setCPF(Long CPF) {
        this.CPF = CPF;
    }

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }
}
