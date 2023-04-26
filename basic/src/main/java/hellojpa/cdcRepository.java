package hellojpa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface cdcRepository extends JpaRepository<accounts, Long> {
}
