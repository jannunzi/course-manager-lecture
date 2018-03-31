package com.jga.repositories;
import org.springframework.data.repository.*;

import com.jga.models.Faculty;

public interface FacultyRepository
	extends CrudRepository<Faculty, Integer> {
}
