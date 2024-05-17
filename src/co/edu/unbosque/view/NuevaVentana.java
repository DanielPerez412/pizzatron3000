package co.edu.unbosque.view;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class NuevaVentana extends JPanel implements MouseListener, MouseMotionListener {
    private static final int WIDTH = 1335;
    private static final int HEIGHT = 729;
    private static final int OBJETO1_SIZE = 200;
    private static final int OBJETO2_SIZE = 275;
    private static final int OBJETO3_SIZE = 150;
    private static final int OBJETO4_SIZE = 180;
    private static final int OBJETO5_SIZE = 185;
    private static final int OBJETO6_SIZE = 220;
    private static final int OBJETO7_SIZE = 180;
    private static final int OBJETO8_SIZE = 220;
    private static final int VELOCIDAD_OBJETO1 = (int) 3;

    private int objeto1X = WIDTH / 16 - OBJETO1_SIZE / 2;
    private int objeto1Y = HEIGHT / 2 + OBJETO1_SIZE / 2;

    private int objeto2X = WIDTH / 13 - OBJETO2_SIZE / 2;
    private int objeto2Y = HEIGHT / 2 - OBJETO2_SIZE / 2;

    private int objeto3X = WIDTH / 3 - OBJETO3_SIZE / 2;
    private int objeto3Y = HEIGHT / 3 - OBJETO3_SIZE / -3;

    private int objeto4X = (int) (WIDTH / 2.8 - OBJETO4_SIZE / -2);
    private int objeto4Y = (int) (HEIGHT / 3.1 - OBJETO4_SIZE / -3);

    private int objeto5X = (WIDTH / 2 + OBJETO5_SIZE / 2);
    private int objeto5Y = (int) (HEIGHT / 3.2 - OBJETO5_SIZE / -3);

    private int objeto6X = (int) (WIDTH / 1.6 - OBJETO6_SIZE / -2);
    private int objeto6Y = (int) (HEIGHT / 2.42 + OBJETO6_SIZE / -3);

    private int objeto7X = (int) (WIDTH / 1.27 - OBJETO7_SIZE / -2);
    private int objeto7Y = (int) (HEIGHT / 3.20 - OBJETO7_SIZE / -3);

    private int objeto8X = (int) (WIDTH / 6 - OBJETO8_SIZE / 2);
    private int objeto8Y = (int) (HEIGHT / 4 - OBJETO8_SIZE / -3);

    private boolean draggingObjeto2 = false;
    private boolean draggingObjeto3 = false;
    private boolean draggingObjeto4 = false;
    private boolean draggingObjeto5 = false;
    private boolean draggingObjeto6 = false;
    private boolean draggingObjeto7 = false;
    private boolean draggingObjeto8 = false;

    private boolean objeto2InObjeto1 = false;
    private boolean objeto3InObjeto1 = false;
    private boolean objeto4InObjeto1 = false;
    private boolean objeto5InObjeto1 = false;
    private boolean objeto6InObjeto1 = false;
    private boolean objeto7InObjeto1 = false;
    private boolean objeto8InObjeto1 = false;

    private int offsetX, offsetY;
    private int offsetX3, offsetY3;
    private int offsetX4, offsetY4;
    private int offsetX5, offsetY5;
    private int offsetX6, offsetY6;
    private int offsetX7, offsetY7;
    private int offsetX8, offsetY8;

    private boolean soundPlayed = false; // Variable de instancia para controlar si el sonido ya se reprodujo
    private Clip clip;

    public NuevaVentana() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.WHITE);
        setFocusable(true);
        addMouseListener(this);
        addMouseMotionListener(this);

        Timer timer = new Timer(1000 / 60, e -> moverObjetos());
        timer.start();
               
        playSound("src/sonido/fondo.wav");           
    }

    private void playSound(String filePath) {
        if (!soundPlayed) { // Verificar si el sonido ya se reprodujo
            try {
                File file = new File(filePath);
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
                clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
                soundPlayed = true; // Establecer la variable a true para indicar que el sonido se reprodujo
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    //Función para parar la música al cerrar la ventana
    public void stopSound() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }
    }

    private void moverObjetos() {
        objeto1X += VELOCIDAD_OBJETO1;

        if (objeto2InObjeto1) {
            objeto2X = WIDTH / 13 - OBJETO2_SIZE / 2;
            objeto2Y = HEIGHT / 2 - OBJETO2_SIZE / 2;
        }
        if (objeto3InObjeto1) {
            objeto3X = (WIDTH / 3 - OBJETO3_SIZE / 2);
            objeto3Y = HEIGHT / 3 - OBJETO3_SIZE / -3;
        }
        if (objeto4InObjeto1) {
            objeto4X = (int) (WIDTH / 2.8 - OBJETO4_SIZE / -2);
            objeto4Y = (int) (HEIGHT / 3.10 - OBJETO4_SIZE / -3);
        }
        if (objeto5InObjeto1) {
            objeto5X = (WIDTH / 2 + OBJETO5_SIZE / 2); 
            objeto5Y = (int) (HEIGHT / 3.2 - OBJETO5_SIZE / -3);
        }
        if (objeto6InObjeto1) {
            objeto6X = (int) (WIDTH / 1.6 - OBJETO6_SIZE / -2); 
            objeto6Y = (int) (HEIGHT / 2.42 + OBJETO6_SIZE / -3);
        }
        if (objeto7InObjeto1) {
            objeto7X = (int) (WIDTH / 1.27 - OBJETO7_SIZE / -2); 
            objeto7Y = (int) (HEIGHT / 3.20 - OBJETO7_SIZE / -3); 
        }
        if (objeto8InObjeto1) {
            objeto8X = (int) (WIDTH / 6 - OBJETO8_SIZE / 2); 
            objeto8Y = (int) (HEIGHT / 4 - OBJETO8_SIZE / -3); 
        }
//        if (objeto1X + OBJETO1_SIZE > WIDTH) {
//            // Reiniciar la posición de la pizza
//        	   	
//            objeto1X = WIDTH / 16 - OBJETO1_SIZE / 2;
//        }

        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        ImageIcon fondoIcon = new ImageIcon("src/imagenes/fondo_Juego.png");
        Image fondoImage = fondoIcon.getImage();
        g.drawImage(fondoImage, 0, 0, getWidth(), getHeight(), this);       
        
        ImageIcon fondoIcon2 = new ImageIcon("src/gifs/platafo.gif");
        Image fondoImage2 = fondoIcon2.getImage();
        g.drawImage(fondoImage2, 0, 440, getWidth(), getHeight(), this);
        
        ImageIcon salsaIcon = new ImageIcon("src/gifs/salsa queso.gif");
        Image salsaImage = salsaIcon.getImage();
        g.drawImage(salsaImage, objeto2X, objeto2Y, OBJETO2_SIZE, OBJETO2_SIZE, this);

        ImageIcon quesoIcon = new ImageIcon("src/pizzas/quesos.png");
        Image quesoImage = quesoIcon.getImage();
        g.drawImage(quesoImage, objeto3X, objeto3Y, OBJETO3_SIZE, OBJETO3_SIZE, this);
        
        ImageIcon algasIcon = new ImageIcon("src/pizzas/algas.png");
        Image algasImage = algasIcon.getImage();
        g.drawImage(algasImage, (int) objeto4X, objeto4Y, OBJETO4_SIZE, OBJETO4_SIZE, this);
        
        ImageIcon camaronIcon = new ImageIcon("src/pizzas/camaron.png");
        Image camaronImage = camaronIcon.getImage();
        g.drawImage(camaronImage, (int) objeto5X, objeto5Y, OBJETO5_SIZE, OBJETO5_SIZE, this);
        
        ImageIcon pezronIcon = new ImageIcon("src/pizzas/pez.png");
        Image pezImage = pezronIcon.getImage();
        g.drawImage(pezImage, (int) objeto7X, objeto7Y, OBJETO7_SIZE, OBJETO7_SIZE, this);
        
        ImageIcon pulpoIcon = new ImageIcon("src/pizzas/pulpo.png");
        Image pulpoImage = pulpoIcon.getImage();
        g.drawImage(pulpoImage, (int) objeto6X, objeto6Y, OBJETO6_SIZE, OBJETO6_SIZE, this);
        
        ImageIcon picanteIcon = new ImageIcon("src/gifs/picantes.gif");
        Image picanteImage = picanteIcon.getImage();
        g.drawImage(picanteImage, (int) objeto8X, objeto8Y, OBJETO8_SIZE, OBJETO8_SIZE, this);
        
        
        boolean Pizza1=(objeto8InObjeto1)&&(objeto7InObjeto1)&&(objeto6InObjeto1)&&(objeto5InObjeto1)&&(objeto4InObjeto1)&&(objeto3InObjeto1);
        boolean pizza2=((!objeto8InObjeto1)&&(!objeto7InObjeto1)&&(objeto6InObjeto1)&&(objeto5InObjeto1)&&(objeto4InObjeto1)&&(objeto3InObjeto1) && (objeto2InObjeto1));
        boolean pizza3=((!objeto8InObjeto1)&&(objeto7InObjeto1)&&(!objeto6InObjeto1)&&(objeto5InObjeto1)&&(objeto4InObjeto1)&&(objeto3InObjeto1) && (objeto2InObjeto1));
        boolean pizza4=((!objeto8InObjeto1)&&(!objeto7InObjeto1)&&(!objeto6InObjeto1)&&(objeto5InObjeto1)&&(objeto4InObjeto1)&&(objeto3InObjeto1) && (objeto2InObjeto1));
        
        
        ImageIcon fondoIcon1 = new ImageIcon("src/imagenes/cajas.png");
        Image fondoImage1 = fondoIcon1.getImage();
        g.drawImage(fondoImage1, 0, 0, getWidth(), getHeight(), this);
        
        if ((!objeto8InObjeto1)&&(!objeto7InObjeto1)&&(!objeto6InObjeto1)&&(!objeto5InObjeto1)&&(!objeto4InObjeto1)&&(!objeto3InObjeto1) && (!objeto2InObjeto1)) {
            ImageIcon pizzaIcon = new ImageIcon("src/pizzas/sola.png");
            Image pizzaImage = pizzaIcon.getImage();
            g.drawImage(pizzaImage, objeto1X, objeto1Y, OBJETO1_SIZE, OBJETO1_SIZE, this);
        }        
        if ((objeto8InObjeto1)&&(!objeto7InObjeto1)&&(!objeto6InObjeto1)&&(!objeto5InObjeto1)&&(!objeto4InObjeto1)&&(!objeto3InObjeto1) && (!objeto2InObjeto1)) {
            ImageIcon pizzaIcon = new ImageIcon("src/pizzas/picante.png");
            Image pizzaImage = pizzaIcon.getImage();
            g.drawImage(pizzaImage, objeto1X, objeto1Y, OBJETO1_SIZE, OBJETO1_SIZE, this);
        }
        if ((!objeto8InObjeto1)&&(objeto7InObjeto1)&&(!objeto6InObjeto1)&&(!objeto5InObjeto1)&&(!objeto4InObjeto1)&&(!objeto3InObjeto1) && (!objeto2InObjeto1)) {
            ImageIcon pizzaIcon = new ImageIcon("src/pizzas/peces.png");
            Image pizzaImage = pizzaIcon.getImage();
            g.drawImage(pizzaImage, objeto1X, objeto1Y, OBJETO1_SIZE, OBJETO1_SIZE, this);
        }
        if ((!objeto8InObjeto1)&&(!objeto7InObjeto1)&&(objeto6InObjeto1)&&(!objeto5InObjeto1)&&(!objeto4InObjeto1)&&(!objeto3InObjeto1) && (!objeto2InObjeto1)) {
            ImageIcon pizzaIcon = new ImageIcon("src/pizzas/pulpos.png");
            Image pizzaImage = pizzaIcon.getImage();
            g.drawImage(pizzaImage, objeto1X, objeto1Y, OBJETO1_SIZE, OBJETO1_SIZE, this);
        }
        if ((!objeto8InObjeto1)&&(!objeto7InObjeto1)&&(!objeto6InObjeto1)&&(objeto5InObjeto1)&&(!objeto4InObjeto1)&&(!objeto3InObjeto1) && (!objeto2InObjeto1)) {
            ImageIcon pizzaIcon = new ImageIcon("src/pizzas/camarones.png");
            Image pizzaImage = pizzaIcon.getImage();
            g.drawImage(pizzaImage, objeto1X, objeto1Y, OBJETO1_SIZE, OBJETO1_SIZE, this);
        }
        if ((!objeto8InObjeto1)&&(!objeto7InObjeto1)&&(!objeto6InObjeto1)&&(!objeto5InObjeto1)&&(objeto4InObjeto1)&&(!objeto3InObjeto1) && (!objeto2InObjeto1)) {
            ImageIcon pizzaIcon = new ImageIcon("src/pizzas/con algas.png");
            Image pizzaImage = pizzaIcon.getImage();
            g.drawImage(pizzaImage, objeto1X, objeto1Y, OBJETO1_SIZE, OBJETO1_SIZE, this);
        }

        if ((!objeto8InObjeto1)&&(!objeto7InObjeto1)&&(!objeto6InObjeto1)&&(!objeto5InObjeto1)&&(!objeto4InObjeto1)&&(objeto3InObjeto1) && (!objeto2InObjeto1)) {
            ImageIcon pizzaIcon = new ImageIcon("src/pizzas/conqueso.png");
            Image pizzaImage = pizzaIcon.getImage();
            g.drawImage(pizzaImage, objeto1X, objeto1Y, OBJETO1_SIZE, OBJETO1_SIZE, this);
        }

        if ((!objeto8InObjeto1)&&(!objeto7InObjeto1)&&(!objeto6InObjeto1)&&(!objeto5InObjeto1)&&(!objeto4InObjeto1)&&(!objeto3InObjeto1) && (objeto2InObjeto1)) {
            ImageIcon pizzaIcon = new ImageIcon("src/pizzas/con salsa.png");
            Image pizzaImage = pizzaIcon.getImage();
            g.drawImage(pizzaImage, objeto1X, objeto1Y, OBJETO1_SIZE, OBJETO1_SIZE, this);
        }
        
        if ((!objeto8InObjeto1)&&(!objeto7InObjeto1)&&(!objeto6InObjeto1)&&(!objeto5InObjeto1)&&(!objeto4InObjeto1)&&(objeto3InObjeto1) && (objeto2InObjeto1)) {
            ImageIcon pizzaIcon = new ImageIcon("src/pizzas/salsa y queso.png");
            Image pizzaImage = pizzaIcon.getImage();
            g.drawImage(pizzaImage, objeto1X, objeto1Y, OBJETO1_SIZE, OBJETO1_SIZE, this);
        }
        if ((!objeto8InObjeto1)&&(!objeto7InObjeto1)&&(!objeto6InObjeto1)&&(!objeto5InObjeto1)&&(objeto4InObjeto1)&&(objeto3InObjeto1) && (!objeto2InObjeto1)) {
            ImageIcon pizzaIcon = new ImageIcon("src/pizzas/con algas y queso.png");
            Image pizzaImage = pizzaIcon.getImage();
            g.drawImage(pizzaImage, objeto1X, objeto1Y, OBJETO1_SIZE, OBJETO1_SIZE, this);
        }
        if ((!objeto8InObjeto1)&&(!objeto7InObjeto1)&&(!objeto6InObjeto1)&&(!objeto5InObjeto1)&&(objeto4InObjeto1)&&(!objeto3InObjeto1) && (!objeto2InObjeto1)) {
            ImageIcon pizzaIcon = new ImageIcon("src/pizzas/con algas y salsa.png");
            Image pizzaImage = pizzaIcon.getImage();
            g.drawImage(pizzaImage, objeto1X, objeto1Y, OBJETO1_SIZE, OBJETO1_SIZE, this);
        }
        if ((!objeto8InObjeto1)&&(!objeto7InObjeto1)&&(!objeto6InObjeto1)&&(!objeto5InObjeto1)&&(objeto4InObjeto1)&&(objeto3InObjeto1) && (objeto2InObjeto1)) {
            ImageIcon pizzaIcon = new ImageIcon("src/pizzas/algas queso salsa.png");
            Image pizzaImage = pizzaIcon.getImage();
            g.drawImage(pizzaImage, objeto1X, objeto1Y, OBJETO1_SIZE, OBJETO1_SIZE, this);
        }
        if ((!objeto8InObjeto1)&&(!objeto7InObjeto1)&&(!objeto6InObjeto1)&&(objeto5InObjeto1)&&(objeto4InObjeto1)&&(!objeto3InObjeto1) && (!objeto2InObjeto1)) {
            ImageIcon pizzaIcon = new ImageIcon("src/pizzas/camarones algas.png");
            Image pizzaImage = pizzaIcon.getImage();
            g.drawImage(pizzaImage, objeto1X, objeto1Y, OBJETO1_SIZE, OBJETO1_SIZE, this);
        }

        if ((!objeto8InObjeto1)&&(!objeto7InObjeto1)&&(!objeto6InObjeto1)&&(objeto5InObjeto1)&&(!objeto4InObjeto1)&&(objeto3InObjeto1) && (!objeto2InObjeto1)) {
            ImageIcon pizzaIcon = new ImageIcon("src/pizzas/camaron queso.png");
            Image pizzaImage = pizzaIcon.getImage();
            g.drawImage(pizzaImage, objeto1X, objeto1Y, OBJETO1_SIZE, OBJETO1_SIZE, this);
        }

        if ((!objeto8InObjeto1)&&(!objeto7InObjeto1)&&(!objeto6InObjeto1)&&(objeto5InObjeto1)&&(!objeto4InObjeto1)&&(!objeto3InObjeto1) && (objeto2InObjeto1)) {
            ImageIcon pizzaIcon = new ImageIcon("src/pizzas/camaron salsa.png");
            Image pizzaImage = pizzaIcon.getImage();
            g.drawImage(pizzaImage, objeto1X, objeto1Y, OBJETO1_SIZE, OBJETO1_SIZE, this);
        }
        if ((!objeto8InObjeto1)&&(!objeto7InObjeto1)&&(!objeto6InObjeto1)&&(objeto5InObjeto1)&&(objeto4InObjeto1)&&(objeto3InObjeto1) && (!objeto2InObjeto1)){
            ImageIcon pizzaIcon = new ImageIcon("src/pizzas/camaron algas queso.png");
            Image pizzaImage = pizzaIcon.getImage();
            g.drawImage(pizzaImage, objeto1X, objeto1Y, OBJETO1_SIZE, OBJETO1_SIZE, this);
        }
        if ((!objeto8InObjeto1)&&(!objeto7InObjeto1)&&(!objeto6InObjeto1)&&(objeto5InObjeto1)&&(!objeto4InObjeto1)&&(objeto3InObjeto1) && (objeto2InObjeto1)) {
            ImageIcon pizzaIcon = new ImageIcon("src/pizzas/camaron queso salsa.png");
            Image pizzaImage = pizzaIcon.getImage();
            g.drawImage(pizzaImage, objeto1X, objeto1Y, OBJETO1_SIZE, OBJETO1_SIZE, this);
        }
        if ((!objeto8InObjeto1)&&(!objeto7InObjeto1)&&(!objeto6InObjeto1)&&(objeto5InObjeto1)&&(objeto4InObjeto1)&&(!objeto3InObjeto1) && (objeto2InObjeto1)){
            ImageIcon pizzaIcon = new ImageIcon("src/pizzas/camaron algas salsa.png");
            Image pizzaImage = pizzaIcon.getImage();
            g.drawImage(pizzaImage, objeto1X, objeto1Y, OBJETO1_SIZE, OBJETO1_SIZE, this);
        }
        if ((!objeto8InObjeto1)&&(!objeto7InObjeto1)&&(!objeto6InObjeto1)&&(objeto5InObjeto1)&&(objeto4InObjeto1)&&(objeto3InObjeto1) && (objeto2InObjeto1)) {
            ImageIcon pizzaIcon = new ImageIcon("src/pizzas/camaron queso salsa algas.png");
            Image pizzaImage = pizzaIcon.getImage();
            g.drawImage(pizzaImage, objeto1X, objeto1Y, OBJETO1_SIZE, OBJETO1_SIZE, this);
        }
        if ((!objeto8InObjeto1)&&(!objeto7InObjeto1)&&(objeto6InObjeto1)&&(!objeto5InObjeto1)&&(!objeto4InObjeto1)&&(!objeto3InObjeto1) && (objeto2InObjeto1)) {
            ImageIcon pizzaIcon = new ImageIcon("src/pizzas/pulpo salsa.png");
            Image pizzaImage = pizzaIcon.getImage();
            g.drawImage(pizzaImage, objeto1X, objeto1Y, OBJETO1_SIZE, OBJETO1_SIZE, this);
        }

        if ((!objeto8InObjeto1)&&(!objeto7InObjeto1)&&(objeto6InObjeto1)&&(!objeto5InObjeto1)&&(!objeto4InObjeto1)&&(objeto3InObjeto1) && (!objeto2InObjeto1)) {
            ImageIcon pizzaIcon = new ImageIcon("src/pizzas/pulpo queso.png");
            Image pizzaImage = pizzaIcon.getImage();
            g.drawImage(pizzaImage, objeto1X, objeto1Y, OBJETO1_SIZE, OBJETO1_SIZE, this);
        }

        if ((!objeto8InObjeto1)&&(!objeto7InObjeto1)&&(objeto6InObjeto1)&&(!objeto5InObjeto1)&&(objeto4InObjeto1)&&(!objeto3InObjeto1) && (!objeto2InObjeto1)) {
            ImageIcon pizzaIcon = new ImageIcon("src/pizzas/pulpo algas.png");
            Image pizzaImage = pizzaIcon.getImage();
            g.drawImage(pizzaImage, objeto1X, objeto1Y, OBJETO1_SIZE, OBJETO1_SIZE, this);
        }
        if ((!objeto8InObjeto1)&&(!objeto7InObjeto1)&&(objeto6InObjeto1)&&(objeto5InObjeto1)&&(!objeto4InObjeto1)&&(!objeto3InObjeto1) && (!objeto2InObjeto1)) {
            ImageIcon pizzaIcon = new ImageIcon("src/pizzas/pulpo camaron.png");
            Image pizzaImage = pizzaIcon.getImage();
            g.drawImage(pizzaImage, objeto1X, objeto1Y, OBJETO1_SIZE, OBJETO1_SIZE, this);
        }
        if ((!objeto8InObjeto1)&&(!objeto7InObjeto1)&&(objeto6InObjeto1)&&(!objeto5InObjeto1)&&(!objeto4InObjeto1)&&(objeto3InObjeto1) && (objeto2InObjeto1)) {
            ImageIcon pizzaIcon = new ImageIcon("src/pizzas/pulpo salsa queso.png");
            Image pizzaImage = pizzaIcon.getImage();
            g.drawImage(pizzaImage, objeto1X, objeto1Y, OBJETO1_SIZE, OBJETO1_SIZE, this);
        }

        if ((!objeto8InObjeto1)&&(!objeto7InObjeto1)&&(objeto6InObjeto1)&&(!objeto5InObjeto1)&&(objeto4InObjeto1)&&(!objeto3InObjeto1) && (objeto2InObjeto1)) {
            ImageIcon pizzaIcon = new ImageIcon("src/pizzas/pulpo salsa algas.png");
            Image pizzaImage = pizzaIcon.getImage();
            g.drawImage(pizzaImage, objeto1X, objeto1Y, OBJETO1_SIZE, OBJETO1_SIZE, this);
        }

        if ((!objeto8InObjeto1)&&(!objeto7InObjeto1)&&(objeto6InObjeto1)&&(objeto5InObjeto1)&&(!objeto4InObjeto1)&&(!objeto3InObjeto1) && (objeto2InObjeto1)) {
            ImageIcon pizzaIcon = new ImageIcon("src/pizzas/pulpo salsa camaron.png");
            Image pizzaImage = pizzaIcon.getImage();
            g.drawImage(pizzaImage, objeto1X, objeto1Y, OBJETO1_SIZE, OBJETO1_SIZE, this);
        }       
        if ((!objeto8InObjeto1)&&(!objeto7InObjeto1)&&(objeto6InObjeto1)&&(!objeto5InObjeto1)&&(objeto4InObjeto1)&&(objeto3InObjeto1) && (objeto2InObjeto1)) {
            ImageIcon pizzaIcon = new ImageIcon("src/pizzas/pulpo salsa queso algas.png");
            Image pizzaImage = pizzaIcon.getImage();
            g.drawImage(pizzaImage, objeto1X, objeto1Y, OBJETO1_SIZE, OBJETO1_SIZE, this);
        }
        if ((!objeto8InObjeto1)&&(!objeto7InObjeto1)&&(objeto6InObjeto1)&&(objeto5InObjeto1)&&(!objeto4InObjeto1)&&(objeto3InObjeto1) && (objeto2InObjeto1)) {
            ImageIcon pizzaIcon = new ImageIcon("src/pizzas/pulpo salsa queso camaron.png");
            Image pizzaImage = pizzaIcon.getImage();
            g.drawImage(pizzaImage, objeto1X, objeto1Y, OBJETO1_SIZE, OBJETO1_SIZE, this);
        }
        if ((!objeto8InObjeto1)&&(!objeto7InObjeto1)&&(objeto6InObjeto1)&&(objeto5InObjeto1)&&(objeto4InObjeto1)&&(objeto3InObjeto1) && (objeto2InObjeto1)) {
            ImageIcon pizzaIcon = new ImageIcon("src/Pizzas/pulpo salsa queso algas camaron.png");
            Image pizzaImage = pizzaIcon.getImage();
            g.drawImage(pizzaImage, objeto1X, objeto1Y, OBJETO1_SIZE, OBJETO1_SIZE, this);
        }
        if ((!objeto8InObjeto1)&&(objeto7InObjeto1)&&(!objeto6InObjeto1)&&(!objeto5InObjeto1)&&(!objeto4InObjeto1)&&(!objeto3InObjeto1) && (objeto2InObjeto1)) {
            ImageIcon pizzaIcon = new ImageIcon("src/pizzas/peces salsa.png");
            Image pizzaImage = pizzaIcon.getImage();
            g.drawImage(pizzaImage, objeto1X, objeto1Y, OBJETO1_SIZE, OBJETO1_SIZE, this);
        }

        if ((!objeto8InObjeto1)&&(objeto7InObjeto1)&&(!objeto6InObjeto1)&&(!objeto5InObjeto1)&&(!objeto4InObjeto1)&&(objeto3InObjeto1) && (!objeto2InObjeto1)) {
            ImageIcon pizzaIcon = new ImageIcon("src/pizzas/peces queso.png");
            Image pizzaImage = pizzaIcon.getImage();
            g.drawImage(pizzaImage, objeto1X, objeto1Y, OBJETO1_SIZE, OBJETO1_SIZE, this);
        }

        if ((!objeto8InObjeto1)&&(objeto7InObjeto1)&&(!objeto6InObjeto1)&&(!objeto5InObjeto1)&&(objeto4InObjeto1)&&(!objeto3InObjeto1) && (!objeto2InObjeto1)) {
            ImageIcon pizzaIcon = new ImageIcon("src/pizzas/peces algas.png");
            Image pizzaImage = pizzaIcon.getImage();
            g.drawImage(pizzaImage, objeto1X, objeto1Y, OBJETO1_SIZE, OBJETO1_SIZE, this);
        }
        if ((!objeto8InObjeto1)&&(objeto7InObjeto1)&&(!objeto6InObjeto1)&&(objeto5InObjeto1)&&(!objeto4InObjeto1)&&(!objeto3InObjeto1) && (!objeto2InObjeto1)) {
            ImageIcon pizzaIcon = new ImageIcon("src/pizzas/peces camaron.png");
            Image pizzaImage = pizzaIcon.getImage();
            g.drawImage(pizzaImage, objeto1X, objeto1Y, OBJETO1_SIZE, OBJETO1_SIZE, this);
        }
        if ((!objeto8InObjeto1)&&(objeto7InObjeto1)&&(objeto6InObjeto1)&&(!objeto5InObjeto1)&&(!objeto4InObjeto1)&&(!objeto3InObjeto1) && (!objeto2InObjeto1)) {
            ImageIcon pizzaIcon = new ImageIcon("src/pizzas/peces pulpo.png");
            Image pizzaImage = pizzaIcon.getImage();
            g.drawImage(pizzaImage, objeto1X, objeto1Y, OBJETO1_SIZE, OBJETO1_SIZE, this);
        }
        if ((!objeto8InObjeto1)&&(objeto7InObjeto1)&&(!objeto6InObjeto1)&&(!objeto5InObjeto1)&&(!objeto4InObjeto1)&&(objeto3InObjeto1) && (objeto2InObjeto1)) {
            ImageIcon pizzaIcon = new ImageIcon("src/pizzas/peces salsa queso.png");
            Image pizzaImage = pizzaIcon.getImage();
            g.drawImage(pizzaImage, objeto1X, objeto1Y, OBJETO1_SIZE, OBJETO1_SIZE, this);
        }

        if ((!objeto8InObjeto1)&&(objeto7InObjeto1)&&(!objeto6InObjeto1)&&(!objeto5InObjeto1)&&(objeto4InObjeto1)&&(!objeto3InObjeto1) && (objeto2InObjeto1)) {
            ImageIcon pizzaIcon = new ImageIcon("src/pizzas/peces salsa algas.png");
            Image pizzaImage = pizzaIcon.getImage();
            g.drawImage(pizzaImage, objeto1X, objeto1Y, OBJETO1_SIZE, OBJETO1_SIZE, this);
        }

        if ((!objeto8InObjeto1)&&(objeto7InObjeto1)&&(!objeto6InObjeto1)&&(objeto5InObjeto1)&&(!objeto4InObjeto1)&&(!objeto3InObjeto1) && (objeto2InObjeto1)) {
            ImageIcon pizzaIcon = new ImageIcon("src/pizzas/peces salsa camaron.png");
            Image pizzaImage = pizzaIcon.getImage();
            g.drawImage(pizzaImage, objeto1X, objeto1Y, OBJETO1_SIZE, OBJETO1_SIZE, this);
         }   
        if ((!objeto8InObjeto1)&&(objeto7InObjeto1)&&(objeto6InObjeto1)&&(!objeto5InObjeto1)&&(!objeto4InObjeto1)&&(!objeto3InObjeto1) && (objeto2InObjeto1)) {
            ImageIcon pizzaIcon = new ImageIcon("src/pizzas/peces salsa pulpo.png");
            Image pizzaImage = pizzaIcon.getImage();
            g.drawImage(pizzaImage, objeto1X, objeto1Y, OBJETO1_SIZE, OBJETO1_SIZE, this);
         }
        if ((!objeto8InObjeto1)&&(objeto7InObjeto1)&&(!objeto6InObjeto1)&&(!objeto5InObjeto1)&&(objeto4InObjeto1)&&(objeto3InObjeto1) && (objeto2InObjeto1)) {
            ImageIcon pizzaIcon = new ImageIcon("src/pizzas/peces salsa queso algas.png");
            Image pizzaImage = pizzaIcon.getImage();
            g.drawImage(pizzaImage, objeto1X, objeto1Y, OBJETO1_SIZE, OBJETO1_SIZE, this);
        }
        if ((!objeto8InObjeto1)&&(objeto7InObjeto1)&&(!objeto6InObjeto1)&&(objeto5InObjeto1)&&(!objeto4InObjeto1)&&(objeto3InObjeto1) && (objeto2InObjeto1)) {
            ImageIcon pizzaIcon = new ImageIcon("src/pizzas/peces salsa queso camaron.png");
            Image pizzaImage = pizzaIcon.getImage();
            g.drawImage(pizzaImage, objeto1X, objeto1Y, OBJETO1_SIZE, OBJETO1_SIZE, this);
        }
        if ((!objeto8InObjeto1)&&(objeto7InObjeto1)&&(objeto6InObjeto1)&&(!objeto5InObjeto1)&&(!objeto4InObjeto1)&&(objeto3InObjeto1) && (objeto2InObjeto1)) {
            ImageIcon pizzaIcon = new ImageIcon("src/pizzas/peces salsa queso pulpo.png");
            Image pizzaImage = pizzaIcon.getImage();
            g.drawImage(pizzaImage, objeto1X, objeto1Y, OBJETO1_SIZE, OBJETO1_SIZE, this);
        }
        if ((!objeto8InObjeto1)&&(objeto7InObjeto1)&&(!objeto6InObjeto1)&&(objeto5InObjeto1)&&(objeto4InObjeto1)&&(objeto3InObjeto1) && (objeto2InObjeto1)) {
            ImageIcon pizzaIcon = new ImageIcon("src/pizzas/peces salsa queso algas camaron.png");
            Image pizzaImage = pizzaIcon.getImage();
            g.drawImage(pizzaImage, objeto1X, objeto1Y, OBJETO1_SIZE, OBJETO1_SIZE, this);
        }
        if ((!objeto8InObjeto1)&&(objeto7InObjeto1)&&(objeto6InObjeto1)&&(!objeto5InObjeto1)&&(objeto4InObjeto1)&&(objeto3InObjeto1) && (objeto2InObjeto1)) {
            ImageIcon pizzaIcon = new ImageIcon("src/pizzas/peces salsa queso algas pulpo.png");
            Image pizzaImage = pizzaIcon.getImage();
            g.drawImage(pizzaImage, objeto1X, objeto1Y, OBJETO1_SIZE, OBJETO1_SIZE, this);
        }
        if ((!objeto8InObjeto1)&&(objeto7InObjeto1)&&(objeto6InObjeto1)&&(objeto5InObjeto1)&&(objeto4InObjeto1)&&(objeto3InObjeto1) && (objeto2InObjeto1)) {
            ImageIcon pizzaIcon = new ImageIcon("src/pizzas/peces salsa queso algas camaron pulpo.png");
            Image pizzaImage = pizzaIcon.getImage();
            g.drawImage(pizzaImage, objeto1X, objeto1Y, OBJETO1_SIZE, OBJETO1_SIZE, this);
        }
        if ((objeto8InObjeto1)&&(objeto7InObjeto1)&&(!objeto6InObjeto1)&&(!objeto5InObjeto1)&&(!objeto4InObjeto1)&&(!objeto3InObjeto1) ) {
            ImageIcon pizzaIcon = new ImageIcon("src/pizzas/picante pez.png");
            Image pizzaImage = pizzaIcon.getImage();
            g.drawImage(pizzaImage, objeto1X, objeto1Y, OBJETO1_SIZE, OBJETO1_SIZE, this);
        }

        if ((objeto8InObjeto1)&&(!objeto7InObjeto1)&&(!objeto6InObjeto1)&&(!objeto5InObjeto1)&&(!objeto4InObjeto1)&&(objeto3InObjeto1)) {
            ImageIcon pizzaIcon = new ImageIcon("src/pizzas/picante queso.png");
            Image pizzaImage = pizzaIcon.getImage();
            g.drawImage(pizzaImage, objeto1X, objeto1Y, OBJETO1_SIZE, OBJETO1_SIZE, this);
        }

        if ((objeto8InObjeto1)&&(!objeto7InObjeto1)&&(!objeto6InObjeto1)&&(!objeto5InObjeto1)&&(objeto4InObjeto1)&&(!objeto3InObjeto1) ) {
            ImageIcon pizzaIcon = new ImageIcon("src/pizzas/picante algas.png");
            Image pizzaImage = pizzaIcon.getImage();
            g.drawImage(pizzaImage, objeto1X, objeto1Y, OBJETO1_SIZE, OBJETO1_SIZE, this);
        }
        if ((objeto8InObjeto1)&&(!objeto7InObjeto1)&&(!objeto6InObjeto1)&&(objeto5InObjeto1)&&(!objeto4InObjeto1)&&(!objeto3InObjeto1)) {
            ImageIcon pizzaIcon = new ImageIcon("src/pizzas/picante camaron.png");
            Image pizzaImage = pizzaIcon.getImage();
            g.drawImage(pizzaImage, objeto1X, objeto1Y, OBJETO1_SIZE, OBJETO1_SIZE, this);
        }
        if ((objeto8InObjeto1)&&(!objeto7InObjeto1)&&(objeto6InObjeto1)&&(!objeto5InObjeto1)&&(!objeto4InObjeto1)&&(!objeto3InObjeto1) ) {
            ImageIcon pizzaIcon = new ImageIcon("src/pizzas/picante pulpo.png");
            Image pizzaImage = pizzaIcon.getImage();
            g.drawImage(pizzaImage, objeto1X, objeto1Y, OBJETO1_SIZE, OBJETO1_SIZE, this);
        }  
        if ((objeto8InObjeto1)&&(objeto7InObjeto1)&&(!
        		objeto6InObjeto1)&&(!objeto5InObjeto1)&&(!objeto4InObjeto1)&&(!objeto3InObjeto1) ) {
            ImageIcon pizzaIcon = new ImageIcon("src/pizzas/picante pulpo.png");
            Image pizzaImage = pizzaIcon.getImage();
            g.drawImage(pizzaImage, objeto1X, objeto1Y, OBJETO1_SIZE, OBJETO1_SIZE, this);
        }
        if ((objeto8InObjeto1)&&(!objeto7InObjeto1)&&(!objeto6InObjeto1)&&(!objeto5InObjeto1)&&(objeto4InObjeto1)&&(objeto3InObjeto1) ) {
            ImageIcon pizzaIcon = new ImageIcon("src/pizzas/picante queso algas.png");
            Image pizzaImage = pizzaIcon.getImage();
            g.drawImage(pizzaImage, objeto1X, objeto1Y, OBJETO1_SIZE, OBJETO1_SIZE, this);
        }

        if ((objeto8InObjeto1)&&(!objeto7InObjeto1)&&(!objeto6InObjeto1)&&(objeto5InObjeto1)&&(!objeto4InObjeto1)&&(objeto3InObjeto1) ) {
            ImageIcon pizzaIcon = new ImageIcon("src/pizzas/picante queso camarones.png");
            Image pizzaImage = pizzaIcon.getImage();
            g.drawImage(pizzaImage, objeto1X, objeto1Y, OBJETO1_SIZE, OBJETO1_SIZE, this);
        }

        if ((objeto8InObjeto1)&&(!objeto7InObjeto1)&&(objeto6InObjeto1)&&(!objeto5InObjeto1)&&(!objeto4InObjeto1)&&(objeto3InObjeto1) ) {
            ImageIcon pizzaIcon = new ImageIcon("src/pizzas/picante queso pulpo.png");
            Image pizzaImage = pizzaIcon.getImage();
            g.drawImage(pizzaImage, objeto1X, objeto1Y, OBJETO1_SIZE, OBJETO1_SIZE, this);
         }   
        if ((objeto8InObjeto1)&&(objeto7InObjeto1)&&(!objeto6InObjeto1)&&(!objeto5InObjeto1)&&(!objeto4InObjeto1)&&(objeto3InObjeto1)) {
            ImageIcon pizzaIcon = new ImageIcon("src/pizzas/picante queso pez.png");
            Image pizzaImage = pizzaIcon.getImage();
            g.drawImage(pizzaImage, objeto1X, objeto1Y, OBJETO1_SIZE, OBJETO1_SIZE, this);
         }
        if ((objeto8InObjeto1)&&(!objeto7InObjeto1)&&(!objeto6InObjeto1)&&(objeto5InObjeto1)&&(objeto4InObjeto1)&&(objeto3InObjeto1)) {
            ImageIcon pizzaIcon = new ImageIcon("src/pizzas/picante queso algas camaron.png");
            Image pizzaImage = pizzaIcon.getImage();
            g.drawImage(pizzaImage, objeto1X, objeto1Y, OBJETO1_SIZE, OBJETO1_SIZE, this);
        }
        if ((objeto8InObjeto1)&&(!objeto7InObjeto1)&&(objeto6InObjeto1)&&(!objeto5InObjeto1)&&(!objeto4InObjeto1)&&(objeto3InObjeto1)) {
            ImageIcon pizzaIcon = new ImageIcon("src/pizzas/picante queso algas pulpo.png");
            Image pizzaImage = pizzaIcon.getImage();
            g.drawImage(pizzaImage, objeto1X, objeto1Y, OBJETO1_SIZE, OBJETO1_SIZE, this);
        }
        if ((objeto8InObjeto1)&&(objeto7InObjeto1)&&(!objeto6InObjeto1)&&(!objeto5InObjeto1)&&(!objeto4InObjeto1)&&(objeto3InObjeto1)) {
            ImageIcon pizzaIcon = new ImageIcon("src/pizzas/picante queso algas pez.png");
            Image pizzaImage = pizzaIcon.getImage();
            g.drawImage(pizzaImage, objeto1X, objeto1Y, OBJETO1_SIZE, OBJETO1_SIZE, this);
        }
        if ((objeto8InObjeto1)&&(!objeto7InObjeto1)&&(objeto6InObjeto1)&&(objeto5InObjeto1)&&(objeto4InObjeto1)&&(objeto3InObjeto1)) {
            ImageIcon pizzaIcon = new ImageIcon("src/pizzas/picante queso algas camaron pulpo.png");
            Image pizzaImage = pizzaIcon.getImage();
            g.drawImage(pizzaImage, objeto1X, objeto1Y, OBJETO1_SIZE, OBJETO1_SIZE, this);
        }
        if ((objeto8InObjeto1)&&(objeto7InObjeto1)&&(!objeto6InObjeto1)&&(!objeto5InObjeto1)&&(objeto4InObjeto1)&&(objeto3InObjeto1)) {
            ImageIcon pizzaIcon = new ImageIcon("src/pizzas/picante queso algas camaron pez.png");
            Image pizzaImage = pizzaIcon.getImage();
            g.drawImage(pizzaImage, objeto1X, objeto1Y, OBJETO1_SIZE, OBJETO1_SIZE, this);
        }
        if ((objeto8InObjeto1)&&(objeto7InObjeto1)&&(objeto6InObjeto1)&&(objeto5InObjeto1)&&(objeto4InObjeto1)&&(objeto3InObjeto1)) {
            ImageIcon pizzaIcon = new ImageIcon("src/pizzas/picante queso algas camaron pulpo pez.png");
            Image pizzaImage = pizzaIcon.getImage();
            g.drawImage(pizzaImage, objeto1X, objeto1Y, OBJETO1_SIZE, OBJETO1_SIZE, this);
        }

    }
    
    @Override
    public void mousePressed(MouseEvent e) {
        int mouseX = e.getX();
        int mouseY = e.getY();

        if (mouseX >= objeto2X && mouseX <= objeto2X + OBJETO2_SIZE &&
                mouseY >= objeto2Y && mouseY <= objeto2Y + OBJETO2_SIZE) {
            draggingObjeto2 = true;
            offsetX = mouseX - objeto2X;
            offsetY = mouseY - objeto2Y;
        } else if (mouseX >= objeto3X && mouseX <= objeto3X + OBJETO3_SIZE &&
                mouseY >= objeto3Y && mouseY <= objeto3Y + OBJETO3_SIZE) {
            draggingObjeto3 = true;
            offsetX3 = mouseX - objeto3X;
            offsetY3 = mouseY - objeto3Y;
        } else if (mouseX >= objeto4X && mouseX <= objeto4X + OBJETO4_SIZE &&
                mouseY >= objeto4Y && mouseY <= objeto4Y + OBJETO4_SIZE) {
            draggingObjeto4 = true;
            offsetX4 = (int) (mouseX - objeto4X);
            offsetY4 = mouseY - objeto4Y;
        } else if (mouseX >= objeto5X && mouseX <= objeto5X + OBJETO5_SIZE &&
                mouseY >= objeto5Y && mouseY <= objeto5Y + OBJETO5_SIZE) {
            draggingObjeto5 = true;
            offsetX5 = (int) (mouseX - objeto5X);
            offsetY5 = mouseY - objeto5Y;
        } else if (mouseX >= objeto6X && mouseX <= objeto6X + OBJETO6_SIZE &&
                mouseY >= objeto6Y && mouseY <= objeto6Y + OBJETO6_SIZE) {
            draggingObjeto6 = true;
            offsetX6 = (int) (mouseX - objeto6X);
            offsetY6 = mouseY - objeto6Y;
        } else if (mouseX >= objeto7X && mouseX <= objeto7X + OBJETO7_SIZE &&
                mouseY >= objeto7Y && mouseY <= objeto7Y + OBJETO7_SIZE) {
            draggingObjeto7 = true;
            offsetX7 = (int) (mouseX - objeto7X);
            offsetY7 = mouseY - objeto7Y;
        }else if (mouseX >= objeto8X && mouseX <= objeto8X + OBJETO8_SIZE &&
                mouseY >= objeto8Y && mouseY <= objeto8Y + OBJETO8_SIZE) {
            draggingObjeto8 = true;
            offsetX8 = (int) (mouseX - objeto8X);
            offsetY8 = mouseY - objeto8Y;
        }
    }


    @Override
    public void mouseReleased(MouseEvent e) {
        if (draggingObjeto2) {
            if (objeto2X + OBJETO2_SIZE >= objeto1X && objeto2X <= objeto1X + OBJETO1_SIZE &&
                    objeto2Y + OBJETO2_SIZE >= objeto1Y && objeto2Y <= objeto1Y + OBJETO1_SIZE) {
                objeto2X = objeto1X + OBJETO1_SIZE / 16 - OBJETO2_SIZE / 2;
                objeto2Y = objeto1Y + OBJETO1_SIZE / 2 - OBJETO2_SIZE / 2;
                objeto2InObjeto1 = true;
            } else {
                objeto2InObjeto1 = false;
            }
            draggingObjeto2 = false;
            playSound("src/sonido/salsapitza.wav"); // Reproducir el sonido
        } else if (draggingObjeto3) {
            if (objeto3X + OBJETO3_SIZE >= objeto1X && objeto3X <= objeto1X + OBJETO1_SIZE &&
                    objeto3Y + OBJETO3_SIZE >= objeto1Y && objeto3Y <= objeto1Y + OBJETO1_SIZE) {
                objeto3X = objeto1X + OBJETO1_SIZE / 3 - OBJETO3_SIZE / 2;
                objeto3Y = objeto1Y + OBJETO1_SIZE / 3 - OBJETO3_SIZE / -3;
                objeto3InObjeto1 = true;
            } else {
                objeto3InObjeto1 = false;
            }
            draggingObjeto3 = false;
            playSound("src/sonido/ingredientes-_1_.wav");
        } else if (draggingObjeto4) {
            if (objeto4X + OBJETO4_SIZE >= objeto1X && objeto4X <= objeto1X + OBJETO1_SIZE &&
                    objeto4Y + OBJETO4_SIZE >= objeto1Y && objeto4Y <= objeto1Y + OBJETO1_SIZE) {
                objeto4X = (int) (objeto1X + WIDTH / 2.5 - OBJETO4_SIZE / -2);
                objeto4Y = objeto1Y + OBJETO1_SIZE / 3 - OBJETO4_SIZE / -3;
                objeto4InObjeto1 = true;
            } else {
                objeto4InObjeto1 = false;
            }
            draggingObjeto4 = false;
            playSound("src/sonido/ingredientes-_1_.wav");
        } else if (draggingObjeto5) {
            if (objeto5X + OBJETO5_SIZE >= objeto1X && objeto5X <= objeto1X + OBJETO1_SIZE &&
                    objeto5Y + OBJETO5_SIZE >= objeto1Y && objeto5Y <= objeto1Y + OBJETO1_SIZE) {
                objeto5X = objeto1X + OBJETO1_SIZE / 16 - OBJETO5_SIZE / 2;
                objeto5Y = objeto1Y + OBJETO1_SIZE / 2 + OBJETO5_SIZE / 2;
                objeto5InObjeto1 = true;
            } else {
                objeto5InObjeto1 = false;
            }
            draggingObjeto5 = false;
            playSound("src/sonido/ingredientes-_1_.wav");
        } else if (draggingObjeto6) {
            if (objeto6X + OBJETO6_SIZE >= objeto1X && objeto6X <= objeto1X + OBJETO1_SIZE &&
                    objeto6Y + OBJETO6_SIZE >= objeto1Y && objeto6Y <= objeto1Y + OBJETO1_SIZE) {
                objeto6X = objeto1X + OBJETO1_SIZE / 16 - OBJETO6_SIZE / 2;
                objeto6Y = objeto1Y + OBJETO1_SIZE / 2 + OBJETO6_SIZE / 2;
                objeto6InObjeto1 = true;
            } else {
                objeto6InObjeto1 = false;
            }
            draggingObjeto6 = false;
            playSound("src/sonido/ingredientes-_1_.wav");
        } else if (draggingObjeto7) {
            if (objeto7X + OBJETO7_SIZE >= objeto1X && objeto7X <= objeto1X + OBJETO1_SIZE &&
                    objeto7Y + OBJETO7_SIZE >= objeto1Y && objeto7Y <= objeto1Y + OBJETO1_SIZE) {
                objeto7X = objeto1X + OBJETO1_SIZE / 16 - OBJETO7_SIZE / 2;
                objeto7Y = objeto1Y + OBJETO1_SIZE / 2 + OBJETO7_SIZE / 2;
                objeto7InObjeto1 = true;
            } else {
                objeto7InObjeto1 = false;
            }
            draggingObjeto7 = false;
            playSound("src/sonido/ingredientes-_1_.wav");
        } else if (draggingObjeto8) {
            if (objeto8X + OBJETO8_SIZE >= objeto1X && objeto8X <= objeto1X + OBJETO1_SIZE &&
                    objeto8Y + OBJETO8_SIZE >= objeto1Y && objeto8Y <= objeto1Y + OBJETO1_SIZE) {
                objeto8X = objeto1X + OBJETO1_SIZE / 16 - OBJETO8_SIZE / 2;
                objeto8Y = objeto1Y + OBJETO1_SIZE / 2 + OBJETO8_SIZE / 2;
                objeto8InObjeto1 = true;
            } else {
                objeto8InObjeto1 = false;
            }
            draggingObjeto8 = false;
            playSound("src/sonido/SlasaHot.wav");
        }
       
        repaint();
    }


    @Override
    public void mouseDragged(MouseEvent e) {
        if (draggingObjeto2) {
            int mouseX = e.getX();
            int mouseY = e.getY();

            objeto2X = mouseX - offsetX;
            objeto2Y = mouseY - offsetY;

            repaint();
        } else if (draggingObjeto3) {
            int mouseX = e.getX();
            int mouseY = e.getY();

            objeto3X = mouseX - offsetX3;
            objeto3Y = mouseY - offsetY3;

            repaint();
        } else if (draggingObjeto4) {
            int mouseX = e.getX();
            int mouseY = e.getY();

            objeto4X = mouseX - offsetX4;
            objeto4Y = mouseY - offsetY4;

            repaint();
        }        if (draggingObjeto5) {
            int mouseX = e.getX();
            int mouseY = e.getY();

            objeto5X = mouseX - offsetX5;
            objeto5Y = mouseY - offsetY5;

            repaint();
        } else if (draggingObjeto6) {
            int mouseX = e.getX();
            int mouseY = e.getY();

            objeto6X = mouseX - offsetX6;
            objeto6Y = mouseY - offsetY6;

            repaint();
        } else if (draggingObjeto7) {
            int mouseX = e.getX();
            int mouseY = e.getY();

            objeto7X = mouseX - offsetX7;
            objeto7Y = mouseY - offsetY7;

            repaint();
        }else if (draggingObjeto8) {
            int mouseX = e.getX();
            int mouseY = e.getY();

            objeto8X = mouseX - offsetX8;
            objeto8Y = mouseY - offsetY8;

            repaint();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
    @Override
    public void mouseMoved(MouseEvent e) {}

    public static void main(String[] args) {

        JFrame frame = new JFrame("Movimiento de Objetos");
        NuevaVentana movimientoObjetos = new NuevaVentana();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(movimientoObjetos);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}