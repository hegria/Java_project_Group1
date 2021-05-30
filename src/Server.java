
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
	
	private static ArrayList<Thread> arr = new ArrayList<Thread>(); // 4개면 꽉참!
	public static void main(String[] args) {
		Yacht yatch = new Yacht();
		ServerSocket ss = null;
		int id = 1; // userid를 보내줌.
		try {
			 ss = new ServerSocket(5000);
			
			
		} catch (IOException e) {
		}
		while (true) {
			try {
			if(arr.size()==4) {
				break;
			}
			Socket soc = ss.accept(); // id를 보내야하니까..
			yatch.numofman++;
			OutputStream os =soc.getOutputStream();
			DataOutputStream dos =new DataOutputStream(os);
			dos.write(id++); // id 하나만 보냄.
			Thread t1 = new ServerSend(soc,yatch); // server<=(server의 정보를)send 
			Thread t2 = new ClientReceive(soc, yatch); // client<=(client의 정보를)recevive
			t1.start();
			t2.start();
			arr.add(t1);
			arr.add(t2);
			
			} catch (IOException e) {
				// TODO: handle exception
			}
		}
	}
}
