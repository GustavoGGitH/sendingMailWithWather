package com.OpenWeather.Request.Entities;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Users {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer id;
	
	@Column
	public String username;
	
	@Column
	public String firstname;
	
	@Column
	public String lastname;
	
	@Column
	public String localidad;
	
	@Column 
	public Integer id_localidad;
		
	@Column
	public String email;

	/**
	 * 
	 */
	public Users() {
	
	}


	public Users(Integer id, String username, String firstname, String lastname, String localidad, Integer id_localidad,
			String email) {
		super();
		this.id = id;
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.localidad = localidad;
		this.id_localidad = id_localidad;
		this.email = email;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getLocalidad() {
		return localidad;
	}


	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}


	public Integer getId_localidad() {
		return id_localidad;
	}


	public void setId_localidad(Integer id_localidad) {
		this.id_localidad = id_localidad;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((id_localidad == null) ? 0 : id_localidad.hashCode());
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result + ((localidad == null) ? 0 : localidad.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Users other = (Users) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (id_localidad == null) {
			if (other.id_localidad != null)
				return false;
		} else if (!id_localidad.equals(other.id_localidad))
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		if (localidad == null) {
			if (other.localidad != null)
				return false;
		} else if (!localidad.equals(other.localidad))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Users [id=" + id + ", username=" + username + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", localidad=" + localidad + ", id_localidad=" + id_localidad + ", email=" + email + "]";
	}
	
	
	
	

}
