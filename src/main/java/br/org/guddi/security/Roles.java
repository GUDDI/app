package br.org.guddi.security;

import static br.org.guddi.security.IRoles.ADMINISTRATOR;
import static br.org.guddi.security.IRoles.INVALID;
import static br.org.guddi.security.IRoles.MANAGER;
import static br.org.guddi.security.IRoles.USER;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author escritorio
 */
public class Roles implements IRoles {

    public static List<String> getRole(Long role) {
        List<String> list = new ArrayList<String>();
        switch (Integer.getInteger("" + role)) {
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

    public static List<String> getRole() {
        List<String> list = new ArrayList<String>();
        list.add(USER);
        list.add(MANAGER);
        list.add(ADMINISTRATOR);
        list.add(INVALID);
        return list;
    }

    public static Long getRole(List<String> listRole) {
        Long number = 0L;

        if (listRole.contains(USER)) {
            number = number + 1L;
        }
        if (listRole.contains(MANAGER)) {
            number = number + 2L;
        }
        if (listRole.contains(ADMINISTRATOR)) {
            number = number + 4L;
        }
        if (listRole.contains(INVALID)) {
            number = number + 8L;
        }

        return number;
    }

    public static Long getRole(String role) {

        if (role.equals(USER)) {
            return 1L;
        }
        if (role.equals(MANAGER)) {
            return 2L;
        }
        if (role.equals(ADMINISTRATOR)) {
            return 4L;
        }

        return 99L;
    }
}
