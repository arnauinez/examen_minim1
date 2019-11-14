package test.java;

import dsa.models.User;
import dsa.project.GameManager;
import dsa.project.GameManagerImp;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;
import static org.junit.Assert.*;

public class GameManagerTest {
    private GameManager gm = null;

    @Before
    public void setUp() {
        this.gm = GameManagerImp.getInstance();

        gm.addUser(000, "Arnau", "Martinez");
        gm.addUser(001, "Carlos", "Lopez");
        gm.addUser(002, "Snoop", "Dog");
        gm.addUser(003, "Kim", "Kardasian");

        //Order _order = new Order(900, 222,"Arnau");
       // _order.setProductLines(001, 5);
       // _order.setProductLines(002, 7);

        //gm.placeOrder(222, "Arnau", _order);
    }
    @After
    public void tearDown() {
        this.gm.clear();
    }

    @Test
    public void TestingUsers() {
        assertEquals(gm.getUsersHMAPnum(), 4, 4);
        gm.rmvUser(003);
        assertEquals(gm.getUsersHMAPnum(), 3, 3);

        List<User> _sortedUsers = gm.getSortedUsersList();
        assertEquals(_sortedUsers.get(0).getId(), 000, 000);
        assertEquals(_sortedUsers.get(1).getId(), 001, 001);
        assertEquals(_sortedUsers.get(2).getId(), 002, 002);
    }

    @Test
    public void TestingObj() {
        gm.addObj(000, 999, "espada", true, 100);
        gm.addObj(000, 888, "escudo", false, 50);
        gm.addObj(000, 777, "hechizo", false, 30);
        assertEquals(gm.numObj(000), 3, 3);
    }
}