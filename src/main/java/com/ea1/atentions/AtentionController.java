package com.ea1.atentions;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AtentionController {
  private List<Atention> atentions = new ArrayList<>();

  public AtentionController() {
    Doctor doctor = new Doctor(0, "12832324-3", "Carlos Antonio Fuentes Smith", "Cardiología", "Carlos.fuentes.cardiologo@clinicauc.cl", "Avenida Las Condes 27312, Las Condes, Santiago", 982737323);
    Patient patient1 = new Patient(0, "10345678-9", "Alfredo Monsalve Fuenzalida", "Avenida Pedro Aguirre Cerda 2677, Cerrillos, Santiago", "Alfredomonsalve@gmail.com", 980834353);
    Patient patient2 = new Patient(0, "7232323-K", "Carolina Carrasco Aguilar", "Pasaje Cerro Murallón 2575, Maipú, Santiago", "carolina.nails@gmail.com", 923230492);
    Patient patient3 = new Patient(0, "20374832-0", "Alejandro López Aguirre", "Avenida Pedro Aguirre Cerda 2677, Cerrillos, Santiago", "Aj.lopezaguirre@gmail.com", 998909093);

    atentions.add(new Atention(0, LocalDate.of(2024,1,1), patient1, doctor, "Hipertensión arterial", "Control de la presión arterial mediante medicamentos como los inhibidores de la enzima convertidora de angiotensina (IECA) o los bloqueadores de los receptores de angiotensina (BRA)", "Es importante adoptar un estilo de vida saludable que incluya una dieta baja en sodio, ejercicio regular y evitar el consumo de tabaco y alcohol"));
    atentions.add(new Atention(1, LocalDate.of(2024, 1, 1), patient2, doctor, "Cardiopatía isquémica estable", "Uso de medicamentos antianginosos como los nitratos, beta-bloqueantes o calcioantagonistas, además de estatinas para controlar el colesterol", "El paciente debe ser educado sobre la importancia de controlar factores de riesgo modificables como la hipertensión, el colesterol alto y el tabaquismo, y seguir una dieta y ejercicio adecuados"));
    atentions.add(new Atention(2, LocalDate.of(2024,1,1), patient3, doctor, "Arritmia cardíaca (fibrilación auricular)", "Control del ritmo cardíaco con medicamentos antiarrítmicos, anticoagulación para prevenir la formación de coágulos sanguíneos y, en algunos casos, cardioversión eléctrica", "Es importante que el paciente evite la cafeína, el alcohol y otros desencadenantes de arritmias, y siga un seguimiento regular con su cardiólogo"));
    atentions.add(new Atention(3, LocalDate.of(2024, 3, 20), patient1, doctor, "Infarto de miocardio", "Administración de medicamentos antiplaquetarios como el ácido acetilsalicílico (aspirina), terapia de reperfusión como la angioplastia coronaria o la trombolisis", "El paciente debe recibir educación sobre la importancia de buscar atención médica inmediata ante síntomas de infarto, como dolor en el pecho o dificultad para respirar"));
    atentions.add(new Atention(4, LocalDate.of(2024, 3, 21), patient2, doctor, "Insuficiencia cardíaca congestiva", "Uso de diuréticos para controlar la retención de líquidos, inhibidores de la enzima convertidora de angiotensina (IECA) o bloqueadores de los receptores de angiotensina (BRA) para mejorar la función cardíaca", "El paciente debe llevar un registro diario del peso corporal y estar atento a signos de empeoramiento de los síntomas, como dificultad para respirar o hinchazón de las extremidades"));
  }

  @GetMapping("/atentions")
  public List<Atention> getAtentions() {
    return atentions;
  }

  @GetMapping("/atentions/{id}")
  public ResponseEntity<?> getAtention(@PathVariable int id) {
    for (Atention atention : atentions) {
      if (atention.getId() == id) {
        return ResponseEntity.ok(atention);
      }
    }

    ErrorMessage errorMessage = new ErrorMessage(404, "No se encontró la atención con el id: " + id);
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
  }
  
  @GetMapping("/atentions/doctors/{rut}")
  public ResponseEntity<?> getAtentionsPerDoctor(@PathVariable String rut) {
    List<Atention> atentionsPerDoc = new ArrayList<>();

    for (Atention atention : atentions) {
      if (atention.getDoctor().getRut().equals(rut)) {
        atentionsPerDoc.add(atention);
      }
    }

    if (atentionsPerDoc.size() > 0) {
      return ResponseEntity.ok(atentionsPerDoc);
    } else {
      ErrorMessage errorMessage = new ErrorMessage(404, "No se encontraron atenciones para el doctor: " + rut);
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }
  }

  @GetMapping("/atentions/patients/{rut}")
  public ResponseEntity<?> getAtentionsPerPatient(@PathVariable String rut) {
    List<Atention> atentionsPerPatient = new ArrayList<>();

    for (Atention atention : atentions) {
      if (atention.getPatient().getRut().equals(rut)) {
        atentionsPerPatient.add(atention);
      }
    }

    if (atentionsPerPatient.size() > 0) {
      return ResponseEntity.ok(atentionsPerPatient);
    } else {
      ErrorMessage errorMessage = new ErrorMessage(404, "No se encontraron atenciones para el paciente: " + rut);
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }
  }
}
