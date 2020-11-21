package main.ed_sis.domain.controllers;

import main.ed_sis.domain.models.Admin;
import main.ed_sis.domain.models.Usuario;

import java.io.*;
import java.util.Random;

public class UsuarioAdminManipuladorArquivo {

    // retorna usuario atraves do (cpf || email) && senha
    public Usuario loginUsuario(String key, String password) throws IOException {
        BufferedReader buffReadUsuario = new BufferedReader(new FileReader("files/Usuario.txt"));
        String linhaUsuario = buffReadUsuario.readLine();

        Usuario usuario = new Usuario();
        while (true) {
            if (linhaUsuario != null) {
                String segments[] = linhaUsuario.split(";");
                if (key.contains("@") && (segments[3].equals(key) && segments[4].equals(password))) {
                    usuario.setId(Integer.parseInt(segments[0]));
                    usuario.setNome(segments[1]);
                    usuario.setCPF(segments[2]);
                    usuario.setEmail(segments[3]);
                    usuario.setSenha(segments[4]);
                    usuario.setRG(segments[5]);
                    usuario.setSexo(segments[6]);
                } else if (segments[2].equals(key) && segments[4].equals(password)) {
                    usuario.setId(Integer.parseInt(segments[0]));
                    usuario.setNome(segments[1]);
                    usuario.setRG(segments[2]);
                    usuario.setEmail(segments[3]);
                    usuario.setSenha(segments[4]);
                    usuario.setRG(segments[5]);
                    usuario.setSexo(segments[6]);
                }
            } else {
                break;
            }
            linhaUsuario = buffReadUsuario.readLine();
        }
        buffReadUsuario.close();
        return usuario;
    }

    // retorna aluno atraves do (cpf || email) && senha
    public Admin loginAdmin(String key, String password) throws IOException {
        BufferedReader buffReadAluno = new BufferedReader(new FileReader("files/Admin.txt"));
        String linhaAdm = buffReadAluno.readLine();

        Admin admin = new Admin();
        while (true) {

            if (linhaAdm != null) {

                String segments[] = linhaAdm.split(";");

                if (key.contains("@")) {
                    if (segments[3].equals(key) && segments[4].equals(password)) {

                        admin.setId(Integer.parseInt(segments[0]));
                        admin.setNome(segments[1]);
                        admin.setCPF(segments[2]);
                        admin.setEmail(segments[3]);
                        admin.setSenha(segments[4]);
                        admin.setRG(segments[5]);
                        admin.setSexo(segments[6]);
                    }
                } else {
                    if (segments[2].equals(key) && segments[4].equals(password)) {

                        admin.setId(Integer.parseInt(segments[0]));
                        admin.setNome(segments[1]);
                        admin.setCPF(segments[2]);
                        admin.setEmail(segments[3]);
                        admin.setSenha(segments[4]);
                        admin.setRG(segments[5]);
                        admin.setSexo(segments[6]);
                    }

                }

            } else
                break;
            linhaAdm = buffReadAluno.readLine();
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
