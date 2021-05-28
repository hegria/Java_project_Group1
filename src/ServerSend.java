
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ServerSend extends Thread{ // SERVER�� Yatch������ encode�ؼ� client���� ���.
	private Socket server;
	private Yatch yatch;
	public ServerSend(Socket soc, Yatch yat) {
		this.server = soc;
		this.yatch = yat;
		// TODO Auto-generated constructor stub
	}

	public void run() {
		
			try {
				BufferedWriter out = new BufferedWriter(new OutputStreamWriter(server.getOutputStream()));
				String message = ""; // Yatch������ encode�� �� �ɰ���. �������� �Ű���..
					while(true) {

							for(int i=0;i<30;i++) {
								if(i == 0) {
									message = Integer.toString(yatch.table[0][0]);
								} else {
									message = message + " " +Integer.toString(yatch.table[i/15][i%15]);
									//System.out.println(Integer.toString(i/12)+Integer.toString(i%12)+Integer.toString(yatch.table[i/12][i%12]));
								}
							}
							for(int i=0;i<5;i++) {
								message = message + " " +Integer.toString(yatch.play.dieces[i]);
								
							}
							message = message + " " +Integer.toString(yatch.turn);
							message = message + " " +Integer.toString(yatch.rollchance);
							message = message + " " +Integer.toString(yatch.emoji[0]);
							message = message + " " +Integer.toString(yatch.emoji[1]);
							message = message + " " +Integer.toString(yatch.numofman);
							out.write(message+"\n"); // nextlien���� �ٲܲ��� overload����..
							out.flush();
						
						try {
							Thread.sleep(500);
						} catch (InterruptedException e) {
							// TODO: handle exception
						}
					}
				
			} catch (IOException e) {
				// TODO: handle exception
			}
		
	}
}
