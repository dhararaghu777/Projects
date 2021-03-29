package com.project.loan.dao;

import java.sql.*;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.project.loan.dto.Eligibility;
import com.project.loan.dto.Approved;
import com.project.loan.dto.CustomerDetails;
import com.project.loan.dto.Program;
import com.project.loan.dto.User;
import com.project.loan.util.DBUtils;

public class DAOImpl implements DAO{
	boolean b=false;

	@Override
	public boolean apply(CustomerDetails cd) {

		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;	
		String query="insert into customer_details values(?,?,?,?,?,?,?)";
		String date=""+LocalDate.now();
		try
		{
			Class.forName(DBUtils.DRIVER);
			con=DriverManager.getConnection(DBUtils.DBURL,DBUtils.USER,DBUtils.PASS);


			pstmt=con.prepareStatement(query);
			pstmt.setString(1, cd.getName());
			pstmt.setString(2, cd.getDob());
			pstmt.setString(3, cd.getMartial());
			pstmt.setLong(4,cd.getNumber());
			pstmt.setString(5,cd.getEmail());
			pstmt.setInt(6,cd.getDependents());
			pstmt.setString(7,date);
			int count=pstmt.executeUpdate();
			if(count>0)
			{

				b=true;			

			}		

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
			try {
				if(con!=null)
				{
					con.close();
				}
				if(pstmt!=null)
				{
					pstmt.close();
				}
				if(rs!=null)
				{
					rs.close();
				}

			}catch(Exception e)
			{
				e.printStackTrace();
			}

		}
		return b;


	}



	@Override
	public List<Program> view() {
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;	
		ArrayList<Program> array=new ArrayList<Program>();
		String query="select * from loan_programs";
		try
		{
			Class.forName(DBUtils.DRIVER);
			con=DriverManager.getConnection(DBUtils.DBURL,DBUtils.USER,DBUtils.PASS);

			stmt=con.createStatement();
			rs=stmt.executeQuery(query);
			while(rs.next()) {
				Program ref=new Program();
				ref.setProgramName(rs.getString("program_name"));
				ref.setDescription(rs.getString("description"));
				ref.setType(rs.getString("type"));
				ref.setDuration(rs.getInt("duration_in_years"));
				ref.setMinAmnt(rs.getInt("min_loan_amnt"));
				ref.setMaxAmnt(rs.getInt("max_loan_amnt"));
				ref.setInterest(rs.getInt("rate_of_interest"));
				ref.setProofs(rs.getString("proofs_required"));
				array.add(ref);
			}


		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;			
		}
		finally {
			try {
				if(con!=null) {
					con.close();
				}
				if(stmt!=null) {
					stmt.close();
				}
				if(rs!=null) {
					rs.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return array;





	}

	@Override
	public User login(User u) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;	
		String query=" select * from users where login_id= ? and password= ? and role= ? ";
		try
		{
			Class.forName(DBUtils.DRIVER);
			con=DriverManager.getConnection(DBUtils.DBURL,DBUtils.USER,DBUtils.PASS);


			pstmt=con.prepareStatement(query);
			pstmt.setString(1, u.getLoginId());
			pstmt.setString(2, u.getPassword());
			pstmt.setString(3, u.getRole());
			rs=pstmt.executeQuery();
			if(rs.next())
			{

				return u;			

			}		

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
			try {
				if(con!=null)
				{
					con.close();
				}
				if(pstmt!=null)
				{
					pstmt.close();
				}
				if(rs!=null)
				{
					rs.close();
				}

			}catch(Exception e)
			{
				e.printStackTrace();
			}

		}
		return null;



	}

	@Override
	public Eligibility checkEligibility(Eligibility c) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;	
		String query="select date,martial_status,dependents from customer_details where phone_number=?";
		try
		{
			Class.forName(DBUtils.DRIVER);
			con=DriverManager.getConnection(DBUtils.DBURL,DBUtils.USER,DBUtils.PASS);


			pstmt=con.prepareStatement(query);
			pstmt.setLong(1,c.getPhone());
			rs=pstmt.executeQuery();
			if(rs.next())
			{			
				c.setDepndents(rs.getInt("dependents"));
				c.setMartial(rs.getString("martial_status"));
				c.setDate(rs.getString("date"));
				return c;
			}	


		}
		catch(Exception e)
		{
			return null;

		}finally
		{
			try {
				if(con!=null)
				{
					con.close();
				}
				if(pstmt!=null)
				{
					pstmt.close();
				}
				if(rs!=null)
				{
					rs.close();
				}

			}catch(Exception e)
			{
				e.printStackTrace();
			}

		}
		return null;


	}

	@Override
	public void allotInterview() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doVerification() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean logout() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean uploadSchemes(String name,String desc,String type,long dur,long min_amnt,long max_amnt,long interest,String proof) {

		Connection con=null;
		PreparedStatement pstmt=null;

		try {

			Class.forName(DBUtils.DRIVER);
			con=DriverManager.getConnection(DBUtils.DBURL,DBUtils.USER,DBUtils.PASS);


			String query="insert into loan_programs values(?,?,?,?,?,?,?,?)";
			pstmt=con.prepareStatement(query);
			pstmt.setString(1, name);
			pstmt.setString(2, desc);
			pstmt.setString(3,type);
			pstmt.setLong(4, dur);
			pstmt.setLong(5,min_amnt);
			pstmt.setLong(6,max_amnt);
			pstmt.setLong(7,interest);
			pstmt.setString(8,proof);
			int count=pstmt.executeUpdate();

			if(count>0)
			{
				b=true;
			}else
			{
				b=false;
			}			

		}catch(Exception e)
		{
			e.printStackTrace();


		}finally
		{
			try {
				if(con!=null)
				{
					con.close();
				}
				if(pstmt!=null)
				{
					pstmt.close();
				}

			}catch(Exception e)
			{
				e.printStackTrace();
			}

		}
		return b;


	}






	@Override
	public boolean deleteSchemes(String name) {


		Connection con=null;
		PreparedStatement pstmt=null;
		try
		{
			Class.forName(DBUtils.DRIVER);
			con=DriverManager.getConnection(DBUtils.DBURL,DBUtils.USER,DBUtils.PASS);

			String query="delete from loan_programs where program_name=?";
			pstmt=con.prepareStatement(query);

			pstmt.setString(1, name);
			int count=pstmt.executeUpdate();
			if(count>0)
			{
				b=true;
			}
			else {
				b=false;
			}


		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			try {
				if(con!=null)
				{
					con.close();
				}
				if(pstmt!=null)
				{
					pstmt.close();
				}

			}catch(Exception e)
			{
				e.printStackTrace();
			}

		}
		return b;

	}

	@Override
	public boolean updateSchemes(String where1,String where2,long value) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try
		{
			Class.forName(DBUtils.DRIVER);
			con=DriverManager.getConnection(DBUtils.DBURL,DBUtils.USER,DBUtils.PASS);

			String query=" update loan_programs set "+where1+" = ? where program_name = ? " ;
			pstmt=con.prepareStatement(query);
			//pstmt.setString(1,where1);
			pstmt.setLong(1,value);
			pstmt.setString(2,where2);
			int count=pstmt.executeUpdate();
			if(count>0)
			{
				b= true;
			}			

		}catch(Exception e)
		{
			e.printStackTrace();

		}
		finally {
			try {
				if(con!=null)
				{
					con.close();
				}
				if(pstmt!=null)
				{
					pstmt.close();
				}

			}catch(Exception e)
			{
				e.printStackTrace();
			}}
		return b;




	}

	@Override
	public Program search(String name) {

		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		try
		{
			Class.forName(DBUtils.DRIVER);
			con=DriverManager.getConnection(DBUtils.DBURL,DBUtils.USER,DBUtils.PASS);

			String query="select * from loan_programs where program_name=?";
			pstmt=con.prepareStatement(query);
			pstmt.setString(1,name);
			rs=pstmt.executeQuery();

			if(rs.next())
			{
				Program p=new Program();
				p.setProgramName(rs.getString("program_name"));
				p.setDescription(rs.getString("description"));
				p.setType(rs.getString("type"));
				p.setDuration(rs.getInt("duration_in_years"));
				p.setMinAmnt(rs.getInt("min_loan_amnt"));
				p.setMaxAmnt(rs.getInt("max_loan_amnt"));
				p.setInterest(rs.getInt("rate_of_interest"));
				p.setProofs(rs.getString("proofs_required"));

				return p;
			}


		}catch(Exception e)
		{
			e.printStackTrace();

		}
		finally {
			try {
				if(con!=null)
				{
					con.close();
				}
				if(pstmt!=null)
				{
					pstmt.close();
				}

			}catch(Exception e)
			{
				e.printStackTrace();
			}}

		return null;
	}



	@Override
	public boolean deleteApplicant(Eligibility e) {
		
		Connection con=null;
		PreparedStatement pstmt=null;		
		try
		{
			Class.forName(DBUtils.DRIVER);
			con=DriverManager.getConnection(DBUtils.DBURL,DBUtils.USER,DBUtils.PASS);

			String query="delete from customer_details where phone_number=?";
			pstmt=con.prepareStatement(query);
			pstmt.setLong(1,e.getPhone());
			int count=pstmt.executeUpdate();

			if(count>0)
			{
				return true;
			}
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}finally {
			try {
				if(con!=null) {
					con.close();
				}
				if(pstmt!=null) {
					pstmt.close();
				}				
			}catch(Exception exp) {
				exp.printStackTrace();
			}
		}

		
		
		return false;
	}



	@Override
	public boolean approve(Approved a) {
		
		Connection con=null;
		PreparedStatement pstmt=null;		
		try
		{
			Class.forName(DBUtils.DRIVER);
			con=DriverManager.getConnection(DBUtils.DBURL,DBUtils.USER,DBUtils.PASS);

			String query="insert into approved_loans values(?,?,?,?,?,?,?)";
			pstmt=con.prepareStatement(query);
			pstmt.setString(1,a.getName());
			pstmt.setDouble(2,a.getApprovedLoan());
			pstmt.setDouble(3,a.getMonthly());
			pstmt.setInt(4,a.getDuration());
			pstmt.setDouble(5,a.getDownPayment());
			pstmt.setInt(6,a.getInterest());
			pstmt.setDouble(7,a.getTotalAmnt());
			
			
			int count=pstmt.executeUpdate();

			if(count>0)
			{
				return true;
			}
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}finally {
			try {
				if(con!=null) {
					con.close();
				}
				if(pstmt!=null) {
					pstmt.close();
				}				
			}catch(Exception exp) {
				exp.printStackTrace();
			}
		}
		
		return false;
	}






}
