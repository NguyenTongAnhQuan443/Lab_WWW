package vn.edu.iuh.fit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.models.Address;
import vn.edu.iuh.fit.services.AddressService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    // Lấy tất cả địa chỉ
    @GetMapping("/all")
    public String getAllAddresses(Model model) {
        List<Address> addresses = addressService.getAllAddress();
        model.addAttribute("addresses", addresses);
        return "addresses"; // trả về trang HTML addresses.html
    }

    // Tìm kiếm địa chỉ theo ID
    @GetMapping("/{id}")
    public String getAddressById(@PathVariable UUID id, Model model) {
        Optional<Address> address = addressService.getAddressById(id);
        if (address.isPresent()) {
            model.addAttribute("address", address.get());
            return "address"; // trả về trang HTML address.html cho địa chỉ cụ thể
        } else {
            return "error"; // trả về trang lỗi nếu không tìm thấy
        }
    }

    // Thêm địa chỉ mới
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("address", new Address());
        return "addAddress"; // trả về trang HTML addAddress.html với form
    }

    @PostMapping("/add")
    public String addAddress(@ModelAttribute("address") Address address) {
        addressService.addAddress(address);
        return "redirect:/address/all"; // chuyển hướng về trang danh sách sau khi thêm
    }

    // Cập nhật địa chỉ
    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable UUID id, Model model) {
        Optional<Address> address = addressService.getAddressById(id);
        if (address.isPresent()) {
            model.addAttribute("address", address.get());
            return "updateAddress"; // trả về trang HTML updateAddress.html với form cập nhật
        } else {
            return "error"; // trả về trang lỗi nếu không tìm thấy
        }
    }

    @PostMapping("/update")
    public String updateAddress(@ModelAttribute("address") Address address) {
        addressService.updateAddress(address);
        return "redirect:/address/all"; // chuyển hướng về trang danh sách sau khi cập nhật
    }

    // Xóa địa chỉ theo ID
    @GetMapping("/delete/{id}")
    public String deleteAddress(@PathVariable UUID id) {
        addressService.deleteAddress(id);
        return "redirect:/address/all"; // chuyển hướng về trang danh sách sau khi xóa
    }
}
