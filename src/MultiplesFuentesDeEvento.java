import java.awt.Color;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import javax.swing.Action;

import javax.swing.ActionMap;

import javax.swing.Icon;

import javax.swing.ImageIcon;

import javax.swing.InputMap;

import javax.swing.JButton;

import javax.swing.JComponent;

import javax.swing.JFrame;

import javax.swing.JPanel;

import javax.swing.KeyStroke;

public class MultiplesFuentesDeEvento {

    public static void main(String [] args) {

        Ventana ventana=new Ventana();

        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}

class Ventana extends JFrame {

    public Ventana() {

        setTitle("Implementacion de M,F");
        setSize(500,500);
        setLocationRelativeTo(null);

        add(new Lamina());

    }

}

class Lamina extends JPanel {

    Lamina() {

    AccionColor accionAmarillo=new AccionColor("Amarillo",new ImageIcon("Imagenes/Iconos/15X15/Yellow.gif"),Color.YELLOW);
    AccionColor accionRojo=new AccionColor("Rojo",new ImageIcon("Imagenes/Iconos/15X15/Red.gif"),Color.RED);
    AccionColor accionAzul=new AccionColor("Azul",new ImageIcon("Imagenes/Iconos/15X15/Blue.gif"),Color.BLUE);

    InputMap MapaEntrada=getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);  //Mapa de Entrada:

    KeyStroke teclaAmarillo=KeyStroke.getKeyStroke("ctrl A");   //La Combinacion de Teclas                                                                                               
    KeyStroke teclaAzul=KeyStroke.getKeyStroke("ctrl B");
    KeyStroke teclaRojo=KeyStroke.getKeyStroke("ctrl R");

    MapaEntrada.put(teclaAmarillo, "fondo_Amarillo");   //Asignar la combinacion de tecla a un objeto porque no se puede asignar la combinacion de tecla directamente a la accion.
    MapaEntrada.put(teclaAzul, "fondo_Azul");
    MapaEntrada.put(teclaRojo, "fondo_Rojo");  

    ActionMap mapaAccion=getActionMap();  

    mapaAccion.put("fondo_Amarillo",accionAmarillo); 
    mapaAccion.put("fondo_Azul",accionAzul);
    mapaAccion.put("fondo_Rojo",accionRojo);

    }


 private class AccionColor extends AbstractAction{

    public AccionColor(String nombre,Icon icono,Color color_boton) {

        putValue(Action.NAME,nombre);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Color c=(Color)getValue("color_de_fondo");

        setBackground(c);

        System.out.println(getValue(Action.NAME));

      }

    }

}