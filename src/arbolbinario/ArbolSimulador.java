/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolbinario;

import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
/**
 *
 * @author TAURUS
 */
public class ArbolSimulador {
    Arbol miArbol = new Arbol();

    public ArbolSimulador() {
    }

    public boolean insertar(Integer dato) {
        return (this.miArbol.agregar(dato));
    }

    public String imprimirPorNiveles() {
        ArrayList it = this.miArbol.impNiveles();
        return (recorrido(it, "Imprimir Por niveles"));
    }

    public String darHojas() {
        ArrayList it = this.miArbol.getHojas();
        return (recorrido(it, "Hojas del Arbol"));
    }

    public String darPadre(Integer hijo) {
        if (this.miArbol.getRaiz().getDato() == (hijo)) {
            
            JOptionPane.showMessageDialog(null, "La raiz no tiene padre");
            //return;
        }
        Integer padre = this.miArbol.padre(hijo);
        if (padre == null) {
            JOptionPane.showMessageDialog(null, "No existe el Dato");
            //return ("No existe el Dato: " + hijo.toString());
        }
        return (padre.toString());
    }
    public String esta(Integer dato) {
        boolean siEsta = this.miArbol.buscar(dato);
        String r = "El dato:" + dato.toString() + "\n";
        r += siEsta ? "Si se encuentra en el arbol" : "No se encuentra en el arbol";
        return (r);
    }
    private String recorrido(ArrayList it, String msg) {
        int i = 0;
        String r = msg ;
        while (i < it.size()) {
            r += it.get(i).toString();
            i++;
        }
        return (r);
    }
    
    public String CantidadNodos(){
        return this.miArbol.cantidadNodos();
    }
    
    public String CantidadHojas(){
        return this.miArbol.cantidadNodosHoja();
    }
    public String alturaArbol(){
        return this.miArbol.retornarAltura();
    }
    public String porNivel(){
        this.miArbol.alturaArbol();
        ArrayList it = this.miArbol.imprimirNivel();
        return (recorrido(it,""));
    }
    public String ramaMayor() {
        ArrayList it = this.miArbol.ObtenerRamamayor();
        return (recorrido(it, "Rama(s) con mas valores"));
    }
    

    public JPanel getDibujo() {
        return this.miArbol.getdibujo();
    }
}
