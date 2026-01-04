/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebadesicion;

import java.io.FileWriter;
import java.io.PrintWriter;

public class Nodo {

    int nodoID;
    String pregunOrResp = null;
    Nodo ramaSI = null;
    Nodo ramaNO = null;

    public Nodo(int nuevoID, String nuevaPregRes) {
        nodoID = nuevoID;
        pregunOrResp = nuevaPregRes;
    }

    public void graficar(String path) {
        FileWriter fichero = null;
        PrintWriter escritor;
        try {
            fichero = new FileWriter("aux_grafico.dot");
            escritor = new PrintWriter(fichero);
            escritor.print(getCodigoGraphviz());
        } catch (Exception e) {
            System.err.println("Error al escribir el archivo aux_grafico.dot");
        } finally {
            try {
                if (null != fichero) {
                    fichero.close();
                }
            } catch (Exception e2) {
                System.err.println("Error al cerrar el archivo aux_grafico.dot");
            }
        }
        try {
            Runtime rt = Runtime.getRuntime();
            rt.exec("dot -Tjpg -o " + path + " aux_grafico.dot");
            Thread.sleep(500);
            rt.exec("cmd /c start " + path);
        } catch (Exception ex) {
            System.err.println("Error al generar la imagen para el archivo aux_grafico.dot");
        }
    }

    String getCodigoGraphviz() {
        return "digraph grafica{\n"
                + "rankdir=TB;\n"
                + "node [shape = box, style=filled, fillcolor=seashell2];\n"
                + getCodigoInterno()
                + "}\n";
    }

    String getCodigoInterno() {
        String etiqueta;
        if (ramaSI == null && ramaNO == null) {
            etiqueta = "nodo" + nodoID + " [ label =\"" + nodoID + ". " + pregunOrResp + "\"];\n";
        } else {
            etiqueta = "nodo" + nodoID + " [ label =\"" + nodoID + ". " + pregunOrResp + "\"];\n";
        }
        if (ramaSI != null) {
            etiqueta = etiqueta + ramaSI.getCodigoInterno()
                    + "nodo" + nodoID + ":C0->nodo" + ramaSI.nodoID + "[label=\"SI\"]" + "\n";
        }
        if (ramaNO != null) {
            etiqueta = etiqueta + ramaNO.getCodigoInterno()
                    + "nodo" + nodoID + ":C1->nodo" + ramaNO.nodoID + "[label=\"NO\"]" + "\n";
        }
        return etiqueta;
    }
}
