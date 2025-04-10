package com.app;

import com.app.entity.PermissionEntity;
import com.app.entity.RoleEntity;
import com.app.entity.RoleEnum;
import com.app.entity.UserEntity;
import com.app.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Set;

@SpringBootApplication
public class SpringBootAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAppApplication.class, args);
	}

	@Bean
	CommandLineRunner init(UserRepository userRepository){
		return args -> {
			/* CREAR LOS PERMISOS */
			PermissionEntity createPermission = PermissionEntity.builder()
					.name("CREATE")
					.build();

			PermissionEntity updatePermission = PermissionEntity.builder()
					.name("UPDATE")
					.build();

			PermissionEntity readPermission = PermissionEntity.builder()
					.name("READ")
					.build();

			PermissionEntity deletePermission = PermissionEntity.builder()
					.name("DELETE")
					.build();

			PermissionEntity refactorPermission = PermissionEntity.builder()
					.name("REFACTOR")
					.build();

			/* CREAR LOS ROLES */
			RoleEntity roleAdmin = RoleEntity.builder()
					.roleEnum(RoleEnum.ADMIN)
					.permissionList(Set.of(createPermission, readPermission, updatePermission, deletePermission))
					.build();

			RoleEntity roleUser = RoleEntity.builder()
					.roleEnum(RoleEnum.USER)
					.permissionList(Set.of(createPermission, readPermission))
					.build();

			RoleEntity roleInvited = RoleEntity.builder()
					.roleEnum(RoleEnum.INVITED)
					.permissionList(Set.of(readPermission))
					.build();

			RoleEntity roleDevelop = RoleEntity.builder()
					.roleEnum(RoleEnum.DEVELOPER)
					.permissionList(Set.of(createPermission, readPermission, updatePermission, deletePermission, refactorPermission))
					.build();

			/* CREAR LOS USUARIOS */

			UserEntity userAriane = UserEntity.builder()
					.userName("Ariane")
					.password("$2a$10$BYg4Mex5gyupw9udOGNy.eu1kNQFlvhj0yoJqy.VBlSL6/sTfwUtC")
					.isEnable(true)
					.accountNoExpired(true)
					.accountNoLocked(true)
					.credentialNoExpired(true)
					.roles(Set.of(roleAdmin))
					.build();

			UserEntity userIvan = UserEntity.builder()
					.userName("Ivan")
					.password("$2a$10$BYg4Mex5gyupw9udOGNy.eu1kNQFlvhj0yoJqy.VBlSL6/sTfwUtC")
					.isEnable(true)
					.accountNoExpired(true)
					.accountNoLocked(true)
					.credentialNoExpired(true)
					.roles(Set.of(roleUser))
					.build();

			UserEntity userAndres = UserEntity.builder()
					.userName("Andres")
					.password("$2a$10$BYg4Mex5gyupw9udOGNy.eu1kNQFlvhj0yoJqy.VBlSL6/sTfwUtC")
					.isEnable(true)
					.accountNoExpired(true)
					.accountNoLocked(true)
					.credentialNoExpired(true)
					.roles(Set.of(roleInvited))
					.build();

			UserEntity userAndrea = UserEntity.builder()
					.userName("Andrea")
					.password("$2a$10$BYg4Mex5gyupw9udOGNy.eu1kNQFlvhj0yoJqy.VBlSL6/sTfwUtC")
					.isEnable(true)
					.accountNoExpired(true)
					.accountNoLocked(true)
					.credentialNoExpired(true)
					.roles(Set.of(roleDevelop))
					.build();

			userRepository.saveAll(List.of(userAndrea, userAriane, userAndres, userIvan));
		};
	}
}
