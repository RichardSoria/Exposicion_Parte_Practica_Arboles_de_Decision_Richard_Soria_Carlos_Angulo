/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebadesicion;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class AbrirArchivo extends JFrame {

    private String path = "";
    private JFileChooser abrirArchivo;

    public AbrirArchivo() {
        setLocationRelativeTo(null);
    }

    public String url() {

        if (abrirArchivo == null) {
            abrirArchivo = new JFileChooser();
        }
        abrirArchivo.setFileSelectionMode(JFileChooser.OPEN_DIALOG);
        int seleccion = abrirArchivo.showOpenDialog(this);

        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File f = abrirArchivo.getSelectedFile();
            try {
                path = f.getAbsolutePath();
            } catch (Exception exp) {
                JOptionPane.showMessageDialog(null, "Error al obtener direccion de archivo", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
        return path;
    }

}
