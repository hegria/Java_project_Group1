
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ServerSend extends Thread{ // SERVER�� yacht������ encode�ؼ� client���� ���.
	private Socket server;
	private Yacht yacht;
	public ServerSend(Socket soc, Yacht yat) {
		this.server = soc;
		this.yacht = yat;
		// TODO Auto-generated constructor stub
	}

	public void run() {
		
			try {
				BufferedWriter out = new BufferedWriter(new OutputStreamWriter(server.getOutputStream()));
				String message = ""; // yacht������ encode�� �� �ɰ���. �������� �Ű���..
					while(true) {

							for(int i=0;i<30;i++) {
								if(i == 0) {
									message = Integer.toString(yacht.table[0][0]);
								} else {
									message = message + " " +Integer.toString(yacht.table[i/15][i%15]);
									//System.out.println(Integer.toString(i/12)+Integer.toString(i%12)+Integer.toString(yacht.table[i/12][i%12]));
								}
							}
							for(int i=0;i<5;i++) {
								message = message + " " +Integer.toString(yacht.play.dieces[i]);
								
							}
							message = message + " " +Integer.toString(yacht.turn);
							message = message + " " +Integer.toString(yacht.rollchance);
							message = message + " " +Integer.toString(yacht.emoji[0]);
							message = message + " " +Integer.toString(yacht.emoji[1]);
							message = message + " " +Integer.toString(yacht.numofman);
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
