package com.neha.rest.example;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.neha.rest.example.model.Student;
import com.neha.rest.example.repository.StudentController;
import com.neha.rest.example.repository.StudentRepository;
import com.neha.rest.example.util.TestUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestApiApplicationTests {

	public static final String ROOT_RESOURCE = "/students";
	
	public Student s;

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;
	@Mock
	public StudentRepository studentRepository;
	
	@InjectMocks
	public StudentController controller;
	

	@Before
	public void before() {
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
		s = new Student("Lost", "you", "Junior");
			}

	@Test
	public void getAStringTest() throws Exception {
		List<Student> lis = new ArrayList<>();
		lis.add(s);
		Mockito.when(studentRepository.findAll()).thenReturn(lis);
		mockMvc.perform(MockMvcRequestBuilders.get(ROOT_RESOURCE))
		.andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(jsonPath("$[0].firstName", is("Lost")))
        .andExpect(jsonPath("$[0].lastName", is("you")))
        .andExpect(jsonPath("$[0].year", is("Junior")));
//        .andExpect(jsonPath("$[0].id", is(101)))
//        .andExpect(jsonPath("$[0].firstName", is("Jane")))
//        .andExpect(jsonPath("$[0].lastName", is("Doe")))
//        .andExpect(jsonPath("$[0].year", is("Junior")))
//        .andExpect(jsonPath("$[1].id", is(102)))
//        .andExpect(jsonPath("$[1].firstName", is("Martin")))
//        .andExpect(jsonPath("$[1].lastName", is("Fowler")))
//        .andExpect(jsonPath("$[1].year", is("Senior")));
	}
	
	@Test
	public void testAddStudent() throws Exception{
		
		RequestBuilder requestBuilder  = MockMvcRequestBuilders.post(ROOT_RESOURCE).contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(s)).accept(MediaType.APPLICATION_JSON); 
		Mockito.when(studentRepository.save(Mockito.any(Student.class))).thenReturn(s);
		mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.status().isCreated());
	}

}
