package com.comp62542.backend.patterns.factory;

import com.comp62542.backend.patterns.state.FullyRegisterAdapter;
import com.comp62542.backend.patterns.state.NotRegister;
import com.comp62542.backend.patterns.state.PendingRegister;
import com.comp62542.backend.patterns.state.State;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

public class StateFactory {
    public State getState(String state) {
        if(state.equalsIgnoreCase("NotRegister")) {
            return new NotRegister();
        }else if(state.equalsIgnoreCase("PendingRegister")) {
            return new PendingRegister();
        }else if(state.equalsIgnoreCase("FullyRegistered")) {
            return new FullyRegisterAdapter();
        }
        return null;
    }
}
