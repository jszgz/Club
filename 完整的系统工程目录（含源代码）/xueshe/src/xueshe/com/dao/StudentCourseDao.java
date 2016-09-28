package xueshe.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import xueshe.com.model.Course;
import xueshe.com.model.CourseCount;
import xueshe.com.model.StudentCourse;

public class StudentCourseDao extends BaseDao{
	//获得该学生的该社团内的未选择的课程（某年份）
	public ArrayList<Course> getUnselectedCourses(String Sno,String CLno,String Cyear)
	{
		String sql="SELECT cno,cname,cyear,cteacher FROM courses WHERE cyear like ? AND cno in (SELECT cno FROM clubscourses WHERE clno=? AND cno NOT IN (SELECT cno FROM studentscourses WHERE sno=?))";
		ArrayList<Course> courseList = new ArrayList<Course>();
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, "%"+Cyear+"%");
			pstmt.setString(2, CLno);
			pstmt.setString(3, Sno);
			try (ResultSet rst = pstmt.executeQuery()) {
				while (rst.next()) {
					Course course = new Course();
					course.setCno(rst.getString("cno"));
					course.setCname(rst.getString("cname"));
					course.setCyear(rst.getString("cyear"));
					course.setCteacher(rst.getString("cteacher"));
					courseList.add(course);
				}
				conn.close();
				return courseList;
			}
		} catch (SQLException se) {
			se.printStackTrace();
			return null;
		}
	}
	//获得该学生的该社团内的已选择的课程（某年份）
	public ArrayList<Course> getAllSelectedCoursesIgnoreClub(String Sno,String Cyear)
	{
		String sql="SELECT cno,cname,cyear,cteacher FROM courses WHERE cyear like ? AND cno in (SELECT cno FROM studentscourses WHERE sno=?)";
		ArrayList<Course> courseList = new ArrayList<Course>();
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, "%"+Cyear+"%");
			pstmt.setString(2, Sno);
			try (ResultSet rst = pstmt.executeQuery()) {
				while (rst.next()) {
					Course course = new Course();
					course.setCno(rst.getString("cno"));
					course.setCname(rst.getString("cname"));
					course.setCyear(rst.getString("cyear"));
					course.setCteacher(rst.getString("cteacher"));
					courseList.add(course);
				}
				conn.close();
				return courseList;
			}
		} catch (SQLException se) {
			se.printStackTrace();
			return null;
		}
	}
	//获得该学生所有的选课（某年份）
	public ArrayList<Course> getSelectedCourses(String Sno,String CLno,String Cyear)
	{
		String sql="SELECT cno,cname,cyear,cteacher FROM courses WHERE cyear like ? AND cno in (SELECT cno FROM clubscourses WHERE clno=? AND cno IN (SELECT cno FROM studentscourses WHERE sno=?))";
		ArrayList<Course> courseList = new ArrayList<Course>();
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, "%"+Cyear+"%");
			pstmt.setString(2, CLno);
			pstmt.setString(3, Sno);
			try (ResultSet rst = pstmt.executeQuery()) {
				while (rst.next()) {
					Course course = new Course();
					course.setCno(rst.getString("cno"));
					course.setCname(rst.getString("cname"));
					course.setCyear(rst.getString("cyear"));
					course.setCteacher(rst.getString("cteacher"));
					courseList.add(course);
				}
				conn.close();
				return courseList;
			}
		} catch (SQLException se) {
			se.printStackTrace();
			return null;
		}
	}
	//增加一条学生选课的记录
	public boolean insertStudentCourse(String Sno,String Cno)
	{
		String sql = "INSERT INTO studentscourses (sno,cno) VALUES (?,?)";
		try (Connection conn = this.dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, Sno);
			pstmt.setString(2, Cno);
			pstmt.executeUpdate();
			conn.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	//更新一条学生选课的记录（后台操作）
	public boolean updataStudentCourse(StudentCourse studentcourse)
	{
		String sql = "UPDATE studentscourses set scgrade=? WHERE sno=? AND cno=?";
		try (Connection conn = this.dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setDouble(1, studentcourse.getSCgrade());
			pstmt.setString(2, studentcourse.getSno());
			pstmt.setString(3, studentcourse.getCno());
			pstmt.executeUpdate();
			conn.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	//删除一条学生选课的记录
	public boolean deleteStudentCourse(String Sno,String Cno)
	{
		String sql = "DELETE FROM studentscourses WHERE sno=? AND cno=?";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, Sno);
			pstmt.setString(2, Cno);
			pstmt.executeUpdate();
			conn.close();
			return true;
		} catch (Exception se) {
			se.printStackTrace();
			return false;
		}
	}
	//根据课程号和学号获得选课信息
		public StudentCourse getStudentCourseBySnoCno(String Sno,String Cno)
		{
			String sql="SELECT sno,cno,scgrade FROM studentscourses WHERE sno=? AND cno=?";
			try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
				pstmt.setString(1, Sno);
				pstmt.setString(2, Cno);
				try (ResultSet rst = pstmt.executeQuery()) {
					while (rst.next()) {
						StudentCourse sc = new StudentCourse();
						sc.setCno(rst.getString("cno"));
						sc.setSno(rst.getString("sno"));
						sc.setSCgrade(rst.getDouble("scgrade"));
						conn.close();
						return sc;
					}
					return null;
				}
			} catch (SQLException se) {
				se.printStackTrace();
				return null;
			}
		}
	//查询学生是否选择了该课程
	public boolean ifSelectedCourses(String Sno,String Cno)
	{
		String sql="SELECT sno,cno FROM studentscourses WHERE sno=? AND cno=?";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, Sno);
			pstmt.setString(2, Cno);
			try (ResultSet rst = pstmt.executeQuery()) {
				while (rst.next()) {
					conn.close();
					return true;
				}
				conn.close();
				return false;
			}
		} catch (SQLException se) {
			se.printStackTrace();
			return false;
		}
	}
	//获得所有的选课信息
	public ArrayList<StudentCourse> getAllStudentCourses()
	{
		String sql="SELECT * FROM studentscourses";
		ArrayList<StudentCourse> studentcourseList = new ArrayList<StudentCourse>();
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			try (ResultSet rst = pstmt.executeQuery()) {
				while (rst.next()) {
					StudentCourse studentcourse = new StudentCourse();
					studentcourse.setCno(rst.getString("cno"));
					studentcourse.setSno(rst.getString("sno"));
					studentcourse.setSCgrade(rst.getDouble("scgrade"));
					studentcourseList.add(studentcourse);
				}
				conn.close();
				return studentcourseList;
			}
		} catch (SQLException se) {
			se.printStackTrace();
			return null;
		}
	}
}
