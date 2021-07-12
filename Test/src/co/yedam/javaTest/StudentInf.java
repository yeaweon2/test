package co.yedam.javaTest;

import java.util.List;

public interface StudentInf {
	public void insert(Student std);
	
	public boolean update(Student std);
	
	public boolean delete(int sel);
	
	public List<Student> selectAll();	
	
	public Student selectOne(int sel);
	
	public Student stdMaxScore(String type);
}
