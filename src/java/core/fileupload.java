/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;
import  java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.io.output.*;

/**
 *
 * @author boniface Kaghusa Mutanava
 */
public class fileupload 
{
          FileItemFactory factory = new DiskFileItemFactory();
   public ServletFileUpload upload = new ServletFileUpload(factory);
   
   
          public Map uploadfile(List items, String path) throws Exception, FileUploadException
                {
                    String itemName = "";
                  Map fields =  new HashMap();
                            Iterator itr = items.iterator();
                            while (itr.hasNext())
                            {
                                    FileItem item = (FileItem) itr.next();
                                    if (!item.isFormField())
                                        {   
                                            itemName = item.getName();
                                            File savedFile = new File( path+itemName);
                                            item.write(savedFile);
                                        }
                                    else 
                                        {
                                            fields.put(item.getFieldName(), item.getString());
                                        }

                            }
                            return fields;
                   }
                
}
    

