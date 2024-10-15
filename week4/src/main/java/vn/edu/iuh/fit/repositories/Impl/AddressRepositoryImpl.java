package vn.edu.iuh.fit.repositories.Impl;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.models.Address;
import vn.edu.iuh.fit.repositories.IAddressRespository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class AddressRepositoryImpl implements IAddressRespository {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public AddressRepositoryImpl(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public boolean addAddress(Address address) {
        String sql = "insert into address (id, city, country, number, street, zipcode) values (?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, address.getId(), address.getCity(), address.getCountry(), address.getNumber(), address.getStreet(), address.getZipcode()) > 0;
    }

    @Override
    public boolean updateAddress(Address address) {
        String sql = "update address set city = ?, country = ?, number = ?, street = ?, zipcode = ? where id = ?";
        return jdbcTemplate.update(sql, address.getCity(), address.getCountry(), address.getNumber(), address.getStreet(), address.getZipcode(), address.getId()) > 0;
    }

    @Override
    public boolean deleteAddress(UUID address) {
        String sql = "delete from address where id = ?";
        return jdbcTemplate.update(sql, address) > 0;
    }

    @Override
    public Optional<Address> getAddressById(UUID id) {
        String sql = "select * from address where id = ?";
        Address address = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Address.class), id);
        return address != null ? Optional.of(address) : Optional.empty();
    }

    @Override
    public List<Address> getAllAddress() {
        String sql = "select * from address";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Address.class));
    }
}
