package com.lil.springperformance.client.repository;

import com.lil.springperformance.client.domain.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DeviceRepository {

    //https://www.onlinetutorialspoint.com/spring-boot/spring-boot-h2-database-jdbc-example.html

    @Autowired
    JdbcTemplate jdbc;

    public List<Device> getAllDevices(){
        List<Device> devices = jdbc.query("select id, name, display, isUp category from device",(result,rowNum)->new Device(result.getInt("id"),
                result.getString("name"),result.getString("display"),result.getBoolean("isup")));
        return devices;
    }

    public Device getDevice(int id){
        String query = "SELECT * FROM ITEM WHERE ID=?";
        Device device = jdbc.queryForObject(query,new Object[]{id},new BeanPropertyRowMapper<>(Device.class));

        return device;
    }
}


