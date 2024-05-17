package co.edu.unbosque.model;

import co.edu.unbosque.view.VentanaPrincipal;

public class Controller {
	
	private VentanaPrincipal vp;
	
	public Controller(){
		vp = new VentanaPrincipal();
	}
	public void run(){
		vp.setVisible(true);
	}

}
