package MP14SMMA.SERVER.APP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class RestaurantServer {

	public RestaurantServer() {

	}

	public static void main(String[] args) {
		try {
			ServerSocket ssk = new ServerSocket(20002);
			System.out.println("Servidor iniciado");

			while (true) {
				Socket sk = ssk.accept();
				Server ser = new Server(sk);
				ser.start();
			}
		} catch (IOException ex) {

		}
	}
}
