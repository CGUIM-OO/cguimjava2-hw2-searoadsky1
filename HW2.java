import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author TODO: B0444223 吳昀叡
 * Try to write some comments for your codes (methods, 15 points)
 */
/*很專業、很有想法的程式碼。花了不少時間，但有學到其中的精隨*/
/*suit花色 rank數字 */
public class HW2 {//讓使用者輸入幾副牌，印出花色、點數。

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("input N (deck of cards):");
		String testn= sc.nextLine(); 
        
		int nDeck=Integer.parseInt(testn);//字串換成int
		
		Deck deck=new Deck(nDeck);//把deck類別叫出來。
		
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
	 * @param allCards 所有的牌
	 * @param nDeck 總共有幾副牌
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
 * Description: TODO: please add description here public Deck(){}是建構子。各行註解寫在下面
 */
class Deck{//一個類別
	private ArrayList<Card> cards; //宣皓陣列
	//TODO: Please implement the constructor (30 points)
	public Deck(){}//建構子
	
	public Deck(int nDeck)//有參數的建構子
	{
		cards=new ArrayList<Card>();
		//1 Deck have 52 cards, https://en.wikipedia.org/wiki/Poker
		//Hint: Use new Card(x,y) and 3 for loops to add card into deck
		//Sample code start
		//Card card=new Card(1,1); ->means new card as clubs ace
		//cards.add(card);
		//Sample code end
		
		
		for(int i=0;i<nDeck;i++)// 幾副牌、四個花色、每副牌1-13 把牌跟花色存到陣列
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
	public void printDeck(){//印出牌堆
		//Hint: print all items in ArrayList<Card> cards, 
		//TODO: please implement and reuse printCard method in Card class (5 points)
	for(int i=0;i<52;i++)//一副牌52張 
	{
		Card n=cards.get(i);
		//System.out.println(n.getSuit()+","+n.getRank());
		n.printCard();
	}
		
		
		
		
	}
	public ArrayList<Card> getAllCards(){//取得所有的卡
		return cards;
	}
}
/**
 * Description: TODO: please add description here 。各行程式碼意思直接寫在下面。
 */
/*建立class類別，suit和rank是instance field。    */
class Card{
	private int suit; //Definition: 1~4, Clubs=1, Diamonds=2, Hearts=3, Spades=4
	private int rank; //1~13
	/**
	 * @param s suit
	 * @param r rank
	 */
	public Card(int s,int r){//建構子
		suit=s;
		rank=r;
	}	
	public Card() {//系統自動產生的建構子
		// TODO Auto-generated constructor stub 
		
	}
	//TODO: 1. Please implement the printCard method (20 points, 10 for suit, 10 for rank)
	public void printCard(){//印出花色，數字
		//Hint: print (System.out.println) card as suit,rank, for example: print 1,1 as Clubs Ace
		System.out.println(getSuit()+","+getRank());
		
			
		
	}
	public int getSuit(){ //取得花色
		return suit;
	}
	public int getRank(){//取得點數
		return rank;
	}
}