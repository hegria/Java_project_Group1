import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;


public class ServerReceive extends Thread {
	private Socket server;
	private Yatch yatch;
	String[] Code;
	public ServerReceive(Socket socket, Yatch yatch) {
		this.server = socket;
		this.yatch = yatch;
		// TODO Auto-generated constructor stub
	}
	public void run() {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(server.getInputStream()));
			String message;
			while (true) {
				message = in.readLine();
				Code = message.split(" ");
				for(int i =0;i<28;i++) {
					yatch.table[i/14][i%14] = Integer.parseInt(Code[i]);
				}
				for(int i=0;i<5;i++) {
					yatch.play.dieces[i] = Integer.parseInt(Code[28+i]);
				}
				yatch.turn = Integer.parseInt(Code[33]);
				yatch.rollchance = Integer.parseInt(Code[34]);
				yatch.imoji[0] = Integer.parseInt(Code[35]);
				yatch.imoji[1] = Integer.parseInt(Code[36]);
			}
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
