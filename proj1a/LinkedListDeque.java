public class LinkedListDeque <Item>{

    private IntNode sentinel;
    private int size;


    public class IntNode {
         public IntNode prev;
         public Item item;
         public IntNode next;

         public IntNode() {
             item = null;
             prev = null;
             next = null;
         }

        public IntNode(Item _item, IntNode _prev, IntNode _next) {
            item = _item;
            prev = _prev;
            next = _next;
        }


    }

    public LinkedListDeque()
    {
        sentinel = new IntNode();
        size = 0;
        sentinel.next = sentinel;
        sentinel.prev = sentinel;

    }

    public LinkedListDeque( LinkedListDeque other )
    {
        sentinel = new IntNode( );
        size = other.size();
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        IntNode p = other.sentinel.prev;
        while(p!=other.sentinel)
        {
            this.addFirst(p.item);
            p = p.prev;
        }
    }


    public void addFirst( Item item ) {
        IntNode p = this.sentinel.next;
        sentinel.next = new IntNode( item, sentinel, p);
        p.prev = sentinel.next;
        size++;

    }

    public void addLast( Item item )
    {
        IntNode p = this.sentinel.prev;
        sentinel.prev = new IntNode(item,p ,sentinel );
        p.next = sentinel.prev;
        size++;
    }

    public boolean isEmpty()
    {

        return this.size ==0;
    }

    public int size()
    {
        return this.size;
    }

    public void printDeque()
    {
        IntNode p = this.sentinel.next;
        while(p!= this.sentinel)
        {
            System.out.print( String.valueOf(p.item) + " " );
            p = p.next;
        }
        System.out.println();

    }

    public Item removeFirst()
    {
        if(size == 0)
        {
            return null;
        }

        IntNode first = this.sentinel.next;
        this.sentinel.next = first.next;
        first.next.prev = sentinel;
        size--;
        return first.item;
    }

    public Item removeLast()
    {

        if(size == 0)
        {
            return null;
        }
        IntNode last = sentinel.prev;
        sentinel.prev = last.prev;
        last.prev.next = sentinel;
        size--;
        return last.item;
    }

    public Item get(int index)
    {
        if(index >= this.size)
        {
            return null;
        }

        IntNode p = sentinel.next;

        for(int i = 0; i< index; i++)
        {
            p = p.next;
        }
        return p.item;
    }

    public Item getRecursive(int index)
    {
        if(index >= this.size)
        {
            return null;
        }
        else
        {
            return recursiveHelper( sentinel.next, index ).item;
        }


    }

    public IntNode recursiveHelper( IntNode node, int index  )
    {
        if(index ==0)
        {
            return node;
        }
        else
        {
            return recursiveHelper(node.next, index-1);
        }
    }

}
