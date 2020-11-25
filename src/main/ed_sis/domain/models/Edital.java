package main.ed_sis.domain.models;

public class Edital {
    private Integer id;
    private String definicao_curso;
    private String publico_alvo;
    private String periodo_inscricao;
    private Integer qtd_vagas_ampla;
    private Integer qtd_vagas_afirmativas;
    private Integer qtd_vagas_deficientes;
    private Integer id_campus;
    private Integer id_curso;

    public String toString() {
        return String.format("%s;%s;%s;%s;%s;%s;%s;%s;%s",
                this.id, this.definicao_curso, this.publico_alvo, this.periodo_inscricao,
                this.qtd_vagas_ampla, this.qtd_vagas_afirmativas, this.qtd_vagas_deficientes, this.id_campus,
                this.id_curso);
    }

    public Edital() {
    }

    public Edital(String _linha) {
        this.id = Integer.parseInt(_linha.split(";")[0]);
        this.definicao_curso = _linha.split(";")[1];
        this.publico_alvo = _linha.split(";")[2];
        this.periodo_inscricao = _linha.split(";")[3];
        this.qtd_vagas_ampla = Integer.parseInt(_linha.split(";")[4]);
        this.qtd_vagas_afirmativas = Integer.parseInt(_linha.split(";")[5]);
        this.qtd_vagas_deficientes = Integer.parseInt(_linha.split(";")[6]);
        this.id_campus = Integer.parseInt(_linha.split(";")[7]);
        this.id_curso = Integer.parseInt(_linha.split(";")[8]);
    }

    public Integer getId_curso() {
        return id_curso;
    }

    public void setId_curso(Integer id_curso) {
        this.id_curso = id_curso;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDefinicao_curso() {
        return definicao_curso;
    }

    public void setDefinicao_curso(String definicao_curso) {
        this.definicao_curso = definicao_curso;
    }

    public String getPublico_alvo() {
        return publico_alvo;
    }

    public void setPublico_alvo(String publico_alvo) {
        this.publico_alvo = publico_alvo;
    }

    public String getPeriodo_inscricao() {
        return periodo_inscricao;
    }

    public void setPeriodo_inscricao(String periodo_inscricao) {
        this.periodo_inscricao = periodo_inscricao;
    }

    public Integer getQtd_vagas_ampla() {
        return qtd_vagas_ampla;
    }

    public void setQtd_vagas_ampla(Integer qtd_vagas_ampla) {
        this.qtd_vagas_ampla = qtd_vagas_ampla;
    }

    public Integer getQtd_vagas_afirmativas() {
        return qtd_vagas_afirmativas;
    }

    public void setQtd_vagas_afirmativas(Integer qtd_vagas_afirmativas) {
        this.qtd_vagas_afirmativas = qtd_vagas_afirmativas;
    }

    public Integer getId_campus() {
        return id_campus;
    }

    public void setId_campus(Integer id_campus) {
        this.id_campus = id_campus;
    }

    public Integer getQtd_vagas_deficientes() {
        return qtd_vagas_deficientes;
    }

    public void setQtd_vagas_deficientes(Integer qtd_vagas_deficientes) {
        this.qtd_vagas_deficientes = qtd_vagas_deficientes;
    }
}
