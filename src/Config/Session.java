/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Config;

/**
 *
 * @author PC1
 */
public class Session {
    private static int id;
    private static String email;
    private static String fullname;
    private static String password;
    private static String contact;
    private static String type;
    private static String status;
    
    
  public static void setSession(String e, String f, String c, String t, String s){
     
    email = e;     
    fullname = f;
    contact = c;
    type = t;
    status = s;
  }
    public static int getId() {
        return id;
    }

 public static String getEmail(){
       return email; 
    }

    public static String getFullname() {
        return fullname;
    } 

    public static String getContact() {
        return contact;
    }

   
    public static String getType() {
        return type;
    }

    

    public static String getStatus() {
        return status;
    }
   public static void clearSession(){
       id = 0;
       email = null;
       fullname = null;
       contact = null;
       type = null;
       status = null;
   }
   
    
   
}
