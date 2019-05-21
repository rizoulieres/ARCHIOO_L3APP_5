package calculateur;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;


import calculateur.Exception.DivisionException;
import calculateur.Exception.OperationException;

public class Serveur {

	private static ServerSocket serveur;
	private static final int PORT = 33001;
	private static float result = 0;
	
	public static void launch() throws IOException, ClassNotFoundException, DivisionException, OperationException{
		serveur = new ServerSocket(PORT);
		
		while(true) {
			
			Socket socket = serveur.accept();
			//LOGGER.log(Level.INFO,"Conexion etablie");
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			
			String operation = (String) ois.readObject();
			
			try {
				CalculetteConf.getOperation(operation);
			}catch (OperationException e) {
				e.getMessage();
				System.exit(1);
			}
			float a = (float) ois.readObject();
			float b = (float) ois.readObject();
			
			Calculette c = new Calculette();
			
			try {
				result = c.calculer(operation, a, b);
				
			}catch (DivisionException e) {
				e.getMessage();
				System.exit(1);
				
			}
			
			oos.writeObject(result);
			
		}
		
	}
	

	
}
