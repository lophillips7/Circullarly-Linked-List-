/** This program constructs a Circularly Linked List Class to make a shopping
* list for the Prog2.java.
*
*Pledged
*@author Lo Phillips
*@date 10/15/19
*/
public class CList<E>
{
private Link<E> head;
private Link<E> curr;
private int cnt;

public void clear(){
curr = head = null;
cnt = 0;
}//clear

public void moveToStart(){
curr = head;
}//moveToStart

public void prev(){
if(curr == head)
return;
Link<E> temp = head;
while(temp.next() != curr)
	temp = temp.next();
curr = temp;
}//prev

public void next(){
curr = curr.next();
}//next

public int length(){
return cnt;
}//length

public int currPos(){
	Link<E> temp = head;
	int count = 0;
	for (int i = 0; curr != temp; i++)
	{
		temp = temp.next();
		count++;}
	return count;
}//currPos

public void moveToPos(int pos){
	assert (pos>=0) && (pos<=cnt): "Position out of range";
	curr =  head;
	for(int i=0; i<pos; i++)
		curr = curr.next();
}//moveToPos

public E getValue(){
	if(head == null) return null;
	else
		return curr.element();
}//getValue

public void insert(E item){
	if(head == null){
	head = new Link<E>(item, null);
	head.setNext(head);
	curr = head;
	}//if
	else
	{
		curr.setNext(new Link<E>(item, curr.next()));
	}
	cnt++;
}//insert

public void append(E item){
	 if(head == null){
	 	 head = new Link<E> (item, null);
	 	 curr = head;
}//if
	else if(head.next() == null){
		head.setNext(new Link<E>(item, head));}
	else {
		Link <E> temp = head;
		while(temp.next() != head){
			temp = temp.next();
		}//while
			temp.setNext(new Link<E>(item, head));
	}//else
	cnt++;
}//append
	
 public E remove() {
  	  Link <E> temp;
  	  Link<E> tail;
  	  if(head == null) {
  	  	  return null;
  	  } //if
	  else if(cnt == 1){
		temp = head;
		curr = head = null;
		cnt--;
		return temp.element();}//else if
  	  else if(curr == head) {
  	  	  temp = head;
  	  	  curr = head.next();
  	  	  tail = head;
	  	  while(tail.next() != head)
	  		  tail = tail.next();
  	  	  head = head.next();
  	  	  tail.setNext(head);
  	  	  cnt--;
  	  	  return temp.element();
  	  }//else if
  	  else {
  	  	  temp = curr;  
  	  	  prev();
  	  	  curr.setNext(curr.next().next());
  	  	  curr = curr.next();
  	  	  cnt--;
  	  	  return temp.element();
  	  }//else
  }//remove

}//CList