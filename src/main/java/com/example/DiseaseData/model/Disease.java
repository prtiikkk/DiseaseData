package com.example.DiseaseData.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author pratikprajapati
 *
 *         This is the model class for the Application
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Disease {

  private static final long serialVersionUID = 1L;
  private String ICD;
  private List<String> SYNONYMS;

  public String getICD() {
    return ICD;
  }

  public void setICD(String iCD) {
    ICD = iCD;
  }

  public List<String> getSYNONYMS() {
    return SYNONYMS;
  }

  public void setSYNONYMS(List<String> sYNONYMS) {
    SYNONYMS = sYNONYMS;
  }

}
