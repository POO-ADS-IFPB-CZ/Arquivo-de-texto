package com.ifpb.exemploarquivos.view;

import com.ifpb.exemploarquivos.dao.PessoaDaoArquivo;
import com.ifpb.exemploarquivos.model.ManipulaArquivoTexto;
import com.ifpb.exemploarquivos.model.Pessoa;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

public class App {

    public static void main(String[] args) {

        try{
            PessoaDaoArquivo dao = new PessoaDaoArquivo();

//            System.out.println(dao.salvar(new Pessoa("222.222.222-02",
//                    "Maria", LocalDate.now())));

            System.out.println(dao.deletar(new Pessoa("222.222.222-02",
                    null, null)));

            System.out.println(dao.getPessoas());

        }catch(ClassNotFoundException ex){
            ex.printStackTrace();
        }catch(IOException ex){
            ex.printStackTrace();
        }

    }

}
