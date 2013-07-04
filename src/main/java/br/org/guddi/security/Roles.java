package br.org.guddi.security;

import static br.org.guddi.security.IRoles.ADMINISTRATOR;
import static br.org.guddi.security.IRoles.INVALID;
import static br.org.guddi.security.IRoles.MANAGER;
import static br.org.guddi.security.IRoles.USER;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author escritorio
 */
public class Roles implements IRoles {

    /**
     *
     * @param role
     * @return
     */
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

    /**
     *
     * @return
     */
    public static List<String> getRole() {
        List<String> list = new ArrayList<String>();
        list.add(USER);
        list.add(MANAGER);
        list.add(ADMINISTRATOR);
        list.add(INVALID);
        return list;
    }

    /**
     *
     * @param listRole
     * @return
     */
    public static Long getRole(List<String> listRole) {
        Long number = 0L;

        if (listRole.contains(USER)) {
            number += 1L;
        }
        if (listRole.contains(MANAGER)) {
            number += 2L;
        }
        if (listRole.contains(ADMINISTRATOR)) {
            number += 4L;
        }
        if (listRole.contains(INVALID)) {
            number += 8L;
        }

        return number;
    }

    /**
     *
     * @param role
     * @return
     */
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
    private static final Logger LOG = Logger.getLogger(Roles.class.getName());
}
