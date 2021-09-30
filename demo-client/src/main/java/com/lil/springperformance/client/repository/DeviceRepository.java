package com.lil.springperformance.client.repository;

import com.lil.springperformance.client.DemoClientApplication;
import com.lil.springperformance.client.domain.Device;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DeviceRepository {

    //https://www.onlinetutorialspoint.com/spring-boot/spring-boot-h2-database-jdbc-example.html

    private static Logger logger = LoggerFactory.getLogger(DeviceRepository.class);

    @Autowired
    JdbcTemplate jdbc;

    public List<Device> getAllDevices(){
        List<Device> devices = jdbc.query("select id, name, display, isUp category from device",(result,rowNum)->new Device(result.getInt("id"),
                result.getString("name"),result.getString("display"),result.getBoolean("isup")));
        return devices;
    }

    public Device getDevice(int id){
        String query = "select * from device where id = ?";
        Device device = jdbc.queryForObject(query,new Object[]{id},new BeanPropertyRowMapper<>(Device.class));
        logger.info(device.toString());
        return device;
    }
}


