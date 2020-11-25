package main.ed_sis.domain.controllers;

import main.ed_sis.domain.models.Curso;
import main.ed_sis.domain.models.Documento;
import main.ed_sis.domain.models.Usuario;

import java.io.*;

public class DocumentoManipuladorArquivo {
    private File documentoFile = new File("files/", "Documento.txt");

    public static void main(String[] args) throws IOException {
        DocumentoManipuladorArquivo d = new DocumentoManipuladorArquivo();

//        Documento[] documentos = d.getAllDocumentos();
//
//        documentos = quickSort(documentos, 0, documentos.length-1);
//
//        for (int i=0;i<documentos.length;i++){
//            System.out.println(documentos[i].getId());
//        }

        UsuarioAdminManipuladorArquivo u = new UsuarioAdminManipuladorArquivo();

        d.cadastrarUsuario(u.getUsuarioById(456754),888913);
    }

    public void cadastrarUsuario(Usuario usuario, Integer id_edital) throws IOException {
        Documento documento = new Documento();

        documento.setId_usuario(usuario.getId());
        documento.setId_edital(id_edital);

        documento.setId(CampusManipuladorArquivo.retornaId(6));
        documento.setNome("RG");
        documento.setValor(usuario.getRG());

        insertDocumento(documento);

        documento.setId(CampusManipuladorArquivo.retornaId(6));
        documento.setNome("CPF");
        documento.setValor(usuario.getCPF());

        insertDocumento(documento);
    }

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

    public Documento[] findByEditalId(Integer _id) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(documentoFile));

        Documento[] documentos = new Documento[0];

        for (String linha = reader.readLine(); linha != null; linha = reader.readLine()) {
            if (new Documento(linha).getId_edital().equals(_id)) {
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

    public static Documento[] quickSort(Documento v[], int esquerda, int direita) {
        int esq = esquerda;
        int dir = direita;
        Documento pivo = v[(esq + dir) / 2];
        Documento troca;

        while (esq <= dir) {
            while (v[esq].getId() < pivo.getId()) {
                esq = esq + 1;
            }
            while (v[dir].getId() > pivo.getId()) {
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
}
