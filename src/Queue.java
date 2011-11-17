public class Queue<R>
{
	private QueueNode<R> head;
	private QueueNode<R> tail;
	private int height;

	public Queue()
	{
		super();
	}

	public String toString()
	{
		StringBuilder result = new StringBuilder();
		while(this.peek() != null)
		{
			result.append( this.pop().toString() );
			result.append( '\n' );
		}
		return result.toString();
	}
	
	public String toString(boolean flag)
	{
		StringBuilder result = new StringBuilder();
		while(this.peek() != null)
		{
			result.append( this.popNode().toString() );
			result.append( '\n' );
		}
		return result.toString();
	}
	public R peek()
	{
		if(this.getHead() == null)
		{
			return null;
		}
		return this.getHead().getData();
	}
	public R pop()
	{
		if( this.getHead() == null )
		{
			return null;
		}
		R toReturn = head.getData();
		this.setHead( this.getHead().getNext() );
		this.setHeight( this.getHeight() - 1 );
		return toReturn;
	}
	
	public QueueNode<R> popNode()
	{
		if( this.getHead() == null )
		{
			return null;
		}
		QueueNode<R> toReturn = this.getHead();
		this.setHead(this.getHead().getNext());
		this.setHeight(this.getHeight() -1);
		return toReturn;
	}

	public QueueNode<R> push( R toPush )
	{
		QueueNode<R> newNode = new QueueNode<R>( toPush );
		if( this.getHead() == null )
		{
			if( this.getTail() == null )
			{
				this.setTail( newNode );
				this.setHead( newNode );
				this.setHeight( this.getHeight() + 1 );
				return this.getHead();
			}
			System.out.println( "The head was null, but the tail was not" );
			return null;
		}
		this.getTail().setNext( newNode );
		this.setTail( newNode );
		this.setHeight( this.getHeight() + 1 ); 
		return this.getHead();
	}
	public QueueNode<R> pushToBottom( R toPush )
	{
		QueueNode<R> newNode = new QueueNode<R>( toPush );
		if( this.getHead() == null )
		{
			if( this.getTail() == null )
			{
				this.setTail( newNode );
				this.setHead( newNode );
				this.setHeight( this.getHeight() + 1 );
				return this.getHead();
			}
			System.out.println( "The head was null, but the tail was not" );
			return null;
		}
		newNode.setNext( this.getHead() );
		this.setHead( newNode );
		this.setHeight( this.getHeight() + 1 );
		return this.getHead();
	}

	/**
	 * @return the head
	 */
	private QueueNode<R> getHead()
	{
		return this.head;
	}

	/**
	 * @param head_p
	 *            the head to set
	 */
	private void setHead( QueueNode<R> head_p )
	{
		this.head = head_p;
	}

	/**
	 * @return the tail
	 */
	private QueueNode<R> getTail()
	{
		return this.tail;
	}

	/**
	 * @param tail_p
	 *            the tail to set
	 */
	private void setTail( QueueNode<R> tail_p )
	{
		this.tail = tail_p;
	}

	/**
	 * @return the height
	 */
	private int getHeight()
	{
		return this.height;
	}

	/**
	 * @param height_p
	 *            the height to set
	 */
	private void setHeight( int height_p )
	{
		this.height = height_p;
	}
}

class QueueNode<E>
{
	private E data;
	private QueueNode<E> next;

	QueueNode( E data )
	{
		this.data = data;
	}

	QueueNode()
	{
		super();
	}

	/**
	 * @return the data
	 */
	public E getData()
	{
		return this.data;
	}

	/**
	 * @param data_p
	 *            the data to set
	 */
	public void setData( E data_p )
	{
		this.data = data_p;
	}

	@Override
	public String toString()
	{
		return "QueueNode [data=" + this.data + ", next=" + this.next + "]";
	}

	/**
	 * @return the next
	 */
	public QueueNode<E> getNext()
	{
		return this.next;
	}

	/**
	 * @param next_p
	 *            the next to set
	 */
	public void setNext( QueueNode<E> next_p )
	{
		this.next = next_p;
	}
}
