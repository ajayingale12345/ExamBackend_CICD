package com.cybage.entity;

import java.util.Collection;



import java.util.HashSet;
import java.util.Set;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@ToString
@Table(name="users")
@Data
public class User  implements UserDetails{
	@Id                     
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String username;
	private String password;
	private String firstName;
	private String lastName;

	private String email;
	private boolean enabled=true;
	private String profile;
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy ="user")
	@JsonIgnore
	private Set<UserRole>userRoles=new HashSet<UserRole>();
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
	 Set<Authority>set =new  HashSet<>();
	   this.userRoles.forEach(userRole->{
		   set.add(new Authority(userRole.getRole().getRoleName()));
	   });
		return set;
	}
	@Override
	public String getUsername() {
		
		return username;
	}
	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
	
		return true;
	}
	

}
