package main.ed_sis.domain.controllers;

import main.ed_sis.domain.estruturas.ListaEncadeadaEdital;
import main.ed_sis.domain.models.Documento;
import main.ed_sis.domain.models.Edital;

import java.io.*;

public class EditalManipuladorArquivo {
    private File editalFile = new File("files/", "Edital.txt");

//    public static void main(String[] args) throws IOException {
//        EditalManipuladorArquivo e = new EditalManipuladorArquivo();
//
//        e.getAllEditaisUserNotIncluded(456754).print();
//    }

    public void insertEdital(Edital _edital) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(editalFile, true));

        _edital.setId(CampusManipuladorArquivo.retornaId(6));

        writer.write(_edital.toString() + "\n");
        writer.flush();

        writer.close();
    }

    public boolean update(Edital _edital) throws IOException {
        File tempFile = new File("files/", "tempFile.txt");

        BufferedReader bufferedReader = new BufferedReader(new FileReader(editalFile));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(tempFile, false));

        boolean hasBeenUpdated = false;
        int i = 0;
        for (String linha = bufferedReader.readLine(); linha != null; linha = bufferedReader.readLine(), i++) {
            if (new Edital(linha).getId().equals(_edital.getId())) {
                hasBeenUpdated = true;
                bufferedWriter.write(_edital.toString() + "\n");
                bufferedWriter.flush();
            } else {
                bufferedWriter.write(linha + "\n");
                bufferedWriter.flush();
            }
        }

        bufferedReader.close();
        bufferedWriter.close();
        editalFile.delete();
        tempFile.renameTo(editalFile);

        return hasBeenUpdated;
    }

    public boolean delete(Integer _id) throws IOException {
        File tempFile = new File("files/", "tempFile.txt");

        BufferedReader bufferedReader = new BufferedReader(new FileReader(editalFile));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(tempFile, false));

        boolean hasBeenDeleted = false;
        int i = 0;
        for (String linha = bufferedReader.readLine(); linha != null; linha = bufferedReader.readLine(), i++) {
            if (new Edital(linha).getId().equals(_id)) {
                hasBeenDeleted = true;
                continue;
            }

            bufferedWriter.write(linha + "\n");
            bufferedWriter.flush();
        }

        bufferedReader.close();
        bufferedWriter.close();
        editalFile.delete();
        tempFile.renameTo(editalFile);

        return hasBeenDeleted;
    }

    public Edital findById(Integer _id) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(editalFile));

        for (String linha = bufferedReader.readLine(); linha != null; linha = bufferedReader.readLine()) {
            if (new Edital(linha).getId().equals(_id)) {
                bufferedReader.close();
                return new Edital(linha);
            }
        }
        bufferedReader.close();
        return null;
    }

    public ListaEncadeadaEdital getAllEdital() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(editalFile));

        ListaEncadeadaEdital edital = new ListaEncadeadaEdital();
        for (String _linha = reader.readLine(); _linha != null; _linha = reader.readLine()) {
            edital.addFinal(new Edital(_linha));
        }

        return edital;
    }

    public ListaEncadeadaEdital getAllEditaisUserNotIncluded(Integer _usuario_id, Integer _curso_id) throws IOException {
        DocumentoManipuladorArquivo documentoManipuladorArquivo = new DocumentoManipuladorArquivo();

        Documento[] documentos = documentoManipuladorArquivo.findByUsuarioId(_usuario_id);

        Edital[] editais = getAllEdital().toArray();

        for (int y = 0; y < documentos.length; y++) {
            Edital[] aux = new Edital[0];
            for (int i = 0; i < editais.length; i++) {
                if ((documentos.length > 0 && editais.length > 0) && editais[i].getId().equals(documentos[y].getId_edital())) {//ta certo, não mexe
                    continue;
                } else if (editais[i].getId_curso().equals(_curso_id)) {
                    Edital[] aux2 = new Edital[aux.length + 1];

                    for (int k = 0; k < aux.length; k++) {
                        aux2[k] = aux[k];
                    }

                    aux2[aux2.length - 1] = editais[i];
                    aux = aux2;
                }
            }
            editais = aux;
        }

        return new ListaEncadeadaEdital().toListaEncadeada(editais);
    }

    public ListaEncadeadaEdital getAllEditalByCampusId(Integer _id) throws IOException {
        ListaEncadeadaEdital _lista = getAllEdital(), _toReturn = new ListaEncadeadaEdital();

        while (_lista.lenght() > 0) {
            Edital _edital = _lista.rmInicio();
            if (_edital.getId_campus().equals(_id)) {
                _toReturn.addFinal(_edital);
            }
        }

        return _toReturn;
    }

    public ListaEncadeadaEdital getAllEditalByCursoId(Integer _id) throws IOException {
        ListaEncadeadaEdital _lista = getAllEdital(), _toReturn = new ListaEncadeadaEdital();

        while (_lista.lenght() > 0) {
            Edital _edital = _lista.rmInicio();
            if (_edital.getId_curso().equals(_id)) {
                _toReturn.addFinal(_edital);
            }
        }

        return _toReturn;
    }
}
