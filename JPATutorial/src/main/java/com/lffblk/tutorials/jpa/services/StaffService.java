package com.lffblk.tutorials.jpa.services;

import com.lffblk.tutorials.jpa.entities.advanced.joinedtable.JoinedTableStaff;
import com.lffblk.tutorials.jpa.entities.advanced.joinedtable.NonTeachingJoinedTableStaff;
import com.lffblk.tutorials.jpa.entities.advanced.joinedtable.TeachingJoinedTableStaff;
import com.lffblk.tutorials.jpa.entities.advanced.singletable.NonTeachingSingleTableStaff;
import com.lffblk.tutorials.jpa.entities.advanced.singletable.SingleTableStaff;
import com.lffblk.tutorials.jpa.entities.advanced.singletable.TeachingSingleTableStaff;
import com.lffblk.tutorials.jpa.entities.advanced.tableperclass.NonTeachingTablePerClassStaff;
import com.lffblk.tutorials.jpa.entities.advanced.tableperclass.TablePerClassStaff;
import com.lffblk.tutorials.jpa.entities.advanced.tableperclass.TeachingTablePerClassStaff;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by lffblk on 14.05.2017.
 */
public class StaffService extends BaseService {
    public TeachingSingleTableStaff createTeachingSingleTableStaff(String name, String qualification,
                                                                   String subjectExpertise) {
        entityManager.getTransaction().begin();

        TeachingSingleTableStaff staff = new TeachingSingleTableStaff();
        staff.setName(name);
        staff.setQualification(qualification);
        staff.setSubjectExpertise(subjectExpertise);
        entityManager.persist(staff);

        entityManager.getTransaction().commit();
        return staff;
    }

    public NonTeachingSingleTableStaff createNonTeachingSingleTableStaff(String name, String areaExpertise) {
        entityManager.getTransaction().begin();

        NonTeachingSingleTableStaff staff = new NonTeachingSingleTableStaff();
        staff.setName(name);
        staff.setAreaExpertise(areaExpertise);
        entityManager.persist(staff);

        entityManager.getTransaction().commit();
        return staff;
    }

    public TeachingJoinedTableStaff createTeachingJoinedTableStaff(String name, String qualification,
                                                                   String subjectExpertise) {
        entityManager.getTransaction().begin();

        TeachingJoinedTableStaff staff = new TeachingJoinedTableStaff();
        staff.setName(name);
        staff.setQualification(qualification);
        staff.setSubjectExpertise(subjectExpertise);
        entityManager.persist(staff);

        entityManager.getTransaction().commit();
        return staff;
    }

    public NonTeachingJoinedTableStaff createNonTeachingJoinedTableStaff(String name, String areaExpertise) {
        entityManager.getTransaction().begin();

        NonTeachingJoinedTableStaff staff = new NonTeachingJoinedTableStaff();
        staff.setName(name);
        staff.setAreaExpertise(areaExpertise);
        entityManager.persist(staff);

        entityManager.getTransaction().commit();
        return staff;
    }

    public TeachingTablePerClassStaff createTeachingTablePerClassStaff(String name, String qualification,
                                                                       String subjectExpertise) {
        entityManager.getTransaction().begin();

        TeachingTablePerClassStaff staff = new TeachingTablePerClassStaff();
        staff.setName(name);
        staff.setQualification(qualification);
        staff.setSubjectExpertise(subjectExpertise);
        entityManager.persist(staff);

        entityManager.getTransaction().commit();
        return staff;
    }

    public NonTeachingTablePerClassStaff createNonTeachingTablePerClassStaff(String name, String areaExpertise) {
        entityManager.getTransaction().begin();

        NonTeachingTablePerClassStaff staff = new NonTeachingTablePerClassStaff();
        staff.setName(name);
        staff.setAreaExpertise(areaExpertise);
        entityManager.persist(staff);

        entityManager.getTransaction().commit();
        return staff;
    }

    public List<SingleTableStaff> getAllSingleTableStaff() {
        Query query = entityManager.createQuery("SELECT s FROM SingleTableStaff s");
        return query.getResultList();
    }

    public List<JoinedTableStaff> getAllJoinedTableStaff() {
        Query query = entityManager.createQuery("SELECT s FROM JoinedTableStaff s");
        return query.getResultList();
    }

    public List<TablePerClassStaff> getAllTablePerClassStaff() {
        Query query = entityManager.createQuery("SELECT s FROM TablePerClassStaff s");
        return query.getResultList();
    }

    @Override
    void clearTable() {
        entityManager.getTransaction().begin();

        Query query = entityManager.createQuery("DELETE FROM SingleTableStaff e");
        query.executeUpdate();

        query = entityManager.createQuery("DELETE FROM JoinedTableStaff e");
        query.executeUpdate();

        query = entityManager.createQuery("DELETE FROM TablePerClassStaff e");
        query.executeUpdate();

        entityManager.getTransaction().commit();
    }

    public static StaffService getInstance() {
        if (instance == null) {
            instance = new StaffService();
        }
        return (StaffService) instance;
    }
}
