package com.mthree.classroster.service;

import com.mthree.classroster.dao.ClassRosterAuditDao;
import com.mthree.classroster.dao.ClassRosterPersistenceException;

public class ClassRosterAuditDaoStubImpl implements ClassRosterAuditDao {

    @Override
    public void writeAuditEntry(String entry) throws ClassRosterPersistenceException {
    }
}
