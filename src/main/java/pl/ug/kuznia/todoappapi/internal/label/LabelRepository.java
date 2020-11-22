package pl.ug.kuznia.todoappapi.internal.label;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LabelRepository extends CrudRepository<Label, Long> {

    List<Label> findAll();

    Optional<Label> findByName(String name);
}
