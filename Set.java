    /**
     * @author Gil Mansharov
     * @ID 313260192
     * This class represents the group of all the odd positive numbers
     */

public class Set 
    {
        private IntNode _head;
        private int _length;
        
        /**
         * Set class constructor
         */
        public Set() // Time Complexity: O(1), Memory Complexity: O(1)
        {
            _head = null;
            _length = 0;
        }
        
        /**
         * Checks if the Set is empty
         * @return True if the Set is empty, otherwise false
         */
        public boolean isEmpty() // Time Complexity: O(1), Memory Complexity: O(1)
        {
            return _head == null;
        }
        
        /**
         * Checks if a given number is a member of the Set
         * @param num The number to check
         * @return True if the number is a member of the Set, otherwise false
         */
        public boolean isMember(int num) // Time Complexity: O(n), Memory Complexity: O(1)
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
        
        /**
         * Checks if two Sets are the same
         * @param other The set to compare
         * @return True if the Sets are equals, otherwise false
         */
        public boolean equals(Set other) // Time Complexity: O(n), Memory Complexity: O(1);
        {
            if (other == null)
                return false;
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
        
        /**
         * Gets the number of elements in the Set
         * @return Number of elements in the set
         */
        public int numOfElements() // Time Complexity: O(1), Memory Complexity: O(1)
        {
            return _length;
        }
        
        /**
         * Checks if a given Set is a subset of the current Set object
         * @param other the Set to check if if its a subset
         * @return true if the given Set is a subset of the current Set object, otherwise false
         */
        public boolean subSet(Set other) // Time Complexity: O(n), Memory Complexity: O(1)
        {
            if (other == null)
                return false;
            if(other.isEmpty())
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
        
        /**
         * Adds a new number to the Set
         * @param x The number to add
         */
        public void addToSet(int x) // Time Complexity: O(n), Memory Complexity: O(1)
        {
            if (x % 2 == 1 && x > 0)
            {
                if (this.isEmpty())
                {
                    _head = new IntNode(x, null);
                    _length++;
                    return;
                }
                IntNode p = _head;
                if (_head.getValue() > x)
                {
                    _head = new IntNode(x, _head);
                    _length++;
                    return;
                }
                while (p.getNext() != null)
                {
                    if (p.getValue() == x)
                        return;
                    if (p.getNext().getValue() > x)
                    {
                        IntNode temp = new IntNode(x, p.getNext());
                        p.setNext(temp);
                        _length++;
                        return;
                    }
                    p = p.getNext();
                }
                if (p.getValue() != x)
                {
                    p.setNext(new IntNode(x, null));
                    _length++;
                }
            }
        }
        
        /**
         * Removes a number from the Set
         * @param x The number to remove
         */
        public void removeFromSet(int x) // Time Complexity: O(n), Memory Complexity: O(1)
        {
            if (!isMember(x))
                return;
            IntNode p = _head;
            IntNode next = p.getNext();
            if (p.getValue() == x)
            {
                _head = _head.getNext();
                _length--;
                return;
            }
            while (p != null && next != null)
            {
                if (next.getValue() == x)
                {
                    p.setNext(next.getNext());
                    _length--;
                    return;
                }
                p = p.getNext();
                next = next.getNext();
            }
        }
        
        /**
         * Gets a String that represents the Set object
         * @return a description of the Set object in this format: "{a1,a2,a3,......}" while a1,a2,a3,.... are numbers in the Set object
         */
        public String toString() // Time Complexity: O(n), Memory Complexity: O(n)
        {
            String str = new String("{");
            IntNode p = _head;
            while (p != null)
            {
                if (p.getNext() == null)
                    str += p.getValue();
                else
                    str += p.getValue() + ",";
                p = p.getNext();
            }
            str += "}";
            return new String(str);
        }
        
        /**
         * Gets the intersection of a given Set object with the current Set object
         * @param other The set to get intersection with
         * @return a new Set object which represents the intersection between the Sets
         */
        public Set intersection(Set other) // Time Complexity: O(n), Memory Complexity: O(n)
        {
            if (other == null)
                return null;
            IntNode pThis = this._head;
            IntNode pOther = other._head;
            Set intersection = new Set();
            IntNode pInter = intersection._head;
            while (pThis != null && pOther != null)
            {
                if (pThis.getValue() == pOther.getValue())
                {
                    if (intersection.isEmpty())
                    {
                        intersection._head = new IntNode(pThis.getValue(), null);
                        pInter = intersection._head;
                    }
                    else
                    {
                        pInter.setNext(new IntNode(pThis.getValue(), null));
                        pInter = pInter.getNext();
                    }
                    intersection._length++;
                    pThis = pThis.getNext();
                    pOther = pOther.getNext();
                }
                else
                {
                    if (pThis.getValue() > pOther.getValue())
                        pOther = pOther.getNext();
                    else
                        pThis = pThis.getNext();
                }
            }
            return intersection;
        }
        
        /**
         * Gets the union of a given Set object with the current Set object
         * @param other The set to get union with
         * @return a new Set object which represents the union between the Sets
         */
        public Set union(Set other) // Time Complexity: O(n), Memory Complexity: O(n)
        {
            if (other == null)
                return null;
            IntNode pThis = this._head;
            IntNode pOther = other._head;
            Set union = new Set();
            IntNode pUnion = union._head;
            
            while (pThis != null && pOther != null)
            {
                if (pThis.getValue() == pOther.getValue())
                {
                    if (union.isEmpty())
                    {
                        union._head = new IntNode(pThis.getValue(), null);
                        pUnion = union._head;
                    }
                    else
                    {
                        pUnion.setNext(new IntNode(pThis.getValue(), null));
                        pUnion = pUnion.getNext();
                    }
                    pThis = pThis.getNext();
                    pOther = pOther.getNext();
                }
                else
                {
                    if (pThis.getValue() > pOther.getValue())
                    {
                        if (union.isEmpty())
                        {
                            union._head = new IntNode(pOther.getValue(), null);
                            pUnion = union._head;
                        }
                        else
                        {
                            pUnion.setNext(new IntNode(pOther.getValue(), null));
                            pUnion = pUnion.getNext();
                        }
                        pOther = pOther.getNext();
                    }
                    else
                    {
                        if (union.isEmpty())
                        {
                            union._head = new IntNode(pThis.getValue(), null);
                            pUnion = union._head;
                        }
                        else
                        {
                            pUnion.setNext(new IntNode(pThis.getValue(), null));
                            pUnion = pUnion.getNext();
                        }
                        pThis = pThis.getNext();
                    }
                }
                union._length++;
            }
            
            while (pThis != null)
            {
                if (union.isEmpty())
                {
                    union._head = new IntNode(pThis.getValue(), null);
                    pUnion = union._head;
                }
                else
                {
                    pUnion.setNext(new IntNode(pThis.getValue(), null));
                    pUnion = pUnion.getNext();
                }
                pThis = pThis.getNext();
                union._length++;
            }
            
            while (pOther != null)
            {
                if (union.isEmpty())
                {
                    union._head = new IntNode(pOther.getValue(), null);
                    pUnion = union._head;
                }
                else
                {
                    pUnion.setNext(new IntNode(pOther.getValue(), null));
                    pUnion = pUnion.getNext();
                }
                pOther = pOther.getNext();
                union._length++;
            }
            return union;
        }
        
        /**
         * Gets the difference of a given Set object with the current Set object
         * @param other The set to get difference with
         * @return a new Set object which represents the difference between the Sets
         */
        public Set difference(Set other) // Time Complexity: O(n), Memory Complexity: O(n)
        {
            if (other == null)
                return null;
            IntNode pThis = this._head;
            IntNode pOther = other._head;
            Set difference = new Set();
            IntNode pDiff = difference._head;
            
            while (pThis != null && pOther != null)
            {
                if (pThis.getValue() == pOther.getValue())
                {
                    pThis = pThis.getNext();
                    pOther = pOther.getNext();
                }
                else
                {
                    if (pThis.getValue() > pOther.getValue())
                        pOther = pOther.getNext();
                    else
                    {
                        if (difference.isEmpty())
                        {
                            difference._head = new IntNode(pThis.getValue(), null);
                            pDiff = difference._head;
                        }
                        else
                        {
                            pDiff.setNext(new IntNode(pThis.getValue(), null));
                            pDiff = pDiff.getNext();
                        }
                        pThis = pThis.getNext();
                        difference._length++;
                    }
                }
            }
            while (pThis != null)
            {
                if (difference.isEmpty())
                {
                    difference._head = new IntNode(pThis.getValue(), null);
                    pDiff = difference._head;
                }
                else
                {
                    pDiff.setNext(new IntNode(pThis.getValue(), null));
                    pDiff = pDiff.getNext();
                }
                pThis = pThis.getNext();
            }
            return difference;
        }
	}