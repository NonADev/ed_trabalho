package main.ed_sis.domain.models;

public class Documento {
    private Integer id;
    private String nome;
    private String valor;
    private Integer id_edital;
    private Integer id_usuario;

    public Documento() {
    }

    public Documento(String _linha) {
        this.setId(Integer.parseInt(_linha.split(";")[0]));
        this.setNome(_linha.split(";")[1]);
        this.setValor(_linha.split(";")[2]);
        this.setId_edital(Integer.parseInt(_linha.split(";")[3]));
        this.setId_usuario(Integer.parseInt(_linha.split(";")[4]));
    }

    public String toString() {
        return String.format("%s;%s;%s;%s;%s",
                this.id, this.nome, this.valor, this.id_edital,
                this.id_usuario);
    }

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
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

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Integer getId_edital() {
        return id_edital;
    }

    public void setId_edital(Integer id_edital) {
        this.id_edital = id_edital;
    }
}
