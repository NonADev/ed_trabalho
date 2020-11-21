package main.ed_sis.domain.models;

public class Campus {
    private Integer id;
    private String nome;
    private String estado;
    private String CEP;
    private String rua;
    private String bairro;
    private Integer numero;

    public Campus() {
    }

    public Campus(String _linha) {
        this.setId(Integer.parseInt(_linha.split(";")[0]));
        this.setNome(_linha.split(";")[1]);
        this.setCEP(_linha.split(";")[2]);
        this.setEstado(_linha.split(";")[3]);
        this.setBairro(_linha.split(";")[4]);
        this.setRua(_linha.split(";")[5]);
        this.setNumero(Integer.parseInt(_linha.split(";")[6]));
    }

    public String toString() {
        return String.format("%s;%s;%s;%s;%s;%s;%s",
                this.getId(), this.getNome(), this.getCEP(), this.getEstado(), this.getBairro(), this.getRua(), this.getNumero());
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }
}
