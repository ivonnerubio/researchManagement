package com.irubio.researchManagement.Repository;

import com.irubio.researchManagement.Model.Paper;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaperRepository extends JpaRepository<Paper, Long>{

        void deletePaperById(Long id);

        Optional<Paper> findPaperById(Long id);



}
