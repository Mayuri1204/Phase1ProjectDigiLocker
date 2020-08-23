package com.simplilearn.phaseoneproject;

public interface UserCredentials {

	void setLoggedInUser(String loggedInUser);

	void setSiteName(String siteName);

	void setusername(String username);

	void setPassword(String password);

	char[] getLoggedInUser();

	char[] getSiteName();

	char[] getuserName();

	Object getPassword();

}
