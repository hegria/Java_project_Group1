import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
	public static void main(String[] args) {
		try {
		Socket client = new Socket("localhost",5000);
		DataInputStream dis =new DataInputStream(client.getInputStream());
		int id = dis.read();
		Yatch yatch = new Yatch();
		String a = "";
		Userinfo user = new Userinfo();
		Thread recieve = new ServerReceive(client, yatch);
		System.out.println("I'm"+Integer.toString(id));
		Layout layout = new Layout(yatch, id, user);
		Thread draw = new Thread(layout);
		Thread send = new ClientSend(client, user, id);
		send.start();
		recieve.start();
		draw.start();
		} catch (IOException e) {
			// TODO: handle exception
		}
	}
}
