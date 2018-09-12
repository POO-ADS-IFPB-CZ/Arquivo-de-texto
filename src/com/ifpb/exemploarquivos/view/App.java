package com.ifpb.exemploarquivos.view;

import com.ifpb.exemploarquivos.model.ManipulaArquivoTexto;

import java.io.File;
import java.io.IOException;

public class App {

    public static void main(String[] args) {

        try{
            ManipulaArquivoTexto manipula =
                    new ManipulaArquivoTexto("teste.txt");

//            System.out.println(manipula.getConteudo());

            manipula.imprimir("Exemplo de escrita");

        }catch(IOException ex){
            ex.printStackTrace();
        }


    }

}
