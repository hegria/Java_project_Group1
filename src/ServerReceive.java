import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;


public class ServerReceive extends Thread {
	private Socket server;
	private Yacht yacht;
	String[] Code; // " "로 다 짜름..
	public ServerReceive(Socket socket, Yacht yacht) {
		this.server = socket;
		this.yacht = yacht;
		// TODO Auto-generated constructor stub
	}
	public void run() {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(server.getInputStream()));
			String message;
			while (true) {
				message = in.readLine();
				Code = message.split(" ");
				for(int i =0;i<30;i++) {
					yacht.table[i/15][i%15] = Integer.parseInt(Code[i]);
				}
				for(int i=0;i<5;i++) {
					yacht.play.dieces[i] = Integer.parseInt(Code[30+i]);
				}
				yacht.turn = Integer.parseInt(Code[35]);
				yacht.rollchance = Integer.parseInt(Code[36]);
				yacht.emoji[0] = Integer.parseInt(Code[37]);
				yacht.emoji[1] = Integer.parseInt(Code[38]);
				yacht.numofman = Integer.parseInt(Code[39]);
			}
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
