package ftimo.tourserviceapplication.repository;


import ftimo.tourserviceapplication.model.Tour;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TourRepository extends JpaRepository<Tour, Long> {
}
