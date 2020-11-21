package pl.ug.kuznia.todoappapi.internal.label;

import lombok.Value;

import javax.validation.constraints.NotNull;

@Value
public class LabelDto {

    @NotNull
    String name;

    public Label createLabel(){
        return new Label(name);
    }
}
