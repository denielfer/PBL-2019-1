package coisas_para_davi;

abstract class AVLTree { 
  
    No raiz = null; 
  
    int altura(No N) { 
        if (N == null) 
            return 0; 
  
        return N.altura; 
    } 
  
    // retorna o valor maior entre dois inteiros 
    int max(int a, int b) { 
        return (a > b) ? a : b; 
    } 
  
    No rotacaoDireita(No y) { 
        No x = y.esquerda; 
        No T2 = x.direita; 
  
        // rotação
        x.direita = y; 
        y.esquerda = T2; 
  
        // atualiza altura
        y.altura = max(altura(y.esquerda), altura(y.direita)) + 1; 
        x.altura = max(altura(x.esquerda), altura(x.direita)) + 1; 
  
        // retorna nova raiz
        return x; 
    }
  
    No rotacaoEsquerda(No x) {
        No y = x.direita; 
        No T2 = y.esquerda; 
  
        // Perform rotation 
        y.esquerda = x; 
        x.direita = T2; 
  
        //  Update heights 
        x.altura = max(altura(x.esquerda), altura(x.direita)) + 1; 
        y.altura = max(altura(y.esquerda), altura(y.direita)) + 1; 
  
        // Return new root 
        return y; 
    	
    }
  
    // obtém o valor de balanceamento de nó N 
    int getBalanceamento(No N) { 
        if (N == null) 
            return 0; 
  
        return altura(N.esquerda) - altura(N.direita); 
    } 
  
    No inserir(No node, int chave) { 
  
        /* 1.  Executa a inserção tradicional de árvore binária de busca */
        if (node == null) 
            return (new No(chave)); 
  
        if (chave < node.chave) 
            node.esquerda = inserir(node.esquerda, chave); 
        else if (chave > node.chave) 
            node.direita = inserir(node.direita, chave); 
        else // duplicação de chaves não é permitida
            return node; 
  
        /* 2. Atualiza altura deste nó pai */
        node.altura = 1 + max(altura(node.esquerda), 
                              altura(node.direita)); 
  
    /* 3. Obtém o fator de balanceamento deste nó pai para checar se ele agora está desbalanceado */
    int balance = getBalanceamento(node); 

    // Se o nó está desbalanceado, então existe 4 casos 
    // esquerda
    if (balance > 1 && chave < node.esquerda.chave) 
        return rotacaoDireita(node); 

    // direita  
    if (balance < -1 && chave > node.direita.chave) 
        return rotacaoEsquerda(node); 

    // esquerda direita 
    if (balance > 1 && chave > node.esquerda.chave) { 
        node.esquerda = rotacaoEsquerda(node.esquerda); 
        return rotacaoDireita(node); 
    } 

    // direita esquerda 
    if (balance < -1 && chave < node.direita.chave) { 
        node.direita = rotacaoDireita(node.direita); 
        return rotacaoEsquerda(node); 
    } 
  
        return node; 
    } 
  
    void preOrdem(No node) { 
        if (node != null) { 
            System.out.print(node.chave + " "); 
            preOrdem(node.esquerda); 
            preOrdem(node.direita); 
        } 
    } 
    
    abstract No deleteNo(No node, int chave);
  
 
} 
