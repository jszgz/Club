package xueshe.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import xueshe.com.model.Club;
import xueshe.com.model.Course;
import xueshe.com.model.CourseCount;
import xueshe.com.model.Student;

public class ClubDao extends BaseDao {

	// 根据社团名称模糊查找课程
	public ArrayList<Club> findClubsByCLname(String clname) {
		String sql = "SELECT clno,clname,clabout FROM clubs WHERE clname like ?";
		ArrayList<Club> clubList = new ArrayList<Club>();
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, "%" + clname + "%");
			try (ResultSet rst = pstmt.executeQuery()) {
				while (rst.next()) {
					Club club = new Club();
					club.setCLno(rst.getString("clno"));
					club.setCLname(rst.getString("clname"));
					club.setCLabout(rst.getString("clabout"));
					clubList.add(club);
				}
				conn.close();
				return clubList;
			}
		} catch (SQLException se) {
			se.printStackTrace();
			return null;
		}
	}

	// 根据社团编号获取社团
	public Club getClubByCLno(String CLno) {
		String sql = "SELECT * FROM clubs where clno=?";

		try {
			Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, CLno);
			ResultSet rst = pstmt.executeQuery();
			while (rst.next()) {
				Club club = new Club();
				club.setCLno(rst.getString("clno"));
				club.setCLname(rst.getString("clname"));
				club.setCLabout(rst.getString("clabout"));
				conn.close();
				return club;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	// 根据社团名称获取社团
		public Club getClubByCLname(String CLname) {
			String sql = "SELECT * FROM clubs where clname=?";

			try {
				Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, CLname);
				ResultSet rst = pstmt.executeQuery();
				while (rst.next()) {
					Club club = new Club();
					club.setCLno(rst.getString("clno"));
					club.setCLname(rst.getString("clname"));
					club.setCLabout(rst.getString("clabout"));
					conn.close();
					return club;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		}

	// 增加社团
	public boolean insertClub(Club club) {
		String sql = "INSERT INTO clubs (clno,clname,clabout) VALUES (?,?,?)";
		try (Connection conn = this.dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, club.getCLno());
			pstmt.setString(2, club.getCLname());
			pstmt.setString(3, club.getCLabout());
			pstmt.executeUpdate();
			conn.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	// 删除社团
	public boolean deleteClub(String CLno) {
		String sql = "DELETE FROM clubs WHERE clno=?";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, CLno);
			pstmt.executeUpdate();
			conn.close();
			return true;
		} catch (Exception se) {
			se.printStackTrace();
			return false;
		}
	}
	//修改社团
		public boolean updateClub(Club club) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			try {
				conn = dataSource.getConnection();
				pstmt = conn.prepareStatement(
						"UPDATE clubs SET clname=?,clabout=? WHERE clno=?");
				pstmt.setString(1, club.getCLname());
				pstmt.setString(2, club.getCLabout());
				pstmt.setString(3, club.getCLno());
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
		//获取所有社团编号以便设置新插入社团的编号
		public ArrayList<String> getAllCLno()
		{
			ArrayList<String> clnoList=new ArrayList<String>();
			String sql = "SELECT clno FROM clubs";
			try {
				Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rst = pstmt.executeQuery();
				while (rst.next()) {
					clnoList.add(rst.getString("clno"));
				}
				conn.close();
				return clnoList;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		}
		//获取所有社团用于搜索选择
		public ArrayList<Club> getAllClub()
		{
			ArrayList<Club> clubList=new ArrayList<Club>();
			String sql = "SELECT clno,clname FROM clubs";
			try {
				Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rst = pstmt.executeQuery();
				while (rst.next()) {
					Club club=new Club();
					club.setCLno(rst.getString("clno"));
					club.setCLname(rst.getString("clname"));
					clubList.add(club);
				}
				conn.close();
				return clubList;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		}
		//获得某社团内各个课程某年份的选课人数
				public ArrayList<CourseCount> getClubCoursesYearStatistic(String CLno,String Cyear)
				{
					String sql="SELECT cname,COUNT(sno) statistic FROM courses,studentscourses,clubscourses WHERE cyear LIKE ? AND courses.cno=clubscourses.cno AND clno=? AND courses.cno=studentscourses.cno GROUP BY cname";
					ArrayList<CourseCount> coursecountList = new ArrayList<CourseCount>();
					try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
						pstmt.setString(1, "%"+Cyear+"%");
						pstmt.setString(2, CLno);

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
				//获得某社团内各个课程(某年份)
				public ArrayList<Course> getClubCourses(String CLno,String Cyear)
				{
					String sql="SELECT courses.cno,cname,cyear,cteacher FROM courses,clubscourses WHERE cyear LIKE ? AND courses.cno=clubscourses.cno AND clno=?";
					ArrayList<Course> courseList = new ArrayList<Course>();
					try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
						pstmt.setString(1, "%"+Cyear+"%");
						pstmt.setString(2, CLno);
						try (ResultSet rst = pstmt.executeQuery()) {
							while (rst.next()) {
								Course course = new Course();
								course.setCname(rst.getString("cname"));
								course.setCno(rst.getString("cno"));
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
	
}
