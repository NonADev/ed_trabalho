package main.ed_sis.domain.estruturas;

import main.ed_sis.domain.models.Usuario;

public class PilhaUsuario {
    private Usuario dado[];

    public Usuario desempilhar() {
        if (this.dado == null)
            return null;
        else if (this.dado.length == 1) {
            Usuario aux = this.dado[0];
            this.dado = null;
            return aux;
        } else {
            Usuario aux[] = new Usuario[dado.length - 1];
            for (int i = 0; i < aux.length; i++) {
                aux[i] = this.dado[i];
            }
            Usuario aux2 = this.dado[dado.length - 1];
            this.dado = aux;
            return aux2;
        }
    }

    public void empilhar(Usuario _dado) {
        if (this.dado == null) {
            this.dado = new Usuario[1];
            this.dado[0] = _dado;
        } else {
            Usuario aux[] = new Usuario[dado.length + 1];

            for (int i = 0; i < dado.length; i++) {
                aux[i] = this.dado[i];
            }
            aux[aux.length - 1] = _dado;

            this.dado = aux;
        }
    }

    public void print() {
        if (dado != null) {
            for (int i = 0; i < dado.length; i++) {
                System.out.println(dado[i].getNome());
            }
        }
    }
}
