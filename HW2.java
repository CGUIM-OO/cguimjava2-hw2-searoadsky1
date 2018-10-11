import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author TODO: B0444223 �d����
 * Try to write some comments for your codes (methods, 15 points)
 */
/*�ܱM�~�B�ܦ��Q�k���{���X�C��F���֮ɶ��A�����Ǩ�䤤�����H*/
/*suit��� rank�Ʀr */
public class HW2 {//���ϥΪ̿�J�X�ƵP�A�L�X���B�I�ơC

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("input N (deck of cards):");
		String testn= sc.nextLine(); 
        
		int nDeck=Integer.parseInt(testn);//�r�괫��int
		
		Deck deck=new Deck(nDeck);//��deck���O�s�X�ӡC
		
		//TODO: please check your output, make sure that you print all cards on your screen (10 points)
		
		
		for(int i=0;i<nDeck;i++) {
			
		deck.printDeck();
		
		}
		
		
		if(isAllCardsCorrect(deck.getAllCards(),nDeck)){
			System.out.println("Well done!");
		}else{
			System.out.println("Error, please check your sourse code");
		}
		
	}
	/**
	 * This method is used for checking your result, not a part of your HW2
	 * @param allCards �Ҧ����P
	 * @param nDeck �`�@���X�ƵP
	 * @return
	 */
	private static boolean isAllCardsCorrect(ArrayList<Card> allCards,int nDeck){
		//check the output 
		boolean isCorrect=true;;
		HashMap <String,Integer> checkHash=new HashMap<String,Integer>();
		for(Card card:allCards){
			int suit= card.getSuit();
			int rank = card.getRank();
			if(suit>4||suit<1||rank>13||rank<1){
				isCorrect=false;
				break;
			}
			if(checkHash.containsKey(suit+","+rank)){
				checkHash.put(suit+","+rank, 
						checkHash.get(suit+","+rank)+1);
			}else{
				checkHash.put(suit+","+rank, 1);
			}

		}
		if(checkHash.keySet().size()==52){
			for(int value:checkHash.values()){
				if(value!=nDeck){
					isCorrect=false;
					break;
				}
			}
		}else{
			isCorrect=false;
		}
		return isCorrect;
	}

}
/**
 * Description: TODO: please add description here public Deck(){}�O�غc�l�C�U����Ѽg�b�U��
 */
class Deck{//�@�����O
	private ArrayList<Card> cards; //�ŵq�}�C
	//TODO: Please implement the constructor (30 points)
	public Deck(){}//�غc�l
	
	public Deck(int nDeck)//���Ѽƪ��غc�l
	{
		cards=new ArrayList<Card>();
		//1 Deck have 52 cards, https://en.wikipedia.org/wiki/Poker
		//Hint: Use new Card(x,y) and 3 for loops to add card into deck
		//Sample code start
		//Card card=new Card(1,1); ->means new card as clubs ace
		//cards.add(card);
		//Sample code end
		
		
		for(int i=0;i<nDeck;i++)// �X�ƵP�B�|�Ӫ��B�C�ƵP1-13 ��P����s��}�C
		{
			for(int x=1;x<5;x++) 
			{
				
				for(int y=1;y<14;y++) 
				{
					Card a=new Card(x,y);
					cards.add(a);
				
				}
			}
		}
		
		

	}	
	
	//TODO: Please implement the method to print all cards on screen (10 points)
	public void printDeck(){//�L�X�P��
		//Hint: print all items in ArrayList<Card> cards, 
		//TODO: please implement and reuse printCard method in Card class (5 points)
	for(int i=0;i<52;i++)//�@�ƵP52�i 
	{
		Card n=cards.get(i);
		//System.out.println(n.getSuit()+","+n.getRank());
		n.printCard();
	}
		
		
		
		
	}
	public ArrayList<Card> getAllCards(){//���o�Ҧ����d
		return cards;
	}
}
/**
 * Description: TODO: please add description here �C�U��{���X�N�䪽���g�b�U���C
 */
/*�إ�class���O�Asuit�Mrank�Oinstance field�C    */
class Card{
	private int suit; //Definition: 1~4, Clubs=1, Diamonds=2, Hearts=3, Spades=4
	private int rank; //1~13
	/**
	 * @param s suit
	 * @param r rank
	 */
	public Card(int s,int r){//�غc�l
		suit=s;
		rank=r;
	}	
	public Card() {//�t�Φ۰ʲ��ͪ��غc�l
		// TODO Auto-generated constructor stub 
		
	}
	//TODO: 1. Please implement the printCard method (20 points, 10 for suit, 10 for rank)
	public void printCard(){//�L�X���A�Ʀr
		//Hint: print (System.out.println) card as suit,rank, for example: print 1,1 as Clubs Ace
		System.out.println(getSuit()+","+getRank());
		
			
		
	}
	public int getSuit(){ //���o���
		return suit;
	}
	public int getRank(){//���o�I��
		return rank;
	}
}