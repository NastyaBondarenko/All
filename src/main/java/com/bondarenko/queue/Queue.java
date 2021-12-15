package com.bondarenko.queue;

public interface Queue {


    void add(Object element);
    /* добавляем элемент в конец очереди. (если очередь с приоритетом - т.е.
     PriorityQueue - элемент ставится не обязательно в конец, а в соответствии со своим приоритетом)*/

    boolean offer(Object element);
    /*пытается добавить оbj в очередь. Возвращает true, если оbj добавлен, и false в противном случае.*/

    Object remove();
    /*удаляет элемент из головы очереди, возвращая его. Инициирует исключение NoSuchElementException, если очередь пуста. */

    Object peek();
    /*возвращает элемент из головы очереди. Возвращает null, если очередь пуста. Элемент не удаляется */

    Object element();
    //возвращает элемент из головы очереди. Элемент не удаляется. Если очередь пуста,
    // инициируется исключение NoSuchElementException.

    Object poll();
    /*Retrieves and removes the head of this queue, or returns null if this queue is empty.
    Returns:the head of this queue, or null if this queue is empty*/




}
