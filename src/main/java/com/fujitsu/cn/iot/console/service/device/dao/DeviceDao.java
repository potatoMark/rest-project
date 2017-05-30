package com.fujitsu.cn.iot.console.service.device.dao;

import com.fujitsu.cn.iot.console.service.device.entity.Company;
import com.fujitsu.cn.iot.console.service.device.entity.Device;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by yule on 2017/3/27.
 *
 * Data retrieving and building from database.
 */
@Repository
public class DeviceDao {
    private static final Logger LOG = LoggerFactory.getLogger(DeviceDao.class);

    @Autowired
    JdbcTemplate jdbcTemplate;

    private static final String SQL_RETRIEVE_DEVICE_LIST =
            "select device.id as dev_id, device.name as dev_name, device.type as dev_type, " +
            "company.id as com_id, company.name as com_name, company.address as com_addr, company.tel as com_tel, company.sector as com_sector " +
            "from device left join company on device.companyId = company.id";

    private static final String SQL_RETRIEVE_DEVICE = SQL_RETRIEVE_DEVICE_LIST + " where device.id = ?";

    public void insertDevice(Device device) {
        jdbcTemplate.update("insert into device (id, name, type, companyid) values (?, ?, ?, ?)",
                                device.getDeviceId(),
                                device.getName(),
                                device.getType(),
                                device.getOwner().getCompanyId());
    }

    public void removeDeviceById(String id) {
        jdbcTemplate.update("delete from device where id = ?", id);
    }

    public void updateDeviceInfo(Device device) {
        jdbcTemplate.update("update device() set name = ?, type = ?, companyid = ? where id = ?",
                            device.getName(),
                            device.getType(),
                            device.getOwner().getCompanyId(),
                            device.getDeviceId());
    }

    public Device findDeviceById(String deviceId) {
        try {
            return jdbcTemplate.queryForObject(SQL_RETRIEVE_DEVICE, new DeviceMapper(), deviceId);
        } catch (DataAccessException e){
            LOG.error("exception occurred while retrieving device.", e);
            return null;
        }
    }

    public List<Device> findAllDevices() {
        return jdbcTemplate.query(SQL_RETRIEVE_DEVICE_LIST, new DeviceMapper());
    }


    // template
    private static final class DeviceMapper implements RowMapper<Device> {

        @Override
        public Device mapRow(ResultSet resultSet, int i) throws SQLException {
            Device device = new Device();
            Company company = new Company();

            device.setDeviceId(resultSet.getString("dev_id"));
            device.setName(resultSet.getString("dev_name"));
            device.setType(resultSet.getString("dev_type"));

            company.setCompanyId(resultSet.getString("com_id"));
            company.setName(resultSet.getString("com_name"));
            company.setAddress(resultSet.getString("com_addr"));
            company.setTel(resultSet.getString("com_tel"));
            company.setSector(resultSet.getString("com_sector"));

            device.setOwner(company);

            return device;
        }
    }

}
