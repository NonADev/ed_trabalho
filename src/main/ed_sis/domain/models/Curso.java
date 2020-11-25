package main.ed_sis.domain.models;

public class Curso {
    private Integer id;
    private String nome;
    private Integer semestre;
    private Integer id_campus;

    public Curso() {
    }

    public Curso(String _linha) {
        this.setId(Integer.parseInt(_linha.split(";")[0]));
        this.setNome(_linha.split(";")[1]);
        this.setSemestre(Integer.parseInt(_linha.split(";")[2]));
        this.setId_campus(Integer.parseInt(_linha.split(";")[3]));
    }

    public String toString() {
        return String.format("%s;%s;%s;%s",
                this.id, this.nome, this.semestre, this.id_campus);
    }

    public Integer getId_campus() {
        return id_campus;
    }

    public void setId_campus(Integer id_campus) {
        this.id_campus = id_campus;
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

    public Integer getSemestre() {
        return semestre;
    }

    public void setSemestre(Integer semestre) {
        this.semestre = semestre;
    }
}
