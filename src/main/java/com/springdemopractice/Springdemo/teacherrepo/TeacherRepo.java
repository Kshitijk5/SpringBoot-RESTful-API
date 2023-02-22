package com.springdemopractice.Springdemo.teacherrepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springdemopractice.Springdemo.entity.Teacher;

public interface TeacherRepo extends JpaRepository<Teacher,Integer>{

} 
