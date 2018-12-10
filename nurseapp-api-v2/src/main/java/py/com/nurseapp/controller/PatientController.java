package py.com.nurseapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//import py.com.naturabeans.Patient;
//import py.com.naturabeans.dto.request.PatientDto;

@RestController()
public class PatientController {

    static final String BASE_CONTROLLER_PATH = "v1/patients";

    private static final Logger LOGGER= LoggerFactory.getLogger(PatientController.class);


//    @ApiOperation(value="Register patient", notes="Create new patient", response=Patient.class)
//    @PostMapping
//    @RequestMapping(method=RequestMethod.GET)
//    public Patient createPatient(
//            @RequestBody
//            @Valid PatientDto patientDto ) {
//        LOGGER.info("IN POST /patients {}", patientDto);
//        Patient patientRegister = null;//patientService.createPatient(patientDto);
//        LOGGER.info("OUT POST /patients {} ",patientRegister);
//        return patientRegister;
//        URI location = ServletUriComponentsBuilder
//                .fromCurrentRequest().path("/{id-patient}")
//                .buildAndExpand(patientRegister.getCodPatient()).toUri();
//        return ResponseEntity.created(location).build();
//
//    }

////    @ApiOperation(value="Get patient", notes="Get patient's data. given an id-patient", response=Patient.class)
////    @GetMapping("/{id-patient}")
//    @RequestMapping(value = "/{id-patient}", method=RequestMethod.GET)
//    public ResponseEntity<Patient> getPatient(
//            @PathVariable(value="id-patient")Integer idPatient) {
//        LOGGER.info("IN GET /patients/{}",idPatient);
//        Patient patient = null;//patientService.getPatient(idPatient);
//        LOGGER.info("OUT GET /patients/{}  {}",idPatient, patient);
//        return  ResponseEntity.ok(patient);
//    }
    
    
//@ApiOperation(value="Get patient", notes="Get patient's data. given an id-patient", response=Patient.class)
@RequestMapping(value = "/{id-patient}", method=RequestMethod.GET)
public ResponseEntity<String> getPatient(
        @PathVariable(value="id-patient")Integer idPatient) {
    LOGGER.info("IN GET /patients/{}",idPatient);
    String patient = null;//patientService.getPatient(idPatient);
    LOGGER.info("OUT GET /patients/{}  {}",idPatient, patient);
    return  ResponseEntity.ok(patient);
}
    
//
//
////    @ApiOperation(value="Get patients", notes="Get patient a list of patients", response=ResponsePatientListDto.class)
////    @GetMapping()
//    public ResponseEntity<ResponsePatientListDto> getPatients(
//            @RequestParam(value="name", required = false)String name,
//            @RequestParam(value="document", required = false)String document,
//            @RequestParam(value="status", required = false)Status status) {
//        LOGGER.info("IN GET /patients/ with params {},{},{}",name, document, status);
//        List<Patient> patients = null;//patientService.getPatients(name, document, status);
//        ResponsePatientListDto patiensList = new ResponsePatientListDto(patients);
//        LOGGER.info("OUT GET /patients {} ",patiensList);
//        return  ResponseEntity.ok(patiensList);
//    }
//
////    @ApiOperation(value="Update patient", notes="Update patient data")
////    @PutMapping
//    @ResponseStatus(code=HttpStatus.OK)
//    public void updatePatient(
//            @PathVariable(value="id-patient")Integer idPatient,
//            @RequestBody
//            @Valid PatientDto patientDto ){
//        LOGGER.info("IN PUT /patients {}", patientDto);
//       // patientService.createPatient(patientDto);
//        LOGGER.info("OUT PUT /patients OK");
//    }
//
////    @ApiOperation(value="Delete patient", notes="Delete patient data")
////    @DeleteMapping
//    @ResponseStatus(code=HttpStatus.NO_CONTENT)
//    public void deletePatient(
//            @PathVariable(value="id-patient")Integer idPatient){
//        LOGGER.info("IN DELETE /patients/{}", idPatient);
////        patientService.deletePatient(idPatient);
//        LOGGER.info("OUT DELETE /patients OK");
//    }
//
////    @ApiOperation(value="Register history patient vital sign ", notes="Register a new history patient vital sign ", response=ResponsePatientVitalSignDto.class)
////    @PostMapping("/vital-signs")
//    @RequestMapping(value="/vital-signs", method=RequestMethod.GET)
//    public ResponseEntity<Patient> createHistoryPatientVitalSign(
//            @RequestBody
//            @Valid PatientVitalSignDto patientVitalSignDto ) {
//        LOGGER.info("IN POST /patients/vital-signs {}", patientVitalSignDto);
//        ResponsePatientVitalSignDto responsePatientListDto = null;//patientService.registerPatientVitalSign(patientVitalSignDto);
//        LOGGER.info("OUT POST /patients/vital-signs {} ",responsePatientListDto);
//        URI location = ServletUriComponentsBuilder
//                .fromCurrentRequest().path("/{id}")
//                .buildAndExpand(responsePatientListDto.getPatientVitalSign().getId()).toUri();
//        return ResponseEntity.created(location).build();
//    }


}
