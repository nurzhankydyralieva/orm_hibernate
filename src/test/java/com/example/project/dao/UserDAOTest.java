package com.example.project.dao;

import com.example.project.entity.User;
import com.example.project.service.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
class UserDAOTest {
    @Mock
    private UserDAO userDAO;
    @InjectMocks
    private UserServiceImpl userService;
    private User user;
    public List<User> users;

    @BeforeEach
    public void setUp() {
        userDAO = mock(UserDAO.class);
        userService = new UserServiceImpl(userDAO);
        user = User.builder().firstName("Maxim").lastName("Smith").userName("Toms").password("333").isActive(true).criteria("Criteria for Selecting Training Modalities").build();
        users = Arrays.asList(new User(), new User());
    }

    @Test
    void selectAllUsers() {
        userService.selectAllUsers();
        assertEquals(2, users.size());
    }

    @Test
    void showUserById() {
        userService.selectUserById(1);
        assertEquals("Toms", user.getUserName());
    }

    @Test
    void createUser() {
        userService.createUser(user);
        assertEquals(user.getUserName(), "Toms");
    }

    @Test
    void updateUser() {
        int idToUpdate = 1;
        User userToUpdate = new User();
        user.setId(idToUpdate);
        user.setFirstName("Andrea");
        userService.updateUser(idToUpdate, userToUpdate);
        assertEquals(2, users.size());
        assertEquals("Andrea", user.getFirstName());
    }

    @Test
    void deleteUser() {
        boolean deletedId = userService.deleteUser(1);
        assertTrue(deletedId);
    }
}