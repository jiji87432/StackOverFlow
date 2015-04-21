package org.arunm.models;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ExamRepository extends CrudRepository<Exam, Integer> {

}
