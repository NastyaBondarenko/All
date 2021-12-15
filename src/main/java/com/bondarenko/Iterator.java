package com.bondarenko;
public interface Iterator {
    public boolean hasNext();//вертає логічне значення якщо є наступний елемент в колекції
    public Object next();//вертає наступний об'єкт
    public void remove();
}
