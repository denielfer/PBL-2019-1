
package coisas_para_davi;

public class MyAVLTree extends AVLTree {
    
    @Override
    No deleteNo(No node, int chave) {
        if(node == null)
            return node;
        else if( node.chave < chave ){
            node.direita = this.deleteNo(node.direita, chave);
        }
        else if( node.chave > chave ){
            node.esquerda = this.deleteNo(node.esquerda, chave);
        }
        else if( node.chave == chave ){
            if( node.direita == null || node.esquerda == null ){
                if( node.direita == null ){
                    node = node.esquerda;
                    node.altura = 1 + max(altura(node.esquerda), 
                              altura(node.direita)); 
                }else{
                    node = node.direita;
                    node.altura = 1 + max(altura(node.esquerda), 
                              altura(node.direita)); 
                }
            }else {
                No temp = node;
                node = node.direita;
                node = this.addBranch( node , temp.esquerda );
            }
        }
        this.rotations( node, chave );
        return node;
    }
    
    private No addBranch( No node, No branch  ){
        if( node == null){
            node = branch;
        }else if( node.chave < branch.chave) {
            node.direita = this.addBranch(node.direita, branch);
        }else if( node.chave > branch.chave ){
            node.esquerda = this.addBranch(node.esquerda, branch);
        }
        node.altura = 1 + max(altura(node.esquerda), 
                              altura(node.direita)); 
        node = this.rotations(node, branch.chave);
        return node;
    }
    
    private No rotations( No node, int chave ){
        int balance = getBalanceamento(node); 
  

        if (balance > 1 && getBalanceamento(node.esquerda) >= 0){ 
            return rotacaoDireita(node); 

        }else if(balance < -1 && getBalanceamento(node.direita) <= 0) {
            return rotacaoEsquerda(node); 

        }else if (balance > 1 && getBalanceamento(node.esquerda) < 0) { 
            node.esquerda = rotacaoEsquerda(node.esquerda); 
            return rotacaoDireita(node); 

        }else if (balance < -1 && getBalanceamento(node.direita) > 0) { 
            node.direita = rotacaoDireita(node.direita); 
            return rotacaoEsquerda(node); 
        } 
        return node;
    }

}
