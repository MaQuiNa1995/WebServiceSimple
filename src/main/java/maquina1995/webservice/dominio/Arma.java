package maquina1995.webservice.dominio;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Arma implements Persistible<Long>, Serializable {

	@Id
	@GeneratedValue(generator = "sequence",
	        strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "sequence",
	        allocationSize = 1)
	@EqualsAndHashCode.Exclude
	private Long id;
	private String nombre;
	private String tipo;
	private Integer elemento;
	private Boolean elementoActivado;
	@EqualsAndHashCode.Exclude
	private LocalDateTime tiempoCreacion;

	@PrePersist
	private void actualizarAuditoria() {
		this.tiempoCreacion = LocalDateTime.now(ZoneId.of("Europe/Madrid"));
	}

}
