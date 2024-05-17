package co.edu.unbosque.view;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class colores extends JFrame {

	private JPanel panel1;
	private JLabel menu1;

	public colores() {
		setTitle("CAMBIO");
		setBounds(10, 0, 1335, 730);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		panel1 = new JPanel();
		panel1.setBounds(0, 0, 1335, 780);

		menu1 = new JLabel();
		menu1.setBounds(0, 0, 0, 0);

		JButton botonrojo = new JButton();
		botonrojo.setBounds(0, 0, 667, 345);
		ImageIcon im = new ImageIcon("src/imagenes/rojo.png");
		Icon i = new ImageIcon(im.getImage().getScaledInstance(botonrojo.getWidth(), botonrojo.getHeight(),
				Image.SCALE_AREA_AVERAGING));
		botonrojo.setIcon(i);
		add(botonrojo);

		botonrojo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				accesoriosrojo accesoriosrojo = new accesoriosrojo();
				accesoriosrojo.setVisible(true);
				VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
				ventanaPrincipal.setVisible(false);
			}
		});

		JButton botonamarillo = new JButton();
		botonamarillo.setBounds(667, 0, 668, 345);
		ImageIcon ima = new ImageIcon("src/imagenes/amarillo.png");
		Icon ic = new ImageIcon(ima.getImage().getScaledInstance(botonamarillo.getWidth(), botonamarillo.getHeight(),
				Image.SCALE_DEFAULT));
		botonamarillo.setIcon(ic);
		add(botonamarillo);

		botonamarillo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				accesoriosamarillo accesoriosamarillo = new accesoriosamarillo();
				accesoriosamarillo.setVisible(true);
				VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
				ventanaPrincipal.setVisible(false);
			}
		});

		JButton botonnegro = new JButton();
		botonnegro.setBounds(0, 345, 667, 345);
		ImageIcon imag = new ImageIcon("src/imagenes/en los 1600.png");
		Icon ico = new ImageIcon(
				imag.getImage().getScaledInstance(botonnegro.getWidth(), botonnegro.getHeight(), Image.SCALE_DEFAULT));
		botonnegro.setIcon(ico);
		add(botonnegro);

		botonnegro.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				accesoriosnegro accesoriosnegro = new accesoriosnegro();
				accesoriosnegro.setVisible(true);
				VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
				ventanaPrincipal.setVisible(false);
			}
		});

		JButton botonverde = new JButton();
		botonverde.setBounds(667, 345, 668, 345);
		ImageIcon image = new ImageIcon("src/imagenes/verde.png");
		Icon icon = new ImageIcon(
				image.getImage().getScaledInstance(botonverde.getWidth(), botonverde.getHeight(), Image.SCALE_DEFAULT));
		botonverde.setIcon(icon);
		add(botonverde);

		botonverde.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				accesoriosverde accesoriosverde = new accesoriosverde();
				accesoriosverde.setVisible(true);
				VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
				ventanaPrincipal.setVisible(false);
			}
		});

		add(panel1);
		panel1.add(menu1);

	}
}
