package task.pokemon;

import java.util.Scanner;

class Pokemon{
	private String owner;
	private String[] skills;
	public static int count = 0;

	
	
	
	public Pokemon() {
		System.out.println("포켓몬 생성");
		Pokemon.count += 1;
	}
	
	public Pokemon(String owner, String skills){
		this.owner = owner;
		this.skills = skills.split("/");
		System.out.println("포켓몬 생성");
		Pokemon.count += 1;
	}
	
	public String getOwner(){
		return this.owner;
	}
	
	public void setOwner(String newOne) {
		this.owner = newOne;		
	}
	
	public String[] getSkills(){
		return this.skills;
	}
	
	public void setSkills(String skills) {
		this.skills = skills.split("/");		
	}
	
	public void info() {
		System.out.printf("%s의 포켓몬이 사용 가능한 스킬\n", this.owner);
		for(int i=1; i <= this.skills.length ; i++ ) {
			System.out.printf("%d : %s\n", i, this.skills[i-1]);
		}
	}
	
	public void attack(int idx) {
		System.out.printf("%s 공격 시전!\n", this.skills[idx]);
	}
	
}// end of Pokemon

class Pikachu extends Pokemon{

	private String name = "피카츄";
	
	public Pikachu() {super();}
	public Pikachu(String owner, String skills) {
		super(owner, skills);
	}
	
	public void attack(int idx) {
		System.out.printf("[삐까삐까] %s의 %s가 %s 공격 시전!\n"
				, getOwner(), name, this.getSkills()[idx]);
	}
	
}// end of Pikachu


class Ggoboogi extends Pokemon{

	private String name = "꼬부기";

	public Ggoboogi() {super();}
	public Ggoboogi(String owner, String skills) {
		super(owner, skills);
	}
	
	public void attack(int idx) {
		System.out.printf("[꼬북꼬북] %s의 %s가 %s 공격 시전!\n"
				, getOwner(), name, getSkills()[idx]);
	}
	
}// end of Ggoboogi


class Pairi extends Pokemon{

	private String name = "파이리";
	
	public Pairi() {super();}
	public Pairi(String owner, String skills) {
		super(owner, skills);
	}
	
	public void attack(int idx) {
		System.out.printf("[파릴파릴] %s의 %s가 %s 공격 시전!\n"
				, this.getOwner(), name, this.getSkills()[idx]);
	}
	
}// end of pairi

public class Pokemon0210 {

	public static void main(String[] args) {
		while (true) {
			System.out.printf("총 %d 마리의 포켓몬이 생성되었습니다.\n", Pokemon.count );
			System.out.print("1) 포켓몬 생성   2) 프로그램 종료 : ");
			Scanner sc = new Scanner(System.in);
			int menu = sc.nextInt();
			sc.nextLine();
			if(menu == 2) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
			else if(menu == 1){ // start of menu 1
				while(true) {
				System.out.print("1) 피카츄   2) 꼬부기   3)파이리 : ");
				int p_menu = sc.nextInt();
				sc.nextLine();
				Pokemon p = null;
				if (p_menu == 1) {
					p = new Pikachu();
				}else if (p_menu == 2) {
					p = new Ggoboogi ();
				}else if (p_menu == 3) {
					p = new Pairi();
				}else {
					System.out.println("\n메뉴에서 골라주세요");
				} // end of if
				if (p != null) {
					System.out.print("플레이어 이름 입력 : ");
					p.setOwner(sc.nextLine());
					System.out.print("사용 가능한 기술 입력(/로 구분하여 입력) : ");
					p.setSkills(sc.nextLine());
					p.info();
					System.out.print("공격 번호 선택 : ");
					p.attack(sc.nextInt()-1);
				}
				break;
				}
				
			}// end of menu 1
			
		}// end of while

	}// end of main
}

