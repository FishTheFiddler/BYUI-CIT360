package WesHibernate;

import javax.persistence.*;

@Entity
@Table(name = "city")
public class City {

    @Id
    @Column(name = "ID")
    private int id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Population")
    private int population;

    @Column(name = "CountryCode")
    private String countryCode;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return id;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getCountryCode() { return countryCode; }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String toString() {
        return "ID: " + Integer.toString(id) + "\n" + "Name: " + name + "\n" + "Population: " + population + "\n" + "Country Code: " + countryCode;
    }
}
