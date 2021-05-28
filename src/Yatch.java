
import java.util.Random;


public class Yatch {
	//전체 게임정보가 들어가야함 (Serversend가 parse해서 client한테 보낸다.)
	// layout이 이 정보를 가지고 화면을 출력할거임..
	int numofman = 0; // 게임 킬때 두명 들어와야 켜지는거..
	int table[][] = new int[2][15]; //13을 보너스로하고, 14를 총점으로?
 	Playing play = new Playing(); // dice정보만
	int emoji[] = new int[2]; // 실제 press한 imoji값(실제플로팅되고있는 값음)
	int turn; //1-24
	int rollchance; // 갱신
	Yatch(){ // 서버에서 처음 야추 정보가 될거임//
		turn = 1;
		rollchance = 3;
		for(int i=0;i<2;i++) {
			for(int j=0;j<13;j++) {
				table[i][j]=-1; // 입력하지 않은 상태 = -1 ; 입력한 상태는 0이상..
			}
		}
	}
	void rolldice(int nums[]) { //nums는 어느 주사위를 돌릴지 돌린다면 1 아니라면 0
		Random random = new Random();
		for(int i =0; i<5; i++) {
			if(nums[i]==1) {
				play.dieces[i] = random.nextInt(6);
			}
		}
		scoring();
	}
	void scoring() {
		//주사위 눈합친거
		int[] numof = new int[6]; // 각눈의 개수를 저장.
		for(int i =0;i<12 ;i++) {
			play.suits[i] = 0;
		}
		play.suits[6] = 0;
		for (int i =0; i<5;i++) {
			numof[play.dieces[i]]++;
			
		}
		for (int i =0; i<6;i++) {
			play.suits[i] = numof[i]*(i+1);	
		}
		for (int i=0;i<6;i++) {
			play.suits[6] += numof[i]*(i+1);
		}
		int[] iss= new int[6];
		int seq_max =0;
		int isone = 0;
		int isfour = 0;
		int isthree = 0;
		int isfive = 0;
		int istwo = 0;
		for (int i=0;i<6;i++) {
			boolean check=false;
			if(numof[i]==4) {
				isfour = 4*(i+1);
			}
			if(numof[i]==3){
				isthree =3*(i+1);
			}
			if(numof[i]==2) {
				istwo = 2*(i+1);
			}
			if(numof[i]==5){
				isfive =5*(i+1);
			}
			if(numof[i]==1) {
				isone =(i+1);
				check =true;
			}
			if(check) {
				if(i==0)
					iss[0] = 1;
				else
					iss[i]=iss[i-1]+1;
			}
			if(seq_max<iss[i])
				seq_max=iss[i];
		}
		if(isfour!=0) {
			play.suits[7] = isfour+isone;
		}
		  if(seq_max==4) {
	            play.suits[8] =15;
	        }
	        if(seq_max==5) {
	            play.suits[9] =30;
	        }
		if(isthree !=0&&istwo!=0) {
			play.suits[10] = isthree+ istwo;
		}
		if(isfive!=0) {
			play.suits[11] = 50;
		}
	} // 회색으로 띄우는거?
	// suits는 버튼에 지정된 값 (족보 몇번째껄로 할건지)
	void pressscore(int player,int suits) {
		table[player][suits] = play.suits[suits];
		int total = 0;
		int subtotal = 0; // 보너스

		for (int i=0;i<6;i++) {
			if(table[player][i]!=-1)
				subtotal += table[player][i];
		}
		if(subtotal>=63) {
			table[player][12] = 35;
		}
		for (int i =0;i<13;i++) {
			if(table[player][i]!=-1)
				total += table[player][i];
		}
		table[player][14] = subtotal;
		table[player][13] = total;
		
	}
	void turnover() {
		turn+=1;
		rollchance = 3;
		
	}
	int winner() { //이긴사람 축정하는거  0 이 draw 1이 win 2가 lose
		if(table[0][13]>table[1][13]) {
			return 1;
		}else if(table[0][13]==table[1][13]) {
			return 0;
		}else {
			return 2;
		}
	}
}

class Playing{
	int dieces[]; // 지금 주사위
	int suits[]; // 지금 주사위 눈에 따른 전체 족보 모든 경우의수..
	Playing(){
		dieces = new int[5];
		suits = new int[12];
	}
}