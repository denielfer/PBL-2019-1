package coisas_para_davi;

import java.util.Scanner;

 public class UsingAVLTree
 {
	   public static void main(String[] args) { 
               //substituir pela classe implementada
               MyAVLTree tree = new MyAVLTree();
                tree.raiz = tree.inserir(tree.raiz, 5); 
                tree.raiz = tree.inserir(tree.raiz, 9); 
                tree.raiz = tree.inserir(tree.raiz, 1); 
                tree.raiz = tree.inserir(tree.raiz, 7); 
                tree.raiz = tree.inserir(tree.raiz, 10); 
                tree.raiz = tree.inserir(tree.raiz, -5); 
                tree.raiz = tree.inserir(tree.raiz, 2); 
                tree.raiz = tree.inserir(tree.raiz, 4); 
                tree.raiz = tree.inserir(tree.raiz, 6); 
	  
	        /* 
	                 5 
	             /         \ 
	            1           9 
	           /  \        /  \ 
	         -5    2      7    10 
                        \    /
                         4  6
                
                output esperado : 5 1 -5 2 4 9 7 6 10
                */
	        tree.preOrdem(tree.raiz); 
                System.out.append('\n');
                
                tree.raiz = tree.deleteNo(tree.raiz, 7);
                 /* 
	                 5 
	             /         \ 
	            1           9 
	           /  \        /  \ 
	         -5    2      6    10 
                        \    
                         4  
                
                output esperado : 5 1 -5 2 4 9 6 10
                */
                
	        tree.preOrdem(tree.raiz); 
                System.out.append('\n');
                
                tree.raiz = tree.deleteNo(tree.raiz, 5);
                 /* 
	                 2 
	            /         \       
                   1           9
                  /          /    \
                 -5        6      10
                          /
                         4
                output esperado : 2 1 -5 9 6 4 10
                */
                
	        tree.preOrdem(tree.raiz); 
                System.out.append('\n');
                
                tree.raiz = tree.deleteNo(tree.raiz, 9);
                 /* 
	                 2 
	            /         \       
                   1           6
                  /          /    \
                 -5         4     10
                       
                output esperado : 2 1 -5 6 4 10
                */
                
	        tree.preOrdem(tree.raiz); 
                System.out.append('\n');
                
                
	    } 
 }