import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ClientSend extends Thread {
	private Socket server;
	private Userinfo userinfo;
	int userid;
	
	public ClientSend(Socket soc, Userinfo userinfo, int userid) {
		this.server =soc;
		this.userinfo =userinfo;
		this.userid = userid;
	}
	public void run() {
		// TODO Auto-generated method stub
		try {
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(server.getOutputStream()));
			String message;
			while(true) {
				
				if(!userinfo.actionString.equals("")) {
					message = Integer.toString(userid)+" "+userinfo.actionString;
					if(userinfo.actionString.equals("sio")) {
						message = message +" "+ Integer.toString(userinfo.imoji);
						userinfo.imoji = 0;
					}
					if(userinfo.actionString.equals("det")) {
						message = message +" "+ Integer.toString(userinfo.suit);
						userinfo.tablefilled[userinfo.suit] = 1;
						userinfo.suit = -1;
						for(int i=0;i<5;i++) {
							userinfo.dices[i] = 1;
						}
					}
					if(userinfo.actionString.equals("rol")) {
						for(int i =0;i<5;i++) {
						message = message +" "+ Integer.toString(userinfo.dices[i]);
						}
					}

					out.write(message+"\n");
					out.flush();
					userinfo.actionString = "";
				}
				try {
					Thread.sleep(500);
				}  catch (InterruptedException e) {
					// TODO: handle exception
				}
			}
		} catch (IOException e) {
			// TODO: handle exception
		}
	}
	
}
