package main.ed_sis.domain.models;

import main.ed_sis.domain.estruturas.ListaDuplamenteEncadeadaCampus;
import main.ed_sis.domain.estruturas.PilhaUsuario;

public class Edital {
    private int id;
    private String definicao_curso;
    private String publico_alvo;
    private String periodo_inscricao;
    private int qtd_vagas_ampla;
    private int qtd_vagas_afirmativas;
    private int qtd_vagas_deficientes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getQtd_vagas_ampla() {
        return qtd_vagas_ampla;
    }

    public void setQtd_vagas_ampla(int qtd_vagas_ampla) {
        this.qtd_vagas_ampla = qtd_vagas_ampla;
    }

    public int getQtd_vagas_afirmativas() {
        return qtd_vagas_afirmativas;
    }

    public void setQtd_vagas_afirmativas(int qtd_vagas_afirmativas) {
        this.qtd_vagas_afirmativas = qtd_vagas_afirmativas;
    }

    public int getQtd_vagas_deficientes() {
        return qtd_vagas_deficientes;
    }

    public void setQtd_vagas_deficientes(int qtd_vagas_deficientes) {
        this.qtd_vagas_deficientes = qtd_vagas_deficientes;
    }
}
