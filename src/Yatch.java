
import java.util.Random;


public class Yatch {
	//��ü ���������� ������
	int table[][] = new int[2][14]; //13�� ���ʽ����ϰ�, 14�� ��������?
 	Playing play = new Playing();
	int imoji[][] = new int[2][4];
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
		for (int i =0; i<5;i++) {
			numof[play.dieces[i]]++;
			
		}
		for (int i =0; i<6;i++) {
			play.suits[i] = numof[i]*(i+1);	
		}
		for (int i=0;i<6;i++) {
			play.suits[6] += numof[i]*(i+1);
		}
		int isone = 0;
		int isfour = 0;
		int isthree = 0;
		int isfive = 0;
		int istwo = 0;
		boolean isSS = false; // ���߿� ����{0,0,1,1,1,1} ���̵�� �ʿ�
		boolean isLS = false; // ���߿� ����{0,1,1,1,1,1}
		for (int i=0;i<6;i++) {
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
			}
		}
		if(isfour!=0) {
			play.suits[7] = isfour+isone;
		}
		if(isSS) {
			play.suits[8] =15;
		}
		if(isLS) {
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
		
		
		// �ձ��־���
	}
	void turnover() {
		turn++;
		
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