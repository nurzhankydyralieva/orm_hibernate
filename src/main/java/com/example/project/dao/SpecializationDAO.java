package com.example.project.dao;

import com.example.project.entity.Specialization;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SpecializationDAO {
    private final SessionFactory sessionFactory;

    @Transactional(readOnly = true)
    public List<Specialization> selectAllSpecializations() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("SELECT s FROM Specialization s", Specialization.class).getResultList();
    }

    @Transactional(readOnly = true)
    public Specialization showSpecializationById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Specialization.class, id);
    }

    @Transactional
    public void createSpecialization(Specialization specialization) {
        Session session = sessionFactory.getCurrentSession();
        Specialization speciality = new Specialization();
        speciality.setSpeciality(specialization.getSpeciality());
        session.save(speciality);
    }

    @Transactional
    public void updateSpecialization(int id, Specialization updatedSpecialization) {
        Session session = sessionFactory.getCurrentSession();
        Specialization specializationToUpdate = session.get(Specialization.class, id);
        specializationToUpdate.setSpeciality(updatedSpecialization.getSpeciality());
    }
}
