/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebadesicion;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import static java.nio.file.Files.lines;
import java.util.*;

public class Lectura {

    private String[][] tabla;
    private String[] nombreAtri;

    public boolean lectura(String ruta) throws IOException {
        BufferedReader rd = new BufferedReader(new FileReader(ruta));
        String line;
        boolean res = false;
        List<List<String>> content = new ArrayList<>();
        int colum = 0;
        while ((line = rd.readLine()) != null) {
            res = true;
            String[] values = line.split(";");
            colum = values.length;
            content.add(Arrays.asList(values));

        }

        tabla = new String[content.size() - 1][colum];
        nombreAtri = new String[colum - 1];
        int a = 0;
        for (List<String> l : content) {
            int b = 0;
            for (String value : l) {
                if (a > 0) {
                    tabla[a - 1][b] = value;
                }
                if (a < 1 && b < colum - 1) {
                    nombreAtri[b] = value;
                }
                b++;
            }
            a++;
        }
        return res;
    }

    public String[][] getTabla() {
        return tabla;
    }

    public String[] getNombreAtri() {
        return nombreAtri;
    }
}

