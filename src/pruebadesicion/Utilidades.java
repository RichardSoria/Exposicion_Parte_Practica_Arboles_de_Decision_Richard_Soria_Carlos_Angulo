/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebadesicion;


public class Utilidades {

    double[] valoresAtri;
    String[] atributos;
    int indice;
    int indValor;

    public Utilidades(int canAtriV) {
        atributos = new String[1000];
        valoresAtri = new double[canAtriV];
        indValor = 0;
        indice = 0;
    }

    void setIndiceAtri(int valor) {
        indice = valor;
    }

    public void adicionarAtri(String atri) {
        atributos[indice] = atri;
        indice++;
    }

    public void adicionarValorAtri(double vAtri) {
        valoresAtri[indValor] = vAtri;
        indValor++;
    }

    public boolean procesadoAtri(String atri) {
        for (int i = 0; i < indice; i++) {
            if (atributos[i].equals(atri)) {
                return true;
            }
        }
        return false;
    }

    public double log2(double num) {
        return (Math.log(num) / Math.log(2));
    }

    double infor(double pos, double nega) {
        double posi = 0;
        double negai = 0;
        if (pos == 0) {
            posi = 0;
        } else {
            posi = -pos * log2(pos);
        }
        if (nega == 0) {
            negai = 0;
        } else {
            negai = -nega * log2(nega);
        }
        double total = posi + negai;
        return total;
    }

    public static int[] atributoDecision(String atributo, int pos, int deci, String[][] tab, int ejemplos) {
        int sis = 0;
        int nos = 0;
        int resp[] = new int[3];
        for (int i = pos; i < pos + 1; i++) {
            for (int k = 0; k < ejemplos; k++) {
                if (tab[k][i].equals(atributo)) {
                    if (tab[k][deci].equalsIgnoreCase("SI")) {
                        sis++;
                    } else if (tab[k][deci].equalsIgnoreCase("NO")) {
                        nos++;
                    }
                }
            }

        }
        resp[0] = sis;
        resp[1] = nos;
        resp[2] = nos + sis;
        return resp;
    }

    String imprimitTabla(String[][] tab, String[] att, int ejemplos, int atributos) {
        String sal = "";
        for (int i = 0; i < att.length; i++) {
            sal += "  " + att[i];
        }
        sal += "\n";
        for (int i = 0; i < ejemplos; i++) {
            for (int k = 0; k < atributos + 1; k++) {
                sal += "    " + tab[i][k];
            }
            sal += "\n";
        }
        return sal;
    }

    public void ordenarV(String[] atri) {
        double aux = 0;
        String auxA = "";
        for (int i = 0; i < valoresAtri.length; i++) {
            for (int j = 0; j < valoresAtri.length; j++) {
                if (valoresAtri[i] < valoresAtri[j]) {
                    aux = valoresAtri[j];
                    auxA = atri[j];
                    valoresAtri[j] = valoresAtri[i];
                    atri[j] = atri[i];
                    valoresAtri[i] = aux;
                    atri[i] = auxA;
                }
            }
        }
    }

    public String imprimeV(String[] atri) {
        String sal = "";
        sal += "Atributos Ordenados Nivel Informacion \n"
                + "**************************************\n";
        for (int i = 0; i < valoresAtri.length; i++) {
            sal += atri[i] + "...... " + valoresAtri[i] + "\n";
        }
        return sal;
    }

}
