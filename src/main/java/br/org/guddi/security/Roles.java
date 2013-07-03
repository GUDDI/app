package br.org.guddi.security;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author escritorio
 */
public class Roles implements IRoles{
	
       public static List<String> getRole(int role) {
        List<String> list = new ArrayList<String>();
        switch (role) {
            case 1:
                list.add(USER);
                break;
            case 2:
                list.add(MANAGER);
                break;
            case 3:
                list.add(USER);
                list.add(MANAGER);
                break;
            case 4:
                list.add(ADMINISTRATOR);
                break;
            case 5:
                list.add(USER);
                list.add(ADMINISTRATOR);
                break;
            case 6:
                list.add(MANAGER);
                list.add(ADMINISTRATOR);
                break;
            case 7:
                list.add(USER);
                list.add(MANAGER);
                list.add(ADMINISTRATOR);
                break;
            default:
                list.add(INVALID);
                break;
        }
        return list;
    }

    public static int getOperation(List<String> listRole) {
        int number = 0;
        if (listRole.contains(USER)) {
            number = number + 1;
        }
        if (listRole.contains(MANAGER)) {
            number = number + 2;
        }
        if (listRole.contains(ADMINISTRATOR)) {
            number = number + 4;
        }

        return number;
    }
    
     public static int getOperation(String role) {
        
        if (role.equals(USER)) {
            return 1;
        }
        if (role.equals(MANAGER)) {
            return 2;
        }
        if (role.equals(ADMINISTRATOR)) {
            return 4;
        }

        return 99;
    }

  

}
