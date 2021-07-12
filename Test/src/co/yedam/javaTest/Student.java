package co.yedam.javaTest;

public class Student {
	private int stdNo;
	private String stdNm;
	private int stdEngScr;
	private int stdMathScr;
	
	public Student(int stdNo, String stdNm, int stdEngScr, int stdMathScr) {
		super();
		this.stdNo = stdNo;
		this.stdNm = stdNm;
		this.stdEngScr = stdEngScr;
		this.stdMathScr = stdMathScr;
	}

	public int getStdNo() {
		return stdNo;
	}

	public void setStdNo(int stdNo) {
		this.stdNo = stdNo;
	}

	public String getStdNm() {
		return stdNm;
	}

	public void setStdNm(String stdNm) {
		this.stdNm = stdNm;
	}

	public int getStdEngScr() {
		return stdEngScr;
	}

	public void setStdEngScr(int stdEngScr) {
		this.stdEngScr = stdEngScr;
	}

	public int getStdMathScr() {
		return stdMathScr;
	}

	public void setStdMathScr(int stdMathScr) {
		this.stdMathScr = stdMathScr;
	}

	@Override
	public String toString() {
		return "학번 : " + stdNo + " / 학생명 : " + stdNm + " / 영어점수 : " + stdEngScr + " / 수학점수 : " + stdMathScr ;
	}
	
	
	
}
