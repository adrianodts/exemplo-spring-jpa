package com.adrianodantas.exemplo.spring.jpa.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.adrianodantas.exemplo.spring.jpa.entity.Course;

@Repository
@Transactional
public class CourseRepository {

	@Autowired
	private EntityManager entityManager;
	
	public Course findById(long id){
		return entityManager.find(Course.class, id);
	}
	
	public List<Course> findAll(){
		return entityManager.createNamedQuery("find_all", Course.class)
				.getResultList();
	}
		
	public Course save(Course course) {
		if(course.getId() == null) {			
			entityManager.persist(course);			
		} else {			
			entityManager.merge(course);							
		}
		return course;
	}

	public void remove(Long id) {
		Course c = this.findById(id);
		entityManager.remove(c);	
	}
}
