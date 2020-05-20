package test;

import dao.UserDao;
import domain.User;
import org.junit.Test;

public class UserDaoTest {

    @Test
    public void testlogin(){
        User loginuser = new User();
        loginuser.setUsername("mable");
        loginuser.setPassword("123123a");

        UserDao dao = new UserDao();
        User user = dao.login(loginuser);
        System.out.println(user);
    }

}
