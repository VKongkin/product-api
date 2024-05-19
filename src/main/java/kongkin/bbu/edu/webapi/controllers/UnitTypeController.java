package kongkin.bbu.edu.webapi.controllers;

import kongkin.bbu.edu.webapi.exceptions.AppException;
import kongkin.bbu.edu.webapi.models.UnitType;
import kongkin.bbu.edu.webapi.models.repositories.UnitTypeRepository;
import kongkin.bbu.edu.webapi.models.response.MessageResponse;
import kongkin.bbu.edu.webapi.models.services.UnitTypeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin("http://localhost:4200")
@Controller
@RestController
@RequiredArgsConstructor
@Slf4j
public class UnitTypeController {
    private final UnitTypeService unitTypeService;
    private final UnitTypeRepository unitTypeRepository;
    private MessageResponse response;

    @GetMapping("/unitTypes")
    public ResponseEntity<Object> getAllUnitType() {
        List<UnitType> list = unitTypeService.getAllUnitType();
        response = new MessageResponse();
        response.getDataSuccess(list);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/unitTypes/{id}")
    public ResponseEntity<Object> getAllUnitTypeById(@PathVariable("id") Integer id) {
        response = new MessageResponse();
        try {
            log.info("Interception get unit type by id {}", id);
            UnitType unitType = unitTypeService.getUnitTypeById(id);

            response.getDataSuccess(unitType);

        } catch (AppException e) {
            log.error("Error while get unit type by id ", e);
            response.setCode(e.getCode());
            response.setMessage(e.getMessage());
            response.setMessageKH(e.getMessageKH());

        } finally {
            log.info("Final response get unit type by id {}", response);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/unitTypes/{id}")
    public ResponseEntity<Object> getUnitTypeById(@PathVariable("id") Integer id) {
        MessageResponse response = new MessageResponse();
        try {
            log.info("Interception get unit type by id {}", id);
            UnitType unitType = unitTypeService.getUnitTypeById(id);

            if (unitType != null) {
                response.getDataSuccess(unitType);
                return ResponseEntity.ok(response);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (AppException e) {
            log.error("Error while get unit type by id ", e);
            response.setCode(e.getCode());
            response.setMessage(e.getMessage());
            response.setMessageKH(e.getMessageKH());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        } finally {
            log.info("Final response get unit type by id {}", response);
        }
    }

    @PostMapping("/unitTypes/create")
    public ResponseEntity<Object> createUnitType(@RequestBody UnitType req) {
        response = new MessageResponse();
        try {
            log.info("Interception create unit type by id {}", req);
            unitTypeService.create(req);

            response.createDataSuccess(null);

        } catch (AppException e) {
            log.error("Error while create unit type by id ", e);
            response.setCode(e.getCode());
            response.setMessage(e.getMessage());
            response.setMessageKH(e.getMessageKH());

        } catch (Throwable e) {
            log.error("Internal Server Error", e);
            response.generalDataError(null);
        } finally {
            log.info("Final response create unit type by id {}", response);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/unitTypes/update")
    public ResponseEntity<Object> updateUnitType(@RequestBody UnitType req) {
        response = new MessageResponse();
        try {
            log.info("Interception update unit type by id {}", req);
            unitTypeService.updateUnitType(req);

            response.updateDataSuccess(null);

        } catch (AppException e) {
            log.error("Error while update unit type by id ", e);
            response.setCode(e.getCode());
            response.setMessage(e.getMessage());
            response.setMessageKH(e.getMessageKH());

        } catch (Throwable e) {
            log.error("Internal Server Error", e);
            response.generalDataError(null);
        } finally {
            log.info("Final response update unit type by id {}", response);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/unitTypes/delete/{id}")
    public ResponseEntity<Object> deleteUnitType(@PathVariable("id") Integer id) {
        response = new MessageResponse();
        try {
            log.info("Interception delete unit type by id {}", id);
            unitTypeService.deleteId(id);
            response.deleteDataSuccess(null);
        } catch (AppException e) {
            log.error("Error while delete unit type by id ", e);
            response.setCode(e.getCode());
            response.setMessage(e.getMessage());
            response.setMessageKH(e.getMessageKH());

        } finally {
            log.info("Final response delete unit type by id {}", response);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
