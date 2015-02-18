package org.onedevelopment.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.appfuse.dao.BaseDaoTestCase;
import org.appfuse.dao.GenericDao;
import org.junit.Test;
import org.onedevelopment.dao.api.ProvinceDAO;
import org.onedevelopment.model.Province;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

public class ProvinceDaoTest extends BaseDaoTestCase {

	@Autowired
	private ProvinceDAO provinceDao;

	@Test
	public void testFindProvinceByName() throws Exception {
		List<Province> people = provinceDao.findByName("Pichincha");
		assertTrue(people.size() > 0);
	}

	@Autowired
	public void setProvinceDao(GenericDao<Province, Integer> provinceDao) {
		this.provinceDao = (ProvinceDAO) provinceDao;
	}

	@Test(expected = DataAccessException.class)
	public void testAddAndRemovePerson() throws Exception {
		Province province = new Province();
		province.setName("Los Rios");

		province = provinceDao.save(province);
		flush();

		province = provinceDao.get(province.getId());

		assertEquals("Country", province.getName());
		assertNotNull(province.getId());

		log.debug("Eliminando provincia...");

		provinceDao.remove(province.getId());
		flush();

		// should throw DataAccessException
		provinceDao.get(province.getId());
	}

}
