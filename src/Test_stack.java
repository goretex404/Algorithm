import java.util.EmptyStackException;

class Stack<T>{
	class Node<T>{
		private T data;  // 데이터
		private Node<T> next; // 다음노드
		
		// 생성자에서 해당 타입의 데이터를 하나 받아
		// 내부 변수에 저장한다.
		public Node(T data) {
			this.data = data;
		}
	}
	//멤버 변수 선언
	private Node<T> top;
	
	public T pop() {
		//top이 null이면 exception
		if(top == null) {
			throw new EmptyStackException();
		}
		// 맨 위 데이터 반환을하기전에 그 다음주소에있는 데이터를 TOP으로 만들어줘야한다 (스택특성)
		T item = top.data;
		top = top.next;
		return item;
	}
	//push할 T 타입의 item을 하나 받아서
	public void push(T item) {
		//그 item node를 생성
		Node<T> t = new Node<T>(item);
		//top 앞에 그 node 를 위치시키고
		t.next = top;
		//그 node가 탑이 된다.
		top = t;
	}
	public T peek() {
		if(top == null) {
			throw new EmptyStackException();
		}
		return top.data;
	}
	
	public boolean isEmpty() {
		return top == null;
	}
	
}
public class Test_stack {
	public static void main(String[] args) {
		Stack<Integer> s = new Stack<Integer>();
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.peek());
		System.out.println(s.pop());
		System.out.println(s.isEmpty());
		System.out.println(s.pop());
		System.out.println(s.isEmpty());
	}
}
