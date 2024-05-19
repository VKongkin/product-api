package kongkin.bbu.edu.webapi.models.services.impl;

import kongkin.bbu.edu.webapi.exceptions.AppException;
import kongkin.bbu.edu.webapi.models.UnitType;
import kongkin.bbu.edu.webapi.models.repositories.UnitTypeRepository;
import kongkin.bbu.edu.webapi.models.services.UnitTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UnitTypeServiceImpl implements UnitTypeService {

    private final UnitTypeRepository unitTypeRepository;

    @Override
    public List<UnitType> getAllUnitType() {
        return unitTypeRepository.findAll();
    }

    @Override
    public UnitType getUnitTypeById(Integer id) throws AppException {
        var unitType = unitTypeRepository.findById(id).orElse(null);
        if (unitType == null) {
            throw new AppException("ERR-001", "Unit type is not found!", "Unit type is not found!");
        }
        return unitType;
    }

    @Override
    public void create(UnitType req) throws AppException {
        var checkExist = unitTypeRepository.findByName(req.getName());

        if (checkExist != null) {
            throw new AppException("ERR-002", "Unit type is already exist!", "Unit type is already exist!");
        }
        unitTypeRepository.save(req);
    }

    @Override
    public void updateUnitType(@RequestBody UnitType req) throws AppException {
        var unitType = unitTypeRepository.findById(req.getId());
        if (unitType.isEmpty()) {
            throw new AppException("ERR-001", "Unit type is not found!", "Unit type is not found!");
        }
        var checkExistName = unitTypeRepository.findByName(req.getName());

        if (checkExistName != null) {
            if (checkExistName.getId() != unitType.get().getId()) {
                throw new AppException("ERR-002", "Unit type is already exist!", "Unit type is already exist!");
            }
        }

        unitTypeRepository.save(req);
    }

    @Override
    public void delete(@RequestBody UnitType unitType) throws AppException {
        var unitTypeExist = unitTypeRepository.findById(unitType.getId());
        var unitTypeId = unitTypeRepository.findById(unitType.getId()).orElse(null);

        if (unitTypeId == null) {
            throw new AppException("ERR-001", "Unit type is not found!", "Unit type is not found!");
        }
        try {
            unitTypeRepository.delete(unitType);
        } catch (Exception e) {
            throw new AppException("ERR-003", "Unit type is not found!", "Unit type is not found!");
        }
    }

    @Override
    public void deleteId(Integer id) throws AppException {
        var unitTypeId = unitTypeRepository.findById(id).orElse(null);

        if (unitTypeId == null) {
            throw new AppException("ERR-001", "Unit type is not found!", "Unit type is not found!");
        }
        try {
            unitTypeRepository.deleteById(id);
        } catch (Exception e) {
            throw new AppException("ERR-003", "Unit type is not found!", "Unit type is not found!");
        }
    }


}
