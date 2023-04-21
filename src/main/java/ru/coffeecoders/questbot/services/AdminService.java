package ru.coffeecoders.questbot.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.coffeecoders.questbot.entities.Admin;
import ru.coffeecoders.questbot.repositories.AdminRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
    Logger logger = LoggerFactory.getLogger(AdminService.class);
    private final AdminRepository adminRepository;
    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public List<Admin> findAll() {
        List<Admin> list = adminRepository.findAll();
        logger.info("Admins {} displaying", list.isEmpty() ? "are not" : "are");
        return list;
    }

    public Optional<Admin> findById(long id) {
        Optional<Admin> admin = adminRepository.findById(id);
        logger.info("Admin {} with id = {}", admin.isPresent() ? "found" : "not found", id);
        return admin;
    }

    public Admin save(Admin admin) {
        logger.info("Admin = {} has been saved", admin);
        return adminRepository.save(admin);
    }

    /**
     * @author ezuykow
     */
    public void deleteAll(List<Admin> admins) {
        adminRepository.deleteAll(admins);
    }

    /**
     * @author ezuykow
     */
    public Admin getOwner() {
        return findAll().stream().filter(Admin::isOwner).findAny()
                .orElseThrow(() ->
                        new RuntimeException(
                                "Этого никогда, конечно, не будет, но...." +
                                        "типа владельца бота нет, лол"
                        )
                );
    }

    /**
     * @author ezuykow
     */
    public void deleteUselessAdmins() {
        adminRepository.deleteAll(
                findAll().stream()
                        .filter(admin -> !admin.isOwner() && admin.getAdminChats().isEmpty())
                        .toList()
        );
    }
}