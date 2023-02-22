package com.springdemopractice.Springdemo.dao;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import com.springdemopractice.Springdemo.entity.Teacher;
import com.springdemopractice.Springdemo.globalException.Status;
import com.springdemopractice.Springdemo.globalException.TeacherNoSuchIdException;
import com.springdemopractice.Springdemo.teacherrepo.TeacherRepo;

@Repository
public class TeacherDAO {

	@Autowired
	TeacherRepo repo;

	public Status addTeacher(Teacher t) throws TeacherNoSuchIdException {
		try {
			repo.save(t);
			Status status = new Status(HttpStatus.OK.value(), "Teacher saved with ID-" + t.getTeacherId(), new Date());
			return status;
		} catch (Exception e) {
			throw new TeacherNoSuchIdException("Error While Saving Data into the database");
		}
	}

	public Teacher byId(int id) throws TeacherNoSuchIdException {
		try {

			return repo.findById(id).get();

		} catch (Exception e) {
			throw new TeacherNoSuchIdException("No teacher with ID-" + id + " Found");
		}
	}

	public Status update(Teacher t) throws TeacherNoSuchIdException {
		try {
			Teacher temp = repo.findById(t.getTeacherId()).get();
			temp.setTeacherName(t.getTeacherName());
			temp.setSubjects(t.getSubjects());
			repo.save(temp);
			Status status = new Status(HttpStatus.OK.value(), "Teacher with ID-" + t.getTeacherId() + " updated",
					new Date());
			return status;
		} catch (Exception e) {
			throw new TeacherNoSuchIdException("No teacher with ID-" + t.getTeacherId() + " exists,Cannot Update");
		}
	}

	public Status deleteTeacher(int id) throws TeacherNoSuchIdException {
		try {
			Teacher temp = repo.findById(id).get();
			repo.delete(temp);
			Status status = new Status(HttpStatus.OK.value(), "Teacher With ID-" + id + " Deleted", new Date());
			return status;
		} catch (Exception e) {
			throw new TeacherNoSuchIdException("No teacher with ID-" + id + " Found");
		}

	}

	public List<Teacher> Listall() {
		List<Teacher> teachers = repo.findAll();
		return teachers;
	}

}
