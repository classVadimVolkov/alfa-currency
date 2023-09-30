package by.volkov.consumer.repository;

import by.volkov.consumer.model.RateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RateRepository extends JpaRepository<RateEntity, Long> {
}
