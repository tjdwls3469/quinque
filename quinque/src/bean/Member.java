package bean;

public class Member {
	private String id;
	private String password;
	private String nickName;
	private String email;
	
	
	public Member()
	{
		this(null,null,null,null);
	}
	
	public Member(String id, String password, String nickName, String email)
	{
		
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		if(id == null) return ;
		this.id = id;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		if(password == null) return ;
		this.password = password;
	}
	
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		if(nickName == null) return ;
		this.nickName = nickName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		if(email == null) return ;
		this.email = email;
	}

	public String toString() {
		return "Member [id=" + id + ", password=" + password + ", nickName=" + nickName + ", email=" + email + "]";
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nickName == null) ? 0 : nickName.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		
		if (obj == null)
			return false;
		
		if (getClass() != obj.getClass())
			return false;
		
		Member other = (Member) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} 
		else if (!email.equals(other.email))
			return false;
		
		if (id == null) {
			if (other.id != null)
				return false;
		} 
		else if (!id.equals(other.id))
			return false;
		
		if (nickName == null) {
			if (other.nickName != null)
				return false;
		} 
		else if (!nickName.equals(other.nickName))
			return false;
		
		if (password == null) {
			if (other.password != null)
				return false;
		}
		else if (!password.equals(other.password))
			return false;
		
		return true;
	}
	
	
	
}
