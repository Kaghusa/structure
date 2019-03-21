
/* Introduction 
  ==============
*db Class
*This class is used for database related (connect, insert, update, and delete) operations , 
* It aims to facilitate the  use of CRUD functions every where they are needed in the project and to avoid multiple CRUD lines of code. 
* by calling this class you can access the databases
* @author    Kaghusa  Boniface  Mutanava 
*/

package core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.Set;

public class db 
{
    // General Attributes  for database related operations 
    public Connection con=null;
    public String Username="root";
    public String Passwword="";
//    public  Statement Stmt=null;
    private  PreparedStatement psmt=null;
    private  String Url="jdbc:mysql://127.0.0.1:3307/struct?useUnicode=yes&characterEncoding=UTF-8";
    private String  SQL="";
    private ResultSet result =null;
     
    // function to return the Database cannection parameters 
    public Connection getcon() throws SQLException
        {
            con=DriverManager.getConnection(Url, Username, Passwword);
            return con;
        }
    //fucntion to return  the Drive of the database being used 
    public void GetDrive() throws ClassNotFoundException
        {
            Class.forName("com.mysql.jdbc.Driver");
        }
   
    // Connect to the database
    public void connection() throws ClassNotFoundException, SQLException
            {   
                GetDrive();
                getcon();
               
            }   
    /*
     * Returns rows from the database based on the conditions
     * @param string name of the table
     * @param array Conditions :  wherelike, select, where, order_by, limit, whereless, wheregreater, wheregreaterequal, wherelessequal,Conditions
     */
    public  ResultSet getrows (String Table,Map Conditions) throws SQLException, ClassNotFoundException
            {
                ResultSet rows=null;
                String sql="SELECT  ";
              
            if (!Conditions.isEmpty())
                {   
                    int i =0; 
                    sql+=(Conditions.containsKey("select")?Conditions.get("select"): " * ");
                    sql+=" FROM  "+Table;  
                    
                    if (Conditions.containsKey("where"))
                        {
                                    sql+= " WHERE ";
                                    Map where= (Map) Conditions.get("where");
                                    Set <String> keys =  where.keySet();
                                    for(String key: keys) 
                                        {
                                           
                                           String pre  =(i>0)?" AND ":" ";
                                           sql+= pre+key +" = '"+where.get(key)+"'";
                                            i++;
                                        }     
                        } 
                    
                    
                       if (Conditions.containsKey("whereless"))
                        {
                                    sql+= " WHERE ";
                                    Map whereless= (Map) Conditions.get("whereless");
                                    Set <String> keys =  whereless.keySet();
                                    for(String key: keys) 
                                        {
                                           
                                           String pre  =(i>0)?" AND ":" ";
                                           sql+= pre+key +" < '"+whereless.get(key)+"'";
                                            i++;
                                        }     
                        } 
                    
                           if (Conditions.containsKey("wheregreater"))
                        {
                                    sql+= " WHERE ";
                                    Map wheregreater= (Map) Conditions.get("wheregreater");
                                    Set <String> keys =  wheregreater.keySet();
                                    for(String key: keys) 
                                        {
                                           
                                           String pre  =(i>0)?" AND ":" ";
                                           sql+= pre+key +" > '"+wheregreater.get(key)+"'";
                                            i++;
                                        }     
                        } 
                           
                           
                                  if (Conditions.containsKey("wheregreaterequal"))
                        {
                                    sql+= " WHERE ";
                                    Map wheregreaterequal= (Map) Conditions.get("wheregreaterequal");
                                    Set <String> keys =  wheregreaterequal.keySet();
                                    for(String key: keys) 
                                        {
                                           
                                           String pre  =(i>0)?" AND ":" ";
                                           sql+= pre+key +" >= '"+wheregreaterequal.get(key)+"'";
                                            i++;
                                        }     
                        }
                                  
                               if (Conditions.containsKey("wherelessequal"))
                        {
                                    sql+= " WHERE ";
                                    Map wherelessequal= (Map) Conditions.get("wherelessequal");
                                    Set <String> keys =  wherelessequal.keySet();
                                    for(String key: keys) 
                                        {
                                           
                                           String pre  =(i>0)?" AND ":" ";
                                           sql+= pre+key +" <= '"+wherelessequal.get(key)+"'";
                                            i++;
                                        }     
                        }
                    
                    
                    
                    if (Conditions.containsKey("wherelike"))
                        {
                                    sql+= " WHERE ";
                                    Map wherelike= (Map) Conditions.get("wherelike");
                                    Set <String> keys =  wherelike.keySet();
                                    for(String key: keys) 
                                        {
                                           
                                           String pre  =(i>0)?" OR ":" ";
                                           sql+= pre+key +" LIKE '%"+wherelike.get(key)+"%'";
                                            i++;
                                        }     
                        } 
                          
                    if (Conditions.containsKey("order_by"))
                        {
                                    sql+= " ORDER BY      "+Conditions.get("order_by");
                                   
                        }
                    
                    if (Conditions.containsKey("start") &&  Conditions.containsKey("limit"))
                        {
                                    sql+= " LIMIT   "+Conditions.get("start")+", "+Conditions.get("limit");
                                   
                        }
                    else if (!Conditions.containsKey("start") &&  Conditions.containsKey("limit"))
                        {
                                    sql+= " LIMIT   "+Conditions.get("limit");
                                   
                        }
                   connection();
                   psmt=getcon().prepareStatement(sql);
                   rows =psmt.executeQuery();
                  
                 }
           return  rows ; 
            
            }
    
     /*
     * Returns a specific element  from the database table  based on the ID 
     * @param String Object is the name of the specific wanted element  of the table
     * @param String Table is the name of the target table
     * @param int  id  the Id of the target element in the table
     */
    
    public String get_tblelmt_by_id(String Object, String Table, int id) throws SQLException, ClassNotFoundException
    {
        String elmt="";
        ResultSet data =null;
         String sql="SELECT  "+Object+" FROM "+Table+" where id = '"+id+"'";
                   connection();
                   psmt=getcon().prepareStatement(sql);
                   data =psmt.executeQuery(); 
                   if (data.next())
                        {
                            elmt=data.getString(Object);
                        }  
        return elmt;
    }

       /*
     * Returns a  Max value of specific column   from the database table  
     * @param String Object is the name of the specific  column   of the table
     * @param String Table  is the name of the target table
     * @param array Conditions :  select, where, order_by, limit, whereless, wheregreater, wheregreaterequal, wherelessequal,Conditions
     */
    
    public double GetMax(String Object, String Table, Map Conditions) throws SQLException, ClassNotFoundException
    {
         String sql="SELECT  MAX("+Object+")   FROM "+Table+"";
        double max = 0.0;
        ResultSet data =null;
       
        int i=0; 
       
            
        if (!Conditions.isEmpty())
                {
                
                    
                    
                        if (Conditions.containsKey("where"))
                        {
                                    sql+= " WHERE ";
                                    Map where= (Map) Conditions.get("where");
                                    Set <String> keys =  where.keySet();
                                    for(String key: keys) 
                                        {
                                           
                                           String pre  =(i>0)?" AND ":" ";
                                           sql+= pre+key +" = '"+where.get(key)+"'";
                                            i++;
                                        }     
                        } 
                    
                    
                       if (Conditions.containsKey("whereless"))
                        {
                                    sql+= " WHERE ";
                                    Map whereless= (Map) Conditions.get("whereless");
                                    Set <String> keys =  whereless.keySet();
                                    for(String key: keys) 
                                        {
                                           
                                           String pre  =(i>0)?" AND ":" ";
                                           sql+= pre+key +" < '"+whereless.get(key)+"'";
                                            i++;
                                        }     
                        } 
                    
                           if (Conditions.containsKey("wheregreater"))
                        {
                                    sql+= " WHERE ";
                                    Map wheregreater= (Map) Conditions.get("wheregreater");
                                    Set <String> keys =  wheregreater.keySet();
                                    for(String key: keys) 
                                        {
                                           
                                           String pre  =(i>0)?" AND ":" ";
                                           sql+= pre+key +" > '"+wheregreater.get(key)+"'";
                                            i++;
                                        }     
                        } 
                           
                           
                                  if (Conditions.containsKey("wheregreaterequal"))
                        {
                                    sql+= " WHERE ";
                                    Map wheregreaterequal= (Map) Conditions.get("wheregreaterequal");
                                    Set <String> keys =  wheregreaterequal.keySet();
                                    for(String key: keys) 
                                        {
                                           
                                           String pre  =(i>0)?" AND ":" ";
                                           sql+= pre+key +" >= '"+wheregreaterequal.get(key)+"'";
                                            i++;
                                        }     
                        }
                                  
                               if (Conditions.containsKey("wherelessequal"))
                        {
                                    sql+= " WHERE ";
                                    Map wherelessequal= (Map) Conditions.get("wherelessequal");
                                    Set <String> keys =  wherelessequal.keySet();
                                    for(String key: keys) 
                                        {
                                           
                                           String pre  =(i>0)?" AND ":" ";
                                           sql+= pre+key +" <= '"+wherelessequal.get(key)+"'";
                                            i++;
                                        }     
                        }
                    
                        
                }
        
                connection();
                psmt=getcon().prepareStatement(sql);
                data =psmt.executeQuery(); 
                if (data.next())
                    {
                        max=data.getDouble(1);
                    } 
                 //psmt.close();
        return max;
       
    }
    
    /*
     * Returns a  Min value of specific column   from the database table  
     * @param String Object is the name of the specific  column   of the table
     * @param String Table  is the name of the target table
     * @param array Conditions : select, where, order_by, limit, whereless, wheregreater, wheregreaterequal, wherelessequal,Conditions
     */
   
    
    
    
     public double GetMin(String Object, String Table, Map Conditions) throws SQLException, ClassNotFoundException
    {
         String sql="SELECT  MIN("+Object+")   FROM "+Table+"";
        double min = 0.0;
        ResultSet data =null;
       
        int i=0; 
       
            
        if (!Conditions.isEmpty())
                {
                
                    
                    
                        if (Conditions.containsKey("where"))
                        {
                                    sql+= " WHERE ";
                                    Map where= (Map) Conditions.get("where");
                                    Set <String> keys =  where.keySet();
                                    for(String key: keys) 
                                        {
                                           
                                           String pre  =(i>0)?" AND ":" ";
                                           sql+= pre+key +" = '"+where.get(key)+"'";
                                            i++;
                                        }     
                        } 
                    
                    
                       if (Conditions.containsKey("whereless"))
                        {
                                    sql+= " WHERE ";
                                    Map whereless= (Map) Conditions.get("whereless");
                                    Set <String> keys =  whereless.keySet();
                                    for(String key: keys) 
                                        {
                                           
                                           String pre  =(i>0)?" AND ":" ";
                                           sql+= pre+key +" < '"+whereless.get(key)+"'";
                                            i++;
                                        }     
                        } 
                    
                           if (Conditions.containsKey("wheregreater"))
                        {
                                    sql+= " WHERE ";
                                    Map wheregreater= (Map) Conditions.get("wheregreater");
                                    Set <String> keys =  wheregreater.keySet();
                                    for(String key: keys) 
                                        {
                                           
                                           String pre  =(i>0)?" AND ":" ";
                                           sql+= pre+key +" > '"+wheregreater.get(key)+"'";
                                            i++;
                                        }     
                        } 
                           
                           
                                  if (Conditions.containsKey("wheregreaterequal"))
                        {
                                    sql+= " WHERE ";
                                    Map wheregreaterequal= (Map) Conditions.get("wheregreaterequal");
                                    Set <String> keys =  wheregreaterequal.keySet();
                                    for(String key: keys) 
                                        {
                                           
                                           String pre  =(i>0)?" AND ":" ";
                                           sql+= pre+key +" >= '"+wheregreaterequal.get(key)+"'";
                                            i++;
                                        }     
                        }
                                  
                               if (Conditions.containsKey("wherelessequal"))
                        {
                                    sql+= " WHERE ";
                                    Map wherelessequal= (Map) Conditions.get("wherelessequal");
                                    Set <String> keys =  wherelessequal.keySet();
                                    for(String key: keys) 
                                        {
                                           
                                           String pre  =(i>0)?" AND ":" ";
                                           sql+= pre+key +" <= '"+wherelessequal.get(key)+"'";
                                            i++;
                                        }     
                        }
                    
                        
                }
        
                connection();
                psmt=getcon().prepareStatement(sql);
                data =psmt.executeQuery(); 
                if (data.next())
                    {
                        min=data.getDouble(1);
                    }  
        return min;
    }
     
    
     
      /*
     * Returns the Summation  value of   specific column    from the database table  
     * @param String Object is the name of the specific  column   of the table
     * @param String Table  is the name of the target table
     * @param array Conditions : select, where, order_by, limit, whereless, wheregreater, wheregreaterequal, wherelessequal,Conditions
     */
     
     
     public double GetSum(String Object, String Table, Map Conditions) throws SQLException, ClassNotFoundException
    {
         String sql="SELECT  SUM("+Object+")   FROM "+Table+"";
        double sum = 0.0;
        ResultSet data =null;
       
        int i=0; 
       
            
        if (!Conditions.isEmpty())
                {
                
                    
                    
                        if (Conditions.containsKey("where"))
                        {
                                    sql+= " WHERE ";
                                    Map where= (Map) Conditions.get("where");
                                    Set <String> keys =  where.keySet();
                                    for(String key: keys) 
                                        {
                                           
                                           String pre  =(i>0)?" AND ":" ";
                                           sql+= pre+key +" = '"+where.get(key)+"'";
                                            i++;
                                        }     
                        } 
                    
                    
                       if (Conditions.containsKey("whereless"))
                        {
                                    sql+= " WHERE ";
                                    Map whereless= (Map) Conditions.get("whereless");
                                    Set <String> keys =  whereless.keySet();
                                    for(String key: keys) 
                                        {
                                           
                                           String pre  =(i>0)?" AND ":" ";
                                           sql+= pre+key +" < '"+whereless.get(key)+"'";
                                            i++;
                                        }     
                        } 
                    
                           if (Conditions.containsKey("wheregreater"))
                        {
                                    sql+= " WHERE ";
                                    Map wheregreater= (Map) Conditions.get("wheregreater");
                                    Set <String> keys =  wheregreater.keySet();
                                    for(String key: keys) 
                                        {
                                           
                                           String pre  =(i>0)?" AND ":" ";
                                           sql+= pre+key +" > '"+wheregreater.get(key)+"'";
                                            i++;
                                        }     
                        } 
                           
                           
                                  if (Conditions.containsKey("wheregreaterequal"))
                        {
                                    sql+= " WHERE ";
                                    Map wheregreaterequal= (Map) Conditions.get("wheregreaterequal");
                                    Set <String> keys =  wheregreaterequal.keySet();
                                    for(String key: keys) 
                                        {
                                           
                                           String pre  =(i>0)?" AND ":" ";
                                           sql+= pre+key +" >= '"+wheregreaterequal.get(key)+"'";
                                            i++;
                                        }     
                        }
                                  
                               if (Conditions.containsKey("wherelessequal"))
                        {
                                    sql+= " WHERE ";
                                    Map wherelessequal= (Map) Conditions.get("wherelessequal");
                                    Set <String> keys =  wherelessequal.keySet();
                                    for(String key: keys) 
                                        {
                                           
                                           String pre  =(i>0)?" AND ":" ";
                                           sql+= pre+key +" <= '"+wherelessequal.get(key)+"'";
                                            i++;
                                        }     
                        }
                    
                        
                }
        
                connection();
                psmt=getcon().prepareStatement(sql);
                data =psmt.executeQuery(); 
                if (data.next())
                    {
                        sum=data.getDouble(1);
                    }  
        return sum;
    }
     
     
     
     
     
     
     
      /*
     * Returns The average  value of specific column   from the database table  
     * @param String Object is the name of the specific  column   of the table
     * @param String Table  is the name of the target table
     * @param array Conditions : select, where, order_by, limit, whereless, wheregreater, wheregreaterequal, wherelessequal,Conditions
     */
     
       public double GetAvg(String Object, String Table, Map Conditions) throws SQLException, ClassNotFoundException
    {
         String sql="SELECT  AVG("+Object+")   FROM "+Table+"";
        double avg = 0.0;
        ResultSet data =null;
       
        int i=0; 
       
            
        if (!Conditions.isEmpty())
                {
                
                    
                    
                        if (Conditions.containsKey("where"))
                        {
                                    sql+= " WHERE ";
                                    Map where= (Map) Conditions.get("where");
                                    Set <String> keys =  where.keySet();
                                    for(String key: keys) 
                                        {
                                           
                                           String pre  =(i>0)?" AND ":" ";
                                           sql+= pre+key +" = '"+where.get(key)+"'";
                                            i++;
                                        }     
                        } 
                    
                    
                       if (Conditions.containsKey("whereless"))
                        {
                                    sql+= " WHERE ";
                                    Map whereless= (Map) Conditions.get("whereless");
                                    Set <String> keys =  whereless.keySet();
                                    for(String key: keys) 
                                        {
                                           
                                           String pre  =(i>0)?" AND ":" ";
                                           sql+= pre+key +" < '"+whereless.get(key)+"'";
                                            i++;
                                        }     
                        } 
                    
                           if (Conditions.containsKey("wheregreater"))
                        {
                                    sql+= " WHERE ";
                                    Map wheregreater= (Map) Conditions.get("wheregreater");
                                    Set <String> keys =  wheregreater.keySet();
                                    for(String key: keys) 
                                        {
                                           
                                           String pre  =(i>0)?" AND ":" ";
                                           sql+= pre+key +" > '"+wheregreater.get(key)+"'";
                                            i++;
                                        }     
                        } 
                           
                           
                                  if (Conditions.containsKey("wheregreaterequal"))
                        {
                                    sql+= " WHERE ";
                                    Map wheregreaterequal= (Map) Conditions.get("wheregreaterequal");
                                    Set <String> keys =  wheregreaterequal.keySet();
                                    for(String key: keys) 
                                        {
                                           
                                           String pre  =(i>0)?" AND ":" ";
                                           sql+= pre+key +" >= '"+wheregreaterequal.get(key)+"'";
                                            i++;
                                        }     
                        }
                                  
                               if (Conditions.containsKey("wherelessequal"))
                        {
                                    sql+= " WHERE ";
                                    Map wherelessequal= (Map) Conditions.get("wherelessequal");
                                    Set <String> keys =  wherelessequal.keySet();
                                    for(String key: keys) 
                                        {
                                           
                                           String pre  =(i>0)?" AND ":" ";
                                           sql+= pre+key +" <= '"+wherelessequal.get(key)+"'";
                                            i++;
                                        }     
                        }
                    
                        
                }
        
                connection();
                psmt=getcon().prepareStatement(sql);
                data =psmt.executeQuery(); 
                if (data.next())
                    {
                        avg=data.getDouble(1);
                    }  
        return avg;
    }

    /*
     * Insert data into the database
     * @param string name of the table
     * @param Map the Data for inserting into the table
     */
     public  boolean Insert (String Table, Map Data) throws SQLException, ClassNotFoundException
      {
          String Columns=""; 
          String Values =""; 
          int i=0;           
                            
          String pre=" ";
          if (!Data.isEmpty())
            {
                Set <String> keys = Data.keySet();
                for(String key: keys) 
                {
                   pre  =(i>0)?" , ":" ";
                    Columns += pre+key;
                    Values  +=pre+"'"+Data.get(key)+"'";   
                    i++;
                }
                 SQL= "insert into "+Table+" ("+Columns+") values ("+Values+") ";
                 connection();
                    psmt=getcon().prepareStatement(SQL);
                 if (psmt.executeUpdate()>0)
                    {
                     return true;
                    }
                 else return false ;
                
             }
               return false ;
      }
     
     
     /*
     * Update data into the database
     * @param string name of the table
     * @param Map the data for updating into the table
     * @param Map where condition on updating data
     */
  public  boolean Update  (String Table, Map Data, Map Conditions ) throws SQLException, ClassNotFoundException
      {
          String ColValSet=""; 
          String WhereSql ="  where   ";
          int i=0; 
          String pre=" ";
          if (!Data.isEmpty())
            {
                Set <String> keys = Data.keySet();
                for(String key: keys) 
                {
                   pre  =(i>0)?" , ":" ";
                    ColValSet += pre+key+"='"+Data.get(key)+"'";
                       
                    i++;
                }
            }
               i=0; 
                if (!Conditions.isEmpty())
                {
                Set <String> kys = Conditions.keySet();
                for(String ky: kys) 
                {
                   pre  =(i>0)?" AND ":" ";
                    WhereSql += pre+ky+"='"+Conditions.get(ky)+"'";
                      
                    i++;
                }
                }
                 SQL= " update  "+Table+" set "+ColValSet+WhereSql ;
                 connection();
                 
                  psmt=getcon().prepareStatement(SQL);
                 if (psmt.executeUpdate()>0)
                    {
                     return true;
                    }
                 return false ;
      }
   
    /*
     * Delete data from the database
     * @param string name of the table
     * @param Map  where condition on deleting data
     */ 
  
public  boolean Delete  (String Table, Map Conditions ) throws SQLException, ClassNotFoundException
      {
           String WhereSql ="  where   "; 
          int i=0; 
          String pre=" ";
            if (!Conditions.isEmpty())
                {
                Set <String> keys = Conditions.keySet();
                for(String key: keys) 
                {
                   pre  =(i>0)?" AND ":" ";
                    WhereSql += pre+key+"='"+Conditions.get(key)+"'";
                    i++;
                }
                }
                 SQL= " delete  from   "+Table+"  "+WhereSql ;
                 connection();
                 
                  psmt=getcon().prepareStatement(SQL);
                 if (psmt.executeUpdate()>0)
                    {
                     return true;
                    }               
               return false ;
      }
     
}
