package com.irubio.researchManagement.Service;

import com.irubio.researchManagement.Model.Paper;
import com.irubio.researchManagement.Exception.PaperNotFoundException;
import com.irubio.researchManagement.Repository.PaperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.constant.Constable;
import java.util.List;
import java.util.UUID;

@Service
public class PaperService {

    private final PaperRepository paperRepository;

    @Autowired
    public PaperService(PaperRepository paperRepository) {
        this.paperRepository = paperRepository;
    }

    public Paper addNewPaper(Paper paper){
        paper.setPaperCode(UUID.randomUUID().toString());
        return paperRepository.save(paper);

    }

    public List<Paper> getAllPapers(){
        return paperRepository.findAll();
    }

    public Paper getPaperById(Long id){
        return paperRepository.findPaperById(id).orElseThrow(()-> new PaperNotFoundException("Paper with id "+id+"was not found"));
    }

    public Paper updatePaper(Paper paper){
        return paperRepository.save(paper);
    }

    public void deletePaper(Long id){
        paperRepository.deletePaperById(id);
    }



}
