package MP14SMMA.SERVER.APP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class RestaruanteClienteAndroid {
	static Socket sk;

	static DataInputStream dis;
	static DataOutputStream dos;
	
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		try {
			String ip = "192.168.12.200";
			sk = new Socket(ip, 20002);
			System.out.println("Establecida la conexión con " + ip);
			dis = new DataInputStream(sk.getInputStream());
			dos = new DataOutputStream(sk.getOutputStream());
			String nombre = sc.nextLine();
			dos.writeUTF(nombre);
			String s = dis.readUTF();
			System.out.println("El servidor dice: " + s);

		} catch (IOException ex) {
			
		}
	}
}
