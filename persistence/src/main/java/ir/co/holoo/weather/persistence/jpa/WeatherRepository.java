package ir.co.holoo.weather.persistence.jpa;

import ir.co.holoo.weather.model.jpa.WeatherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherRepository extends JpaRepository<WeatherEntity, String> {
}
