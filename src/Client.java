import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
	public static void main(String[] args) {
		try {
		Socket client = new Socket("localhost",5000);
		DataInputStream dis =new DataInputStream(client.getInputStream());
		int id = dis.read();
		Yacht yacht = new Yacht();
		yacht.numofman = id;
		Userinfo user = new Userinfo();
		Thread recieve = new ServerReceive(client, yacht);
		System.out.println("Connected! I'm player"+Integer.toString(id));
		Layout layout = new Layout(yacht, id, user);
		Thread draw = new Thread(layout); // layout은 runnable이기때문에
		Thread send = new ClientSend(client, user, id);
		send.start();
		recieve.start();
		draw.start();
		} catch (IOException e) {
			// TODO: handle exception
		}
	}
}
