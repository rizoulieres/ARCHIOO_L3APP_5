package calculateur;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.InputMismatchException;
import java.util.Scanner;

import calculateur.Exception.DivisionException;
import calculateur.Exception.OperationException;
import properties.AppProperties;

public class LigneDeCommande implements IHM  {

	private Scanner sc;
	private AppProperties texte;
	private static final int PORT = 33001;

	public LigneDeCommande() {
		texte = new AppProperties("fr");
		DivisionException.setAppProperties(texte);
		OperationException.setAppProperties(texte);
		CalculetteConf.setAppProperties(texte);

	}

	public LigneDeCommande(AppProperties app) {
		texte = app;
		DivisionException.setAppProperties(texte);
		OperationException.setAppProperties(texte);
		CalculetteConf.setAppProperties(texte);
	}

	@Override
	public void lancer() {
		System.out.println(texte.getProperties("welcome_message"));

		CalculetteConf.init();

		sc = new Scanner(System.in);
		float a=0;
		float b=0;


		while(true) {


			System.out.println(texte.getProperties("operation_message"));
			String op = sc.next();

			try {
				System.out.print(texte.getProperties("first_digit"));
				a = sc.nextFloat();
				System.out.print(texte.getProperties("second_digit"));
				b = sc.nextFloat();


			}catch (InputMismatchException e) {
				if(e.getClass() == InputMismatchException.class) {
					System.err.println(texte.getProperties("exception_number_message"));
					System.exit(1);
				}
				e.getMessage();
			}

			try {
				float result = call(op, a, b);
				System.out.print(texte.getProperties("result_message"));
				System.out.println(result);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			System.out.print(texte.getProperties("loop"));
			if(sc.next().equals("Q")) {
				System.exit(1);
			}

		}		

	}



	private static float call(String op,float a, float b) throws IOException, ClassNotFoundException {
		InetAddress host = InetAddress.getLocalHost();
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;

		Socket socket = new Socket(host.getHostName(),PORT);

		oos = new ObjectOutputStream(socket.getOutputStream());

		oos.writeObject(op);
		oos.writeObject(a);
		oos.writeObject(b);

		ois = new ObjectInputStream(socket.getInputStream());
		float result = (float) ois.readObject();

		socket.close();

		return result;

	}





}
