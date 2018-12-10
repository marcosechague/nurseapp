package py.com.nurseapp.controller;

import java.net.MalformedURLException;
import java.net.URI;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.swagger.annotations.ApiOperation;
import py.com.nurseapp.beans.Patient;
import py.com.nurseapp.dto.request.PatientDto;
import py.com.nurseapp.service.PatientService;

@RestController("patients")
public class PatientController {

    static final String BASE_CONTROLLER_PATH = "v1/patients";

    private static final Logger LOGGER= LoggerFactory.getLogger(PatientController.class);

    @Autowired
    private PatientService patientService;

    @ApiOperation(value="Register patient", notes="Create new patient", response=Patient.class)
    @PostMapping
    public Patient createPatient(HttpServletResponse response,
            @RequestBody
            @Valid PatientDto patientDto ) throws MalformedURLException {
        LOGGER.info("IN POST /patients {}", patientDto);
        Patient patientRegister = patientService.createPatient(patientDto);
        LOGGER.info("OUT POST /patients {} ",patientRegister);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id-patient}")
                .buildAndExpand(patientRegister.getCodPatient()).toUri();
        response.setHeader("Location", location.toString());
        return patientRegister;
    }

    

    @ApiOperation(value="Get patient", notes="Get patient's data. given an id-patient", response=Patient.class)
    @GetMapping(path="/{id-patient}")
    public ResponseEntity<Patient> getPatient(
            @PathVariable(value="id-patient")Integer idPatient) {
        LOGGER.info("IN GET /patients/{}",idPatient);
        Patient patient = patientService.getPatient(idPatient);
        LOGGER.info("OUT GET /patients/{}  {}",idPatient, patient);
        return  ResponseEntity.ok(patient);
    }
//
//
////    @ApiOperation(value="Get patients", notes="Get patient a list of patients", response=ResponsePatientListDto.class)
//    @GetMapping()
//    public ResponseEntity<ResponsePatientListDto> getPatients(
//            @RequestParam(value="name", required = false)String name,
//            @RequestParam(value="document", required = false)String document,
//            @RequestParam(value="status", required = false)Status status) {
//        LOGGER.info("IN GET /patients/ with params {},{},{}",name, document, status);
//        List<Patient> patients = patientService.getPatients(name, document, status);
//        ResponsePatientListDto patiensList = new ResponsePatientListDto(patients);
//        LOGGER.info("OUT GET /patients {} ",patiensList);
//        return  ResponseEntity.ok(patiensList);
//    }
//
////    @ApiOperation(value="Update patient", notes="Update patient data")
//    @PutMapping
//    @ResponseStatus(code=HttpStatus.OK)
//    public void updatePatient(
//            @PathVariable(value="id-patient")Integer idPatient,
//            @RequestBody
//            @Valid PatientDto patientDto ){
//        LOGGER.info("IN PUT /patients {}", patientDto);
//        patientService.createPatient(patientDto);
//        LOGGER.info("OUT PUT /patients OK");
//    }
//
////    @ApiOperation(value="Delete patient", notes="Delete patient data")
//    @DeleteMapping
//    @ResponseStatus(code=HttpStatus.NO_CONTENT)
//    public void deletePatient(
//            @PathVariable(value="id-patient")Integer idPatient){
//        LOGGER.info("IN DELETE /patients/{}", idPatient);
//        patientService.deletePatient(idPatient);
//        LOGGER.info("OUT DELETE /patients OK");
//    }
//
////    @ApiOperation(value="Register history patient vital sign ", notes="Register a new history patient vital sign ", response=ResponsePatientVitalSignDto.class)
//    @PostMapping("/vital-signs")
//    public ResponseEntity<String> createHistoryPatientVitalSign(
//            @RequestBody
//            @Valid PatientVitalSignDto patientVitalSignDto ) {
//        LOGGER.info("IN POST /patients/vital-signs {}", patientVitalSignDto);
//        ResponsePatientVitalSignDto responsePatientListDto = patientService.registerPatientVitalSign(patientVitalSignDto);
//        LOGGER.info("OUT POST /patients/vital-signs {} ",responsePatientListDto);
//        URI location = ServletUriComponentsBuilder
//                .fromCurrentRequest().path("/{id}")
//                .buildAndExpand(responsePatientListDto.getPatientVitalSign().getId()).toUri();
//        return ResponseEntity.created(location).build();
//    }


}
