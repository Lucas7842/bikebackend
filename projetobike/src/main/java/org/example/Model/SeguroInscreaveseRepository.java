package org.example.Model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SeguroInscreaveseRepository extends JpaRepository<SeguroIncrevase, Long> {
    SeguroIncrevase findByEmail(String email);
}
