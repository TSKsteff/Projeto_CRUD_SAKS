package br.saks.register_services.Entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;

import br.saks.register_services.enums.RoleEnum;


@NoArgsConstructor
@Builder
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_user")
public class User implements Serializable{
	private static final long serialVersionUID = 1758144941447184738L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 100)
	private String name;
		
	@Column(nullable = false, length = 11)
	private String cpf;
	
	@Column(nullable = false, length = 100, unique = true)
	private String email;

	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false, length = 20)
	private String telephone;

	@Column(nullable = false)
	private Boolean active;
	
	@Enumerated(EnumType.STRING)
	private RoleEnum role;

	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

	@PrePersist
	protected void onCreate() {
		createdAt = LocalDateTime.now();
		updatedAt = LocalDateTime.now();
	}
	@PreUpdate
	protected void onUpdate() {
		updatedAt = LocalDateTime.now();
	}

}
