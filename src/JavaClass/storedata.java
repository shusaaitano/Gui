package JavaClass;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author shu
 */
public class storedata {

    // Logged-in user session data (GLOBAL)
    public static String email;
    public static String fullname;
    public static String contact;
    public static String userType;
    public static String status;

    // Optional: clear session on logout
    public static void clear() {
        email = null;
        fullname = null;
        contact = null;
        userType = null;
        status = null;
    }
}
