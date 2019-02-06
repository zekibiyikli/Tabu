import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main {
	
	public static String group1,group2;
	public static int wordvalue;
	public static String[] word=Words.Word();
	public static String[][] forbidden=Words.Forbidden();
	public static int group1Score,group2Score;
	public static int secim;
	static Scanner input=new Scanner(System.in);
	static Random randomNum=new Random();
	public static int start;
	public static int group1count,group2count;
	public static int pas;
	
	public static void main(String[] args) {
		
		System.out.print("Grup 1 isim: ");
		group1=input.nextLine();
		System.out.print("Grup 2 isim: ");
		group2=input.nextLine();
		
		GameGroup1();	

	}
	
	public static void GameGroup1() {
		System.out.println();

		if(group1count==0) {
			System.out.println(group1+" baþlýyor....");

		}	
		System.out.println();

		wordvalue=randomNum.nextInt(word.length);

		System.out.println("---"+word[wordvalue].toUpperCase()+"---");
		System.out.println();

		System.out.println("-"+forbidden[wordvalue][0]);
		System.out.println("-"+forbidden[wordvalue][1]);
		System.out.println("-"+forbidden[wordvalue][2]);
		System.out.println("-"+forbidden[wordvalue][3]);
		System.out.println("-"+forbidden[wordvalue][4]);
		
		
		do {
			System.out.println();
			System.out.print("Secim(1-Doðru 2-Pas 3-Tabu 4-Süre Bitti):");
			secim=input.nextInt();
			
			if(secim==1) {
				group1Score++;
				group1count++;
				GameGroup1();
				
			}
			else if(secim==2) {
				if(pas<3) {
					group1count++;
					pas++;
					GameGroup1();
				}else {
					System.out.println("Pas Hakkýnýz kalmadý");
				}
				
			}
			else if(secim==3) {
				group1count++;
				if(group1Score==0) {
					GameGroup1();
				}
				else {
					group1Score--;
					GameGroup1();
				}
			}
			else if(secim==4) {
				pas=0;
				System.out.println();

				System.out.println("Score");
				System.out.println(group1+" - "+group1Score);
				System.out.println(group2+" - "+group2Score);
				
				do {
					System.out.println();

					System.out.print(group2+" grubu baþlamak için '1' tuþuna  basýnýz: ");
					start=input.nextInt();
				}while(start!=1);
				
				group1count=0;
				GameGroup2();
			}
			
		}while(secim>4 || secim<0 || pas>2);
		
		
		
	}
	
public static void GameGroup2() {
	System.out.println();

	
	if(group2count==0) {
		System.out.println(group2+" baþlýyor....");

	}
	System.out.println();

		wordvalue=randomNum.nextInt(word.length);

		System.out.println("---"+word[wordvalue].toUpperCase()+"---");
		System.out.println();

		System.out.println("-"+forbidden[wordvalue][0]);
		System.out.println("-"+forbidden[wordvalue][1]);
		System.out.println("-"+forbidden[wordvalue][2]);
		System.out.println("-"+forbidden[wordvalue][3]);
		System.out.println("-"+forbidden[wordvalue][4]);

		do {
			System.out.println();
			System.out.print("Secim(1-Doðru 2-Pas 3-Tabu 4-Süre Bitti):");
			secim=input.nextInt();
			
			if(secim==1) {
				group1Score++;
				group2count++;
				GameGroup2();
			}
			else if(secim==2) {
				if(pas<3) {
					group2count++;
					pas++;
					GameGroup2();
				}else {
					System.out.println("Pas Hakkýnýz kalmadý");
				}
			}
			else if(secim==3) {
				group2count++;
				if(group1Score==0) {
					GameGroup2();
				}
				else {
					group1Score--;
					GameGroup2();
				}
			}
			else if(secim==4) {
				pas=0;
				System.out.println();

				System.out.println("Score");
				System.out.println(group1+" - "+group1Score);
				System.out.println(group2+" - "+group2Score);
				
				do {
					System.out.println();

					System.out.print(group1+" grubu baþlamak için '1' tuþuna  basýnýz: ");
					start=input.nextInt();
				}while(start!=1);
				group2count=0;

				GameGroup1();
			}
			
		}while(secim>4 || secim<0);
		
	}

}
