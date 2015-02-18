package org.onedevelopment.impl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.appfuse.service.impl.BaseManagerMockTestCase;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.onedevelopment.dao.api.ProvinceDAO;
import org.onedevelopment.model.Province;
import org.onedevelopment.service.impl.ProvinceServiceImpl;
import org.springframework.security.ldap.userdetails.Person;

public class ProvinceManagerImplTest extends BaseManagerMockTestCase {
	
	@InjectMocks
    private ProvinceServiceImpl manager;
 
    @Mock
    private ProvinceDAO dao;
 
    @Test
    public void testGetProvince() {
        log.debug("testing get...");
        //given
        final Integer id = 0;
        final Province person = new Province();
        //given(dao.get(id)).willReturn(person);
        //when
        Province result = manager.get(id);
        //then
        assertSame(person, result);
    }
 
    @Test
    public void testGetProvinces() {
        log.debug("testing getAll...");
        //given
        final List persons = new ArrayList();
        //given(dao.getAll()).willReturn(persons);
        //when
        List result = manager.getAll();
        //then
        assertSame(persons, result);
    }
 
    @Test
    public void testSaveProvince() {
        log.debug("testing save...");
        //given
        final Province person = new Province();
        // enter all required fields
         
        //given(dao.save(person)).willReturn(person);
        //when
        manager.save(person);
        //then
        //verify(dao).save(person);
    }
    @Test
    public void testRemoveProvince() {
        log.debug("testing remove...");
        //given
        final Integer id = 0;
        //willDoNothing().given(dao).remove(id);
        //when
        manager.remove(id);
        //then
        //verify(dao).remove(id);
    }

}
