package Ejercicio1;
//Programa que capture la informacion de una persona:
//Nombre, Edad, Peso, Altura, Indice de masa personal
//Que guade a varias personas y la informacion se guarde en un archivo

import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Ejercicio1 extends JFrame {

    private final JTextField texto1;//Text field with set size
    private final JTextField texto2;
    private final JTextField texto3;
    private final JTextField texto4;
    private final JTextField texto5;
    private final JTextField textoNo1;
    private final JTextField textoNo2;
    private final JTextField textoNo3;
    private final JTextField textoNo4;
    private final JTextField textoNo5;

    private final JButton boton1;
    private final JButton boton2;
    private final Container container;

    public Ejercicio1() {
        super("Captura de informacion personal");
        setLayout(new FlowLayout());
        container = getContentPane();

        textoNo1 = new JTextField("Nombre:", 5);
        textoNo1.setEditable(false);
        add(textoNo1);
        texto1 = new JTextField(10);
        add(texto1);

        textoNo2 = new JTextField("Edad:", 4);
        textoNo2.setEditable(false);
        add(textoNo2);
        texto2 = new JTextField(3);
        add(texto2);

        textoNo3 = new JTextField("Peso:", 3);
        textoNo3.setEditable(false);
        add(textoNo3);
        texto3 = new JTextField(3);
        add(texto3);

        textoNo4 = new JTextField("Altura", 3);
        textoNo4.setEditable(false);
        add(textoNo4);
        texto4 = new JTextField(3);
        add(texto4);

        textoNo5 = new JTextField("IMC", 3);
        textoNo5.setEditable(false);
        add(textoNo5);
        texto5 = new JTextField(3);
        add(texto5);

        boton1 = new JButton("Guardar");
        add(boton1);
        boton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarEnArchivo();
            }
        });
        boton2 = new JButton("Nuevo registro");
        add(boton2);
        boton1.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent a){
            crearUnNuevoArchivo();
        }

            private void crearUnNuevoArchivo() {
            Ejercicio1 interfaz = new Ejercicio1();
            interfaz.setSize(300, 200);
            interfaz.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            interfaz.setVisible(true);
            dispose();
            }
    });
    }
    private void guardarEnArchivo() {
        try {
            String rutaArchivo = "Informacion Personal.txt";

            FileWriter fileWriter = new FileWriter(rutaArchivo, true);

            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            String nombre = texto1.getText();
            String edad = texto2.getText();
            String peso = texto3.getText();
            String altura = texto4.getText();
            String imc = texto5.getText();

            bufferedWriter.write(String.format("Nombre: %s.\nEdad: %s.\nPeso: %s.\nAltura: %s.\nIMC: %s%n%n", nombre, edad, peso, altura, imc));

            bufferedWriter.close();

            JOptionPane.showMessageDialog(null, "Información guardada en el archivo con éxito.");

        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al guardar la información en el archivo.");
        }
    }

    private void BorrarUnapersona() {
                try {
            String rutaArchivo = "Informacion Personal.txt";

            BufferedReader br = new BufferedReader(new FileReader(rutaArchivo));
            StringBuilder contenido = new StringBuilder();
            String linea;

            while ((linea = br.readLine()) != null) {
                contenido.append(linea).append(System.lineSeparator());
            }
            br.close();

            // Obtén los valores actuales de los campos
            String nombre = texto1.getText();
            String edad = texto2.getText();
            String peso = texto3.getText();
            String altura = texto4.getText();
            String imc = texto5.getText();

            // Crea una cadena de búsqueda para identificar el registro
            String registroABuscar = String.format("Nombre: %s.\nEdad: %s.\nPeso: %s.\nAltura: %s.\nIMC: %s%n%n", nombre, edad, peso, altura, imc);

            // Elimina el registro del contenido
            String contenidoActualizado = contenido.toString().replace(registroABuscar, "");

            // Escribe el contenido actualizado de vuelta al archivo
            BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivo));
            bw.write(contenidoActualizado);
            bw.close();

            JOptionPane.showMessageDialog(null, "Registro borrado con éxito.");

        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al borrar el registro.");
        }
    }
}
