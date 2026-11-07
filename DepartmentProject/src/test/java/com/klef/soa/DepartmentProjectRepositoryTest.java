package com.klef.soa;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.test.context.TestPropertySource;

import com.klef.soa.entity.Department;
import com.klef.soa.repository.DepartmentRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestPropertySource(properties = "spring.datasource.url=jdbc:postgresql://localhost:5432/skill_exam_2400031453")
class DepartmentProjectRepositoryTest {

	@Autowired
	private DepartmentRepository repository;

	@Test
	void testFindAllDepartments() {
		List<Department> departments = repository.findAll();

		assertNotNull(departments);
		assertFalse(departments.isEmpty());
	}

	@Test
	void testFindDepartmentById() {
		List<Department> departments = repository.findAll();
		assertFalse(departments.isEmpty());

		long existingId = departments.get(0).getId();
		Optional<Department> department = repository.findById(existingId);

		assertTrue(department.isPresent());
		assertEquals(existingId, department.get().getId());
		assertFalse(repository.findById(Long.MAX_VALUE).isPresent());
	}

	@Test
	void testFindDepartmentsByNameAndType() {
		List<Department> departments = repository.findAll();
		assertFalse(departments.isEmpty());
		Department existingDepartment = departments.get(0);

		List<Department> byName = repository.findByName(existingDepartment.getName());
		List<Department> byType = repository.findByType(existingDepartment.getType());

		assertNotNull(byName);
		assertFalse(byName.isEmpty());
		assertTrue(byName.stream().allMatch(department ->
				existingDepartment.getName().equals(department.getName())));
		assertNotNull(byType);
		assertFalse(byType.isEmpty());
		assertTrue(byType.stream().allMatch(department ->
				existingDepartment.getType().equals(department.getType())));
	}

	@Test
	void testDepartmentCount() {
		assertEquals(repository.findAll().size(), repository.count());
	}

	@Test
	void testDepartmentDetails() {
		List<Department> departments = repository.findAll();
		assertFalse(departments.isEmpty());
		Optional<Department> department = repository.findById(departments.get(0).getId());

		assertTrue(department.isPresent());
		Department foundDepartment = department.get();

		assertNotNull(foundDepartment.getName());
		assertNotNull(foundDepartment.getType());
		assertNotNull(foundDepartment.getStatus());
		assertNotNull(foundDepartment.getLocation());
	}

}
