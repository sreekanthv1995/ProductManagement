package com.product_management.Management;

import com.product_management.Management.entity.Admin;
import com.product_management.Management.entity.Role;
import com.product_management.Management.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class ManagementApplication implements CommandLineRunner {

	@Autowired
	private AdminRepository adminRepository;
	public static void main(String[] args) {
		SpringApplication.run(ManagementApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		Admin admin = adminRepository.findByRole(Role.ADMIN);
		if (admin == null){
			adminRepository.save(Admin.builder()
							.email("admin@gmail.com")
							.password(new BCryptPasswordEncoder().encode("12345"))
							.name("admin")
							.role(Role.ADMIN)
					.build());
		}
	}
}
