package ariservice.izay.util;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@MappedSuperclass
public abstract class BaseEntity implements Serializable{
	
	@Column(nullable = false, updatable = false)
	@CreationTimestamp
	private Date created_at;

	
	@Column(nullable = false, updatable = false)
	@UpdateTimestamp
	private Date updatedAtDate;
}
