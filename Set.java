

/*
 * Do We need to check if the numbers at the set are odd and positive in the constructor ?
 */
public class Set 
{
	private IntNode _head;
	
	
	public Set() // Time Complexity: O(1), Memory Complexity: O(1)
	{
		_head = null;
	}
	
	/*public Set(IntNode h) // Time Complexity: O(n^2), Memory Complexity: O(n)
	{
		if (h == null)
		{
			_head = null;
			return;
		}
		IntNode p = null;
		boolean isNull = true;
		
		while (h != null)
		{
			if (h.getValue() % 2 == 1 && h.getValue() > 0 && !isMember(h.getValue()))
			{
				if (p == null)
				{
					_head = new IntNode(h.getValue(), null);
					p = _head;
					isNull = false;
				}
				else
				{
					p.setNext(new IntNode(h.getValue(), null));
					p = p.getNext();
				}
			}
			h = h.getNext();
		}
		if (isNull)
			_head = null;
	}*/
	
	public boolean isEmpty() //Time Complexity: O(1), Memory Complexity: O(1)
	{
		return _head == null;
	}
	
	public boolean isMember(int num) //Time Complexity: O(n), Memory Complexity: O(1)
	{
		IntNode p = _head;
		while (p != null)
		{
			if (p.getValue() == num)
				return true;
			if (p.getValue() > num)
				return false;
			p = p.getNext();
		}
		return false;
	}
	
	
	public boolean equals(Set other) //Time Complexity: O(n), Memory Complexity: O(1);
	{
		if (this.numOfElements() != other.numOfElements())
			return false;
		IntNode p1 = this._head;
		IntNode p2 = other._head;
		while (p1 != null && p2 != null)
		{
			if (p1.getValue() != p2.getValue())
				return false;
			p1 = p1.getNext();
			p2 = p2.getNext();
		}
		return true;
	}
	
	public int numOfElements() //Time Complexity: O(n), Memory Complexity: O(1)
	{
		int count = 0;
		IntNode p = _head;
		while (p != null)
		{
			count++;
			p = p.getNext();
		}
		return count;
	}
	
	public boolean subSet(Set other) //Time Complexity: O(n), Memory Complexity: O(1)
	{
		if(other._head == null)
			return true;
		if (this.numOfElements() < other.numOfElements())
			return false;
		IntNode p1 = this._head;
		IntNode p2 = other._head;
		boolean flag = false;
		while (p1 != null && p2 != null)
		{
			if (p1.getValue() > p2.getValue())
				return false;
			if (p1.getValue() == p2.getValue())
			{
				flag = true;
				p1 = p1.getNext();
				p2 = p2.getNext();
			}
			else
			{
				if (flag)
					return false;
				p1 = p1.getNext();
			}
		}
		return flag;
	}
	
	public void addToSet(int x) //Time Complexity: O(n), Memory Complexity: O(1)
	{
		if (x % 2 == 1 && x > 0)
		{
			if (_head == null)
			{
				_head = new IntNode(x, null);
				return;
			}
			IntNode p = _head;
			while (p.getNext() != null)
			{
				if (p.getValue() == x)
					return;
				if (p.getNext().getValue() > x)
				{
					IntNode temp = new IntNode(x, p.getNext());
					p.setNext(temp);
					return;
				}
			}
			p.setNext(new IntNode(x, null));
		}
	}
	
	public void removeFromSet(int x) //Time Complexity: O(n), Memory Complexity: O(1)
	{
		
		IntNode p = _head;
		IntNode next = p.getNext();
		if (p.getValue() == x)
		{
			_head = _head.getNext();
			return;
		}
		while (p != null && next != null)
		{
			if (next.getValue() == x)
			{
				p.setNext(next.getNext());
				return;
			}
		}
	}
	
	public String toString() //Time Complexity: O(n), Memory Complexity: O(1)
	{
		String str = new String("{");
		IntNode p = _head;
		while (p != null)
		{
			if (p.getNext() == null)
				str += p.getValue();
			else
				str += p.getValue() + ",";
		}
		str += "}";
		return new String(str);
	}
	
	
	/**
	 * @param other
	 * @return
	 */
	public Set intersection(Set other) // Time Complexity: O(n^2), Memory Complexity: O(n)
	{
		IntNode pStatic = null;
		IntNode pToAdd = null;
		IntNode pOther = other._head;
		while (pOther != null)
		{
			if (isMember(pOther.getValue()))
			{
				if (pStatic == null)
				{
					pStatic = new IntNode(pOther.getValue(), null);
					pToAdd = pStatic;
				}
				else
				{
					pToAdd.setNext(new IntNode(pOther.getValue(), null));
					pToAdd = pToAdd.getNext();
				}
			}
			pOther = pOther.getNext();
		}
		return new Set(pStatic);
	}
}













