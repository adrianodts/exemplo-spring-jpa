package com.adrianodantas.exemplo.spring.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.adrianodantas.exemplo.spring.jpa.entity.Course;
import com.adrianodantas.exemplo.spring.jpa.repository.CourseRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ExemploSpringJpaApplication.class)
public class ExemploSpringJpaApplicationTests {

	@Autowired
	CourseRepository courseRepository;
	
//	static List<Course> courses;
//	
//	@BeforeClass
//	public static void BeforeClass() {
//		courses = new ArrayList<Course>() {{
//			add(new Course(1L, "ASP.NET MVC"));
//			add(new Course(2L, "ASP.NET core"));
//			add(new Course(3L, "Spring Boot"));
//			add(new Course(4L, "Angular 5"));			
//		}};		
//	}
//
//	@Before
//	public void Before()
//	{
//		if(courses != null) {
//			courses.stream().forEach(c -> {
//				courseRepository.save(c);
//			});		
//			courses = null;
//		}
//	}
	
//	@After
//	public void After()
//	{
//		courses.stream().forEach(c -> {
//			courseRepository.remove(c.getId());
//		});		
//	}
//	
//	@AfterClass
//	public static void AfterClass()
//	{
//		courses = null;
//	}
	
	@Test
	public void findByIdTestId() {
		
		//Given
		Long id = 2L;
		String name = "ASP.NET core";
		
		//Expected
		Course c = courseRepository.findById(id);
		
		//Result
		assertEquals(id, c.getId());
		assertEquals(name, c.getName());
	}

	@Test
	public void findAllCount() {
		//Given
		int count = 0;
		
		//Expected
		List<Course> list = courseRepository.findAll();
		
		//Result
		assertNotEquals(count, list.size());		
	}
	
	@Test
	@DirtiesContext
	public void UpdateName() {
		//Given
		Long id = 1L;
		String newName = "ASP.NET MVC - Updated";
		Course course = new Course(id, newName);
		
		//Expected
		course = courseRepository.save(course);		
				
		//Result
		assertTrue(newName == course.getName());		
	}
	
	@Test
	@DirtiesContext
	public void DeleteRow() {
		//Given
		Long id = 1L;
		
		//Expected
		courseRepository.remove(id);		
		
		//Result
		assertNull(courseRepository.findById(id));		
	}
	
	@Test
	@DirtiesContext
	public void InsertRow() {
		//Given
		String newName = "PHP";
		Course course = new Course(null, newName);
		
		//Expected
		course = courseRepository.save(course);		
				
		//Result
		assertTrue(newName == course.getName());		
	}
}
