package main.ed_sis.domain.models;

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
    //private FilaDuplamenteEncadeada fila_dupla_encadeada_usuarios;
}
