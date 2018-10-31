package com.ksa.core.dataaccess;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

/**
 * JDBCDataAccess.java Class
 * 
 * @version 1.0
 * @author Daksh Verma
 * @description The class is used to provide the JDBC support for Nav services. The class extends the
 *              NamedParameterJdbcDaoSupport class of the SpringFramework. The class includes methods to insert, delete
 *              or update either in batch or singly.
 */
public abstract class JDBCDataAccess<T> extends NamedParameterJdbcDaoSupport {

	/**
	 * setDataSourceCustom method
	 * 
	 * @param dataSource
	 * @return void
	 * @description This method is used to set the custom data source by autowiring it from
	 *              {@link com.ksa.core.config.DBConfig}.
	 */
	@Autowired
	public void setDataSourceCustom(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	/**
	 * batchInsert method
	 * 
	 * @param sql
	 * @param batchValues
	 * @return
	 * @throws SQLException
	 * @return int[]
	 * @description Method used to insert a number of rows in the table taking input the sql and the batch values as a
	 *              array of map.
	 */
	public int[] batchInsert(String sql, Map<String, ?>[] batchValues) throws SQLException {
		return getNamedParameterJdbcTemplate().batchUpdate(sql, batchValues);
	}

	/**
	 * findObject method
	 * 
	 * @param sql
	 * @param elementType
	 * @return
	 * @return T
	 * @description Method used to fetch the object of type T from the database. It is similar to executing Select command.
	 */
	public T findObject(String sql, Class<T> elementType) {
		return (T) getJdbcTemplate().queryForObject(sql, elementType);

	}

	/**
	 * fetchList method
	 * 
	 * @param sql
	 * @param elementType
	 * @return List<T>
	 * @description Method used to fetch a list of objects of type T. It is similar to executing Select * command.
	 */
	public List<T> fetchList(String sql, Class<T> elementType) {
		return getJdbcTemplate().queryForList(sql, elementType);
	}

	/**
	 * deleteAllRows method
	 * 
	 * @param sql
	 * @return int
	 * @description Method used to delete all the rows from table according to the sql provided.
	 */
	public int deleteAllRows(String sql) {
		return getJdbcTemplate().update(sql);
	}

	/**
	 * findEntityByParameter method
	 * 
	 * @param sql
	 * @param params
	 * @param elementType
	 * @return T
	 * @description Method used to find entity of Type T with parameters as conditions. It returns an object of type T.
	 */
	@SuppressWarnings("hiding")
	public <T> T findEntityByParameter(String sql, Object[] params, Class<T> elementType) {
		return (T) getJdbcTemplate().queryForObject(sql, params, elementType);
	}

	/**
	 * fetchListWithParams method
	 * 
	 * @param sql
	 * @param params
	 * @param elementType
	 * @return List<T>
	 * @description Method used to fetch list of type T with parameters as conditions.
	 */
	public List<T> fetchListWithParams(String sql, Object[] params, Class<T> elementType) {
		return getJdbcTemplate().queryForList(sql, params, elementType);
	}

	/**
	 * queryForList method
	 * 
	 * @param sql
	 * @param params
	 * @param mapper
	 * @return List<T>
	 * @description Method used to query the list of type T.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<T> queryForList(String sql, Object[] params, RowMapper mapper) {
		return getJdbcTemplate().query(sql, params, mapper);
	}

	/**
	 * update method
	 * 
	 * @param sql
	 * @return int
	 * @description Method used to update a row in the table according to the sql provided as parameter.
	 */
	public int update(String sql) {
		return getJdbcTemplate().update(sql);
	}

	/**
	 * insert method
	 * 
	 * @param sql
	 * @param paramMap
	 * @throws SQLException
	 * @return int
	 * @description Method used to insert a row into the table.
	 */
	public int insert(String sql, Map<String, ?> paramMap) throws SQLException {
		return getNamedParameterJdbcTemplate().update(sql, paramMap);
	}
	
	/**
	 * getRowCount method
	 * @param sql
	 * @return
	 * @throws SQLException
	 * @description Method used to get row count of a particular table. 
	 */
	public int getAllRowCount(String sql){
		return getJdbcTemplate().queryForObject(sql, Integer.class);
	}
	
	/**
	 * findObject method
	 * 
	 * @param sql
	 * @param elementType
	 * @return
	 * @return T
	 * @description Method used to fetch the object of type T from the database. It is similar to executing Select command.
	 */
	public T findObject(String sql, Map<String, ?> paramMap, Class<T> elementType) {
		return (T) getNamedParameterJdbcTemplate().queryForObject(sql, paramMap, elementType);

	}
}
