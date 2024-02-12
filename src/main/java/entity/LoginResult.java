package entity;

public class LoginResult {
	private String message;
    private int employeeId;

    public LoginResult(String message, int employeeId) {
        this.message = message;
        this.employeeId = employeeId;
    }

    public String getMessage() {
        return message;
    }

    public int getEmployeeId() {
        return employeeId;
    }
}
