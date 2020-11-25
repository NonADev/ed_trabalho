package main.ed_sis.domain.controllers;

import main.ed_sis.domain.models.Curso;
import main.ed_sis.domain.models.Documento;

import java.io.*;

public class DocumentoManipuladorArquivo {
    private File documentoFile = new File("files/", "Documento.txt");

    public void insertDocumento(Documento documento) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(documentoFile, true));

        documento.setId(CampusManipuladorArquivo.retornaId(6));

        writer.write(documento.toString() + "\n");
        writer.flush();

        writer.close();
    }

    public Documento[] getAllDocumentos() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(documentoFile));

        int counter = 0;
        for (String linha = reader.readLine(); linha != null; linha = reader.readLine()) {
            counter++;
        }

        Documento[] documentos = new Documento[counter];
        reader = new BufferedReader(new FileReader(documentoFile));
        int i = 0;

        for (String linha = reader.readLine(); linha != null; linha = reader.readLine(), i++) {
            documentos[i] = new Documento(linha);
        }

        return documentos;
    }

    public Documento findByEditalId(Integer _id) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(documentoFile));

        for (String linha = reader.readLine(); linha != null; linha = reader.readLine()) {
            if (new Documento(linha).getId_edital().equals(_id))
                return new Documento(linha);
        }

        return null;
    }

    public Documento[] findByUsuarioId(Integer _id) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(documentoFile));

        Documento[] documentos = new Documento[0];

        for (String linha = reader.readLine(); linha != null; linha = reader.readLine()) {
            if (new Documento(linha).getId_usuario().equals(_id)) {
                Documento[] aux = new Documento[documentos.length + 1];

                for (int i = 0; i < documentos.length; i++) {
                    aux[i] = documentos[i];
                }

                aux[aux.length - 1] = new Documento(linha);
                documentos = aux;
            }
        }

        return documentos;
    }

    public boolean delete(Integer _id) throws IOException {
        File tempFile = new File("files/", "tempFile.txt");

        BufferedReader bufferedReader = new BufferedReader(new FileReader(documentoFile));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(tempFile, false));

        boolean hasBeenDeleted = false;
        int i = 0;
        for (String linha = bufferedReader.readLine(); linha != null; linha = bufferedReader.readLine(), i++) {
            if (new Documento(linha).getId().equals(_id)) {
                hasBeenDeleted = true;
                continue;
            }

            bufferedWriter.write(linha + "\n");
            bufferedWriter.flush();
        }

        bufferedReader.close();
        bufferedWriter.close();
        documentoFile.delete();
        tempFile.renameTo(documentoFile);

        return hasBeenDeleted;
    }

    public boolean update(Curso _curso) throws IOException {
        File tempFile = new File("files/", "tempFile.txt");

        BufferedReader bufferedReader = new BufferedReader(new FileReader(documentoFile));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(tempFile, false));

        boolean hasBeenUpdated = false;
        int i = 0;
        for (String linha = bufferedReader.readLine(); linha != null; linha = bufferedReader.readLine(), i++) {
            if (!hasBeenUpdated && new Documento(linha).getId().equals(_curso.getId())) {
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
        documentoFile.delete();
        tempFile.renameTo(documentoFile);

        return hasBeenUpdated;
    }
}
