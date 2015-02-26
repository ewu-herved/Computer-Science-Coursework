/*****************************
*****************************/
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.CallableStatement;
import java.util.*;
import java.lang.String;

public class MyQuery {

    private Connection conn = null;
	private Statement statement = null;
	private ResultSet resultSet = null;
    
    public MyQuery(Connection c)throws SQLException
    {
        conn = c;
        statement = conn.createStatement();
    }
    
    public void findBestOfficer() throws SQLException
    {
      String query = "SELECT first, last, count(crime_id) cnt " +
                     "FROM officers join crime_officers using(officer_id) " +
                     "GROUP BY officer_id " +
                     "HAVING count(crime_id) > (SELECT avg(cnt) FROM " +
                     "(SELECT count(crime_id) cnt FROM crime_officers GROUP BY officer_id) temp);"; 
		resultSet = statement.executeQuery(query);
    }
    
    public void printBestOfficer() throws IOException, SQLException
    {
	 System.out.println("******** Query 1 ********");
	   System.out.println("\nLast, First, cnt");
      
      while (resultSet.next()) {
		//fill in this portion
      
         String result = resultSet.getString("Last") + ", " + 
         resultSet.getString("First") + ", " + resultSet.getInt("cnt");
         System.out.println(result);
      }
    }

    public void findCrimeCharge() throws SQLException
    {
      String query = "SELECT charge_id " +
                     "FROM crime_charges " +
                     "WHERE fine_amount > (SELECT avg(fine_amount) FROM crime_charges) " +
                     "and amount_paid < (SELECT avg(amount_paid) FROM crime_charges);";
                        
      resultSet = statement.executeQuery(query);
    }

    public void printCrimeCharge() throws IOException, SQLException
    {
	 System.out.println("******** Query 2 ********");
      System.out.println("\ncharge_id");
      
      while (resultSet.next()) {
		//fill in this portion
      
         String result = resultSet.getString("charge_id");
         System.out.println(result);
      }
    }

    public void findCriminal() throws SQLException
    {
      String query = "SELECT distinct first, last " +
                     "FROM criminals join crimes using(criminal_id) " +
                     "WHERE criminal_id in (SELECT criminal_id FROM crimes join crime_charges using(crime_id) " +
                     "WHERE crime_code in (SELECT crime_code FROM crime_charges WHERE crime_id = 10089));";
                        
      resultSet = statement.executeQuery(query);
    }

    public void printCriminal() throws IOException, SQLException
    {
	 System.out.println("******** Query 3 ********");
      System.out.println("\nfirst, last");
      
      while (resultSet.next()) {
		//fill in this portion
      
         String result = resultSet.getString("first") + ", " + resultSet.getString("last");
         System.out.println(result);
      }
    }

    public void findCriminalSentence() throws SQLException
    {
       String query = "SELECT criminal_id, last, first, count(sentence_id) cnt_sentence " +
                      "FROM criminals join sentences using(criminal_id) " +
                      "GROUP BY criminal_id " +
                      "HAVING count(sentence_id) > 1;";
                        
       resultSet = statement.executeQuery(query);  
    }

    public void printCriminalSentence() throws IOException, SQLException
    {
	 System.out.println("******** Query 4 ********");
       System.out.println("\ncriminal_id, last, first, cnt_sentence");
      
       while (resultSet.next()) {
		 //fill in this portion
      
          String result = "   " + resultSet.getString("criminal_id") + ",     " + resultSet.getString("last") + ", " +
                          resultSet.getString("first") + ",       " + resultSet.getString("cnt_sentence");
          System.out.println(result);
       }
    }

    public void findChargeCount() throws SQLException
    {
	    String query = "SELECT precinct, count(charge_id) charge_cnt " +
                      "FROM officers join crime_officers using(officer_id) join crime_charges using(crime_id) " +
                      "WHERE charge_status = 'GL' " +
                      "GROUP BY precinct " +
                      "HAVING count(charge_id) >= 7; ";
                        
       resultSet = statement.executeQuery(query);
    }

    public void printChargeCount() throws IOException, SQLException
    {
	 System.out.println("******** Query 5 ********");
       System.out.println("\nprecinct, charge_cnt");
      
       while (resultSet.next()) {
		 //fill in this portion
      
          String result = resultSet.getString("precinct") + "    , " + resultSet.getString("charge_cnt");
          System.out.println(result);
       }
    }
	
    public void findCrimeCounts() throws SQLException
    {
	 System.out.println("******** Query 6 ********");	
	 InputStreamReader istream = new InputStreamReader(System.in) ;
        BufferedReader bufRead = new BufferedReader(istream) ;
		
       boolean continueInput = true;   
          
	    do {
         
   
         try{
            System.out.println("\nPlease enter the officer_id for the query: ");
            //fill in this portion
            
            int id = 0;
            int cnt = 0;
            
            id = Integer.parseInt(bufRead.readLine());
            
            if((double)(id) / 1000000 > 1 || id < 0) {
            
               throw new InputMismatchException();
            }
            
            continueInput = false;
            
            String query = "SELECT count(charge_id) charge_cnt " +
                           "FROM crime_charges join crime_officers using(crime_id) " +
                           "GROUP BY officer_id " +
                           "HAVING officer_id = " + id + ";";                           
                        
            resultSet = statement.executeQuery(query);
            
            while (resultSet.next()) {
            
               cnt = resultSet.getInt("charge_cnt");
			
	            System.out.println("Officer " +id+" has reported "+cnt+" crimes.");
            }
	      }
         
         catch (IOException err) {
            System.out.println("Error reading line");
         }
         catch (InputMismatchException ex) {
   
            System.out.println("Invalid officer_id");
         }  
      }while(continueInput);	       
   }
}

