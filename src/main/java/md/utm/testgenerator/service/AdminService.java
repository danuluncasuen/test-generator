package md.utm.testgenerator.service;

import lombok.AllArgsConstructor;
import md.utm.testgenerator.db.AdminRepository;
import md.utm.testgenerator.entity.Admin;
import md.utm.testgenerator.entity.dto.AdminDto;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AdminService {

    private AdminRepository adminRepository;

    public void addNewAdmin(AdminDto adminDto) {
        Admin admin = new Admin(adminDto);
        adminRepository.save(admin);
    }

    public AdminDto getById(Long id) {
        Admin admin = adminRepository.getById(id);
        return AdminDto.builder()
                .id(admin.getId())
                .username(admin.getUsername())
                .build();
    }
}
