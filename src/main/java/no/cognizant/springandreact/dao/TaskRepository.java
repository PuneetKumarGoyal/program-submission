package no.cognizant.springandreact.dao;

import no.cognizant.springandreact.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

    @Query(value = "SELECT * FROM Tasks t WHERE LOWER(t.task_name) = LOWER(:name) limit 1", nativeQuery = true)
    List<Task> retrieveByName(@Param("name") String name);

}
