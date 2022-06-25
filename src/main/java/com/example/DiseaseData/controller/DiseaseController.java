package com.example.DiseaseData.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.DiseaseData.model.Disease;
import com.example.DiseaseData.service.DiseaseService;

/**
 * @author pratikprajapati
 *
 *         This is the entry point for the Application
 */
@RestController
public class DiseaseController {

  @Autowired
  private DiseaseService diseaseService;


  @PostMapping
  public ResponseEntity<List<Disease>> saveOrUpdate(@RequestBody List<Disease> disease) {
    return new ResponseEntity<List<Disease>>(diseaseService.saveOrUpdate(disease),
        HttpStatus.CREATED);
  }

  @GetMapping("/findAll")
  public List<Disease> findAll() {
    return diseaseService.findAll();
  }

  @GetMapping("/getAllDiseasesInCsv")
  public void getAllDiseasesInCsv(HttpServletResponse servletResponse) throws IOException {
    servletResponse.setContentType("text/csv");
    servletResponse.addHeader("Content-Disposition", "attachment; filename=\"Disease.csv\"");
    diseaseService.writeDiseasesToCsv(servletResponse.getWriter());
  }

}
