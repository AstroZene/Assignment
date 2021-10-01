package com.blog.assignment;

import com.blog.assignment.Repository.AdminRepository;
import org.hamcrest.MatcherAssert;
import org.hamcrest.collection.IsEmptyCollection;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.hasProperty;

public class TestWebApp extends AssignmentApplicationTests {
    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Autowired
    private AdminRepository adminRepository;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testUsers() throws Exception {
        mockMvc.perform(get("/admin/users")).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));
        MatcherAssert.assertThat(adminRepository.findUserById(5L),hasProperty("username",is("Kamren")));
    }

    @Test
    public void testNotNull() throws Exception {
        mockMvc.perform(get("/admin/users")).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));
        MatcherAssert.assertThat(adminRepository.findAllDetails(),not(IsEmptyCollection.empty()));
    }

    @Test
    public void testCount() throws Exception {
        mockMvc.perform(get("/admin/users")).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));
        MatcherAssert.assertThat(adminRepository.findAllDetails().size(),is(10));
    }

    @Test
    public void testPostCount() throws Exception {
        mockMvc.perform(get("/admin/users")).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));
        MatcherAssert.assertThat(adminRepository.findUserById(5L).getPosts().size(),is(10));
    }


}
