package com.ifpb.exemploarquivos.model;

import java.io.*;

public class ManipulaArquivoTexto {

    private File file;

    public ManipulaArquivoTexto(String path) throws IOException {
        file = new File(path);

        if(!file.exists()){
            file.createNewFile();
        }
    }

    public String getConteudo() throws IOException {

        if(file.length()==0){
            return "";
        }

        StringBuilder builder = new StringBuilder();

        try(BufferedReader reader = new BufferedReader(new FileReader(file))){

            String linha = reader.readLine();

            while(linha!= null){
                builder.append(linha);
                builder.append("\n");
                linha = reader.readLine();
            }
        }

        return builder.toString();

    }

    public boolean imprimir(String s) throws IOException {
        try(BufferedWriter writer = new BufferedWriter(
                new PrintWriter(
                        new FileWriter(file, false),true))){
            writer.write(s);
            writer.newLine();
            return true;
        }
    }

}
