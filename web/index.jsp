

<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="core.*; " %>
<% 
    db con= new db();
    notification msg= new notification();
    if (msg.sendmail("bojosmuta@gmail.com", "www.terapreneur.com"))
        {
            out.print("weldone");
        }
    else 
                 out.print("wapi"); 
// banks selection     
                Map Data =  new HashMap();
                Map Conditions  = new HashMap();
                String TbName= "struc_user";
                  Data.put(" id ", 6);
                  Data.put(" id ", 7);

                  
                  Conditions.put("select","Fname , id");
                  Conditions.put("order_by","id desc");
                  Conditions.put("wheregreaterequal", Data);

               ResultSet users = con.getrows(TbName, Conditions);
               
                 while (users.next())
                    {
                       
                        //select ma joulni
                        x
                         Map Data_condition_jour  =  new HashMap();
                Map Conditions  = new HashMap();
                String TbName= "struc_user";
                  Data.put(" id ", users.getDate(1));
                  Data.put(" id ", 7);

                  
                  Conditions.put("select","Fname , id");
                  Conditions.put("order_by","id desc");
                  Conditions.put("wheregreaterequal", Data);
                  
                  ResultSet userso = con.getrows(TbName, Conditions);
                        
                        
                        
                        out.print("<br>");
                        out.print(users.getInt(2));
                        
                        out.print("<br>");
                        
                        out.println(con.get_tblelmt_by_id("Lnam", TbName, users.getInt(2) ));
                    }
                 users.close();
                 
                 // end bamc selection 
                 
                 
                 
                 
               
                 
                  out.print("<br>");
        out.print(" THE MAX IS : ");
                              
out.println(con.GetMax("Lnam", TbName,Conditions));


 out.print("<br>");
        out.print(" THE MIN IS : ");
                              
out.println(con.GetMin("Lnam", TbName,Conditions));

 out.print("<br>");
        out.print(" THE SUM IS : ");
                              
out.println(con.GetSum("Lnam", TbName,Conditions));

 out.print("<br>");
        out.print(" THE Average IS : ");
                              
out.println(con.GetAvg("Lnam", TbName,Conditions) );
//out.println(con.bb );

   //out.println(String.format("%,f",vra));             
                              
%>


   