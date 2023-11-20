//package com.cg.mts.service;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.doNothing;
//import static org.mockito.Mockito.verify;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//
//import com.cg.mts.entity.User;
//import com.cg.mts.repository.UserRepository;
//
//
//@SpringBootTest
//class IUserServiceImplTest {
//	
//	@MockBean
//	UserRepository userrepo;
//	@Autowired
//	IUserService userService;
//
//	@Test
//	public void testRemoveUser() {
//		User existingUser = new User();
// 
//        // Stubbing the repository delete method
//        doNothing().when(userrepo).delete(existingUser);
// 
//        // Act
//        User removedUser = userService.removeUser(existingUser);
// 
//        // Assert
//        assertEquals(existingUser, removedUser);
//        verify(userrepo).delete(existingUser);
//	}
//	}
//
//
