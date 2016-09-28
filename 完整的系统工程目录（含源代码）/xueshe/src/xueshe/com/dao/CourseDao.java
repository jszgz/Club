package xueshe.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import xueshe.com.model.Course;
import xueshe.com.model.CourseCount;

public class CourseDao extends BaseDao {
	// 增加课程
	public boolean insertCourse(Course course) {
		String sql = "INSERT INTO courses (cno,cname,cyear,cteacher) VALUES (?,?,?,?)";
		try (Connection conn = this.dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, course.getCno());
			pstmt.setString(2, course.getCname());
			pstmt.setString(3, course.getCyear());
			pstmt.setString(4, course.getCteacher());
			pstmt.executeUpdate();
			conn.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	// 删除课程
	public boolean deleteCourse(String Cno) {
		String sql = "DELETE FROM courses WHERE cno=?";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, Cno);
			pstmt.executeUpdate();
			conn.close();
			return true;
		} catch (Exception se) {
			se.printStackTrace();
			return false;
		}
	}

	// 修改课程
	public boolean updateCourse(Course course) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement("UPDATE courses SET cname=?,cyear=?,cteacher=? WHERE cno=?");
			pstmt.setString(1, course.getCname());
			pstmt.setString(2, course.getCyear());
			pstmt.setString(3, course.getCteacher());
			pstmt.setString(4, course.getCno());
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

	// 根据课程号获取课程
	public Course getCourseByCno(String Cno){
		String sql = "SELECT * FROM courses where cno=?";
		try {
			Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, Cno);
			ResultSet rst = pstmt.executeQuery();
			while (rst.next()) {
				Course course = new Course();
				course.setCno(rst.getString("cno"));
				course.setCname(rst.getString("cname"));
				course.setCyear(rst.getString("cyear"));
				course.setCteacher(rst.getString("cteacher"));
				conn.close();
				return course;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	// 获取所有课程
		public ArrayList<Course> getAllCourseS(){
			String sql = "SELECT * FROM courses";
			try {
				Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rst = pstmt.executeQuery();
				ArrayList<Course> clist=new ArrayList<Course>();
				while (rst.next()) {
					Course course = new Course();
					course.setCno(rst.getString("cno"));
					course.setCname(rst.getString("cname"));
					course.setCyear(rst.getString("cyear"));
					course.setCteacher(rst.getString("cteacher"));
					clist.add(course);
				}
				conn.close();
				return clist;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		}

	// 根据课程名称模糊查找课程
	public ArrayList<Course> findCoursesByCname(String cname){
		String sql = "SELECT cno,cname,cyear,cteacher FROM courses WHERE cname like ?";
		ArrayList<Course> courseList = new ArrayList<Course>();
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, "%" + cname + "%");
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
	//获取所有课程编号以便设置新插入社团的编号
			public ArrayList<String> getAllCno()
			{
				ArrayList<String> cnoList=new ArrayList<String>();
				String sql = "SELECT cno FROM courses";
				try {
					Connection conn = dataSource.getConnection();
					PreparedStatement pstmt = conn.prepareStatement(sql);
					ResultSet rst = pstmt.executeQuery();
					while (rst.next()) {
						cnoList.add(rst.getString("cno"));
					}
					conn.close();
					return cnoList;
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return null;
			}
			//获取所有课程年份以便设置新插入社团的编号
			public ArrayList<String> getAllCyear()
			{
				ArrayList<String> cnoList=new ArrayList<String>();
				String sql = "SELECT DISTINCT cyear FROM courses";
				try {
					Connection conn = dataSource.getConnection();
					PreparedStatement pstmt = conn.prepareStatement(sql);
					ResultSet rst = pstmt.executeQuery();
					while (rst.next()) {
						cnoList.add(rst.getString("cyear"));
					}
					conn.close();
					return cnoList;
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return null;
			}
			//获得所有课程某年份的选课人数
			public ArrayList<CourseCount> getCoursesYearStatistic(String Cyear)
			{
				String sql="SELECT cname,COUNT(sno) statistic FROM courses,studentscourses,clubscourses WHERE cyear LIKE ? AND courses.cno=clubscourses.cno AND courses.cno=studentscourses.cno GROUP BY cname";
				ArrayList<CourseCount> coursecountList = new ArrayList<CourseCount>();
				try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
					pstmt.setString(1, "%"+Cyear+"%");

					try (ResultSet rst = pstmt.executeQuery()) {
						while (rst.next()) {
							CourseCount coursecount = new CourseCount();
							coursecount.setCname(rst.getString("cname"));
							coursecount.setStatistic(rst.getInt("statistic"));
							coursecountList.add(coursecount);
						}
						conn.close();
						return coursecountList;
					}
				} catch (SQLException se) {
					se.printStackTrace();
					return null;
				}
			}
}
