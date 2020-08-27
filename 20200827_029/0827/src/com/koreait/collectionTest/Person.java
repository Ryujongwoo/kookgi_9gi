package com.koreait.collectionTest;

//	TreeSet에 저장할 클래스는 Comparable 인터페이스를 구현받고 compareTo() 메소드를 Override 한 후 객체의 정렬 기준을 지정히야 한다.
//	TreeSet에 저장할 클래스에 구현한 omparable 인터페이스의 제네릭에는 현재 클래스의 이름을 쓰면된다.
public class Person implements Comparable<Person> {

	private String name;
	private int age;
	
	public Person() { }
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return name + "(" + age + ")";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Person other = (Person) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
//	compareTo() 메소드는 자신(this)과 인수(Person o)로 넘어온 객체(add() 메소드의 인수로 지정한 객체)에 저장된 데이터를 비교한다.
//	비교할 데이터가 문자열일 경우 자신이 크면 1, 같으면 0, 작으면 -1을 리턴한다.
//	비교할 데이터가 숫자일 경우 연산을 실행해서 자신이 크면 양수, 같으면 0, 작으면 음수를 리턴하게 만든다.
	@Override
	public int compareTo(Person o) {
		
//		return this.name.compareTo(o.name);			// name의 오름차순 정렬
//		return -this.name.compareTo(o.name);		// name의 내림차순 정렬
//		return this.age - o.age;					// age의 오름차순 정렬
//		return o.age - this.age;					// age의 내림차순 정렬
		
//		name을 기준으로 오름차순 정렬한다. 단, name이 같을 경우 age를 내림차순으로 정렬한다.
		if (this.name.compareTo(o.name) == 0) {		// name이 같은가?
			return o.age - this.age;
		} else {
			return this.name.compareTo(o.name);
		}
		
	}
	
}















