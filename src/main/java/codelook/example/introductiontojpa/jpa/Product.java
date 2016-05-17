package codelook.example.introductiontojpa.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
@Table(name = "products")
public class Product {

	@Id
    @Column(name = "product_id", insertable = true, updatable = false, nullable = false)
	private Integer id = null;
	
	@Column(name = "product_name", insertable = true, updatable = true, nullable = false)
	private String name = null;

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	@Override
	public int hashCode() {		
		return new HashCodeBuilder()
			.append(this.id)
			.append(this.name)
			.toHashCode();
	}

	@Override
	public boolean equals(Object obj) {

		if (obj == null) { return false; }		
		if (obj == this) { return true; }
		if (obj.getClass() != getClass()) { return false; }
		
		Product rhs = (Product) obj;
		
		return new EqualsBuilder()
			.append(this.getId(), rhs.getId())
			.append(this.getName(), rhs.getName())
			.isEquals();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this)
			.append("id", this.id)
			.append("name", this.name)
			.toString();
	}
}
