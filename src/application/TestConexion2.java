package application;

import java.sql.*;
import java.util.Scanner;

public class TestConexion2 {

	private String bd;
	private String url= "jdbc:oracle:thin:@localhost:1521:XE";
	private String usr = "SYSTEM";
	private String pwd = "Miro_5838";
	private static Connection conexion;
	

	public TestConexion2()  {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conexion = DriverManager.getConnection(url, usr, pwd);
			
			if(!conexion.isClosed()) {
				System.out.println("Conexión establecida");
			}
			else
				System.out.println("Fallo en Conexión");	
			

		}catch (Exception e) {
			System.out.println("ERROR en conexión con ORACLE");	
			e.printStackTrace();
		}
		
	}

	public void CrearTablaPersonas() throws SQLException{
		
		Statement stmt = conexion.createStatement();
		
		String insertsql = "CREATE TABLE DANIEL.PERSONAS (nombre varchar2(10),apellido1 varchar2(10),apellido2 varchar2(10),email varchar2(50))";
		
		int resultado = stmt.executeUpdate(insertsql);
		
		if(resultado !=0) {
			System.out.println("Error en la creacion "+ resultado);

		}
	}
	public void InsertPersonas(String nombre,String apellido1,String apellido2,String email) throws SQLException{
		
		Statement stmt = conexion.createStatement();

		String insertsql = "INSERT INTO DANIEL.PERSONAS VALUES ('"+nombre+"','"+apellido1+"','"+apellido2+"','"+email+"')";
		
		int resultado = stmt.executeUpdate(insertsql);
		
		if(resultado !=1) {
			System.out.println("Error en la creacion "+ resultado);
		}else {
			System.out.println("Datos insertados");
		}
	}
	
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		Scanner in = new Scanner (System.in);
		
		TestConexion2 conn = new TestConexion2();
		conn.CrearTablaPersonas();
		
		System.out.println("nombre");
		String nombre= in.nextLine();
		System.out.println("apellido1");
		String apellido1=in.nextLine();
		System.out.println("apellido2");
		String apellido2=in.nextLine();
		System.out.println("email");
		String email=in.nextLine();
		
		conn.InsertPersonas(nombre,apellido1,apellido2,email);
		
	}

}