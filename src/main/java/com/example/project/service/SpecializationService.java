package com.example.project.service;

import com.example.project.dao.SpecializationDAO;
import com.example.project.entity.Specialization;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SpecializationService {
    private final SpecializationDAO specializationDAO;

    public List<Specialization> selectAllSpecializations() {
        return specializationDAO.selectAllSpecializations();
    }

    public void createSpecialization(Specialization specialization) {
        specializationDAO.createSpecialization(specialization);
    }

    public Specialization getSpecializationById(int id) {
        return specializationDAO.showSpecializationById(id);
    }

    public void updateSpecialization(int id, Specialization updatedSpecialization) {
        specializationDAO.updateSpecialization(id, updatedSpecialization);
    }
}
