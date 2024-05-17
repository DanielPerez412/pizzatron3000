package co.edu.unbosque.view;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class VentanaPrincipal extends JFrame {

    private JPanel panel1;
    private JLabel menu1;
    private DefaultTableModel tablaModelo;
    private JTable tabla;
    private ArrayList<String> nombres = new ArrayList<>();
    private static final String NOMBRES_FILE = "nombres.txt"; // Archivo para almacenar los nombres

    public VentanaPrincipal() {
        cargarNombres(); // Cargar nombres guardados previamente, si existen
        setBounds(10, 0, 1335, 729);
        setTitle("PIZZATRON");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        panel1 = new JPanel();
        panel1.setBounds(0, 0, 1335, 780);

        menu1 = new JLabel();
        ImageIcon menu = new ImageIcon("src/imagenes/Menucom.png");
        Image redimensionado = menu.getImage().getScaledInstance(1335, 685, Image.SCALE_SMOOTH);
        menu1.setIcon(new ImageIcon(redimensionado));
        menu1.setBounds(0, 0, 0, 0);

        JButton boton3 = new JButton();
        boton3.setBounds(900, 450, 300, 60);
        ImageIcon imag = new ImageIcon("src/imagenes/ButtonStart.png");
        Icon ico = new ImageIcon(imag.getImage().getScaledInstance(boton3.getWidth(), boton3.getHeight(), Image.SCALE_DEFAULT));
        boton3.setIcon(ico);
        add(boton3);
        add(panel1);
        panel1.add(menu1);

        boton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = JOptionPane.showInputDialog("Por favor, introduce tu nombre:");
                if (nombre != null && !nombre.isEmpty()) {
                    nombres.add(nombre);
                }
            }
        });

        JButton boton4 = new JButton();
        boton4.setBounds(900, 550, 300, 60);
        ImageIcon image = new ImageIcon("src/imagenes/ButtonStart.png");
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(boton4.getWidth(), boton4.getHeight(), Image.SCALE_DEFAULT));
        boton4.setIcon(icon);
        add(boton4);
        add(panel1);
        panel1.add(menu1);

        boton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarTabla();
            }
        });

        JButton boton = new JButton();
        boton.setBounds(100, 550, 300, 60);
        ImageIcon im = new ImageIcon("src/imagenes/ButtonStart.png");
        Icon i = new ImageIcon(im.getImage().getScaledInstance(boton.getWidth(), boton.getHeight(), Image.SCALE_DEFAULT));
        boton.setIcon(i);
        add(boton);
        add(panel1);
        panel1.add(menu1);

//        boton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                NuevaVentana nuevaVentana = new NuevaVentana();
//                nuevaVentana.setVisible(true);
//                VentanaPrincipal.this.setVisible(false);
//            }
//        });
        //TODO: FALTABA AGREGAR NuevaVentana A UN FRAME PARA PODER SER VISUALIZADA
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	try {
	                JFrame frame = new JFrame();
	                NuevaVentana nuevaVentana = new NuevaVentana();
	                frame.add(nuevaVentana);
	                frame.pack();
	                frame.setVisible(true);
	                VentanaPrincipal.this.setVisible(false);
	                
	                // Agregar un WindowListener para detener el sonido cuando la ventana se cierre
	                frame.addWindowListener(new WindowAdapter() {
	                    @Override
	                    public void windowClosing(WindowEvent e) {
	                        nuevaVentana.stopSound();
	                    }
	                });
	                
            	} catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        JButton boton1 = new JButton();
        boton1.setBounds(100, 450, 300, 60);
        ImageIcon ima = new ImageIcon("src/imagenes/ButtonStart.png");
        Icon ic = new ImageIcon(ima.getImage().getScaledInstance(boton1.getWidth(), boton1.getHeight(), Image.SCALE_DEFAULT));
        boton1.setIcon(ic);
        add(boton1);

        add(panel1);
        panel1.add(menu1);

        boton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                colores colores = new colores();
                colores.setVisible(true);
                VentanaPrincipal.this.setVisible(false);

            }
        });

        add(panel1);
        panel1.add(menu1);
    }
    
    private void playSound(String filePath) {
        boolean soundPlayed = false;
		if (!soundPlayed) { // Verificar si el sonido ya se reprodujo
            try {
                File file = new File(filePath);
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
                soundPlayed = true; // Establecer la variable a true para indicar que el sonido se reprodujo
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    private void cargarNombres() {
        try (BufferedReader br = new BufferedReader(new FileReader(NOMBRES_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                nombres.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void guardarNombres() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(NOMBRES_FILE))) {
            for (String nombre : nombres) {
                bw.write(nombre);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void mostrarTabla() {
        JFrame tablaVentana = new JFrame("Tabla de Puntuaciones");
        tablaVentana.setSize(400, 300);
        tablaVentana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        tablaModelo = new DefaultTableModel();
        tablaModelo.addColumn("Nombre");
        tablaModelo.addColumn("Puntaje");

        tabla = new JTable(tablaModelo);

        for (String nombre : nombres) {
            tablaModelo.addRow(new Object[]{nombre, "0"});
        }

        JScrollPane scrollPane = new JScrollPane(tabla);
        tablaVentana.add(scrollPane);
        tablaVentana.setVisible(true);
    }

    public static void main(String[] args) {
        VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
        ventanaPrincipal.setVisible(true);
        ventanaPrincipal.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                ventanaPrincipal.guardarNombres(); // Guardar nombres al cerrar la ventana
            }
        });
    }
}
