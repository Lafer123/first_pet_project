package API.response;

import API.Deserializer.DateDeserializer;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.apache.commons.lang3.ObjectUtils;
import org.joda.time.DateTime;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class StarshipResponse {

    @JsonProperty("name")
    public String name;

    @JsonProperty("model")
    public String model;

    @JsonProperty("manufacturer")
    public String manufacturer;

    @JsonProperty("cost_in_credits")
    public String cost_in_credits;

    @JsonProperty("length")
    public String length;

    @JsonProperty("max_atmosphering_speed")
    public String max_atmosphering_speed;

    @JsonProperty("crew")
    public String crew;

    @JsonProperty("passengers")
    public String passengers;

    @JsonProperty("cargo_capacity")
    public String cargo_capacity;

    @JsonProperty("consumables")
    public String consumables;

    @JsonProperty("hyperdrive_rating")
    public String hyperdrive_rating;

    @JsonProperty("MGLT")
    public String mglt;

    @JsonProperty("starship_class")
    public String starship_class;

    @JsonProperty("pilots")
    public List<String> pilots;

    @JsonProperty("films")
    public List<String> films;

    @JsonProperty("created")
    public DateTime created;

    @JsonProperty("edited")
    public DateTime edited;

    @JsonProperty("url")
    public String url;

    public StarshipResponse() {
    }

    @JsonCreator
    public StarshipResponse(
            @JsonProperty("name") final String name,
            @JsonProperty("model") final String model,
            @JsonProperty("manufacturer") final String manufacturer,
            @JsonProperty("cost_in_credits") final String cost_in_credits,
            @JsonProperty("length") final String length,
            @JsonProperty("max_atmosphering_speed") final String max_atmosphering_speed,
            @JsonProperty("crew") final String crew,
            @JsonProperty("passengers") final String passengers,
            @JsonProperty("cargo_capacity") final String cargo_capacity,
            @JsonProperty("consumables") final String consumables,
            @JsonProperty("hyperdrive_rating") final String hyperdrive_rating,
            @JsonProperty("MGLT") final String MGLT,
            @JsonProperty("starship_class") final String starship_class,
            @JsonProperty("pilots") final List<String> pilots,
            @JsonProperty("films") final List<String> films,
            @JsonProperty("created") @JsonDeserialize(using = DateDeserializer.class) final DateTime created,
            @JsonProperty("edited") @JsonDeserialize(using = DateDeserializer.class) final DateTime edited,
            @JsonProperty("url") final String url) {
        this.name = name;
        this.model = model;
        this.manufacturer = manufacturer;
        this.cost_in_credits = cost_in_credits;
        this.length = length;
        this.max_atmosphering_speed = max_atmosphering_speed;
        this.crew = crew;
        this.passengers = passengers;
        this.cargo_capacity = cargo_capacity;
        this.consumables = consumables;
        this.hyperdrive_rating = hyperdrive_rating;
        this.mglt = MGLT;
        this.starship_class = starship_class;
        this.films = ObjectUtils.defaultIfNull(films, Collections.emptyList());
        this.pilots = ObjectUtils.defaultIfNull(pilots, Collections.emptyList());
        this.created = created;
        this.edited = edited;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getCost_in_credits() {
        return cost_in_credits;
    }

    public void setCost_in_credits(String cost_in_credits) {
        this.cost_in_credits = cost_in_credits;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getMax_atmosphering_speed() {
        return max_atmosphering_speed;
    }

    public void setMax_atmosphering_speed(String max_atmosphering_speed) {
        this.max_atmosphering_speed = max_atmosphering_speed;
    }

    public String getCrew() {
        return crew;
    }

    public void setCrew(String crew) {
        this.crew = crew;
    }

    public String getPassengers() {
        return passengers;
    }

    public void setPassengers(String passengers) {
        this.passengers = passengers;
    }

    public String getCargo_capacity() {
        return cargo_capacity;
    }

    public void setCargo_capacity(String cargo_capacity) {
        this.cargo_capacity = cargo_capacity;
    }

    public String getConsumables() {
        return consumables;
    }

    public void setConsumables(String consumables) {
        this.consumables = consumables;
    }

    public String getHyperdrive_rating() {
        return hyperdrive_rating;
    }

    public void setHyperdrive_rating(String hyperdrive_rating) {
        this.hyperdrive_rating = hyperdrive_rating;
    }

    public String getMglt() {
        return mglt;
    }

    public void setMglt(String mglt) {
        this.mglt = mglt;
    }

    public String getStarship_class() {
        return starship_class;
    }

    public void setStarship_class(String starship_class) {
        this.starship_class = starship_class;
    }

    public List<String> getPilots() {
        return pilots;
    }

    public void setPilots(List<String> pilots) {
        this.pilots = pilots;
    }

    public List<String> getFilms() {
        return films;
    }

    public void setFilms(List<String> films) {
        this.films = films;
    }

    public DateTime getCreated() {
        return created;
    }

    public void setCreated(DateTime created) {
        this.created = created;
    }

    public DateTime getEdited() {
        return edited;
    }

    public void setEdited(DateTime edited) {
        this.edited = edited;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StarshipResponse)) return false;
        StarshipResponse that = (StarshipResponse) o;
        return Objects.equals(name, that.name)
                && Objects.equals(model, that.model)
                && Objects.equals(manufacturer, that.manufacturer)
                && Objects.equals(cost_in_credits, that.cost_in_credits)
                && Objects.equals(length, that.length)
                && Objects.equals(max_atmosphering_speed, that.max_atmosphering_speed)
                && Objects.equals(crew, that.crew)
                && Objects.equals(passengers, that.passengers)
                && Objects.equals(cargo_capacity, that.cargo_capacity)
                && Objects.equals(consumables, that.consumables)
                && Objects.equals(hyperdrive_rating, that.hyperdrive_rating)
                && Objects.equals(mglt, that.mglt)
                && Objects.equals(starship_class, that.starship_class)
                && Objects.equals(pilots, that.pilots)
                && Objects.equals(films, that.films)
                && Objects.equals(created, that.created)
                && Objects.equals(edited, that.edited)
                && Objects.equals(url, that.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, model, manufacturer, cost_in_credits,
                length, max_atmosphering_speed, crew, passengers,
                cargo_capacity, consumables, hyperdrive_rating, mglt,
                starship_class, pilots, films, created, edited, url);
    }
}
