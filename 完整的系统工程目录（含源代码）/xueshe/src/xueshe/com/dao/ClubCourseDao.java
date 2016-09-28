package xueshe.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ClubCourseDao extends BaseDao{
	//增加一条社团课程的记录
		public boolean insertClubCourse(String CLno,String Cno)
		{
			String sql = "INSERT INTO clubscourses (clno,cno) VALUES (?,?)";
			try (Connection conn = this.dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
				pstmt.setString(1, CLno);
				pstmt.setString(2, Cno);
				pstmt.executeUpdate();
				conn.close();
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
		//删除一条社团课程的记录
		public boolean deleteClubCourse(String CLno,String Cno)
		{
			String sql = "DELETE FROM clubscourses WHERE clno=? AND cno=?";
			try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
				pstmt.setString(1, CLno);
				pstmt.setString(2, Cno);
				pstmt.executeUpdate();
				conn.close();
				return true;
			} catch (Exception se) {
				se.printStackTrace();
				return false;
			}
		}
}
