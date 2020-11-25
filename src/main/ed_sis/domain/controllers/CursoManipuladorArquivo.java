package main.ed_sis.domain.controllers;

import main.ed_sis.domain.models.Campus;
import main.ed_sis.domain.models.Curso;

import java.io.*;

public class CursoManipuladorArquivo {
    private File cursoFile = new File("files/", "Curso.txt");

    public void insertCurso(Curso _curso) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(cursoFile, true));

        _curso.setId(CampusManipuladorArquivo.retornaId(6));

        writer.write(_curso.toString() + "\n");
        writer.flush();

        writer.close();
    }

    public Curso[] getAllCursos() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(cursoFile));

        int counter = 0;
        for (String linha = reader.readLine(); linha != null; linha = reader.readLine()) {
            counter++;
        }

        Curso[] cursos = new Curso[counter];
        reader = new BufferedReader(new FileReader(cursoFile));
        int i = 0;

        for (String linha = reader.readLine(); linha != null; linha = reader.readLine(), i++) {
            cursos[i] = new Curso(linha);
        }

        return cursos;
    }

    public boolean update(Curso _curso) throws IOException {
        File tempFile = new File("files/", "tempFile.txt");

        BufferedReader bufferedReader = new BufferedReader(new FileReader(cursoFile));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(tempFile, false));

        boolean hasBeenUpdated = false;
        int i = 0;
        for (String linha = bufferedReader.readLine(); linha != null; linha = bufferedReader.readLine(), i++) {
            if (!hasBeenUpdated && new Curso(linha).getId().equals(_curso.getId())) {
                hasBeenUpdated = true;
                bufferedWriter.write(_curso.toString() + "\n");
                bufferedWriter.flush();
            } else {
                bufferedWriter.write(linha + "\n");
                bufferedWriter.flush();
            }
        }

        bufferedReader.close();
        bufferedWriter.close();
        cursoFile.delete();
        tempFile.renameTo(cursoFile);

        return hasBeenUpdated;
    }

    public boolean delete(Integer _id) throws IOException {
        File tempFile = new File("files/", "tempFile.txt");

        BufferedReader bufferedReader = new BufferedReader(new FileReader(cursoFile));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(tempFile, false));

        boolean hasBeenDeleted = false;
        int i = 0;
        for (String linha = bufferedReader.readLine(); linha != null; linha = bufferedReader.readLine(), i++) {
            if (new Curso(linha).getId().equals(_id)) {
                hasBeenDeleted = true;
                continue;
            }

            bufferedWriter.write(linha + "\n");
            bufferedWriter.flush();
        }

        bufferedReader.close();
        bufferedWriter.close();
        cursoFile.delete();
        tempFile.renameTo(cursoFile);

        return hasBeenDeleted;
    }

    public Curso[] findByCampusId(Integer _id) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(cursoFile));

        Curso[] cursos = new Curso[1];

        for (String linha = reader.readLine(); linha != null; linha = reader.readLine()) {
            if (new Curso(linha).getId_campus().equals(_id)) {
                Curso[] aux = new Curso[cursos.length + 1];

                for (int i = 0; i < cursos.length; i++) {
                    aux[i] = cursos[i];
                }

                aux[aux.length - 1] = new Curso(linha);
                cursos = aux;
            }
        }

        return cursos;
    }

    public Curso findById(Integer _id) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(cursoFile));

        for (String linha = reader.readLine(); linha != null; linha = reader.readLine()) {
            if (new Curso(linha).getId().equals(_id))
                return new Curso(linha);
        }

        return null;
    }
}
