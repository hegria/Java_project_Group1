
import java.util.Random;


public class Yatch {
	//��ü ���������� ������
	int table[][] = new int[2][14]; //13�� ���ʽ����ϰ�, 14�� ��������?
 	Playing play = new Playing(); // dice������
	int imoji[] = new int[2];
	int turn; //1-24
	int rollchance; // ����
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
		//�ֻ��� ����ģ��
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
		boolean isSS = false; // ���߿� ����{0,0,1,1,1,1} ���̵�� �ʿ�
		boolean isLS = false; // ���߿� ����{0,1,1,1,1,1}
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
	// suits�� ��ư�� ������ �� (���� ���°���� �Ұ���)
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