package main.ed_sis.domain.controllers;

import main.ed_sis.domain.estruturas.ListaDuplamenteEncadeadaCampus;
import main.ed_sis.domain.models.Campus;

import java.io.*;
import java.util.Random;

public class CampusManipuladorArquivo {
//    public static void main(String[] args) throws IOException {
//        CampusManipuladorArquivo campusManipuladorArquivo = new CampusManipuladorArquivo();
//        Campus campus = campusManipuladorArquivo.findById(727640);
//
//        campus.setNome("krustacio");
//
//        campusManipuladorArquivo.update(campus);
//    }

    public boolean delete(Integer _id) throws IOException {
        File campusFile = new File("files/", "Campus.txt");
        File tempFile = new File("files/", "tempFile.txt");

        BufferedReader bufferedReader = new BufferedReader(new FileReader(campusFile));
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
        campusFile.delete();
        tempFile.renameTo(campusFile);

        return hasBeenDeleted;
    }

    public boolean update(Campus _campus) throws IOException {
        File campusFile = new File("files/", "Campus.txt");
        File tempFile = new File("files/", "tempFile.txt");

        BufferedReader bufferedReader = new BufferedReader(new FileReader(campusFile));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(tempFile, false));

        boolean hasBeenUpdated = false;
        int i = 0;
        for (String linha = bufferedReader.readLine(); linha != null; linha = bufferedReader.readLine(), i++) {
            if (Integer.parseInt(linha.split(";")[0]) == _campus.getId()) {
                hasBeenUpdated = true;
                bufferedWriter.write(_campus.toString() + "\n");
                bufferedWriter.flush();
            } else {
                bufferedWriter.write(linha + "\n");
                bufferedWriter.flush();
            }
        }

        bufferedReader.close();
        bufferedWriter.close();
        campusFile.delete();
        tempFile.renameTo(campusFile);

        return hasBeenUpdated;
    }

    public Campus findById(Integer _id) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("files/Campus.txt"));

        for (String linha = bufferedReader.readLine(); linha != null; linha = bufferedReader.readLine()) {
            if (Integer.parseInt(linha.split(";")[0]) == _id) {
                bufferedReader.close();
                return new Campus(linha);
            }
        }
        bufferedReader.close();
        return null;
    }

    public ListaDuplamenteEncadeadaCampus getAllCampus() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("files/Campus.txt"));
        ListaDuplamenteEncadeadaCampus listaDuplamenteEncadeadaCampus = new ListaDuplamenteEncadeadaCampus();

        for (String linha = bufferedReader.readLine(); linha != null; linha = bufferedReader.readLine()) {
            listaDuplamenteEncadeadaCampus.addFinal(new Campus(linha));
        }

        bufferedReader.close();
        return listaDuplamenteEncadeadaCampus;
    }

    public void insertCampus(Campus _campus) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("files/", "Campus.txt"), true));

        _campus.setId(retornaId(6));

        bufferedWriter.write(_campus.toString() + "\n");
        bufferedWriter.flush();

        bufferedWriter.close();
    }

    public static int retornaId(int digitos) {
        int minimum = (int) Math.pow(10, digitos - 1);
        int maximum = (int) Math.pow(10, digitos) - 1;
        Random random = new Random();
        return minimum + random.nextInt((maximum - minimum) + 1);
    }
}
