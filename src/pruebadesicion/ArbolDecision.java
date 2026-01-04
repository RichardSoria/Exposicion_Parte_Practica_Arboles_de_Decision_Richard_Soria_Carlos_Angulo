/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebadesicion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ArbolDecision {

    private HashMap<Integer, String> mapResultado;
    private boolean res = false;

    public void grafica(String path) {
        raiz.graficar(path);
    }

    static BufferedReader e = new BufferedReader(new InputStreamReader(System.in));
    Nodo raiz = null;

    public ArbolDecision() {
    }

    public void crearRaiz(int nodoID, String cuerpo) {
        res = true;
        raiz = new Nodo(nodoID, cuerpo);
        System.out.println("Nodo raíz creado " + nodoID);
    }

    /* ADD NODO SI */
    public void addNodoSI(int IDrefNodo, int nuevoNodoID, String cuerpo) {

        if (raiz == null) {
            System.out.println("ERROR: No hay nodo raíz!");
            return;
        }

        if (buscarArbolyAgregarNodoSI(raiz, IDrefNodo, nuevoNodoID, cuerpo)) {
            System.out.println("Agregando nodo " + nuevoNodoID
                    + " en Rama \"SI\" del nodo " + IDrefNodo);
        } else {
            System.out.println("Nodo " + IDrefNodo + " no Encontrado");
        }
    }

    /* Buscar Arbol y Agregar Nodo SI */
    private boolean buscarArbolyAgregarNodoSI(Nodo nodoActal,
            int IDrefNodo, int nuevoNodoID, String cuerpo) {
        if (nodoActal.nodoID == IDrefNodo) {
            if (nodoActal.ramaSI == null) {
                nodoActal.ramaSI = new Nodo(nuevoNodoID, cuerpo);
            } else {
                System.out.println("ADVERTENCIA: Sobrescritura del nodo anterior"
                        + "(id =" + nodoActal.ramaSI.nodoID
                        + ") vinculado a la rama SI del nodo"
                        + IDrefNodo);
                nodoActal.ramaSI = new Nodo(nuevoNodoID, cuerpo);
            }
            return (true);
        } else {
            if (nodoActal.ramaSI != null) {
                if (buscarArbolyAgregarNodoSI(nodoActal.ramaSI,
                        IDrefNodo, nuevoNodoID, cuerpo)) {
                    return (true);
                } else {
                    if (nodoActal.ramaNO != null) {
                        return (buscarArbolyAgregarNodoSI(nodoActal.ramaNO,
                                IDrefNodo, nuevoNodoID, cuerpo));
                    } else {
                        return (false);
                    }
                }
            }
            return (false);
        }
    }

    public void addNodoNO(int IDrefNodo, int nuevoNodoID, String cuerpo) {
        if (raiz == null) {
            System.out.println("ERROR: No existe un Nodo Raiz!");
            return;
        }
        if (buscarArbolyAgregarNodoNO(raiz, IDrefNodo, nuevoNodoID, cuerpo)) {
            System.out.println("Agregando nodo " + nuevoNodoID
                    + " en rama \"NO\" del Nodo " + IDrefNodo);
        } else {
            System.out.println("Nodo " + IDrefNodo + " no Enocntrado!");
        }
    }

    private boolean buscarArbolyAgregarNodoNO(Nodo currentNode,
            int existingNodeID, int newNodeID, String newQuestAns) {
        if (currentNode.nodoID == existingNodeID) {
            if (currentNode.ramaNO == null) {
                currentNode.ramaNO = new Nodo(newNodeID, newQuestAns);
            } else {
                System.out.println("ADVERTENCIA: Sobrescritura del nodo anterior "
                        + "(id = " + currentNode.ramaNO.nodoID
                        + ") vinculado a la rama NO del nodo "
                        + existingNodeID);
                currentNode.ramaNO = new Nodo(newNodeID, newQuestAns);
            }
            return (true);
        } else {
            if (currentNode.ramaSI != null) {
                if (buscarArbolyAgregarNodoNO(currentNode.ramaSI,
                        existingNodeID, newNodeID, newQuestAns)) {
                    return (true);
                } else {
                    if (currentNode.ramaNO != null) {
                        return (buscarArbolyAgregarNodoNO(currentNode.ramaNO,
                                existingNodeID, newNodeID, newQuestAns));
                    } else {
                        return (false);
                    }
                }
            } else {
                return (false);
            }
        }
    }

    public void consultaArbolBinario() throws IOException {
        consultaArbolBinario(raiz);
    }

    private void consultaArbolBinario(Nodo nodoActual) throws IOException {
        mapResultado = new HashMap<>();
        if (nodoActual.ramaSI == null && nodoActual.ramaNO == null) {
            System.out.println(nodoActual.pregunOrResp);
            mapResultado.put(nodoActual.nodoID, nodoActual.pregunOrResp);
            return;
        } else if (nodoActual.ramaSI != null && nodoActual.ramaNO == null) {
            System.out.println(nodoActual.pregunOrResp);
            mapResultado.put(nodoActual.nodoID, nodoActual.pregunOrResp);
//            return;
        } else if (nodoActual.ramaSI == null && nodoActual.ramaNO != null) {
            System.out.println(nodoActual.pregunOrResp);
            mapResultado.put(nodoActual.nodoID, nodoActual.pregunOrResp);
//            return;
        }
        // preguntar
        preguntar(nodoActual);

    }

    private void preguntar(Nodo nodoActual) throws IOException {
        System.out.println(nodoActual.pregunOrResp + " (Ingresa \"Si\" o \"No\")");
        String respuesta = JOptionPane.showInputDialog(nodoActual.pregunOrResp + " (Ingresa \"Si\" o \"No\")");
        if (respuesta.equalsIgnoreCase("Si")) {
            if (nodoActual.ramaSI != null) {
                consultaArbolBinario(nodoActual.ramaSI);
            } else {
                System.out.println("NO HAY OPCION SI");
                JOptionPane.showMessageDialog(null, "NO HAY OPCION SI", "AVISO", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            if (respuesta.equalsIgnoreCase("No")) {
                if (nodoActual.ramaNO != null) {
                    consultaArbolBinario(nodoActual.ramaNO);
                } else {
                    System.out.println("NO HAY OPCION NO");
                    JOptionPane.showMessageDialog(null, "NO HAY OPCION NO", "AVISO", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                System.out.println("ERROR: Debe responder \"Si\" o \"No\"");
                preguntar(nodoActual);
            }
        }
    }

    public void salidaArbolBin() {
        salidaArbolBin("1", raiz);
    }

    private void salidaArbolBin(String tag, Nodo currentNode) {

        // Check for empty node
        if (currentNode == null) {
            return;
        }

        // Output
        System.out.println("[" + tag + "] nodoID = " + currentNode.nodoID
                + ", cuerpo = " + currentNode.pregunOrResp);

        // Go down yes branch
        salidaArbolBin(tag + ".1", currentNode.ramaSI);

        // Go down no branch
        salidaArbolBin(tag + ".2", currentNode.ramaNO);
    }

    public JPanel getdibujo() {
        return new Graficador(this);
    }

    public HashMap<Integer, String> getMap() {
        return mapResultado;
    }

    public boolean getRes() {
        return res;
    }
}
