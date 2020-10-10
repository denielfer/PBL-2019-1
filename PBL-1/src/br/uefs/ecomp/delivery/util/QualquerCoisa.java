/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uefs.ecomp.delivery.util;

import br.uefs.ecomp.delivery.model.Cardapio;
import br.uefs.ecomp.delivery.model.Cliente;
import br.uefs.ecomp.delivery.model.ItemPedido;
import br.uefs.ecomp.delivery.model.Pedido;
import java.util.Date;

/**
 *
 * @author Daniel Fernandes Campos
 */
public abstract class QualquerCoisa {

    public Cliente getCliente() {
        return null;
    }

    protected void addItem(ItemPedido item){
    }

    public Date getDataHora() {
        return new Date(1553303046);
    }

    public boolean getSituacao() {
        return true;
    }

    public void update(ItemPedido item){
    }

    public void setEndereco(String endereço) {
    }

    public String getEndereco() {
        return "";
    }

    public ListaUsavel getItens(){
        return new ListaUsavel();
    }
        
    private double calcularValorTotal(){
        return (double) 1.0;
    }

    public void setFechado(){
    };

    public boolean getSituaçao(){
        return true;
    }

    public double getValorTotal(){
        return (double)1.0;
    }
    
       private void update(){
    }
 
    public Pedido getPedido() {
        return null;
    }

    public void setPedido(Pedido pedido) {
    }

    public Cardapio getOpcaoMenu() {
        return null;
    }

    public void setOpcaoMenu(Cardapio prato) {
    }

    public int getQuantidade() {
        return 1;
    }

    public void setQuantidade(int quantidade) {
    }

    public String getObservacao() {
        return "";
    }

    public void setObservacao(String descriçao) {
    }

    public String getDescricao() {
        return "";
    }

    public void setDescricao(String descriçao) {
    }

    public double getValor() {
        return 1.0;
    }

    public void setValor(double price) {
    }

    public boolean equals(Cardapio obj){
        return false;
    }
 
    public void setNumber(int i){
    }

    public int getNumber(){
        return 1;
    }
    
    public String getName() {
        return "";
    }

    public void setName(String name) {
    }


    public String getPhone() {
        return "";
    }


    public void setPhone(String foneNumber) {
    }


    public String getEmail() {
        return "";
    }

    public void setEmail(String email) {
    }
        
    public boolean equals(Cliente obj){
        return false;
    }
    
}
