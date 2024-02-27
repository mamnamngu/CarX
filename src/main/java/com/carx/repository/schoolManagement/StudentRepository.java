package com.carx.repository.schoolManagement;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.carx.entity.schoolManagement.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>, JpaSpecificationExecutor<Student>{
	
	public Student findByStudentId(long studentId);
	
	//ADMIN + SCHOOL ASSISTANT
	//Combined filter
	@Query("SELECT e FROM Student e WHERE " +
           "(:name IS NULL OR LOWER(e.name) LIKE '%:name%') AND " +
           "(:schoolId IS NULL OR e.schoolId = :schoolId) AND " +
           "(:status IS NULL OR e.status = :status)")
	public List<Student> findByNameAndSchoolIdAndStatus(@Param("name") String name, @Param("schoolId") Integer schoolId, @Param("status") Integer status);

}
