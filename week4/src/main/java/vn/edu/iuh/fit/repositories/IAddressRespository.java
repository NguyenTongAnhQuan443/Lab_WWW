package vn.edu.iuh.fit.repositories;

import vn.edu.iuh.fit.models.Address;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IAddressRespository {

    boolean addAddress(Address address);

    boolean updateAddress(Address address);

    boolean deleteAddress(UUID address);

    Optional<Address> getAddressById(UUID id);

    List<Address> getAllAddress();
}
