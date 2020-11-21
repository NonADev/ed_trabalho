package main.ed_sis.domain.estruturas;

import main.ed_sis.domain.models.Edital;

public class ListaEncadeadaEdital {
    private NoEdital head;

    public static void main(String[] args) {
        ListaEncadeadaEdital l = new ListaEncadeadaEdital();

        l.addInicio(new Edital("aaa"));
        l.addFinal(new Edital("bbb"));
        l.addPos(new Edital("ccc"), 2);

//        l.rmInicio();
//        l.rmFinal();

        l.print();
    }

    public Edital rmPos(int pos) {
        if (head == null)
            return null;
        else if (pos==0)
            return rmInicio();
        else if (pos==lenght()-1)
            return rmFinal();

        NoEdital aux = head;
        for (int i = 0; i < lenght(); i++, aux = aux.proximo) {
            if (i == pos - 1)
                break;
        }

        Edital toReturn = aux.proximo.edital;

        aux.proximo = aux.proximo.proximo;

        return toReturn;
    }

    public Edital rmFinal() {
        NoEdital aux = head;

        if (head == null) {
            return null;
        } else if (lenght() == 1) {
            Edital toReturn = head.edital;
            head = null;
            return toReturn;
        } else if(lenght() == 2) {
            Edital toReturn = head.proximo.edital;
            head.proximo = head;
            return toReturn;
        }

        while (aux.proximo.proximo != head) {
            aux = aux.proximo;
        }

        Edital toReturn = aux.proximo.edital;

        aux.proximo = aux.proximo.proximo;

        return toReturn;
    }

    public Edital rmInicio() {
        NoEdital aux = head;

        if (head == null) {
            return null;
        } else if (lenght() == 1) {
            Edital toReturn = head.edital;
            head = null;
            return toReturn;
        }

        while (aux.proximo != head) {
            aux = aux.proximo;
        }

        Edital toReturn = aux.proximo.edital;

        aux.proximo = aux.proximo.proximo;
        head = aux.proximo;

        return toReturn;
    }

    public void addPos(Edital _edital, int pos) {
        NoEdital noEdital = new NoEdital();
        noEdital.edital = _edital;

        if (pos > lenght() || pos < 0) {
            throw new IllegalArgumentException();
        } else if (head == null) {
            addIfNull(_edital);
            return;
        } else if (pos == 0) {
            addInicio(_edital);
            return;
        } else if (pos == lenght()) {
            addFinal(_edital);
            return;
        }

        NoEdital aux = head;
        for (int i = 0; i < lenght(); i++, aux = aux.proximo) {
            if (i == pos - 1)
                break;
        }

        noEdital.proximo = aux.proximo;
        aux.proximo = noEdital;
    }

    public void addInicio(Edital _edital) {
        NoEdital noEdital = new NoEdital();

        if (head == null) {
            addIfNull(_edital);
            return;
        }

        noEdital.edital = _edital;
        noEdital.proximo = head;

        NoEdital aux = head;

        while (aux.proximo != head)
            aux = aux.proximo;

        aux.proximo = noEdital;

        head = noEdital;
    }

    public void addFinal(Edital _edital) {
        NoEdital noEdital = new NoEdital();

        if (head == null) {
            addIfNull(_edital);
            return;
        }

        noEdital.edital = _edital;
        noEdital.proximo = head;

        NoEdital aux = head;

        while (aux.proximo != head)
            aux = aux.proximo;

        aux.proximo = noEdital;
    }

    /**
     *
     **/

    public void print() {
        NoEdital aux = head;

        do {
            System.out.println(aux.edital.getDefinicao_curso());
            aux = aux.proximo;
        } while (aux != head);
    }

    private void addIfNull(Edital _edital) {
        NoEdital noEdital = new NoEdital();
        noEdital.edital = _edital;
        noEdital.proximo = noEdital;

        head = noEdital;
    }

    public int lenght() {
        NoEdital aux = head;

        if (head == null) return 0;
        if (head == head.proximo) return 1;

        int i = 0;
        do {
            i++;
            aux = aux.proximo;
        } while (aux != head);

        return i;
    }

    private static class NoEdital {
        public Edital edital;
        public NoEdital proximo;
    }
}
