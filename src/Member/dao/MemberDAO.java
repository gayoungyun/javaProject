package Member.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Member.dto.MemberDTO;

public class MemberDAO {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	public MemberDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버로드");
			String ur1= "jdbc:oracle:thin:@localhost:1521:xe";
			String id ="java", pwd = "1234";
			con = DriverManager.getConnection(ur1, id, pwd);
			System.out.println("연결성공");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<MemberDTO> getMembers(){
		String sql = "select * from memberdatainfo";
		ArrayList<MemberDTO> member = new ArrayList<>();
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while( rs.next() ) {
				MemberDTO dto = new MemberDTO();
				dto.setNum(rs.getInt("num"));
				dto.setId(rs.getString("id"));
				dto.setPwd(rs.getString("pwd"));
				dto.setName(rs.getString("name"));
				dto.setBirth(rs.getString("birth"));
				dto.setTel(rs.getString("tel"));
				dto.setGender(rs.getInt("gender"));
				dto.setAdd(rs.getString("add"));

				member.add(dto);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return member; 
	}

	public int insert(MemberDTO dto) {
		String sql = "insert into memberdatainfo values(memberinf_SEQ.nextval,?,?,?,?,?,?,?)";
		int result = 0;
		try {
			ps = con.prepareStatement(sql);
			//		ps.setInt(1, dto.getNum());
			ps.setString(1, dto.getId());
			ps.setString(2, dto.getPwd());
			ps.setString(3, dto.getName());
			ps.setString(4, dto.getBirth());
			ps.setString(5, dto.getTel());
			ps.setInt(6, dto.getGender());
			ps.setString(7, dto.getAdd());

			System.out.println("test");
			result = ps.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public int memberChk(MemberDTO dto) {
		String userPwd = null;
		String sql = "select * from memberdatainfo where y_pwd='"+userPwd+"'";
		//MemberDTO dto = null;
		int result = -1;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getPwd());
			rs = ps.executeQuery();
			
			if(rs.next()) {
				if(rs.getString("y_pwd").equals(dto.getPwd())) {
					result = 1;
				}else {
					result = 0;
				}

			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public int delete(String delPwd) {
		String sql = "delete from memberdatainfo where pwd=?";
		int result = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, delPwd);
			result = ps.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public boolean phoneNumberchk(String phone)
	{
		String sql = "select * from memberdatainfo where y_tel=?";
		MemberDTO dto = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, phone);
			rs= ps.executeQuery();

			if(rs.next())
			{
				return true;
			}

		}catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}
	
	public boolean passwordchk(String pwd)
	{
		String sql = "select * from memberdatainfo where y_pwd=?";
		MemberDTO dto = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, pwd);
			rs= ps.executeQuery();

			if(rs.next())
			{
				return true;
			}

		}catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}
	
	public MemberDTO findMember(String pwd)
	{
		String sql = "select * from memberdatainfo where y_pwd=?";
		MemberDTO dto = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, pwd);
			rs= ps.executeQuery();
			
			if(rs.next())
			{
				dto = new MemberDTO();
				dto.setId(rs.getString("y_id"));
				dto.setName(rs.getString("y_name"));
				dto.setBirth(rs.getString("y_brith"));
				dto.setTel(rs.getString("y_tel"));
				dto.setAdd(rs.getString("y_add"));
					
			}

		}catch (Exception e) {
			e.printStackTrace();
		}

		return dto;
	}
	
	
	public int modify(MemberDTO dto) {
		String sql = "update memberdatainfo set y_id=?, y_pwd=?, y_name=?, y_tel=?, y_add=?";
		int result = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getId());
			ps.setString(2, dto.getPwd());
			ps.setString(3, dto.getName());
			//ps.setString(4, dto.getBirth());
			ps.setString(4, dto.getTel());
			//ps.setInt(6, dto.getGender());
			ps.setString(5, dto.getAdd());
			result = ps.executeUpdate();

			System.out.println("test");
			result = ps.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}


}
