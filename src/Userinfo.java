
public class Userinfo {
//버튼에 따라서 값이 변하고, send버튼을 누르면 결정되어서 보내어짐.
	int dices[] = {1,1,1,1,1}; // roll
	int emoji = 0; // 내 이모지 뭘 지금 눌러놧는지
	int suit = -1; // 내가 뭘 선택으로 눌러놨는지
	String actionString = ""; // btn 해보면 알텐데.. 눌리면 뭘 할지 구분하기위해서 버튼마다 스트링을 하나씩 지정해줌 근데 얘는 send할때 날라가서
	int tablefilled[] = new int[12];// server가 뭘해야할지 알려줌.(채워져 있는 테이블 오류메세지 뜰때 필요함)
	
	public Userinfo() {
		// TODO Auto-generated constructor stub
	}
}
