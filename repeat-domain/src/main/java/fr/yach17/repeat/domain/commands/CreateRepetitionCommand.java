package fr.yach17.repeat.domain.commands;

/**
 * Created by SaYaQuenGa on 17/07/2014.
 */
public class CreateRepetitionCommand {
    private final String description;
    private final String type;
    private final Object repetitionConfig;
    public CreateRepetitionCommand(String description, String type, Object repetitionConfig){
        this.description = description;
        this.type = type;
        this.repetitionConfig = repetitionConfig;
    }



}
