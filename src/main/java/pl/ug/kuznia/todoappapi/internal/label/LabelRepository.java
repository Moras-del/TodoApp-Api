package pl.ug.kuznia.todoappapi.internal.label;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LabelRepository extends CrudRepository<Label, Long> {

    List<Label> findAll();

}
