package xueshe.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import xueshe.com.model.Course;
import xueshe.com.model.Student;

public class StudentDao extends BaseDao {
	//增加学生
	public boolean insertStudent(Student student) {
		String sql = "INSERT INTO students (sno,sname,ssex,spassword) VALUES (?,?,?,?)";
		try (Connection conn = this.dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, student.getSno());
			pstmt.setString(2, student.getSname());
			pstmt.setString(3, student.getSsex());
			pstmt.setString(4, student.getSpassword());
			pstmt.executeUpdate();
			conn.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	// 删除学生
	public boolean deleteStudent(String Sno) {
		String sql = "DELETE FROM students WHERE sno=?";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, Sno);
			pstmt.executeUpdate();
			conn.close();
			return true;
		} catch (Exception se) {
			se.printStackTrace();
			return false;
		}
	}
	//修改学生
	public boolean updateStudent(Student student) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(
					"UPDATE students SET sname=?,ssex=?,spassword=? WHERE sno=?");
			pstmt.setString(1, student.getSname());
			pstmt.setString(2, student.getSsex());
			pstmt.setString(3, student.getSpassword());
			pstmt.setString(4, student.getSno());
			int n = pstmt.executeUpdate();
			conn.close();
			if (n > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException se) {
			se.printStackTrace();
			return false;
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}
	//根据学号获取学生
	public Student getStudentBySno(String Sno)
	{
		String sql = "SELECT * FROM students where sno=?";
		try {
			Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, Sno);
			ResultSet rst = pstmt.executeQuery();
			while (rst.next()) {
				Student student = new Student();
				student.setSno(rst.getString("sno"));
				student.setSname(rst.getString("sname"));
				student.setSsex(rst.getString("ssex"));
				student.setSpassword(rst.getString("spassword"));
				conn.close();
				return student;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	// 获取所有学生
	public ArrayList<Student> getAllStudents(){
		String sql = "SELECT * FROM students";
		ArrayList<Student> studentList = new ArrayList<Student>();
		
		try{
				Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rst = pstmt.executeQuery();
				while (rst.next()) {
					Student student = new Student();
					student.setSno(rst.getString("sno"));
					student.setSname(rst.getString("sname"));
					student.setSsex(rst.getString("ssex"));
					student.setSpassword(rst.getString("spassword"));
					studentList.add(student);
				}
				conn.close();
				return studentList;
			}
		catch (SQLException se) {
			se.printStackTrace();
			return null;
		}
	}
	
	
	
	
	
	
	
	// 根据分页获取所有学生
		public ArrayList<Student> getAllStudentsWithPage(int perpage,int pageindex){
			String sql = "SELECT * FROM students limit ? offset ?";
			ArrayList<Student> studentList = new ArrayList<Student>();
			
			pageindex=(pageindex-1)*perpage;
			
			try{
					Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, perpage);
					pstmt.setInt(2, pageindex);
					ResultSet rst = pstmt.executeQuery();
					while (rst.next()) {
						Student student = new Student();
						student.setSno(rst.getString("sno"));
						student.setSname(rst.getString("sname"));
						student.setSsex(rst.getString("ssex"));
						student.setSpassword(rst.getString("spassword"));
						studentList.add(student);
					}
					conn.close();
					return studentList;
				}
			catch (SQLException se) {
				se.printStackTrace();
				return null;
			}
		}
		// 获取记录总条数以便进行分页数目控制
		public int getAllStudentsRecord(){
					String sql = "SELECT count(*) FROM students";	
					try{
							Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);
							ResultSet rst = pstmt.executeQuery();
							while (rst.next()) {
								int recordNumber=rst.getInt("count");
								conn.close();
								return recordNumber;
							}
							return -1;
						}
					catch (SQLException se) {
						se.printStackTrace();
						return -1;
					}
				}
}
