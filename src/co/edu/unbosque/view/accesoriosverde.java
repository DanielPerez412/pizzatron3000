package co.edu.unbosque.view;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class accesoriosverde extends JFrame {
		
	    private JPanel panel1;
	    private JLabel menu1;

	    public accesoriosverde() {
	        setTitle("CAMBIO");
	        setBounds(10, 0, 1335, 730);
	        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	        panel1 = new JPanel();
	        panel1.setBounds(0, 0, 1335, 780);

	        menu1 = new JLabel();
	        ImageIcon menu = new ImageIcon("src/imagenes/Menu.png");
	        Image redimensionado = menu.getImage().getScaledInstance(1335, 685, Image.SCALE_SMOOTH);
	        menu1.setIcon(new ImageIcon(redimensionado));
	        menu1.setBounds(0, 0, 0, 0);

	        JButton boton = new JButton();
	        boton.setBounds(0, 0, 667, 345);
	        ImageIcon im = new ImageIcon("src/imagenes/verde.png");
	        Icon i = new ImageIcon(im.getImage().getScaledInstance(boton.getWidth(), boton.getHeight(), Image.SCALE_AREA_AVERAGING));
	        boton.setIcon(i);
	        add(boton);

	        add(panel1);
	        panel1.add(menu1);

	        boton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	menunegro menunegro = new menunegro();
	            	menunegro.setVisible(true);
	                VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
					ventanaPrincipal.setVisible(false);
	            }
	        });
	        
	        
	        JButton boton1 = new JButton();
	        boton1.setBounds(667, 0, 668, 345);
	        ImageIcon ima = new ImageIcon("src/accesorios/verde_bigote.png");
	        Icon ic = new ImageIcon(ima.getImage().getScaledInstance(boton1.getWidth(), boton1.getHeight(), Image.SCALE_DEFAULT));
	        boton1.setIcon(ic);
	        add(boton1);

	        add(panel1);
	        panel1.add(menu1);

	        boton1.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	verde_bigote verde_bigote = new verde_bigote();
	            	verde_bigote.setVisible(true);
	                VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
					ventanaPrincipal.setVisible(false);
	            }
	        });
	    
	    
        JButton boton2 = new JButton();
        boton2.setBounds(0, 345, 667, 345);
        ImageIcon imag = new ImageIcon("src/accesorios/verde_flores.png");
        Icon ico = new ImageIcon(imag.getImage().getScaledInstance(boton2.getWidth(), boton2.getHeight(), Image.SCALE_DEFAULT));
        boton2.setIcon(ico);
        add(boton2);

        add(panel1);
        panel1.add(menu1);

        boton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	verde_flores verde_flores = new verde_flores();
            	verde_flores.setVisible(true);
                VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
				ventanaPrincipal.setVisible(false);
            }
        });
        
        
        JButton boton3 = new JButton();
        boton3.setBounds(667, 345, 668, 345);
        ImageIcon image = new ImageIcon("src/accesorios/verde_gafas.png");
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(boton3.getWidth(), boton3.getHeight(), Image.SCALE_DEFAULT));
        boton3.setIcon(icon);
        add(boton3);

        add(panel1);
        panel1.add(menu1);

        boton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	verde_gafas verde_gafas = new verde_gafas();
            	verde_gafas.setVisible(true);
                VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
				ventanaPrincipal.setVisible(false);
            }
        });
    }

	    public static void main(String[] args) {
	        VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
	        ventanaPrincipal.setVisible(true);
	    }
	}