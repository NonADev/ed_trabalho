package main.ed_sis.domain.controllers;

import main.ed_sis.domain.estruturas.ListaEncadeadaEdital;
import main.ed_sis.domain.models.Edital;

import java.io.*;

public class EditalManipuladorArquivo {
    private File editalFile = new File("files/", "Edital");

//    public static void main(String[] args) throws IOException {
//        EditalManipuladorArquivo e = new EditalManipuladorArquivo();
//        e.insertEdital(new Edital("285839;null;null;null;10;6;4"));
//
//        Edital a = e.findById(285839);
//        a.setDefinicao_curso("akosdkasodkasdasdasd");
//
//        e.update(a);
//
//        e.getAllEdital().print();
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
            if (Integer.parseInt(linha.split(";")[0]) == _edital.getId()) {
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
            if (Integer.parseInt(linha.split(";")[0]) == _id) {
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
            if (Integer.parseInt(linha.split(";")[0]) == _id) {
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
}