
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
	
	private static ArrayList<Thread> arr = new ArrayList<Thread>();
	public static void main(String[] args) {
		Yatch yatch = new Yatch();
		ServerSocket ss = null;
		int id = 1;
		try {
			 ss = new ServerSocket(5000);
			
			
		} catch (IOException e) {
		}
		while (true) {
			try {
			if(arr.size()==4) {
				break;
			}
			Socket soc = ss.accept();
			OutputStream os =soc.getOutputStream();
			DataOutputStream dos =new DataOutputStream(os);
			dos.write(id++);
			Thread t1 = new ServerSend(soc,yatch,0);
			Thread t2 = new ClientReceive(soc, yatch);
			t1.start();
			t2.start();
			arr.add(t1);
			arr.add(t2);
			yatch.numofman++;
			
			} catch (IOException e) {
				// TODO: handle exception
			}
		}
	}
}
