package MP14SMMA.SERVER.APP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Server extends Thread {

	Socket sk;
	String ipCliente;

	DataInputStream dis;
	DataOutputStream dos;

	Server(Socket sk) {
		this.sk = sk;
	}

	@Override
	public void run() {
		try {
			dis = new DataInputStream(sk.getInputStream());
			dos = new DataOutputStream(sk.getOutputStream());

			ipCliente = sk.getInetAddress().getHostAddress();
			System.out.println("Conectado el cliente: " + ipCliente);
			String dni = dis.readUTF();
			String accesKey = dis.readUTF();

		} catch (IOException ex) {

		}
	}
}
