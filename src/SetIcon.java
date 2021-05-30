
public class SetIcon extends Thread{
	Yacht yatch;
	int player;
	int emoji;
	public SetIcon(Yacht yatch,int a, int b) {
		player = a;
		emoji = b;
		this.yatch =yatch;
		}
	
	public void run() {
		if(yatch.emoji[player] ==0) {
			yatch.emoji[player] = emoji;
			try {
				Thread.sleep(3000);
			}catch (InterruptedException e) {
				// TODO: handle exception
			}
			yatch.emoji[player] = 0;
		}
	}

}
