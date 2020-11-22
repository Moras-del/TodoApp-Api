package pl.ug.kuznia.todoappapi.internal.label;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;

import javax.validation.constraints.NotNull;

@Value
public class LabelDto {

    @NotNull
    String name;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public LabelDto(@JsonProperty("name") @NotNull String name) {
        this.name = name;
    }

    public Label createLabel(){
        return new Label(name);
    }
}
