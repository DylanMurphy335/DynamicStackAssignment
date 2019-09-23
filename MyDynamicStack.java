package hint2;

public class MyDynamicStack implements MyStack {
	private MyNode head;
	private int numItems;

	public MyDynamicStack( ){
		this.head = null;
	}

	public boolean isEmpty(){
		if (head == null) { return true; }
		else { return false; }
	}

	public int pop(){
		int ret = -1;
		if (numItems < 0) {
			System.out.println("ERROR: Cannot remove item, invalid index " + numItems);
			ret = -1;
		}
		else{
			if (numItems == 0) {
				head = head.getNext();
                this.numItems--;
                ret = -1;
			}
			else {
				MyNode currentNode = head;
                MyNode previousNode = null;
                int count = 0;

                while (count < numItems){
                    previousNode = currentNode;
                    currentNode = currentNode.getNext();
                    count = count + 1;
                }

                previousNode.setNext(currentNode);
                currentNode = null;
                this.numItems--;
                ret = previousNode.getInfo();
			}
        }
        return ret;
	}

	public void push(int element){
		MyNode newNode = new MyNode(element, null);
		MyNode currentNode = head;

		if (numItems == 0) {
			newNode.setNext(currentNode);
			head = newNode;
			numItems++;
		}
		else if ((numItems > 0)) {
			for (int count = 0; count < numItems-1; count++) {
				currentNode = currentNode.getNext();
			}
			currentNode.setNext(newNode);
			newNode.setNext(null);
			numItems++;
		}
	}

	public void print(){
		String res2 = "";
		int res;
		int index = numItems-1;

		if ((index >= 0) && (index < numItems)) {
			MyNode current = this.head;
			int count = 0;
			while (count <= index){
				res2 += current.getInfo() + " ";
				current = current.getNext();
				count = count + 1;
			}
			char[] array = res2.toCharArray();
			String reverse = "";
		    for (int i = array.length-1; i >= 0; i--) {
		    	reverse += array[i];
		    }
			System.out.print(reverse);
		}
		else {
			res = -1;
			System.out.println("ERROR: Cannot get item, invalid index " + (index+1));
		}
	}
}
