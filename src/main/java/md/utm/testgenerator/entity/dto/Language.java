package md.utm.testgenerator.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public enum Language {

    @JsonProperty("Java")
    JAVA("Java"),
    @JsonProperty("C#")
    CSHARP("C#"),
    @JsonProperty("Javascript")
    JAVASCRIPT("Javascript");

    private final String label;

    Language(String label) {
        this.label = label;
    }

    public static Language getByLabel(String label) {
        for (Language language : values()) {
            if (Objects.equals(language.label, label)) {
                return language;
            }
        }
        return null;
    }

}
