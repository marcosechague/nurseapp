package py.com.naturabeans.nurseappapi.controller;

import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import py.com.naturabeans.nurseappapi.service.PatientService;
import py.com.nurseapp.beans.Patient;
import py.com.nurseapp.beans.Status;
import py.com.nurseapp.dto.request.PatientDto;
import py.com.nurseapp.dto.request.PatientVitalSignDto;

import java.net.URI;
import java.util.List;

import static py.com.naturabeans.nurseappapi.constants.Constants.API_VERSION;
import static py.com.naturabeans.nurseappapi.controller.VitalSignController.BASE_CONTROLLER_PATH;

@RestController(value = BASE_CONTROLLER_PATH)
public class VitalSignController {

    static final String BASE_CONTROLLER_PATH = API_VERSION+"/vital-signs";

    private static final Logger LOGGER= LoggerFactory.getLogger(VitalSignController.class);

    @Autowired
    private PatientService patientService;


    /*@ApiOperation(value="Register patient", notes="Create new patient", response=Patient.class)
    @PostMapping
    public ResponseEntity<Patient> createPatient(
            @RequestBody
            @Valid PatientDto patientDto ) {
        LOGGER.info("IN POST /patients {}", patientDto);
        Patient patientRegister = patientService.createPatient(patientDto);
        LOGGER.info("OUT POST /patients {} ",patientRegister);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id-patient}")
                .buildAndExpand(patientRegister.getCodPatient()).toUri();
        return ResponseEntity.created(location).build();

    }

    @ApiOperation(value="Get patient", notes="Get patient's data. given an id-patient", response=Patient.class)
    @GetMapping("/{id-patient}")
    public ResponseEntity<Patient> getPatient(
            @PathVariable(value="id-patient")Integer idPatient) {
        LOGGER.info("IN GET /patients/{}",idPatient);
        Patient patient = patientService.getPatient(idPatient);
        LOGGER.info("OUT GET /patients/{}  {}",idPatient, patient);
        return  ResponseEntity.ok(patient);
    }


    @ApiOperation(value="Get patients", notes="Get patient a list of patients", response=ResponsePatientList.class)
    @GetMapping()
    public ResponseEntity<ResponsePatientList> getPatients(
            @RequestParam(value="name", required = false)String name,
            @RequestParam(value="document", required = false)String document,
            @RequestParam(value="status", required = false)Status status) {
        LOGGER.info("IN GET /patients/ with params {},{},{}",name, document, status);
        List<Patient> patients = patientService.getPatients(name, document, status);
        ResponsePatientList patiensList = new ResponsePatientList(patients);
        LOGGER.info("OUT GET /patients {} ",patiensList);
        return  ResponseEntity.ok(patiensList);
    }

    @ApiOperation(value="Update patient", notes="Update patient data")
    @PutMapping
    @ResponseStatus(code=HttpStatus.OK)
    public void updatePatient(
            @PathVariable(value="id-patient")Integer idPatient,
            @RequestBody
            @Valid PatientDto patientDto ){
        LOGGER.info("IN PUT /patients {}", patientDto);
        patientService.createPatient(patientDto);
        LOGGER.info("OUT PUT /patients OK");
    }

    @ApiOperation(value="Delete patient", notes="Delete patient data")
    @DeleteMapping
    @ResponseStatus(code=HttpStatus.NO_CONTENT)
    public void deletePatient(
            @PathVariable(value="id-patient")Integer idPatient){
        LOGGER.info("IN DELETE /patients/{}", idPatient);
        patientService.deletePatient(idPatient);
        LOGGER.info("OUT DELETE /patients OK");
    }

    @ApiOperation(value="Register history patient vital sign ", notes="Register a new history patient vital sign ", response=Patient.class)
    @PostMapping("/vital-signs")
    public ResponseEntity<Patient> createHistoryPatientVitalSign(
            @RequestBody
            @Valid PatientVitalSignDto patientVitalSignDto ) {
        LOGGER.info("IN POST /patients/vital-signs {}", patientVitalSignDto);

        //TODO VER QUE PONER AQUI
         patientService.registerpatientVitalSign(patientVitalSignDto);
        LOGGER.info("OUT POST /patients/vital-signs {} ",patientRegister);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id-patient}")
                .buildAndExpand(patientRegister.getCodPatient()).toUri();
        return ResponseEntity.created(location).build();

    }*/


}
