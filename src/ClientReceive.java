import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientReceive extends Thread{
	private Socket server;
	private Yatch yatch;
	String[] Code;
	public ClientReceive(Socket socket,Yatch yatch) {
		this.server = socket;
		this.yatch = yatch;
	}
	public void run() {
		// TODO Auto-generated method stub
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(server.getInputStream()));
			String message;
			while (true) {
				message = in.readLine();
				Code = message.split(" ");
				int id = Integer.parseInt(Code[0]);
				int dices[] = new int[5];
				int suit;
				int emoji;
				String command = Code[1];
				String realcommand = command.substring(0, 3);
				
				if(realcommand.equals("rol")) {
					for(int i=0; i<5;i++) {
						dices[i] = Integer.parseInt(Code[2+i]);
					}
					
					for(int i =0;i<3;i++) {
						yatch.rolldice(dices);
						try {
							Thread.sleep(500);
						} catch (InterruptedException e) {
							// TODO: handle exception
						}
					}
					yatch.rollchance--;
					
				}
				if(realcommand.equals("sem")) {
					emoji = Integer.parseInt(Code[2]);
					Thread t = new SetIcon(yatch, id-1, emoji);
					t.start();
				}
				if(realcommand.equals("det")) {
					suit = Integer.parseInt(Code[2]);
					yatch.pressscore(id-1,suit);
					yatch.turnover();

				}
					
				
			}
		} catch (IOException e) {
			// TODO: handle exception
		}
	}
}
