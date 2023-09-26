package ir.co.holoo.weather.model.jpa;

import ir.co.holoo.commons.data.hibernate.domain.UuidPersistable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serial;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TBL_WEATHER", indexes = {@Index(name = "CITY_INDEX", columnList = "CITY")})
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class WeatherEntity extends UuidPersistable {
    @Serial
    private static final long serialVersionUID = -1228046207404293502L;

    @Column(name = "CITY", nullable = false, length = 50)
    private String city;

    @Column(name = "LATITUDE", nullable = false)
    private Double latitude;

    @Column(name = "LONGITUDE", nullable = false)
    private Double longitude;

    @ElementCollection
    private List<Integer> degrees = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        WeatherEntity that = (WeatherEntity) o;

        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(city, that.city)
                .append(latitude, that.latitude)
                .append(longitude, that.longitude)
                .append(degrees.toArray(), that.degrees.toArray())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .appendSuper(super.hashCode())
                .append(city)
                .append(latitude)
                .append(longitude)
                .append(degrees.toArray())
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .appendSuper(super.toString())
                .append("city", city)
                .append("latitude", latitude)
                .append("longitude", longitude)
                .append("degrees", degrees.toArray())
                .toString();
    }
}
