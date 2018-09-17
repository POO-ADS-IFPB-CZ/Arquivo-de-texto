package com.ifpb.exemploarquivos.dao;

import com.ifpb.exemploarquivos.model.Pessoa;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class PessoaDaoArquivo {

    private File file;

    public PessoaDaoArquivo() throws IOException {
        file = new File("Pessoa");

        if(!file.exists()){
            file.createNewFile();
        }

    }

    public Set<Pessoa> getPessoas() throws IOException, ClassNotFoundException {
        if(file.length()>0){
            try(ObjectInputStream in = new ObjectInputStream(
                    new FileInputStream(file))){
                return (Set<Pessoa>) in.readObject();
            }
        }else{
            return new HashSet<>();
        }
    }

    public boolean salvar(Pessoa pessoa) throws IOException, ClassNotFoundException {
        Set<Pessoa> pessoas = getPessoas();

        if(pessoas.add(pessoa)){
            atualizarArquivo(pessoas);
            return true;
        }else{
            return false;
        }
    }

    public boolean deletar(Pessoa pessoa) throws IOException, ClassNotFoundException {
        Set<Pessoa> pessoas = getPessoas();

        if(pessoas.remove(pessoa)){
            atualizarArquivo(pessoas);
            return true;
        }else{
            return false;
        }

    }

    private void atualizarArquivo(Set<Pessoa> pessoas) throws IOException {
        try(ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream(file))){
            out.writeObject(pessoas);
        }
    }

}
