package org.example.Model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface InscreaveseRepository extends JpaRepository<SeguroIncrevase, Long> {
    SeguroIncrevase findByEmail(String email);
}
