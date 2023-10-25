package ist.challenge.zacharias.service;

import ist.challenge.zacharias.model.User;

public class UserResponse {
    private String status;
    private String message;
    private Iterable<User> users;
    private User user;

    public UserResponse(String status, String message, Iterable<User> users) {
        this.status = status;
        this.message = message;
        this.users = users;
    }
    
    public UserResponse(String status, String message, User user) {
        this.status = status;
        this.message = message;
        this.setUser(user);
    }
    
    public UserResponse(String status, String message) {
        this.status = status;
        this.message = message;        
    }

    // Getters and setters
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Iterable<User> getUsers() {
        return users;
    }

    public void setUsers(Iterable<User> users) {
        this.users = users;
    }

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
