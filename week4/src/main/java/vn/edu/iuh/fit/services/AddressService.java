package vn.edu.iuh.fit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.models.Address;
import vn.edu.iuh.fit.repositories.IAddressRespository;
import vn.edu.iuh.fit.repositories.Impl.AddressRepositoryImpl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AddressService {

    private AddressRepositoryImpl addressRepositoryImpl;

    @Autowired
    public AddressService(AddressRepositoryImpl addressRepositoryImpl) {
        this.addressRepositoryImpl = addressRepositoryImpl;
    }

    public boolean addAddress(Address address) {
        return addressRepositoryImpl.addAddress(address);
    }

    public boolean updateAddress(Address address) {
        return addressRepositoryImpl.updateAddress(address);
    }

    public boolean deleteAddress(UUID addressId) {
        return addressRepositoryImpl.deleteAddress(addressId);
    }

    public Optional<Address> getAddressById(UUID id) {
        return addressRepositoryImpl.getAddressById(id);
    }

    public List<Address> getAllAddress() {
        return addressRepositoryImpl.getAllAddress();
    }
}
