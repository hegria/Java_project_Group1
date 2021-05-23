
public class Client {
	Yatch yatch;
	public static void main(String[] args) {
		Yatch yatch = new Yatch();
		Layout layout = new Layout(yatch);
		Thread draw = new Thread(layout);
		draw.start();
	}
}
