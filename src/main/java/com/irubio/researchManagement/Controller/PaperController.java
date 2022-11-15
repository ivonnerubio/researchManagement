package com.irubio.researchManagement.Controller;

import com.irubio.researchManagement.Model.Paper;
import com.irubio.researchManagement.Service.PaperService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/paper")
public class PaperController {
    private final PaperService paperService;


    public PaperController(PaperService paperService) {
        this.paperService = paperService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Paper>> getAllPapers(){
        List<Paper> papers = paperService.getAllPapers();
        return new ResponseEntity<>(papers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paper> getPaper(@PathVariable("id") Long id){
        Paper paper = paperService.getPaperById(id);
        return new ResponseEntity<>(paper, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Paper> addPaper(@RequestBody Paper paper){
        Paper newPaper = paperService.addNewPaper(paper);
        return new ResponseEntity<>(newPaper, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Paper> updatePaper(@RequestBody Paper paper){
        Paper updatedPaper = paperService.updatePaper(paper);
        return new ResponseEntity<>(updatedPaper, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @Transactional
    public ResponseEntity<Paper> deletePaper(@PathVariable("id") Long id){
        paperService.deletePaper(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}

