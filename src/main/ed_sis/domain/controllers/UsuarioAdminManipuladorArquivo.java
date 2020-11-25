package main.ed_sis.domain.controllers;

import main.ed_sis.domain.estruturas.PilhaUsuario;
import main.ed_sis.domain.models.Admin;
import main.ed_sis.domain.models.Usuario;

import java.io.*;
import java.util.Random;

public class UsuarioAdminManipuladorArquivo {
//    public static void main(String[] args) throws IOException {
//        UsuarioAdminManipuladorArquivo usuarioAdminManipuladorArquivo = new UsuarioAdminManipuladorArquivo();
//
//        PilhaUsuario pilhaUsuario = usuarioAdminManipuladorArquivo.getAllUsuarios();
//
//        pilhaUsuario.print();
//    }

    public Usuario getUsuarioById(Integer _id) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("files/Usuario.txt"));

        for (String linha = bufferedReader.readLine(); linha != null; linha = bufferedReader.readLine()) {
            if (new Usuario(linha).getId().equals(_id)) {
                bufferedReader.close();
                return new Usuario(linha);
            }
        }

        bufferedReader.close();
        return null;
    }

    public boolean update(Usuario _usuario) throws IOException {
        File usuariosFile = new File("files/", "Usuario.txt");
        File tempFile = new File("files/", "tempFile.txt");

        BufferedReader bufferedReader = new BufferedReader(new FileReader(usuariosFile));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(tempFile, false));

        boolean hasBeenUpdated = false;
        int i = 0;
        for (String linha = bufferedReader.readLine(); linha != null; linha = bufferedReader.readLine(), i++) {
            if (new Usuario(linha).getId() == _usuario.getId()) {
                hasBeenUpdated = true;
                bufferedWriter.write(_usuario.toString() + "\n");
                bufferedWriter.flush();
            } else {
                bufferedWriter.write(linha + "\n");
                bufferedWriter.flush();
            }
        }

        bufferedWriter.close();
        bufferedReader.close();
        usuariosFile.delete();
        tempFile.renameTo(usuariosFile);

        return hasBeenUpdated;
    }

    public boolean delete(Integer _id) throws IOException {
        File usuariosFile = new File("files/", "Usuario.txt");
        File tempFile = new File("files/", "tempFile.txt");

        BufferedReader bufferedReader = new BufferedReader(new FileReader(usuariosFile));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(tempFile, false));

        boolean hasBeenDeleted = false;
        int i = 0;
        for (String linha = bufferedReader.readLine(); linha != null; linha = bufferedReader.readLine(), i++) {
            if (new Usuario(linha).getId() == _id) {
                hasBeenDeleted = true;
                continue;
            }

            bufferedWriter.write(linha + "\n");
            bufferedWriter.flush();
        }

        bufferedReader.close();
        bufferedWriter.close();
        usuariosFile.delete();
        tempFile.renameTo(usuariosFile);

        return hasBeenDeleted;
    }

    public PilhaUsuario getAllUsuarios() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("files/Usuario.txt"));
        PilhaUsuario pilhaUsuario = new PilhaUsuario();

        for (String linha = bufferedReader.readLine(); linha != null; linha = bufferedReader.readLine()) {
            Usuario _usuario = new Usuario(linha);

            pilhaUsuario.empilhar(_usuario);
        }

        bufferedReader.close();
        return pilhaUsuario;
    }

    // retorna usuario atraves do (cpf || email) && senha
    public Usuario loginUsuario(String key, String password) throws IOException {
        BufferedReader buffReadUsuario = new BufferedReader(new FileReader("files/Usuario.txt"));

        Usuario usuario = new Usuario();

        for (String linhaUsuario = buffReadUsuario.readLine(); linhaUsuario != null; linhaUsuario = buffReadUsuario.readLine()) {
            Usuario aux = new Usuario(linhaUsuario);

            if ((key.contains("@") && (aux.getEmail().equals(key) && aux.getSenha().equals(password)))
                    || (aux.getCPF().equals(key) && aux.getSenha().equals(password))) {
                usuario = aux;
            }
        }

        buffReadUsuario.close();
        return usuario;
    }

    // retorna aluno atraves do (cpf || email) && senha
    public Admin loginAdmin(String key, String password) throws IOException {
        BufferedReader buffReadAluno = new BufferedReader(new FileReader("files/Admin.txt"));

        Admin admin = new Admin();

        for (String linhaAdm = buffReadAluno.readLine(); linhaAdm != null; linhaAdm = buffReadAluno.readLine()) {
            Admin aux = new Admin(linhaAdm);

            if ((key.contains("@") && (aux.getEmail().equals(key) && aux.getSenha().equals(password)))
                    || (aux.getCPF().equals(key) && aux.getSenha().equals(password))) {
                admin = aux;
            }
        }

        buffReadAluno.close();
        return admin;
    }


    // Adiciona aluno no arquivo txt
    public void insereUsuario(Usuario usuario) throws IOException {
        String nomeArquivo = "Usuario.txt";
        File arq = new File("files/", nomeArquivo);

        String conteudo = retornaId(6) + ";" + usuario.getNome() + ";" + usuario.getCPF() + ";" + usuario.getEmail()
                + ";" + usuario.getSenha() + ";" + usuario.getRG() + ";" + usuario.getSexo() + "\n";
        FileWriter writer = new FileWriter(arq, true);
        PrintWriter print = new PrintWriter(writer);

        print.write(conteudo);
        print.flush();
        print.close();
        writer.close();
    }

    public int retornaId(int digitos) {
        digitos = 6;

        int minimum = (int) Math.pow(10, digitos - 1);
        int maximum = (int) Math.pow(10, digitos) - 1;
        Random random = new Random();
        return minimum + random.nextInt((maximum - minimum) + 1);
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


}
