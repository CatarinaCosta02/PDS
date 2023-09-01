package ex1;

import java.util.Iterator;
import java.util.ListIterator;

public class VectorGeneric<T> {
	private T[] vec;		
	private int nElem;	      
	private final static int ALLOC = 50;   
	private int dimVec = ALLOC;     

	@SuppressWarnings("unchecked")
	public VectorGeneric() {
		vec = (T[]) new Object[dimVec];
		nElem = 0;
	}
	
	public boolean addElem(T elem) {
		if (elem == null)
			return false;
		ensureSpace();
		vec[nElem++] = elem;
		return true;
	}

	private void ensureSpace() {
		if (nElem>=dimVec) {
			dimVec += ALLOC;
			@SuppressWarnings("unchecked")
			T[] newArray = (T[]) new Object[dimVec];
			System.arraycopy(vec, 0, newArray, 0, nElem );
			vec = newArray;
		}
	}

	public boolean removeElem(T elem) {
		for (int i = 0; i < nElem; i++) {
			if (vec[i].equals(elem)) {
				if (nElem-i-1 > 0) // not last element
					System.arraycopy(vec, i+1, vec, i, nElem-i-1 );
				vec[--nElem] = null; // libertar último objecto para o GC
				return true;
			}
		}
		return false;
	}

	public int totalElem() {
		return nElem;
	}
	
	public T getElem(int i) {
		return (T) vec[i];
	}

	public Iterator<T> iterator(){
		return this.new VectorIterator<T>();
	}

	private class VectorIterator<A> implements Iterator<A> {
		// curent position of the iterator
		private int cursor;

		public VectorIterator() {
			this.cursor = 0;
		}
		// means that there is still elements to iterate
		@Override
		public boolean hasNext() {
			return this.cursor != nElem;
		}

		@Override
		public A next() {
			if ( cursor >= nElem ) {
				System.out.println("Index out of bounds");
				throw new IndexOutOfBoundsException();
			}
			return (A) vec[cursor++];
			
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
		
	}

	public ListIterator<T> listIterator(){
		return this.new VectorListIterator<T>();
	}

	public ListIterator<T> listIterator(int index){
		return this.new VectorListIterator<T>(index);
	}

	private class VectorListIterator<A> implements ListIterator<A>{

		private int cursor;

		public VectorListIterator() {
			this.cursor = 0;
		}

		public VectorListIterator(int index) {
			this.cursor = index;
		}

		@Override
		public void add(A a) {
			throw new UnsupportedOperationException();
		}

		@Override
		public boolean hasNext() {
			return this.cursor != nElem;
		}

		@Override
		public boolean hasPrevious() {
			if ( cursor == 0 ) {
				System.out.println("Index out of bounds");
				throw new IndexOutOfBoundsException();
			}
			return true;
		}

		@Override
		public A next() {
			if ( cursor >= nElem ) {
				System.out.println("Index out of bounds");
				throw new IndexOutOfBoundsException();
			}
			return (A) vec[cursor++];
		}

		@Override
		public int nextIndex() {
			return cursor;
		}

		@Override
		public A previous() {
			if ( cursor == 0 ) {
				System.out.println("Index out of bounds");
				throw new IndexOutOfBoundsException();
			}
			return (A) vec[--cursor];
		}

		@Override
		public int previousIndex() {
			return cursor-1;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}

		@Override
		public void set(A arg0) {
			throw new UnsupportedOperationException();

		}

	}
}