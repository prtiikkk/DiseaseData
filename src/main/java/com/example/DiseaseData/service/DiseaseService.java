package com.example.DiseaseData.service;

import java.io.IOException;
import java.io.Writer;
import java.util.List;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.DiseaseData.model.Disease;
import com.example.DiseaseData.repository.DiseaseRepository;

/**
 * @author pratikprajapati
 *
 *         This is the service layer of the Application
 */
@Service
public class DiseaseService {

  // private static final Logger log = LoggerFactory.getLogger(DiseaseService.class);

  @Autowired
  DiseaseRepository diseaseRepository;

  public List<Disease> saveOrUpdate(List<Disease> diseases) {
    return diseaseRepository.saveAll(diseases);
  }

  public List<Disease> findAll() {
    return diseaseRepository.findAll();
  }

  public void writeDiseasesToCsv(Writer writer) {
    List<Disease> diseases = diseaseRepository.findAll();
    try (CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT)) {
      for (Disease disease : diseases) {
        csvPrinter.printRecord(disease.getICD(), disease.getSYNONYMS());
      }
    } catch (IOException e) {
      // log.log(Level.SEVERE, "Error While writing CSV ", e);
    }
  }
}
