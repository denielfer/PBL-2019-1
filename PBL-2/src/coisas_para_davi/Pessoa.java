/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coisas_para_davi;

/**
 *
 * @author dfc15
 */
public class Pessoa implements Elemento{
    private String nome,cpf,contato;
    public Pessoa(String nome,String cpf,String contato){
        this.nome = nome;
        this.cpf = cpf;
        this.contato = contato;
    }

    @Override
    public void printInformation() {
        System.out.println("nome: "+nome+"|Cpf: "+cpf+"|Contato: "+contato);
    }
}
