package com.comp62542.backend.patterns.iterators;

import com.comp62542.backend.dao.UserMapper;
import com.comp62542.backend.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

public class UnregisteredStudentsRespository implements Container{

    @Autowired
    private UserMapper userMapper;

    public User[] students;

    public UnregisteredStudentsRespository() {

    }

    @Override
    public Iterator getIterator() {
        return null;
    }

    private class UnregisterStudentsIterator implements Iterator {
        int index;

        @Override
        public boolean hasNext() {
            return index < students.length;
        }

        @Override
        public User next() {
            if(this.hasNext()) {
                return students[index++];
            }
            return null;
        }
    }
}
