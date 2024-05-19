package kongkin.bbu.edu.webapi.models.services;

import kongkin.bbu.edu.webapi.exceptions.AppException;
import kongkin.bbu.edu.webapi.models.UnitType;

import java.util.List;

public interface UnitTypeService {
    List<UnitType> getAllUnitType();
    UnitType getUnitTypeById(Integer id) throws AppException;
    void create(UnitType unitType) throws AppException;
    void updateUnitType(UnitType unitType) throws AppException;
    void delete(UnitType unitType) throws AppException;
    void deleteId(Integer id) throws AppException;
}
