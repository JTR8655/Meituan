package meituan.dao;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBHelper {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs ;
	
	public Connection getConn(){
		Context ctx;
		try {
			ctx = new InitialContext();
			DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/cmsd");
			conn = ds.getConnection();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	
	public  void closeAll(Connection conn,PreparedStatement pstmt,ResultSet rs){
		if(null!=rs){
			try {
				 
					rs.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(null!=pstmt){
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(null!=conn){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	/**
	 * 给占位符赋值
	 * @param pstmt 要操作的sql语句
	 * @param params 要执行的sql语句中对应的占位符的值 为null则没有占位符
	 * @throws SQLException
	 */
	public void setValue(PreparedStatement pstmt,List<Object> params) throws SQLException{
		//给占位符赋值
		if(params!=null && params.size()>0){
			Object obj=null;
			String type="";
			for(int i=0;i<params.size();i++){
				obj=params.get(i);
				if(obj!=null){
					type=obj.getClass().getName();
					if("[B".equals(type)){
						pstmt.setBytes(i+1, (byte[]) obj);
					} else{
						pstmt.setString(i+1, String.valueOf(obj));
					}
				} else{
					pstmt.setString(i+1,String.valueOf(obj) );
				}
			}
		}
	}
	
	/**
	 * 更新操作
	 * @param sql 要操作的sql语句
	 * @param params 要执行的sql语句中对应的占位符的值 为null则没有占位符
	 * @return
	 */
	public int update(String sql,List<Object> params){
		int result=0;
		
		try {
			conn=this.getConn();
			pstmt=conn.prepareStatement(sql);
			
			this.setValue(pstmt, params);
			result=pstmt.executeUpdate(); //执行语句
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeAll(conn, pstmt, rs);
		}  
		return result;
	}
	
	/**
	 * 增删改的操作 多条语句 sql: 语句, 有可能有?,也有可能没有 params: 参数值的集合
	 * @param sqls
	 * @param params
	 * @return
	 * @throws Exception 
	 */
	public  int doUpdate(List<String> sqls,List<List<Object>> params) throws Exception{
		Connection conn =null;
		PreparedStatement pstmt =null;
		int result = -1;
		try{
			conn = this.getConn();
			conn.setAutoCommit(false);//关闭隐式事务
			if(sqls!=null&&sqls.size()>0){
				for(int i=0;i<sqls.size();i++){
					String sql =sqls.get(i);
					pstmt = conn.prepareStatement(sql);
					setValue(pstmt, params.get(i));
					result = pstmt.executeUpdate();
				}
			}
			conn.commit();//提交事务
		}catch(Exception e){
			conn.rollback();//事务回滚
			throw e;
		}finally{
			conn.setAutoCommit(true);//恢复现场
			closeAll(conn, pstmt, null);
		}
		
		return result;
	}
	
	/**
	 * 查询结果集
	 * @param sql 要执行的sql语句
	 * @param params 要执行的sql语句中对应的占位符的值 为null则没有占位符
	 * @return
	 */
	public List<Map<String, Object> > select(String sql,List<Object> params){
		List<Map<String, Object> > list=new ArrayList<Map<String, Object> >();
		Map<String, Object> map=null; //以列名为键，以对应的值为键
		
		try {
			conn=this.getConn();
			pstmt=conn.prepareStatement(sql);
			
			this.setValue(pstmt, params);
			
			rs=pstmt.executeQuery();
			
			ResultSetMetaData rsmd= rs.getMetaData();//获取元数据
			//从元数据中获取列的信息
			
			String[] colNames=new String[ rsmd.getColumnCount() ];;
			for(int i=0;i<colNames.length;i++){
				colNames[i]=rsmd.getColumnName(i+1);
			}
			
			while(rs.next()){
				map=new HashMap<String, Object>();
				Object obj=null;
				String type;
				if(colNames!=null && colNames.length>0){ 
					//循环取出每一个值
					for(String s:colNames){
						obj=rs.getObject(s);
						if(obj!=null){
							type=obj.getClass().getName();
							if("oracle.sql.BLOB".equals(type)){
								Blob blob=rs.getBlob(s);
								byte[] bt=null;
								InputStream is=blob.getBinaryStream();
								if(is!=null){
									bt=new byte[(int) blob.length()];
									try {
										is.read(bt);
									} catch (IOException e) {
										e.printStackTrace();
									} finally{
										if(is!=null){
											try {
												is.close();
											} catch (IOException e) {
												e.printStackTrace();
											}
										}
									}
									map.put(s, bt);
								} else{
									map.put(s, null);
								}
							} else{
								map.put(s,String.valueOf(obj));
							}
						} else{
							map.put(s, null);
						}
					}
				}
				list.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally{
			this.closeAll(conn, pstmt, rs);
		} 
		return list;
	}
	
	/**
	 * 聚合查询
	 * @param sql　要执行的sql语句
	 * @param params　要执行的sql语句中对应的占位符的值 为null则没有占位符
	 * @return
	 */
	public double selectPloymer(String sql,List<Object> params){
		double result=0;
		
		conn=this.getConn();
		try {
			pstmt=conn.prepareStatement(sql);
			this.setValue(pstmt, params);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				result=rs.getDouble(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeAll(conn, pstmt, rs);
		}   
		
		return result;
	}
	
	/**
	 * 聚合查询
	 * @param sql　要执行的sql语句
	 * @param params　要执行的sql语句中对应的占位符的值 为null则没有占位符
	 * @return
	 */
	public List<Double> selectPloymers(String sql,List<Object> params){
		List<Double> result=new ArrayList<Double>();;
		
		conn=this.getConn();
		try {
			pstmt=conn.prepareStatement(sql);
			this.setValue(pstmt, params);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				for(int i=0;i<rs.getMetaData().getColumnCount();i++){
					result.add(rs.getDouble(i+1));
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			this.closeAll(conn, pstmt, rs);
		}  
		
		return result;
	}
	
	/**
	 * DDL操作
	 * @param sql 要执行的语句
	 * @return
	 */
	public boolean createOp(String sql){
		boolean bl=false;
		
		try {
			conn=this.getConn();
			pstmt=conn.prepareStatement(sql);
			bl=pstmt.execute();
			
		} catch (SQLException e) {
			 
			e.printStackTrace();
		}  
		return bl;
	}
	
	public <T> List<T> find(String sql,List<Object> params,Class c){
		List<T> list=new ArrayList<T>();
		try {
			conn=this.getConn(); //获取连接
			pstmt=conn.prepareStatement(sql);
			this.setValue(pstmt, params);
			rs=pstmt.executeQuery();
			
			//获取返回的结果集中的所有列的列名
			ResultSetMetaData rsmd=rs.getMetaData(); //获取元数据，包含类的名称、类型等信息
			
			String[] colsName=new String[rsmd.getColumnCount()];

			//循环取出每一个列的列名存入到colsName数组中
			for(int i=0;i<colsName.length;i++){
				colsName[i]=rsmd.getColumnName(i+1);
			}
			
			//System.out.println(Arrays.toString(colsName));
			//获取给定的类的所有公有的方法
			Method[] methods=c.getMethods();
//			for(Method m:methods){
//				System.out.println(m.getName());
//			}
			//set+列名 与给定的类中的方法忽略大小写循环比较，如果能匹配的上，则激活该方法将当前列的值注入到对象的对应属性中
			T t; //实例化对象
			String methodName=null;//方法名
			String colName=null; //列名
			String typeName=null; //参数类型名
			Object val=null; //当前循环的列的值
			
			while(rs.next()){
				t=(T) c.newInstance(); //实例化一个类的对象
				for(int i=0;i<colsName.length;i++){
					//获取当前循环的列的列名
					colName=colsName[i];
					
					//根据列名取出当前列中的值
					val=rs.getObject(colName);
					
					for(Method md:methods){ //循环跟方法名比较
						methodName=md.getName();
						if(("set"+colName).equalsIgnoreCase(methodName) && val!=null ){
							//获取返回值的类型
							typeName=val.getClass().getName();
							if("java.math.BigDecimal".equals(typeName)){
								//激活当前方法注值
								md.invoke(t,rs.getInt(colName));
							}else {
								md.invoke(t,rs.getString(colName));
							}
						}
					}
				}
				list.add(t);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}finally{
			this.closeAll(conn, pstmt, rs);
		} 
		return list;
	}
	
}
