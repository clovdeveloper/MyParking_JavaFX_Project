
package com.clovdev.myparking.Dao;


import java.sql.*;
public class db_Mysql1 {
  

    static Connection con;
	public static String rapporteur;
	private static void getInstance(){
		rapporteur="";
		try {

			Class.forName("org.sqlite.JDBC");
                    //(org.sqlite.JDBC)
		    con=DriverManager.getConnection("jdbc:sqlite:myparking");
                    //("jdbc:sqlite:db")
                    rapporteur="succes";
                        System.out.println(rapporteur);
		    
			//System.out.println("La connexion a �t� �tablie avec succes");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rapporteur="La connexion echouee";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rapporteur="Connexion echouee";
		}




	}
	
	public static ResultSet interrogerBD(String requete){
		ResultSet result=null;
		Statement st=null;
		if(con==null)
			getInstance();
		if(rapporteur.equalsIgnoreCase("succes"))
		{ 
			try {
				st=con.createStatement();
				result=st.executeQuery(requete);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			/*try {
				result.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
*/
		}
		
		return result;
	}

	public static int updateBD(String requete){
		int result=-1;
		Statement st=null;
		if(con==null)
			getInstance();
		if(rapporteur.equalsIgnoreCase("succes"))
		{
			try {
				st=con.createStatement();
				result=st.executeUpdate(requete);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return result;
	}


	public static void main(String[] args) {
            getInstance();
        
    }
    
}
