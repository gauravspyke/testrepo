package com.ksa.core.dataaccess;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate5.HibernateTemplate;

/**
 * TestORMDataAccess.java Class
 * 
 * @version 1.0
 * @author Kalpendra Kumar Tripathi
 * @description This class is used to test the methods and scenarios mentioned
 *              in the ORMDataAccess class
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({ DetachedCriteria.class })
public class TestORMDataAccess {

	@Mock
	private SessionFactory sessionFactorycustom;

	@InjectMocks
	private ORMDataAccess oRMDataAccess;

	@Mock
	private DetachedCriteria criteria;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * testSetSessionFactory method
	 * 
	 * @return void
	 * @description Test the {@link ORMDataAccess#setSessionFactory()} method.
	 */
	@Test
	public void testSetSessionFactory() {
		oRMDataAccess.setSessionFactoryCustom(sessionFactorycustom);
		Assert.assertNotNull(sessionFactorycustom);
	}

	/**
	 * testSave method
	 * 
	 * @return void
	 * @description Test the {@link ORMDataAccess#Save()} method.
	 */
	@Test
	public void testSave() {
		Object obj = new Object();
		HibernateTemplate mockTemplate = Mockito.mock(HibernateTemplate.class);
		oRMDataAccess.setHibernateTemplate(mockTemplate);
		Mockito.when(mockTemplate.save(obj)).thenReturn((long) 1);
		oRMDataAccess.save(obj);
		Mockito.verify(mockTemplate).save(obj);
	}

	/**
	 * testsaveOrUpdate method
	 * 
	 * @return void
	 * @description Test the {@link ORMDataAccess#saveOrUpdate()} method.
	 */
	@Test
	public void testsaveOrUpdate() {
		HibernateTemplate mockTemplate = Mockito.mock(HibernateTemplate.class);
		oRMDataAccess.setHibernateTemplate(mockTemplate);
		Object obj = new Object();
		oRMDataAccess.saveOrUpdate(obj);
		Assert.assertNotNull(obj);
	}

	/**
	 * testdelete method
	 * 
	 * @return void
	 * @description Test the {@link ORMDataAccess#delete()} method.
	 */
	@Test
	public void testdelete() {
		HibernateTemplate mockTemplate = Mockito.mock(HibernateTemplate.class);
		oRMDataAccess.setHibernateTemplate(mockTemplate);
		Object obj = new Object();
		oRMDataAccess.delete(obj);
		Assert.assertNotNull(obj);
	}

	/**
	 * testdeleteAll method
	 * 
	 * @return void
	 * @description Test the {@link ORMDataAccess#deleteAll()} method.
	 */
	@Test
	public void testdeleteAll() {
		ArrayList<Object> alCollection = new ArrayList<>();
		alCollection.add(new Object());
		HibernateTemplate mockTemplate = Mockito.mock(HibernateTemplate.class);
		oRMDataAccess.setHibernateTemplate(mockTemplate);
		oRMDataAccess.deleteAll(alCollection);
		Assert.assertNotNull(alCollection);
	}

	/**
	 * testpersist method
	 * 
	 * @return void
	 * @description Test the {@link ORMDataAccess#persist()} method.
	 */
	@Test
	public void testpersist() {
		HibernateTemplate mockTemplate = Mockito.mock(HibernateTemplate.class);
		Object obj = new Object();
		oRMDataAccess.setHibernateTemplate(mockTemplate);
		oRMDataAccess.persist(obj);
		Assert.assertNotNull(obj);
	}

	/**
	 * testupdate method
	 * 
	 * @return void
	 * @description Test the {@link ORMDataAccess#update()} method.
	 */
	@Test
	public void testupdate() {
		HibernateTemplate mockTemplate = Mockito.mock(HibernateTemplate.class);
		Object obj = new Object();
		oRMDataAccess.setHibernateTemplate(mockTemplate);
		oRMDataAccess.update(obj);
		Assert.assertNotNull(obj);
	}

	/**
	 * testmerge method
	 * 
	 * @return void
	 * @description Test the {@link ORMDataAccess#merge()} method.
	 */
	@Test
	public void testmerge() {
		Boolean flag = true;
		HibernateTemplate mockTemplate = Mockito.mock(HibernateTemplate.class);
		Object obj = new Object();
		oRMDataAccess.setHibernateTemplate(mockTemplate);
		Mockito.when(mockTemplate.merge(obj)).thenReturn(flag);
		oRMDataAccess.merge(obj);
		Assert.assertTrue(flag);
	}

	/**
	 * testloadAll method
	 * 
	 * @return void
	 * @description Test the {@link ORMDataAccess#loadAll()} method.
	 */
	@Test
	public void testloadAll() {
		HibernateTemplate mockTemplate = Mockito.mock(HibernateTemplate.class);
		List list = getDummyDataList();
		Object obj = new Object();
		oRMDataAccess.setHibernateTemplate(mockTemplate);
		Mockito.when(mockTemplate.loadAll(Object.class)).thenReturn(list);
		oRMDataAccess.loadAll(Object.class);
		Assert.assertTrue(list.size() > 0);
	}

	/**
	 * testload method
	 * 
	 * @return void
	 * @description Test the {@link ORMDataAccess#load()} method.
	 */
	@Test
	public void testload() {
		Serializable id = "890";
		HibernateTemplate mockTemplate = Mockito.mock(HibernateTemplate.class);
		Object obj = new Object();
		oRMDataAccess.setHibernateTemplate(mockTemplate);
		Mockito.when(mockTemplate.load(Object.class, id)).thenReturn(obj);
		oRMDataAccess.load(Object.class, id);
		Assert.assertNotNull(obj);
	}

	/**
	 * testget method
	 * 
	 * @return void
	 * @description Test the {@link ORMDataAccess#get()} method.
	 */
	@Test
	public void testget() {
		Object obj = new Object();
		Serializable id = "890";
		HibernateTemplate mockTemplate = Mockito.mock(HibernateTemplate.class);
		Mockito.when(mockTemplate.get(Object.class, id)).thenReturn(obj);
		oRMDataAccess.setHibernateTemplate(mockTemplate);
		oRMDataAccess.get(Object.class, id);
		Assert.assertNotNull(obj);
	}

	/**
	 * testFindByCriteria method
	 * 
	 * @return void
	 * @description Test the {@link ORMDataAccess#findByCriteria()} method.
	 */
	@Test
	public void testFindByCriteria() throws DataAccessException {
		HibernateTemplate mockTemplate = Mockito.mock(HibernateTemplate.class);
		PowerMockito.mockStatic(DetachedCriteria.class);
		List list = getDummyDataList();
		oRMDataAccess.setHibernateTemplate(mockTemplate);
		Mockito.when(mockTemplate.findByCriteria(criteria, -1, -1)).thenReturn(list);
		oRMDataAccess.findByCriteria(criteria, -1, -1);
		Assert.assertNotNull(list);
	}

	/**
	 * getDummyDataList method is used to provide Dummy getDummyDataList Object
	 * List for testing.
	 * 
	 * @return List
	 * @since Junr 22, 2017 06:10:41 PM
	 */
	private List<Object> getDummyDataList() {
		List<Object> dummyData = new ArrayList<>();
		Object obj = new Object();
		dummyData.add(obj);
		return dummyData;
	}
}
