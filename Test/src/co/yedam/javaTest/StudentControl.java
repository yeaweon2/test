package co.yedam.javaTest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StudentControl implements StudentInf {

	List<Student> stds = new ArrayList<>();
	
	public void start() {		
		stds.add(new Student(1, "송혜교", 80,75 ));
		stds.add(new Student(2, "강호동", 45,65 ));
		stds.add(new Student(3, "유재석", 90,70 ));
		stds.add(new Student(4, "이효리", 99,30 ));
	}
	
	@Override
	public void insert(Student std) {
		try {
			stds.add(std);	
			System.out.println("※ 【 " + std.getStdNm() + " 】 등록되었습니다. ");
		}catch(Exception e) {
			System.out.println("※ 입력시 오류발생, 관리자에게 문의해주세요.");
		}
		
	}

	@Override
	public boolean update(Student std) {
		boolean chk = false;
		for(int i = 0; i < stds.size(); i++) {
			if(stds.get(i).getStdNo() == std.getStdNo()) {
				if(!std.getStdNm().equals("")) {
					stds.get(i).setStdNm(std.getStdNm());
				}
				 
				if( std.getStdEngScr() != -1 ) {
					stds.get(i).setStdEngScr(std.getStdEngScr());	
				}
				
				if( std.getStdMathScr() != -1 ) {
					stds.get(i).setStdMathScr(std.getStdMathScr());	
				}
				
				//stds.set(i, std);
				chk = true;
				break;
			}
		}
		return chk;
		
	}

	@Override
	public boolean delete(int sel) {
		boolean chk = false;
		for(int i = 0; i < stds.size(); i++) {
			if(stds.get(i).getStdNo() == sel) {
				stds.remove(i);
				chk = true;
				break;
			}
		}
		
		return chk;
	}

	@Override
	public List<Student> selectAll() {
		return stds;
	}

	@Override
	public Student selectOne(int sel) {
		Student std = null;
		for(int i = 0; i < stds.size(); i++) {
			if(stds.get(i).getStdNo() == sel) {
				std = stds.get(i);
				break;
			}
		}		
		
		return std;
	}
	
	public boolean chkStd(int sel) {
		boolean chk = false;
		for(int i = 0; i < stds.size(); i++) {
			if(stds.get(i).getStdNo() == sel) {	
				chk = true;
				break;
			}
		}
		return chk;
	}
	
	@Override	
	public Student stdMaxScore(String type) {
		
		Student std = null;
		int maxScore = 0;
		
		if( type.equals("eng")) {
			for(int i = 0; i < stds.size(); i++) {
				if(maxScore < stds.get(i).getStdEngScr()) {
					maxScore = stds.get(i).getStdEngScr();
					std = stds.get(i);
				}
			}
		}else if(type.endsWith("math")) {
			for(int i = 0; i < stds.size(); i++) {
				if(maxScore < stds.get(i).getStdMathScr()) {
					maxScore = stds.get(i).getStdMathScr();
					std = stds.get(i);
				}
			}			
		}else {
			for(int i = 0; i < stds.size(); i++) {
				if(maxScore < (stds.get(i).getStdMathScr()+stds.get(i).getStdEngScr()) ) {
					maxScore = stds.get(i).getStdMathScr()+stds.get(i).getStdEngScr();
					std = stds.get(i);
				}
			}	
		}
		
		return std;
	}
}
