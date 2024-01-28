package entity;

public class Salary {
	private int id ;
	private int base_salary;
	private int salary_factor;
	private int allowance_factor;
	
	public Salary() {
		
	}

	public Salary(int id, int base_salary, int salary_factor, int allowance_factor) {
		super();
		this.id = id;
		this.base_salary = base_salary;
		this.salary_factor = salary_factor;
		this.allowance_factor = allowance_factor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBase_salary() {
		return base_salary;
	}

	public void setBase_salary(int base_salary) {
		this.base_salary = base_salary;
	}

	public int getSalary_factor() {
		return salary_factor;
	}

	public void setSalary_factor(int salary_factor) {
		this.salary_factor = salary_factor;
	}

	public int getAllowance_factor() {
		return allowance_factor;
	}

	public void setAllowance_factor(int allowance_factor) {
		this.allowance_factor = allowance_factor;
	}

	@Override
	public String toString() {
		return "Salary [id=" + id + ", base_salary=" + base_salary + ", salary_factor=" + salary_factor
				+ ", allowance_factor=" + allowance_factor + "]";
	}
	
	
}
