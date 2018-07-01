/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tdas;

import java.util.Iterator;

/**
 *
 * @author santiago
 */
public class DoublyLinkedList<E> implements List<E>{
    
    private Nodo<E> first,last;
    private int efectivo;
    
    public DoublyLinkedList(){
        this.first = this.last =null;
        efectivo = 0 ;
    }
    @Override
    public boolean isEmty() {
        return (this.first == null && this.last == null);
    }

    @Override
    public int size() {
        return efectivo;
    }

    @Override
    public boolean addFirst(E element) {
        Nodo<E> nodo = new Nodo<> (element);
        if (element ==null)
            return false;
        else if(this.isEmty())
            this.first = this.last = nodo;
        else {
            nodo.setNext(this.first);
            this.first.setPreviuos(nodo);
            this.first = nodo;            
        }
        efectivo++;
        return true;
    }

    @Override
    public boolean addLast(E element) {
        Nodo<E> nodo = new Nodo<> (element);
        if (element ==null)
            return false;
        else if(this.isEmty())
            this.first = this.last = nodo;
        else {
            this.last.setNext(nodo);
            nodo.setPreviuos(this.last);
            this.last = nodo;
        }
        efectivo++;
        return true;    
    }

    @Override
    public E getFirst() {
        if (this.isEmty())
            return null;
        return this.first.getData();
    }

    @Override
    public E getLast() {
        if (this.isEmty())
            return null;
        return this.last.getData();
    }

    @Override
    public boolean removeFirst() {
        if (this.isEmty())
            return false;
        else if ( this.first == this.last)
            this.first = this.last = null;
        else {
            Nodo<E> tmp = this.first.getNext();
            this.first.setNext(null);
            this.first = tmp;
            this.first.setPreviuos(null);
        }
        return true;
    }

    @Override
    public boolean removeLast() {
        if (this.isEmty())
            return false;
        else if ( this.first == this.last)
            this.first = this.last = null;
        else {
            Nodo<E> tmp = this.last.getPreviuos();
            this.last.setPreviuos(null);
            this.last = tmp;
            this.last.setNext(null);
        }
        return true;    }

    @Override
    public boolean contains(E element) {
        if(this.isEmty())
            return false;
        else{
            Nodo<E> p,q;
            p=this.first;
            q=this.last;
            while(!(q.getNext() == p) && (p!=q)){
                if(q.getData().equals(element)||  p.getData().equals(element))
                    return true;
                p = p.getNext();
                q = q.getPreviuos();
            }
        return false;
        }

    }

    @Override
    public E get(int index) {
        int cont = 0 ;
        if(index>=0 && index <efectivo){
            for(Nodo<E> p = this.first ; p!=null ; p= p.getNext()){
                 if(cont==index-1)
                     return p.getData();
                 cont++;
            }
        }
        return null;
    }

    @Override
    public List slicing(int inicio, int fin) {
        int cont = 0;
        DoublyLinkedList<E> lista = new DoublyLinkedList<>();
        if(inicio< fin && fin< efectivo && inicio>0){
        for(Nodo<E> p = this.first ; p!=null ; p = p.getNext()){
            if(cont >= inicio-1 && cont <= fin-1 )
                lista.addLast(p.getData());
            cont++;   
        }}
        return lista;
    }

    @Override
    public boolean remove(int index) {
        int cont = 0 ;
        if(this.isEmty())
            return false;
        else if(index>=0 && index <efectivo){
        for(Nodo<E> p = this.first ; p!=null ; p= p.getNext()){
             if(cont==index-1){
                 p.getPreviuos().setNext(p.getNext());
                 p.setNext(null);
                 p.setPreviuos(null);
                 return true;
                }
             cont++;
        }}
        return false;
    }

    @Override
    public E set(int index, E element) {
        if(this.isEmty())
            return null;
        if(index>=0 && index <efectivo || element != null){
            int cont = 0;
            for(Nodo<E> p = this.first ; p!=null ; p= p.getNext()){
                 if(cont==index-1){
                     E tmp = p.getData();
                     p.setData(element);
                     return tmp;
                     }
                 cont++;
            }     
        }
        return null;
    }

    @Override
    public boolean add(int index, E element) {
          if(this.isEmty())
            return false;
        if(index>=0 && index <efectivo || element != null){
            int cont = 0;
            for(Nodo<E> p = this.first ; p!=null ; p= p.getNext()){
                if(cont==index-1){
                     Nodo<E> nuevo = new Nodo<>(element);
                     Nodo<E> tmp = p.getPreviuos();
                     nuevo.setPreviuos(tmp);
                     p.setPreviuos(nuevo);
                     tmp.setNext(nuevo);
                     nuevo.setNext(p);
                     return true;
                }
                 cont++;}
        }
        return false;
    }

    @Override
    public int indexOf(Object element) {
        if(this.isEmty())
            return 0;
        if(element != null){
            int cont = 0;
            for(Nodo<E> p = this.first ; p!=null ; p= p.getNext()){
                if(p.getData().equals(element))
                    return cont+1;
                 cont++;}
        }
        return 0;
    }
    
     @Override
    public String toString() {
        String cadena = "[";
        for(Nodo<E> p =this.first ; p!=null; p=p.getNext()){
            cadena = cadena + p.getData();
            if( p.getNext() != null)
                cadena += ",";
        }
        cadena+="]";
        
     return cadena;   
    }   
    
}
