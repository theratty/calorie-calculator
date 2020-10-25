package com.awysocki.caloriecalculator.user;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.awysocki.caloriecalculator.validation.FieldMatch;

/**
 * This class is registration form. It contains validation rules for all fields.
 */
@FieldMatch.List({
    @FieldMatch(first = "password", second = "matchingPassword", message = "Hasla musza byc takie same!")
})
public class CrmUser {

	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String userName;

	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String password;
	
	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String matchingPassword;

	private String formRole;

	public CrmUser() {

	}

	public String getFormRole() {
		return formRole;
	}
	public void setFormRole(String formRole) {
		this.formRole = formRole;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMatchingPassword() {
		return matchingPassword;
	}

	public void setMatchingPassword(String matchingPassword) {
		this.matchingPassword = matchingPassword;
	}

}
