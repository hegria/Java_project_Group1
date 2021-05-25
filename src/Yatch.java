
import java.util.Random;


public class Yatch {
	//전체 게임정보가 들어가야함
	int table[][] = new int[2][14]; //13을 보너스로하고, 14를 총점으로?
 	Playing play = new Playing(); // dice정보만
	int imoji[] = new int[2];
	int turn; //1-24
	int rollchance; // 갱신
	Yatch(){
		turn = 1;
		rollchance = 3;
	}
	void rolldice(int nums[]) {
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
		int[] numof = new int[6];
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
		boolean isSS = false; // 나중에 생각{0,0,1,1,1,1} 아이디어 필요
		boolean isLS = false; // 나중에 생각{0,1,1,1,1,1}
		for (int i=0;i<6;i++) {
			boolean check=false;
			if(numof[i]==4) {
				isfour = 4*(i+1);
				check =true;
			}
			if(numof[i]==3){
				isthree =3*(i+1);
				check =true;
			}
			if(numof[i]==2) {
				istwo = 2*(i+1);
				check =true;
			}
			if(numof[i]==5){
				isfive =5*(i+1);
				check =true;
			}
			if(numof[i]==1) {
				isone =(i+1);
				check =true;
			}
			if(check) {
				if(i==0)
					iss[i]++;
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
	}
	// suits는 버튼에 지정된 값 (족보 몇번째껄로 할건지)
	void pressscore(int player,int suits) {
		table[player][suits] = play.suits[suits];
		int total = 0;
		int subtotal = 0;
		for (int i =0;i<13;i++) {
			total += table[player][i];
		}
		for (int i=0;i<6;i++) {
			subtotal += table[player][i];
		}
		if(subtotal>=63) {
			table[player][12] = 35;
		}
		table[player][13] = total;
		
	}
	void turnover() {
		turn+=1;
		rollchance = 3;
		
	}
	int winner() {
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
	int dieces[];
	int suits[];
	Playing(){
		dieces = new int[5];
		suits = new int[14];
	}
}