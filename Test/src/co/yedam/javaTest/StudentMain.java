package co.yedam.javaTest;

import java.util.List;
import java.util.Scanner;

public class StudentMain {
	
	Scanner scn = new Scanner(System.in);	
	StudentControl srv = new StudentControl(); 
	
	public void main() {
		srv.start();
		while(true) {
			
			menuView();
			String sel = scanString("선택 >");
			if( sel.equals("1") || sel.equals("입력")) {
				stdInsert();
			}else if(sel.equals("2") || sel.equals("수정")){
				stdEdit();
			}else if(sel.equals("3") || sel.equals("삭제")){
				stdDel();
			}else if(sel.equals("4") || sel.equals("리스트")){
				stdList();
			}else if(sel.equals("5") || sel.equals("단건조회")){
				stdDetailList();
			}else if(sel.equals("6") || sel.equals("분석")){
				stdAnalysis();
			}else if(sel.equals("7") || sel.equals("종료")){
				break;
			}else {
				System.out.println("※ 잘못된 메뉴입니다.");
			}
		}
		System.out.println("프로그램 종료.");
	}

	public void menuView() {
		System.out.println();
		System.out.println("┏━━━━━━━━━━━━━━━━━━━【 메 뉴 】━━━━━━━━━━━━━━━━━━━	┓");
		System.out.println("┃ 1.입력 2.수정 3.삭제 4.리스트 5.단건조회 6.분석 7.종료	┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
	}
	
	public String scanString(String arg) {
		System.out.print(arg);
		String txt = scn.nextLine();
		return txt;
	}
	
	public Integer scanInt(String arg) {
		
		int txt = 0;
		while(true) {
			try {
				System.out.print(arg);
				txt = scn.nextInt();
				scn.nextLine();
				break;
			}catch(Exception e){
				System.out.println("※ 숫자만 입력해주세요.");
				scn.nextLine();
				continue;
			}
		}
		return txt;
	}	
	
	public void stdInsert() {
		int sel = scanInt("학번 >");
		String name = scanString("이름 >");
		int engScr = scanInt("영어점수 >");
		int mathScr = scanInt("수학점수 >");
		
		Student std = new Student(sel,name,engScr,mathScr);
		srv.insert(std);
		System.out.println();
	}
	
	public void stdEdit() {
		int sel = scanInt("학번 >");
		if(srv.chkStd(sel)) {
			String name = scanString("이름 >");
			int engScr = scanInt("영어점수 >");
			int mathScr = scanInt("수학점수 >");
			Student std = new Student(sel,name,engScr,mathScr);
			boolean chk = srv.update(std);
			if(chk) {
				System.out.println("※ 수정이 완료되었습니다.");
			}
		}else {
			System.out.println("※ 해당 학번은 존재하지 않습니다.");
		}
	}
	
	public void stdDel() {
		int sel = scanInt("학번 >");
		
		if(srv.chkStd(sel)) {
			boolean chk = srv.delete(sel);
			if(chk) {
				System.out.println("※ 삭제가 완료되었습니다.");
			}
		}else {
			System.out.println("※ 해당 학번은 존재하지 않습니다.");
		}
	}
	
	public void stdList() {
		List<Student> stds = srv.selectAll();
		System.out.println("━━━━━━━━━━━━━━━━━━【 학 생 LIST 】━━━━━━━━━━━━━━━━━━");
		for(Student std : stds) {
			System.out.println(std.toString());
		}
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("》》 총 " + (stds.size()) + " 명 《《" );
		System.out.println();
	}	
	
	public void stdDetailList() {
		int sel = scanInt("학번 >");
		if(srv.chkStd(sel)) {
			Student std = srv.selectOne(sel);
		
			System.out.println("┏━━━━━━━━━━━━━━━━━━┓");			
			System.out.println("  학번 : " + std.getStdNo());
			System.out.println("  이름 : " + std.getStdNm());
			System.out.println("  영어점수 : " + std.getStdEngScr() +" 점");
			System.out.println("  수학점수 : " + std.getStdMathScr() +" 점");
			System.out.println("┗━━━━━━━━━━━━━━━━━━┛");						
		}else {
			System.out.println("※ 해당 학번은 존재하지 않습니다.");
		}
		
	}
	
	public void stdAnalysis() {
		Student eStd = srv.stdMaxScore("eng");
		Student mStd = srv.stdMaxScore("math");
		Student totalStd = srv.stdMaxScore("total");
		
		System.out.println("----------------------------------------");
		System.out.println("1. 영어최고 : " + eStd.getStdNm() + "("+ eStd.getStdNo() + ") " + eStd.getStdEngScr() + "점 ");
		System.out.println("2. 수학최고 : " + mStd.getStdNm() + "("+ mStd.getStdNo() + ") " + mStd.getStdMathScr() + "점 ");
		System.out.println("3. 전체최고 : " + totalStd.getStdNm() + "("+ totalStd.getStdNo() + ") 영어 : " + totalStd.getStdEngScr() + "점 / 수학 : " + totalStd.getStdMathScr() + " 점");
		System.out.println("----------------------------------------");

	}
	
	
}

