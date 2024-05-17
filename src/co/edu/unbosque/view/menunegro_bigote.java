package co.edu.unbosque.view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menunegro_bigote extends JFrame {

    private JPanel panel1;
    private JLabel menu1;

    public menunegro_bigote() {
        setBounds(10, 0, 1335, 729);
        setTitle("PIZZATRON");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        panel1 = new JPanel();
        panel1.setBounds(0, 0, 1335, 780);

        menu1 = new JLabel();
        ImageIcon menu = new ImageIcon("src/accesorios/negro_bigote.png");
        Image redimensionado = menu.getImage().getScaledInstance(1335, 685, Image.SCALE_SMOOTH);
        menu1.setIcon(new ImageIcon(redimensionado));
        menu1.setBounds(0, 0, 0, 0);

        JButton boton = new JButton();
        boton.setBounds(100, 550, 300, 60);
        ImageIcon im = new ImageIcon("src/imagenes/ButtonStart.png");
        Icon i = new ImageIcon(im.getImage().getScaledInstance(boton.getWidth(), boton.getHeight(), Image.SCALE_DEFAULT));
        boton.setIcon(i);
        add(boton);

        add(panel1);
        panel1.add(menu1);

        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NuevaVentana nuevaVentana = new NuevaVentana();
                nuevaVentana.setVisible(true);
                menunegro_bigote ventanaPrincipal = new menunegro_bigote();
				ventanaPrincipal.setVisible(false);
            }
        });
        
        
    }

    public static void main(String[] args) {
        menunegro_bigote ventanaPrincipal = new menunegro_bigote();
        ventanaPrincipal.setVisible(true);
        menunegro_bigote ventanaPrincipal1 = new menunegro_bigote();
		ventanaPrincipal1.setVisible(false);
    }
    
    

}
