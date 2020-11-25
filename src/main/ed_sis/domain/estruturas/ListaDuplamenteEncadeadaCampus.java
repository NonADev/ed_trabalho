package main.ed_sis.domain.estruturas;


import main.ed_sis.domain.models.Campus;

public class ListaDuplamenteEncadeadaCampus {
    private NoCampus head;

    public Campus rmPos(int pos) {
        Campus toReturn = null;
        if (head == null) {
            throw new IllegalArgumentException("Lista null");
        } else if (pos == 0) {
            toReturn = rmInicio();
        } else if (pos == length() - 1) {
            toReturn = rmFinal();
        } else if (pos > length() - 1 || pos < 0) {
            throw new IllegalArgumentException("Lista não possui item " + pos);
        } else {
            NoCampus aux = head;
            for (int i = 0; i < length(); i++, aux = aux.proximo) {
                if (pos == i) {
                    toReturn = aux.campus;
                    aux.proximo.anterior = aux.anterior;
                    aux.anterior.proximo = aux.proximo;
                }
            }
        }
        return toReturn;
    }

    public Campus rmFinal() {
        NoCampus toReturn;
        if (head == null) {
            throw new IllegalArgumentException("Lista null");
        } else if (length() == 1) {
            toReturn = head;
            head = null;
        } else {
            NoCampus aux = head;
            while (aux.proximo != head) {
                aux = aux.proximo;
            }
            toReturn = aux;
            aux.anterior.proximo = head;
            head.anterior = aux.anterior;
        }
        return toReturn.campus;
    }

    public Campus rmInicio() {
        NoCampus toReturn = head;
        if (head == null) {
            throw new IllegalArgumentException("Lista null");
        } else if (length() == 1) {
            head = null;
        } else {
            NoCampus aux = head.proximo;
            aux.anterior = aux.anterior.anterior;
            aux.anterior.proximo = aux;
            head = aux;
        }
        return toReturn.campus;
    }

    public void addInicio(Campus _campus) {
        NoCampus noCampus = new NoCampus();
        noCampus.campus = _campus;

        if (head == null) {
            noCampus.proximo = noCampus;
            noCampus.anterior = noCampus;
        } else {
            noCampus.proximo = head;
            noCampus.anterior = head.anterior;
            head.anterior = noCampus;
            noCampus.anterior.proximo = noCampus;
        }
        head = noCampus;
    }

    public void addFinal(Campus _campus) {
        NoCampus noCampus = new NoCampus();
        noCampus.campus = _campus;

        if (head == null) {
            noCampus.proximo = noCampus;
            noCampus.anterior = noCampus;
            head = noCampus;
        } else {
            NoCampus aux = head;
            while (aux.proximo != head) {
                aux = aux.proximo;
            }

            noCampus.proximo = head;
            noCampus.anterior = aux;
            aux.proximo = noCampus;
            head.anterior = noCampus;
        }
    }

    public void addPos(Campus _campus, int pos) {
        NoCampus noCampus = new NoCampus();
        noCampus.campus = _campus;
        if (pos > length()) {
            throw new IllegalArgumentException("Lista null");
        } else if (pos == 0) {
            addInicio(_campus);
        } else if (pos == length()) {
            addFinal(_campus);
        } else {
            NoCampus aux = head;
            for (int i = 0; i < length(); i++, aux = aux.proximo) {
                if (pos == i) {
                    noCampus.proximo = aux;
                    noCampus.anterior = aux.anterior;
                    aux.anterior = noCampus;
                    noCampus.anterior.proximo = noCampus;
                    return;
                }
            }
        }
    }

    /**
     * métodos de ajuda
     **/

    public int length() {
        NoCampus aux = head;
        if (head == null) return 0;
        int c = 1;
        while (aux.proximo != head) {
            c++;
            aux = aux.proximo;
        }
        return c;
    }

    public Campus[] toArray() {
        Campus[] toReturn = new Campus[length()];

        int originalLength = length();

        for (int i = 0; i < originalLength; i++) {
            toReturn[i] = rmInicio();
        }

        return toReturn;
    }

    public static Double[] quickSort(Double v[], int esquerda, int direita) {
        int esq = esquerda;
        int dir = direita;
        Double pivo = v[(esq + dir) / 2];
        Double troca;

        while (esq <= dir) {
            while (v[esq] < pivo) {
                esq = esq + 1;
            }
            while (v[dir] > pivo) {
                dir = dir - 1;
            }
            if (esq <= dir) {
                troca = v[esq];
                v[esq] = v[dir];
                v[dir] = troca;
                esq = esq + 1;
                dir = dir - 1;
            }
        }

        if (dir > esquerda)
            quickSort(v, esquerda, dir);
        if (esq < direita)
            quickSort(v, esq, direita);

        return v;
    }

    public void print() {
        NoCampus aux = head;
        if (head == null) return;
        do {
            System.out.println(aux.campus.toString());
            aux = aux.proximo;
        } while (aux.proximo != head);
        if (aux != head) System.out.println(aux.campus.toString().replace("\n", ""));
    }

    private static class NoCampus {
        public main.ed_sis.domain.models.Campus campus;
        public NoCampus anterior, proximo;
    }
}
