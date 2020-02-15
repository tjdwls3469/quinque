package model;

import java.util.ArrayList;
import java.util.Collection;

import bean.Member;

public class MemberDAO {

	/**
	 * 회원들의 리스트를 갖는 변수
	 */
	private ArrayList<Member> members;
	
	private String url;
	private String user;
	private String password;
	private String Driver;
	
	
	public MemberDAO()
	{
		this(null);
	}
	public MemberDAO(ArrayList<Member> members)
	{
		this.members = members;
	}
	
	public boolean add(Member e) {
		return members.add(e);
	}
	
	public void add(int index, Member element) {
		members.add(index, element);
	}
	
	public boolean addAll(Collection<? extends Member> c) {
		return members.addAll(c);
	}
	
	public boolean addAll(int index, Collection<? extends Member> c) {
		return members.addAll(index, c);
	}
	
	public int size() {
		return members.size();
	}
	
	public int indexOf(Object o) {
		return members.indexOf(o);
	}
	
	public Object clone() {
		return members.clone();
	}
	
	public Member get(int index) {
		return members.get(index);
	}
	
	public Member set(int index, Member element) {
		return members.set(index, element);
	}

	public Member remove(int index) {
		return members.remove(index);
	}
	
	public boolean remove(Object o) {
		return members.remove(o);
	}

	public String toString() {
		return members.toString();
	}
	
	
}
