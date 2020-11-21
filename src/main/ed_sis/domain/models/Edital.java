package main.ed_sis.domain.models;

import main.ed_sis.domain.estruturas.ListaDuplamenteCampus;
import main.ed_sis.domain.estruturas.PilhaUsuario;

public class Edital {
    private int id;
    private String definicao_curso;
    private String publico_alvo;
    private String periodo_inscricao;
    private int qtd_vagas_ampla;
    private int qtd_vagas_afirmativas;
    private int qtd_vagas_deficientes;

    private PilhaUsuario pilha_documentos;
    private ListaDuplamenteCampus lista_dupla_encadeada_campus;

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

    public PilhaUsuario getPilha_documentos() {
        return pilha_documentos;
    }

    public void setPilha_documentos(PilhaUsuario pilha_documentos) {
        this.pilha_documentos = pilha_documentos;
    }

    public ListaDuplamenteCampus getLista_dupla_encadeada_campus() {
        return lista_dupla_encadeada_campus;
    }

    public void setLista_dupla_encadeada_campus(ListaDuplamenteCampus lista_dupla_encadeada_campus) {
        this.lista_dupla_encadeada_campus = lista_dupla_encadeada_campus;
    }
}
