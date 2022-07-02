package response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.Collections;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OptionsResponse {

    @JsonProperty("name")
    String name;

    @JsonProperty("description")
    String description;

    @JsonProperty("renders")
    List<String> renders;

    @JsonProperty("parses")
    List<String> parses;

    @JsonCreator
    public OptionsResponse(
            @JsonProperty("name") final String name,
            @JsonProperty("description") final String description,
            @JsonProperty("renders") final List<String> renders,
            @JsonProperty("parses") final List<String> parses) {
        this.name = name;
        this.description = description;
        this.renders = ObjectUtils.defaultIfNull(renders, Collections.emptyList());
        this.parses = ObjectUtils.defaultIfNull(parses, Collections.emptyList());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getRenders() {
        return renders;
    }

    public void setRenders(List<String> renders) {
        this.renders = renders;
    }

    public List<String> getParses() {
        return parses;
    }

    public void setParses(List<String> parses) {
        this.parses = parses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        OptionsResponse that = (OptionsResponse) o;

        return new EqualsBuilder()
                .append(parses, that.parses)
                .append(name, that.name)
                .append(description, that.description)
                .append(renders, that.renders)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(parses)
                .append(name)
                .append(description)
                .append(renders)
                .toHashCode();
    }
}
