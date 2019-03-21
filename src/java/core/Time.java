/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

 
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author olivier
 */
public class Time 
{
    
    public int DateDifference(String date1, String date2)
        {
            int diffDays=0;     
        try    
                {
			String format = "MM/dd/yyyy"; // Set date format into a string variable
                        SimpleDateFormat sdf = new SimpleDateFormat(format);//define the Dateformat 
                        Date dateObj1 = sdf.parse(date1); //convert the date 1 string into Date
			Date dateObj2 = sdf.parse(date2);//convert the date 2 string into Date
			long diff = dateObj2.getTime() - dateObj1.getTime();// computing the difference 
                        diffDays = (int) (diff / (24 * 60 * 60 * 1000)); //converting the datedifference into integer 
		} 
        catch (Exception e) 
                {
			e.printStackTrace();
		}
         return  diffDays;
	}   
            
            
        
    
}
